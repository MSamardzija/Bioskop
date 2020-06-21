<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Početna strana</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    
                </div>
                <div class="col-md-8">
                    <div class="card text-center border-secondary">
                        <%
                            String msg = (String)request.getAttribute("msg");
                            if(msg != null)
                            {
                        %>
                        <h2><%= msg %></h2>
                        <% } %>
                        <div class="card-header text-primary font-weight-bold">
                            Rezervacija karata
                        </div>
                        <div class="card-body bg-dark">
                            <blockquote class="blockquote mb-0 text-primary font-weight-bold">
                                <p>Rezervisite kartu na vreme. Izaberite projekciju koju zelite da gledate i podignite kartu najkasnije 
                                    pola sata pre projekcije.<br>Made By:</p>
                            </blockquote>
                            <img src="Slike/CinemaLogo.jpg" alt="Ne moze da se ucita logo." class="img-fluid">
                        </div>
                    </div>

                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
    </body>
</html>
