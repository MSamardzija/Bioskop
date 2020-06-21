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

public class dodajBioskop extends HttpServlet {

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
        String nazivBioskopa = request.getParameter("nazivBioskopa");
        String adresa = request.getParameter("adresa");
        String telefon = request.getParameter("telefon");
        String opis = request.getParameter("opis");
        String menadzer = request.getParameter("menadzerId");
        String slika = request.getParameter("slika");
        
        String dbUrl = "jdbc:mysql://localhost:3306/bioskop";
        String user = "root";
        String pass = "";
        
        try 
        {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(dbUrl,user,pass);
           Statement st = con.createStatement();
           ResultSet rs = null;
           String upit = "SELECT naziv, adresa FROM bioskop";
           rs = st.executeQuery(upit);
           
           while(rs.next())
           {
               if(nazivBioskopa.equals(rs.getString("naziv")) && adresa.equals(rs.getString("adresa")))
               {
                   request.setAttribute("msg", "Vec postoji takav bioskop.");
                   request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
               }
           }
           st.close();
           con.close();
        } 
        catch (ClassNotFoundException e) 
        {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
        }
        catch (SQLException se)
        {
            request.setAttribute("msg", se.getMessage());
            request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
        }
        
        if(nazivBioskopa != null && nazivBioskopa.length()>0 && adresa != null && adresa.length() > 0
                && opis != null && opis.length() > 0 && slika != null && slika.length() > 0
                && telefon != null && telefon.length() > 0 && menadzer != null && menadzer.length() > 0)
        {
            try 
                {
                    int menadzerID = Integer.parseInt(menadzer);
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(dbUrl,user,pass);
                    String upitZaUnosUBazu = "INSERT INTO bioskop(naziv,adresa,telefon,opis,menadzerID,slika) VALUES (?,?,?,?,?,?)";
                    
                    PreparedStatement ps = con.prepareStatement(upitZaUnosUBazu);
                    ps.setString(1, nazivBioskopa);
                    ps.setString(2, adresa);
                    ps.setString(3, telefon);
                    ps.setString(4, opis);
                    ps.setInt(5, menadzerID);
                    ps.setString(6, slika);
                    
                    try 
                    {
                        ps.executeUpdate();
                    } 
                    catch (SQLException e) 
                    {
                        String poruka = e.getMessage();
                        request.setAttribute("msg", poruka);
                        request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
                    }
                    
                    request.setAttribute("msg", "Uspesno ste dodali bioskop.");
                    request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
                    
                    ps.close();
                    con.close();
                } 
                catch (ClassNotFoundException e) 
                {
                    request.setAttribute("msg", e.getMessage());
                    request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
                }
                catch (SQLException se)
                {
                    request.setAttribute("msg", se.getMessage());
                    request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
                }
        }
        else 
        {
            request.setAttribute("msg", "Morate popuniti sva polja.");
            request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
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
