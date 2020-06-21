<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Bioskop" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bioskopi</title>
    </head>
    <body>
        <% 
            String msg = (String)request.getAttribute("msg");
            if(msg != null)
            {
        %>
        <%= msg %>
        <%
            }
        %>
        <%
            ArrayList<Bioskop> bioskopi = (ArrayList<Bioskop>)request.getAttribute("bioskopi");
        %>
        <div class="container">
            <div class="row">
                <%
                    for(Bioskop b : bioskopi)
                    {
                %>
                <div class="col-4">
                    <div class="card-deck bg-dark text-white shadow p-3 mb-5 rounded" style="width: 18rem;">
                        <img src="Slike/<%= b.getSlika() %>" class="card-img-top" height="200px" width="300px" alt="Nije moguce ucitati sliku"><%--Moras da skines slike u netbeansproject i u folder slike--%>
                        <div class="card-body">
                            <h5 class="card-title"><%= b.getNaziv()%></h5>
                            <p class="card-text"><%= b.getOpis()%></p>
                            <% 
                                if(korisnik == null)
                                {
                            %>
                            <form action="listaFilmova" method="post">
                                <input type="hidden" name="bioskopID" value="<%= b.getId() %>">
                                <input type="submit" class="btn btn-primary" value="Detaljnije">
                            </form>
                            <%  
                                }
                                else if(korisnik.getTipKorisnika().equals("Administrator"))
                                {
                            %>
                            <form action="razdvajanjeBioskopa" method="post" style="display: inline">
                                <input type="hidden" name="idBioskopa" value="<%= b.getId() %>">
                                <input type="submit" name="akcija" class="btn btn-light" value="Izmeni">
                                <input type="submit" name="akcija" class="btn btn-danger" value="Obrisi">  
                            </form>
                            <% } 
                                else if(korisnik.getTipKorisnika().equals("Menadzer"))
                                {
                            %>
                            <form action="listaFilmova" method="post" style="display: inline">
                                <input type="hidden" name="bioskopID" value="<%= b.getId() %>">
                                <input type="submit" class="btn btn-primary" value="Detaljnije">
                            </form>
                                <% }
                                    else if(korisnik.getTipKorisnika().equals("Klijent"))
                                    {
                                %>
                                <form action="listaFilmova" method="post">
                                <input type="hidden" name="bioskopID" value="<%= b.getId() %>">
                                <input type="submit" class="btn btn-primary" value="Detaljnije">
                                </form>
                                <% } %>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
