<%@page import="binovi.Bioskop"%>
<%@page import="binovi.Korisnik"%>
<%@page import="java.util.ArrayList"%>
<%@include file="zaglavlje.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmeni bioskop</title>
    </head>
    <body>
        <div class="container text-white">
            <div class="row">
                <div class="col-md-2">
                    
                </div>
                <div class="col-md-8">
                    <h2 align="center">
                        <%
                            String msg = (String)request.getAttribute("msg");
                            if(msg != null)
                            {
                        %>
                            <%=msg%>
                        <%
                            }
                            ArrayList<Korisnik> listaMenadzera = (ArrayList<Korisnik>)request.getAttribute("listaMenadzera");
                            Bioskop bioskop = (Bioskop)request.getAttribute("bioskop");
                        %>
                    </h2>
                    <form action="izmeniBioskop" method="post">
                        <%--<div class="form-group">
                            <label>ID hotela</label>--%>
                            <input name="idBioskopa" type="hidden" class="form-control" value="<%= bioskop.getId() %>">
                        <%--</div>--%>
                        <div class="form-group">
                            <label>Naziv bioskopa: </label>
                            <input name="nazivBioskopa" type="text" class="form-control" value="<%= bioskop.getNaziv()%>">
                        </div>
                        <div class="form-group">
                            <label>Adresa: </label>
                            <input name="adresa" type="text" class="form-control" value="<%= bioskop.getAdresa()%>">
                        </div>
                        <div class="form-group">
                            <label>Telefon: </label>
                            <input name="telefon" type="text" class="form-control" value="<%= bioskop.getTelefon()%>">
                        </div>
                        <div class="form-group">
                            <label>Opis: </label>
                            
                            <textarea name="opis" class="form-control" cols="40" maxlength="400"><%= bioskop.getOpis()%></textarea>
                        </div>
                        <div class="form-group">
                            <label>Menadzer ID </label>
                            <select name="menadzerId" class="form-control">
                                <%
                                    if(listaMenadzera != null)
                                    {
                                        for(Korisnik k : listaMenadzera)
                                        {
                                %>
                                <option value="<%= k.getId() %>" class="form-control"><%= k.getKorisnickoIme() %></option>
                                <% 
                                        }
                                    }
                                    else
                                    {
                                %>
                                <option value="Nema rezultata">Nema rezultata</option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Slika: </label>
                            <input type="file" name="slika" value="<%= bioskop.getSlika()%>">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Sacuvaj promene">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                  </form>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    </body>
</html>
