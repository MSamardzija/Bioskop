/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import binovi.Korisnik;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class proveraRezervacije extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //SimpleDateFormat datumFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        String idFilmaStr = request.getParameter("idFilma");
        String idProjekcijeStr = request.getParameter("idProjekcije");
        String idBioskopaStr = request.getParameter("idBioskopa");
        String idSaleStr = request.getParameter("idSale");
        String cenaKarteStr = request.getParameter("cena");
        String brojSlobodnihMestaStr = request.getParameter("slobodnaMesta");
        String datum = request.getParameter("datum");
        String brojKarataStr = request.getParameter("brojKarata");
        
        HttpSession sesija = request.getSession();
        Korisnik korisnik = (Korisnik)sesija.getAttribute("korisnik");
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        if(korisnik != null)
        {
            if(idProjekcijeStr != null && idProjekcijeStr.length() > 0 && idBioskopaStr != null && idBioskopaStr.length() > 0
                    && idSaleStr != null && idSaleStr.length() > 0 && cenaKarteStr != null && cenaKarteStr.length() > 0
                    && brojSlobodnihMestaStr != null && brojSlobodnihMestaStr.length() > 0 && datum != null && datum.length() > 0
                    && brojKarataStr != null && brojKarataStr.length() > 0 && idFilmaStr != null && idFilmaStr.length() > 0)
            {
                try 
                {
                    int idKorisnika = korisnik.getId();
                    int idProjekcije = Integer.parseInt(idProjekcijeStr);
                    int idBioskopa = Integer.parseInt(idBioskopaStr);
                    int idSale = Integer.parseInt(idSaleStr);
                    int idFilma = Integer.parseInt(idFilmaStr);
                    int brojSlobonihMesta = Integer.parseInt(brojSlobodnihMestaStr);
                    int brojKarata = Integer.parseInt(brojKarataStr);
                    float cena = Float.parseFloat(cenaKarteStr);

                    //Date datumDolaska = datumFormat.parse(datumDolaskaStr);
                    //Date datumOdlaska = datumFormat.parse(datumOdlaskaStr);
                    //long razlika = datumOdlaska.getTime() - datumDolaska.getTime();//razlika u milisekundama
                    //long razlikaDani = (razlika / (1000*60*60*24));//TimeUnit.DAYS.convert(ukupnoMiliSekundi, TimeUnit.MILLISECONDS);

                    float ukupnaCena = cena * brojKarata;

                    float poeni = ukupnaCena / 100;
                    
                    brojSlobonihMesta -= brojKarata;

                    if(brojSlobonihMesta > 0 && ukupnaCena > 0)
                    {
                        try 
                        {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskop","root","");
                            Class.forName("com.mysql.jdbc.Driver");
                            st = con.createStatement();
                            PreparedStatement ps;
                            
                            String upitRezervacija = "INSERT INTO rezervacija (idFilma, cenaKarte, datumPocetkaFilma, idBioskopa, BrojKarata, idKorisnika, poeni, idProjekcije, idSale)"
                                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
               
                            ps = con.prepareStatement(upitRezervacija);
               
                            ps.setInt(1, idFilma);
                            ps.setFloat(2, ukupnaCena);
                            ps.setString(3, datum);
                            ps.setInt(4, idBioskopa);
                            ps.setInt(5, brojKarata);
                            ps.setInt(6, idKorisnika);
                            ps.setFloat(7, poeni);
                            ps.setInt(8, idProjekcije);
                            ps.setInt(9, idSale);
               
                            try 
                            {
                                ps.executeUpdate();
                            }
                            catch (SQLException e)
                            {
                                request.setAttribute("msg", e.getMessage());
                                request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                            }
                            String slobdnaMesta = "UPDATE sale SET brojSlobodnihMesta = ? WHERE id = ?";
                            
                            ps = con.prepareStatement(slobdnaMesta);
                            
                            ps.setInt(1, brojSlobonihMesta);
                            ps.setInt(2, idSale);
                            try 
                            {
                                ps.executeUpdate();
                            }
                            catch (SQLException e)
                            {
                                request.setAttribute("msg", e.getMessage());
                                request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                            }
                            ps.close();
                            st.close();
                            con.close();
                            request.setAttribute("msg", "Uspesno ste rezervisali karte.");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            
                            //rs = st.executeQuery(upit);

                            //if(rs.next())
                            //{
                            //    String status = "Rezervisano";
                            //    Rezervacija rezervacija = new Rezervacija(idSobe, ukupnaCena, poeni, datumDolaskaStr, datumOdlaskaStr, rs.getString("naziv"),status, komentar, idKorisnika);

                            //    sesija.setAttribute("rezervacija", rezervacija);
                            //    request.getRequestDispatcher("potvrdaRezervacije.jsp").forward(request, response);
                                
                            //    st.close();
                            //    con.close();
                            //}
                        } 
                        catch (IOException | ClassNotFoundException | SQLException | ServletException e) 
                        {
                            request.setAttribute("msg", "Greska u radu sa bazom.");
                            request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                        }
                    }
                    else
                    {
                        request.setAttribute("msg", "Greska, trenutno nema slobodnih mesta.");
                        request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                    }
                } 
                catch (Exception e) 
                {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                }
            }
            else
            {
                request.setAttribute("msg", "Morate popuniti broj karata.");
                request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
            }
        }
        else 
        {
            request.setAttribute("msg", "Morate da se ulogujete da biste izvrsili rezervaciju!");
            request.getRequestDispatcher("logovanjeForma.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
