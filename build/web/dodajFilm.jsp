<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="binovi.Film" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj film</title>
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
                        %>
                    </h2>
                    <form action="dodajFilm" method="post">
                        <div class="form-group">
                            <label><b>Naziv: </label>
                            <input type="text" name="naziv" class="form-control" placeholder="Unesite naziv filma">
                        </div>
                        <div class="form-group">
                            <label><b>Opis: </label>
                            <textarea cols="40" maxlength="400" class="form-control" name="opis" placeholder="Unesite opis filma"></textarea>
                        </div>
                        <div class="form-group">
                            <label><b>Slika: </label>
                            <input type="file" name="slika">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Dodaj film">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                  </form>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    </body>
</html>
