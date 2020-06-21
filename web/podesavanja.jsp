<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="binovi.Film" %>
<%@page import="binovi.Bioskop" %>
<%@page import="binovi.Korisnik" %>
<%@page import="binovi.Sala" %>
<%@page import="binovi.Rezervacija" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <form action="promeniKorisnika" method="post">
                        <div class="form-group">
                            <label>Korisnicko ime: </label>
                            <input type="text" name="korisnickoIme" class="form-control" value="<%= korisnik.getKorisnickoIme() %>">
                        </div>
                        <div class="form-group">
                            <label>Lozinka: </label>
                            <input type="text" name="lozinka" class="form-control" value="<%= korisnik.getLozinka()%>">
                        </div>
                        <div class="form-group">
                            <label>Email: </label>
                            <input type="text" name="email" class="form-control" value="<%= korisnik.getEmail()%>">
                        </div>
                        <div class="form-group">
                            <label>Telefon: </label>
                            <input type="text" name="telefon" class="form-control" value="<%= korisnik.getTelefon()%>">
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
