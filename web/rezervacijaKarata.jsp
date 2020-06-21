<%@page import="binovi.Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Film" %>
<%@page import="binovi.Projekcija" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rezervacija karata</title>
    </head>
    <body>
        <%
            String slika = (String)request.getAttribute("slika");
            String opis = (String)request.getAttribute("opis");
            Sala sala = (binovi.Sala)request.getAttribute("sala");
            Projekcija projekcija = (binovi.Projekcija)request.getAttribute("opisProjekcije");
        %>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    
                </div>
                <div class="media col-md-8 card-header bg-dark shadow p-3 mb-5 mt-5 rounded text-white">
                    <img src="Slike/<%= slika %>" height="300" width="200" class="align-self-center mr-3" alt="Nije moguce ucitati sliku">
                    <div class="media-body">
                        <h5 class="mt-0"><%= opis %></h5>
                        <form action="proveraRezervacije" method="post">
                            <p><b>Sala: <%= sala.getOpis() %></p>
                            <p>Broj slobodnih mesta: <%= sala.getBrojSlobodnihMesta() %></p>
                            <p>Cena karte: <%= projekcija.getCenaKarte() %></p>
                            <p>Datum i vreme projekcije: <%= projekcija.getDatum()%></p>
                            <p>Broj karata<br><input type="text" name="brojKarata" value="1"></p>
                            <p><input type="hidden" name="idFilma" value="<%= projekcija.getIdFilma()%>"></p>
                            <p><input type="hidden" name="datum" value="<%= projekcija.getDatum() %>"></p>
                            <p><input type="hidden" name="slobodnaMesta" value="<%= sala.getBrojSlobodnihMesta() %>"></p>
                            <p><input type="hidden" name="cena" value="<%= projekcija.getCenaKarte() %>"></p>
                            <p><input type="hidden" name="idBioskopa" value="<%= projekcija.getIdBioskopa() %>"></p>
                            <p><input type="hidden" name="idSale" value="<%= projekcija.getIdSale() %>"></p>
                            <p><input type="hidden" name="idProjekcije" value="<%= projekcija.getId()%>"></p>
                            <p><input type="submit" value="Rezervisi" class="btn btn-secondary btn-lg"></p>
                        </form>
                    </div>
                </div>
                <div class="col-md-2">
                    
                </div>
                <%
                    String msg = (String)request.getAttribute("msg");
                    if(msg != null)
                    {
                %>
                <%= msg %>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
