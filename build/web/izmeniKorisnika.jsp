<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="binovi.Korisnik"%>
<%@page import="java.util.ArrayList"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmeni korisnika</title>
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
                            Korisnik korisnikIzmena = (Korisnik)request.getAttribute("korisnikIzmena");
                        %>
                    </h2>
                    <form action="izmeniKorisnika" method="post">
                            <input name="idKorisnika" type="hidden" class="form-control" value="<%= korisnikIzmena.getId() %>">
                        <div class="form-group">
                            <label>Korisnicko ime: </label>
                            <input name="korisnickoIme" type="text" class="form-control" value="<%= korisnikIzmena.getKorisnickoIme() %>">
                        </div>
                        <div class="form-group">
                            <label>Lozinka: </label>
                            <input name="lozinka" type="text" class="form-control" value="<%= korisnikIzmena.getLozinka() %>">
                        </div>
                        <div class="form-group">
                            <label>Email: </label>
                            <input name="email" type="text" class="form-control" value="<%= korisnikIzmena.getEmail() %>">
                        </div>
                        <div class="form-group">
                            <label>Telefon </label>
                            <input type="text" name="telefon" class="form-control" value="<%= korisnikIzmena.getTelefon()%>">
                        </div>
                        <div class="form-group">
                            <label>Poeni: </label>
                            <input type="text" name="poeni" class="form-control" value="<%= korisnikIzmena.getPoeni() %>">
                        </div>
                        <div class="form-group">
                            <label>Tip korisnika: </label>
                            <select name="tipKorisnika" class="form-control">
                                <option value="Menadzer">Menadzer</option>
                                <option value="Administrator">Administrator</option>
                                <option value="Klijent">Klijent</option>
                            </select>
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
