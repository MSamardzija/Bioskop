/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import binovi.Bioskop;
import binovi.Film;
import binovi.Korisnik;
import binovi.Sala;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class dodajP extends HttpServlet {

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
        HttpSession sesija = request.getSession();
        Korisnik korisnik = (Korisnik)sesija.getAttribute("korisnik");
        int menadzer = korisnik.getId();
        
        String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
        String user = "root";
        String pass = "";
            
            try 
            {
                ArrayList<Bioskop> listaBioskopa = new ArrayList<>();
                ArrayList<Sala> listaSala = new ArrayList<>();
                ArrayList<Film> listaFilmova = new ArrayList<>();
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl,user,pass);
                Statement st = con.createStatement();
                ResultSet rs = null;
                
                String upitBioskop = "SELECT * FROM bioskop WHERE menadzerID = '" + menadzer + "'";
                
                rs = st.executeQuery(upitBioskop);
                
                while(rs.next())
                {
                    listaBioskopa.add(new Bioskop(rs.getInt("id"), rs.getString("naziv"), rs.getString("adresa"), rs.getString("telefon"), 
                            rs.getString("opis"), rs.getString("slika"), rs.getInt("menadzerID")));
                }
                
                String upitSale = "SELECT * FROM sale, bioskop WHERE sale.idBioskopa = bioskop.id AND bioskop.menadzerID = '" + menadzer + "'";
                
                rs = st.executeQuery(upitSale);
                
                while(rs.next())
                {
                    listaSala.add(new Sala(rs.getInt("id"), rs.getInt("idBioskopa"), rs.getString("opis"), rs.getInt("brojMesta"), rs.getInt("brojSlobodnihMesta")));
                }
                
                String upitFilmovi = "SELECT * FROM filmovi";
                
                rs = st.executeQuery(upitFilmovi);
                
                while(rs.next())
                {
                    listaFilmova.add(new Film(rs.getInt("filmovi.id"), rs.getString("filmovi.naziv"), rs.getString("filmovi.opis"), rs.getString("filmovi.slika")));
                }
                
                request.setAttribute("listaFilmova", listaFilmova);
                request.setAttribute("listaBioskopa", listaBioskopa);
                request.setAttribute("listaSala", listaSala);
                request.getRequestDispatcher("dodajProjekciju.jsp").forward(request, response);
                
                rs.close();
                st.close();
                con.close();
            } 
            catch (IOException | ClassNotFoundException | SQLException | ServletException e) 
            {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("dodajProjekciju.jsp").forward(request, response);
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
