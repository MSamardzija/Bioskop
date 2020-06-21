/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import binovi.Projekcija;
import binovi.Sala;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class opisIRezervacijaKarte extends HttpServlet {

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
        
        String idStr = request.getParameter("idFilma");
        String idBioskopaStr = request.getParameter("idBioskopa");
        String opis = request.getParameter("opis");
        String slika = request.getParameter("slika");
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        if(idStr != null && idStr.length() > 0 && idBioskopaStr != null && idBioskopaStr.length() > 0 && opis != null && opis.length() > 0 &&
                slika != null && slika.length() > 0)
        {
            try 
            {
                int id = Integer.parseInt(idStr);
                int idBioskopa = Integer.parseInt(idBioskopaStr);

                String upit = "SELECT * FROM filmovi, projekcije, sale WHERE filmovi.id = '" + id + "' and projekcije.idBioskopa = '" + idBioskopa + 
                        "' and sale.idBioskopa = '" + idBioskopa + "'";

                try 
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskop","root","");
                    st = con.createStatement();
                    rs = st.executeQuery(upit);

                    if(rs.next())
                    {
                        Projekcija projekcija = new Projekcija(rs.getInt("projekcije.id"), rs.getFloat("projekcije.cenaKarte"), rs.getString("projekcije.datumProjekcije"),
                                rs.getInt("projekcije.idBioskopa"),
                        rs.getInt("projekcije.idFilma"), rs.getInt("projekcije.idSale"));
                        Sala sala = new Sala(rs.getInt("sale.id"), idBioskopa, rs.getString("sale.opis"), rs.getInt("sale.brojMesta"), rs.getInt("sale.brojSlobodnihMesta"));
                        request.setAttribute("opis", opis);
                        request.setAttribute("slika", slika);
                        request.setAttribute("sala", sala);
                        request.setAttribute("opisProjekcije", projekcija);
                        request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                        
                        st.close();
                        con.close();
                    }
                } 
                catch (Exception e) 
                {
                    request.setAttribute("msg", "Greska u radu sa bazom.");
                    request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
                }
            } 
            catch (Exception e) 
            {
                request.setAttribute("msg", "Id nije dobrog formata");
                request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("msg", "Id nije unet");
            request.getRequestDispatcher("rezervacijaKarata.jsp").forward(request, response);
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
