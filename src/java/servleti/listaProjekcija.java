/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import binovi.Film;
import binovi.Projekcija;
import binovi.Sala;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listaProjekcija extends HttpServlet {

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
        
        String idBioskopaStr = request.getParameter("idBioskopa");
        String idFilmaStr = request.getParameter("idFilma");
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        ArrayList<Projekcija> listaProjekcija = new ArrayList<Projekcija>();
        ArrayList<Sala> listaSala = new ArrayList<Sala>();
        
        try 
        {
            int bioskopID = Integer.parseInt(idBioskopaStr);
            int filmID = Integer.parseInt(idFilmaStr);
            
            String upit1 = "SELECT * FROM sale WHERE idBioskopa = '" + bioskopID + "'";
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskop","root","");
            st = con.createStatement();
            rs = st.executeQuery(upit1);
            
            while(rs.next())
            {
                    listaSala.add(new Sala(rs.getInt("id"), bioskopID, rs.getString("opis"), 
                            rs.getInt("brojMesta"), rs.getInt("brojSlobodnihMesta")));
            }
            
            String upit = "SELECT * FROM projekcije WHERE idBioskopa = '" + bioskopID + "' AND idFilma = '" + filmID + "'";
            
            rs = st.executeQuery(upit);
            
            while(rs.next())
            {
                    listaProjekcija.add(new Projekcija(rs.getInt("id"), rs.getFloat("cenaKarte"), rs.getString("datumProjekcije"), 
                            bioskopID, rs.getInt("idFilma"), rs.getInt("idSale")));
            }
            
            request.setAttribute("idBioskopa", bioskopID);
            request.setAttribute("idFilma", filmID);
            request.setAttribute("listaSala", listaSala);
            request.setAttribute("listaProjekcija", listaProjekcija);
            request.getRequestDispatcher("izmenaProjekcija.jsp").forward(request, response);
            
            st.close();
            con.close();
        } 
        catch (Exception e) 
        {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
