<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Film" %>
<%@page import="binovi.Bioskop" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmeni film</title>
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
                            //ArrayList<Bioskop> listaBioskopa = (ArrayList<Bioskop>)request.getSession().getAttribute("listaBioskopa");
                            //ArrayList<Film> listaFilmova = (ArrayList<Film>)request.getSession().getAttribute("listaFilmova");
                            Film filmIzmena = (Film)request.getAttribute("filmIzmena");
                        %>
                    </h2>
                    <form action="izmeniFilm" method="post">
                        <input name="idFilma" type="hidden" class="form-control" value="<%= filmIzmena.getId() %>">
                        <div class="form-group">
                            <label><b>Naziv: </label>
                            <input type="text" name="naziv" class="form-control" value="<%= filmIzmena.getNaziv()%>">
                        </div>
                        <div class="form-group">
                            <label><b>Opis: </label>
                            <textarea cols="40" maxlength="400" class="form-control" name="opis"><%= filmIzmena.getOpis()%></textarea>
                        </div>
                        <div class="form-group">
                            <label><b>Slika: </label>
                            <input type="file" name="slika" value="<%= filmIzmena.getSlika() %>">
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
