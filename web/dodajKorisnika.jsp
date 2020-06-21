<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj korisnika</title>
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
                    <form action="dodajKorisnika" method="post">
                        <div class="form-group">
                            <label>Korisnicko ime: </label>
                            <input name="korisnickoIme" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Lozinka: </label>
                            <input name="lozinka" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Email: </label>
                            <input name="email" type="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefon </label>
                            <input name="telefon" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Poeni </label>
                            <input type="text" name="poeni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tip korisnika </label>
                            <select name="tipKorisnika" class="form-control">
                                <option value="Menadzer">Menadzer</option>
                                <option value="Administrator">Administrator</option>
                                <option value="Klijent">Klijent</option>
                            </select>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Dodaj korisnika">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                  </form>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    </body>
</html>
