<%@page import="binovi.Bioskop"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj salu</title>
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
                        %>
                    </h2>
                    <form action="dodajSalu" method="post">
                        <div class="form-group">
                            <label>Opis: </label>
                            <input name="opis" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Broj mesta: </label>
                            <input name="brojMesta" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Broj slobodnih mesta: </label>
                            <input name="brojSlobodnihMesta" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Bioskop ID </label>
                            <select name="idBioskopa" class="form-control">
                                <%
                                    if(listaBioskopa != null)
                                    {
                                        for(Bioskop b : listaBioskopa)
                                        {
                                %>
                                <option value="<%= b.getId() %>" class="form-control"><%= b.getNaziv() %></option>
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
                        <input type="submit" class="btn btn-primary" value="Dodaj salu">
                        <input type="reset" class="btn btn-danger" value="Resetuj">
                  </form>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    </body>
</html>
