<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija</title>
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
                    <form action="registracija" method="post">
                        <div class="form-group">
                            <label><b>Email</label>
                            <input name="email" type="email" class="form-control" placeholder="npr. milos@gmail.com">
                        </div>
                        <div class="form-group">
                            <label><b>Korisničko ime: </label>
                            <input name="korisnickoIme" type="text" class="form-control" placeholder="Korisničko ime">
                        </div>
                        <div class="form-group">
                            <label><b>Lozinka: </label>
                            <input name="sifra" type="password" class="form-control" placeholder="Lozinka">
                        </div>
                        <div class="form-group">
                            <label><b>Potvrdi lozinku: </label>
                            <input name="potvrda" type="password" class="form-control" placeholder="Potvrda">
                        </div>
                        <div class="form-group">
                            <label><b>Telefon: </label>
                            <input name="telefon" type="text" class="form-control" placeholder="Unesite broj telefona">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Registrujte se">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                  </form>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    </body>
</html>
