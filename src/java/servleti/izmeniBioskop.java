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

public class izmeniBioskop extends HttpServlet {

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
        String nazivBioskopa = request.getParameter("nazivBioskopa");
        String adresa = request.getParameter("adresa");
        String telefon = request.getParameter("telefon");
        String opis = request.getParameter("opis");
        String menadzerIdStr = request.getParameter("menadzerId");
        String slika = request.getParameter("slika");
        
        if(idBioskopaStr != null && idBioskopaStr.length() > 0 && nazivBioskopa != null && nazivBioskopa.length() > 0
                && adresa != null && adresa.length() > 0 && telefon != null && telefon.length() > 0 
                && opis != null && opis.length() > 0 && menadzerIdStr != null && menadzerIdStr.length() > 0
                && slika != null && slika.length() > 0)
        {
            String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
            String user = "root";
            String pass = "";
            try 
            {
                int idBioskopa = Integer.parseInt(idBioskopaStr);
                int menadzerID = Integer.parseInt(menadzerIdStr);
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dbUrl,user,pass);
                Statement st = con.createStatement();
                
                String upit = "UPDATE bioskop SET naziv = ?, adresa = ?, telefon = ?, opis = ?, menadzerID = ?, slika = ? WHERE id = ?";
            
                PreparedStatement ps = con.prepareStatement(upit);
                ps.setString(1, nazivBioskopa);
                ps.setString(2, adresa);
                ps.setString(3, telefon);
                ps.setString(4, opis);
                ps.setInt(5, menadzerID);
                ps.setString(6, slika);
                ps.setInt(7, idBioskopa);
                
                try {
                    ps.executeUpdate();
                } 
                catch (SQLException e) {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                request.setAttribute("msg", "Uspesno ste izmenili bioskop.");
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
            request.setAttribute("msg", "Niste uneli promenu");
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
