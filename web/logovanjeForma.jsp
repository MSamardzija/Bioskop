<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logovanje</title>
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
                    <b><%= msg %>
                    <%
                        }
                    %>
                    </h2>
                    <form action="logovanje" method="post">
                        <div class="form-group">
                          <label><b>Korisnicko ime: </label>
                          <input type="text" name="korisnicko" class="form-control" placeholder="Unesite korisnicko ime">
                        </div>
                        <div class="form-group">
                          <label><b>Lozinka: </label>
                          <input type="password" name="lozinka" class="form-control" placeholder="Unesite lozinku">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Ulogujte se">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                    </form>
                </div>
                <div class="col-md-2">
                    
                </div>
        </div>
    </body>
</html>
