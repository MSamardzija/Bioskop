<%@page import="servleti.listaProjekcija"%>
<%@page import="binovi.Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Film" %>
<%@page import="binovi.Bioskop" %>
<%@page import="binovi.Projekcija" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmeni projekciju</title>
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
                            ArrayList<Projekcija> listaProjekcija = (ArrayList<Projekcija>)request.getAttribute("listaProjekcija");
                            ArrayList<Sala> listaSala = (ArrayList<Sala>)request.getAttribute("listaSala");
                            int bioskopId = (int)request.getAttribute("idBioskopa");
                            int filmId = (int)request.getAttribute("idFilma");
                        %>
                    </h2>
                        <% 
                            if(listaProjekcija != null)
                            {
                                for(Projekcija p : listaProjekcija)
                                {
                        %>
                        <form action="izmeniProjekciju" method="post">
                        <input name="idProjekcije" type="hidden" class="form-control" value="<%= p.getId() %>">
                        <input name="idFilma" type="hidden" class="form-control" value="<%= p.getIdFilma() %>">
                        <div class="form-group">
                            <label><b>Bioskop: </label>
                            <input type="text" name="idBioskopa" class="form-control" value="<%= p.getIdBioskopa()%>" readonly="">
                        </div>
                        <div class="form-group">
                            <label><b>Sala </label>
                            <select name="idSale" class="form-control">
                                <%
                                    if(listaSala != null)
                                    {
                                        for(Sala s : listaSala)
                                        {
                                %>
                                <option class="form-control" value="<%= s.getId() %>"><%= s.getOpis()%></option>
                                <%
                                        }
                                    }
                                    else
                                    {
                                %>
                                <option class="form-control">Nema rezultata</option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label><b>Cena: </label>
                            <input type="text" name="cena" class="form-control" value="<%= p.getCenaKarte()%>">
                        </div>
                        <div class="form-group">
                            <label><b>Datum projekcije: </label>
                            <input type="datetime-local"  name="datum" class="form-control" value="<%= p.getDatum()%>">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Sacuvaj promene">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                        </form>
                        <%
                                }
                            }
                            else
                            {
                        %>
                        <h2 align="center" class="text-white">
                            Nema rezultata
                        </h2>
                        <%
                            }
                        %>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    </body>
</html>
