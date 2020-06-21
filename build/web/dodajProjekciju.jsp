<%@page import="servleti.listaBioskopa"%>
<%@page import="binovi.Film"%>
<%@page import="binovi.Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Bioskop" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj projekciju</title>
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
                            ArrayList<Bioskop> listaBioskopa = (ArrayList<Bioskop>)request.getAttribute("listaBioskopa");
                            ArrayList<Sala> listaSala = (ArrayList<Sala>)request.getAttribute("listaSala");
                            ArrayList<Film> listaFilmova = (ArrayList<Film>)request.getAttribute("listaFilmova");
                        %>
                    </h2>
                        <form action="dodajProjekciju" method="post">
                        <div class="form-group">
                            <label><b>Bioskop </label>
                            <select name="idBioskopa" class="form-control">
                                <%
                                    if(listaBioskopa != null)
                                    {
                                        for(Bioskop b : listaBioskopa)
                                        {
                                %>
                                <option class="form-control" value="<%= b.getId() %>"><%= b.getNaziv()%></option>
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
                            <label><b>Film </label>
                            <select name="idFilma" class="form-control">
                                <%
                                    if(listaFilmova != null)
                                    {
                                        for(Film f : listaFilmova)
                                        {
                                %>
                                <option class="form-control" value="<%= f.getId() %>"><%= f.getNaziv()%></option>
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
                            <input type="text" name="cena" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><b>Datum projekcije: </label>
                            <input type="datetime-local"  name="datum" class="form-control">
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
