<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Film" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filmovi</title>
    </head>
    <body>
       <% 
            ArrayList<Film> filmovi = (ArrayList<Film>)request.getAttribute("listaFilmova");
            int idBioskopa = (int)request.getAttribute("idBioskopa");
        %>
        <div class="container">
            <div class="row">
                <%
                    if(korisnik == null || korisnik.getTipKorisnika().equals("Klijent"))
                    {
                        for(Film f : filmovi)
                        {
                %>
                <div class="col-4">
                    <div class="card-deck bg-dark text-white shadow p-3 mb-5 rounded" style="width: 18rem;">
                        <img src="Slike/<%= f.getSlika() %>" class="card-img-top" height="300px" width="300px" alt="Nije moguce ucitati sliku"><%--Moras da skines slike u netbeansproject i u folder slike--%>
                        <div class="card-body">
                            <p class="card-text">
                                Naziv filma: <%= f.getNaziv()%><br>
                            </p>
                            <form action="opisIRezervacijaKarte" method="post">
                                <input type="hidden" name="idFilma" value="<%= f.getId() %>">
                                <input type="hidden" name="idBioskopa" value="<%= idBioskopa %>">
                                <input type="hidden" name="opis" value="<%= f.getOpis()%>">
                                <input type="hidden" name="slika" value="<%= f.getSlika()%>">
                                <input type="submit" class="btn btn-primary" value="Rezervisi">
                            </form>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                    else if(korisnik.getTipKorisnika().equals("Menadzer"))
                    {
                        for(Film f : filmovi)
                        {
                %>
                <div class="col-4">
                    <div class="card-deck bg-dark text-white shadow p-3 mb-5 rounded" style="width: 18rem;">
                        <img src="Slike/<%= f.getSlika() %>" class="card-img-top" height="300px" width="300px" alt="Nije moguce ucitati sliku"><%--Moras da skines slike u netbeansproject i u folder slike--%>
                        <div class="card-body">
                            <p class="card-text">
                                Naziv filma: <%= f.getNaziv()%><br>
                            </p>
                            <form action="razdvajanjeFilma" method="post" style="display: inline">
                                <input type="hidden" name="idFilma" value="<%= f.getId() %>">
                                <input type="hidden" name="idBioskopa" value="<%= idBioskopa %>">
                                <input type="submit" class="btn btn-light" name="akcija" value="Izmeni">
                                <input type="submit" class="btn btn-danger" name="akcija" value="Obrisi">
                            </form>
                            <form action="listaProjekcija" method="post" style="display: block; align-content: center; padding-top: 5px">
                                <input type="hidden" name="idFilma" value="<%= f.getId() %>">
                                <input type="hidden" name="idBioskopa" value="<%= idBioskopa %>">
                                <input type="submit" class="btn btn-light" value="Izmeni projekciju">
                            </form>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>
