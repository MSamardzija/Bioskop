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

public class izmeniSalu extends HttpServlet {

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
        String idSaleStr = request.getParameter("idSale");
        String idBioskopaStr = request.getParameter("idBioskopa");
        String brojMestaStr = request.getParameter("brojMesta");
        String brojSlobodnihMestaStr = request.getParameter("brojSlobodnihMesta");
        String opis = request.getParameter("opis");
        
        if(idBioskopaStr != null && idBioskopaStr.length() > 0 && idSaleStr != null && idSaleStr.length() > 0
                && brojMestaStr != null && brojMestaStr.length() > 0 && brojSlobodnihMestaStr != null && brojSlobodnihMestaStr.length() > 0 
                && opis != null && opis.length() > 0 )
        {
            String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
            String user = "root";
            String pass = "";
            try 
            {
                int idBioskopa = Integer.parseInt(idBioskopaStr);
                int idSale = Integer.parseInt(idSaleStr);
                int brojMesta = Integer.parseInt(brojMestaStr);
                int brojSlobodnihMesta = Integer.parseInt(brojSlobodnihMestaStr);
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl,user,pass);
                Statement st = con.createStatement();
                
                String upit = "UPDATE sale SET opis = ?, brojMesta = ?, brojSlobodnihMesta = ?, idBioskopa = ? WHERE id = ?";
            
                PreparedStatement ps = con.prepareStatement(upit);
                ps.setString(1, opis);
                ps.setInt(2, brojMesta);
                ps.setInt(3, brojSlobodnihMesta);
                ps.setInt(4, idBioskopa);
                ps.setInt(5, idSale);
                
                try {
                    ps.executeUpdate();
                } 
                catch (SQLException e) {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                request.setAttribute("msg", "Uspesno ste izmenili salu.");
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
