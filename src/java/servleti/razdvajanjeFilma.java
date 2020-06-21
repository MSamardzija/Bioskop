/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import binovi.Bioskop;
import binovi.Film;
import binovi.Korisnik;
import binovi.Projekcija;
import binovi.Sala;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class razdvajanjeFilma extends HttpServlet {

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
        String akcija = request.getParameter("akcija");
        String idFilmaStr = request.getParameter("idFilma");
        String idBioskopaStr = request.getParameter("idBioskopa");
        int idFilma = Integer.parseInt(idFilmaStr);
        int idBioskopa = Integer.parseInt(idBioskopaStr);
        HttpSession lista = request.getSession();
        
        if("Izmeni".equals(akcija))
        {
            String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
            String user = "root";
            String pass = "";
            HttpSession sesija = request.getSession();
            Korisnik korisnik = (Korisnik)sesija.getAttribute("korisnik");
            int menadzer = korisnik.getId();
            
            try 
            {
//                ArrayList<Bioskop> listaBioskopa = new ArrayList<>();
//                ArrayList<Sala> listaSala = new ArrayList<>();
//                ArrayList<Projekcija> listaProjekcija = new ArrayList<>();
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl,user,pass);
                Statement st = con.createStatement();
                ResultSet rs;
                
//                String upitHotel = "SELECT * FROM bioskop WHERE menadzerID = '" + menadzer + "'";
//                
//                rs = st.executeQuery(upitHotel);
//                
//                while(rs.next())
//                {
//                    listaBioskopa.add(new Bioskop(rs.getInt("id"), rs.getString("naziv"), rs.getString("adresa"), rs.getString("telefon"), 
//                            rs.getString("opis"), rs.getString("slika"), rs.getInt("menadzerID")));
//                }
//                
//                String upitSale = "SELECT * FROM sale, bioskop WHERE sale.idBioskopa = '" + idBioskopa + "' AND bioskop.menadzerID = '" + menadzer + "'";
//                
//                rs = st.executeQuery(upitSale);
//                
//                while(rs.next())
//                {
//                    listaSala.add(new Sala(rs.getInt("id"), rs.getInt("idBioskopa"), rs.getString("opis"), rs.getInt("brojMesta"), rs.getInt("brojSlobodnihMesta")));
//                }
//                
//                String upitProjekcije = "SELECT * FROM projekcije WHERE idBioskopa = '" + idBioskopa + "' AND idFilma = '" + idFilma + "'";
//                
//                rs = st.executeQuery(upitProjekcije);
//                
//                while(rs.next())
//                {
//                    listaProjekcija.add(new Projekcija(rs.getInt("id"), rs.getFloat("cenaKarte"), rs.getDate("datumProjekcije"), rs.getInt("idBioskopa"), rs.getInt("idFilma"), rs.getInt("idSale")));
//                }
                
                String upit = "SELECT * FROM filmovi WHERE id = '" + idFilma + "'";
                
                rs = st.executeQuery(upit);
                if(rs.next())
                {
                    Film filmIzmena = new Film(idFilma, rs.getString("filmovi.naziv"), rs.getString("filmovi.opis"), rs.getString("filmovi.slika"));
                    
//                    lista.setAttribute("listaProjekcija", listaProjekcija);
//                    lista.setAttribute("listaBioskopa", listaBioskopa);
//                    lista.setAttribute("listaSala", listaSala);
                    request.setAttribute("filmIzmena", filmIzmena);
                    request.getRequestDispatcher("izmeniFilm.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("msg", "Nema rezultata u bazi");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                rs.close();
                st.close();
                con.close();
            } 
            catch (IOException | ClassNotFoundException | SQLException | ServletException e) 
            {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else if ("Obrisi".equals(akcija))
        {
            String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
            String user = "root";
            String pass = "";
            
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl,user,pass);
                Statement st = con.createStatement();
                
                String upitRezervacija = "DELETE FROM filmovi WHERE id = ?";
            
                PreparedStatement ps = con.prepareStatement(upitRezervacija);
                ps.setInt(1, idFilma);
                
                try {
                ps.executeUpdate();
                } 
                catch (SQLException e) {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                request.setAttribute("msg", "Obrisali ste film.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
            catch (IOException | ClassNotFoundException | SQLException | ServletException e) 
            {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
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
