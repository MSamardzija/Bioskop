<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="binovi.Korisnik" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <title></title>
    </head>
    <body style="background-image: url('Slike/background.jpg')">
        <nav class="navbar navbar-expand-lg navbar-light p-3 mb-2 bg-transparent text-white">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a href="index.jsp">
                            <img src="Slike/Logo.jpg" width="50" height="47" class="rounded-circle float-left" alt="Nece da se ucita">
                        </a>
                    </li>
                    <%
                        Korisnik korisnik = (Korisnik)request.getSession().getAttribute("korisnik");
                        if(korisnik == null)
                        {
                    %>
                    <li class="nav-item">
                        <a href="listaBioskopa" class="btn btn-secondary btn-lg ml-3">Bioskopi</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-success btn-lg ml-3" href="registracijaForma.jsp">Registruj se</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-danger btn-lg ml-3" href="logovanjeForma.jsp">Uloguj se</a>
                    </li>
                    <%
                        }
                        else if(korisnik.getTipKorisnika().equals("Menadzer"))
                        {
                    %>
                    <li class="nav-item">
                        <a href="listaBioskopaMenadzera" class="btn btn-secondary btn-lg ml-3">Bioskopi</a>
                    </li>
                    <li class="nav-item">
                        <a href="dodajFilm.jsp" class="btn btn-secondary btn-lg ml-3">Dodaj film</a>
                    </li>
                    <li class="nav-item">
                        <a href="dodajP" class="btn btn-secondary btn-lg ml-3">Dodaj projekciju</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-secondary btn-lg ml-3" href="profil">Moj profil</a>
                    </li>
                    <li class="nav-item">
                        <a href="odjava" class="btn btn-secondary btn-lg ml-3">Odjavi se</a>
                    </li>
                    <%
                        }
                        else if(korisnik.getTipKorisnika().equals("Administrator") || korisnik.getTipKorisnika().equals("Klijent"))
                        {
                    %>
                    <li class="nav-item">
                        <a href="listaBioskopa" class="btn btn-secondary btn-lg ml-3">Bioskopi</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-secondary btn-lg ml-3" href="profil">Moj profil</a>
                    </li>
                    <li class="nav-item">
                        <a href="odjava" class="btn btn-secondary btn-lg ml-3">Odjavi se</a>
                    </li>
                    <% } %>
                </ul>
            </div>
        </nav>
        
        </div>
        <script type="text/javascript" src="js/bootstrap.bundle.js"></script>
        <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
