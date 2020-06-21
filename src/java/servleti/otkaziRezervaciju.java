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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class otkaziRezervaciju extends HttpServlet {

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
        String idRezervacijeStr = request.getParameter("idRezervacije");
        String brojKarataStr = request.getParameter("brojKarata");
        String idSaleStr = request.getParameter("idSale");
        
        String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
        String user = "root";
        String pass = "";
        
        try 
        {
            int idRezervacije = Integer.parseInt(idRezervacijeStr);
            int idSale = Integer.parseInt(idSaleStr);
            int brojKarata = Integer.parseInt(brojKarataStr);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = null;
            
            String upitRezervacija = "DELETE FROM rezervacija WHERE id = ?";
            
            PreparedStatement ps = con.prepareStatement(upitRezervacija);
            
            ps.setInt(1, idRezervacije);
            
            try {
                ps.executeUpdate();
            } 
            catch (SQLException e) {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("profil.jsp").forward(request, response);
            }
            String upit = "SELECT * FROM sale WHERE id = '" + idSale + "'";
            rs = st.executeQuery(upit);
            
            if(rs.next())
            {
                int brojSlobodnihMesta = rs.getInt("brojSlobodnihMesta");
                brojSlobodnihMesta += brojKarata;
                
                String upitSlobodneSobe = "UPDATE sale SET brojSlobodnihMesta = ? WHERE id = ?";
                
                ps = con.prepareStatement(upitSlobodneSobe);
                ps.setInt(1, brojSlobodnihMesta);
                ps.setInt(2, idSale);
                
                try {
                ps.executeUpdate();
                } 
                catch (SQLException e) {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("profil.jsp").forward(request, response);
                }
            }
            
            request.setAttribute("msg", "Uspesno ste obrisali rezervaciju");
            request.getRequestDispatcher("profil").forward(request, response);
            
            rs.close();
            ps.close();
            st.close();
            con.close();
        } 
        catch (IOException | ClassNotFoundException | NumberFormatException | SQLException | ServletException e) 
        {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("profil.jsp").forward(request, response);
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
