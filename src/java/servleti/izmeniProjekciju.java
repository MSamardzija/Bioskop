/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class izmeniProjekciju extends HttpServlet {

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
        String idSaleStr = request.getParameter("idSale");
        String idProjekcijeStr = request.getParameter("idProjekcije");
        String cenaStr = request.getParameter("cena");
        String datumStr = request.getParameter("datum");
        
        if(idBioskopaStr != null && idBioskopaStr.length() > 0 && idFilmaStr != null && idFilmaStr.length() > 0
                && idSaleStr != null && idSaleStr.length() > 0 && cenaStr != null && cenaStr.length() > 0 
                && datumStr != null && datumStr.length() > 0 && idProjekcijeStr != null && idProjekcijeStr.length() > 0)
        {
            String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
            String user = "root";
            String pass = "";
            try 
            {
                int idBioskopa = Integer.parseInt(idBioskopaStr);
                int idFilma = Integer.parseInt(idFilmaStr);
                int idSale = Integer.parseInt(idSaleStr);
                int idProjekcije = Integer.parseInt(idProjekcijeStr);
                float cena = Float.parseFloat(cenaStr);
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl,user,pass);
                Statement st = con.createStatement();
                
                String upit = "UPDATE projekcije SET cenaKarte = ?, datumProjekcije = ?, idBioskopa = ?, idFilma = ?, "
                        + "idSale = ? WHERE id = ?";
            
                PreparedStatement ps = con.prepareStatement(upit);
                ps.setFloat(1, cena);
                ps.setString(2, datumStr);
                ps.setInt(3, idBioskopa);
                ps.setInt(4, idFilma);
                ps.setInt(5, idSale);
                ps.setInt(6, idProjekcije);
                
                try {
                    ps.executeUpdate();
                } 
                catch (SQLException e) {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                request.setAttribute("msg", "Uspesno ste izmenili projekciju");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
                ps.close();
                st.close();
                con.close();
            } 
            catch (IOException | ClassNotFoundException | NumberFormatException | SQLException | ServletException e) 
            {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("msg", "Niste uneli promenu.");
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
