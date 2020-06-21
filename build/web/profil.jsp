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
        <title>Profil</title>
    </head>
    <body>
        <div class="container bg-dark text-white">
            <div class="row">
                <div class="col-md-12">
                    <h2 align="center">
                        <%
                            String msg = (String)request.getAttribute("msg");
                            if(msg != null)
                            {
                        %>
                            <%= msg %>
                        <%
                            }
                        %>
                    </h2>
                    <%
                        if(korisnik.getTipKorisnika().equals("Klijent") || korisnik.getTipKorisnika().equals("Menadzer"))
                        {
                            ArrayList<Rezervacija> listaRezervacija = (ArrayList<Rezervacija>)request.getAttribute("listaRezervacija");
                            ArrayList<String> listaNazivaHotela = (ArrayList<String>)request.getAttribute("listaNazivaBioskopa");
                            ArrayList<String> listaNazivaFilmova = (ArrayList<String>)request.getAttribute("listaNazivaFilmova");
                    %>
                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th>Bioskop</th>
                            <th>Film</th>
                            <th>Datum</th>
                            <th>Cena</th>
                            <th>Broj karata</th>
                            <th>Poeni</th>
                          </tr>
                        </thead>
                        <tbody>
                    <% 
                        if(listaRezervacija != null)
                            {
                                for(Rezervacija r : listaRezervacija)
                                {
                    %>
                        <form action="otkaziRezervaciju" method="post">
                          <tr>
                          <input type="hidden" name="brojKarata" value="<%= r.getBrojKarata()%>"> 
                          <input type="hidden" name="idSale" value="<%= r.getIdSale()%>"> 
                          <input type="hidden" name="idRezervacije" value="<%= r.getId()%>">
                            <td><%= r.getIdBioskopa()%></td>
                            <td><%= r.getIdFilma()%></td>
                            <td><%= r.getDatum()%></td>
                            <td><%= r.getCena()%></td>
                            <td><%= r.getBrojKarata()%></td>
                            <td><%= r.getPoeni()%></td>
                            <%
                                if(korisnik.getTipKorisnika().equals("Klijent"))
                                {
                            %>
                            <td>
                                <input type="submit" value="Otkazi" class="btn btn-danger btn-lg">
                            </td>
                            <% 
                                }
                                else
                                {
                            %>
                            <td>
                                <input type="submit" value="Obrisi" class="btn btn-danger btn-lg">
                            </td>
                            <% } %>
                          </tr>
                        </form>
                          <% 
                                }
                          %>
                          </tbody>
                    <%
                        }
                        else 
                        {
                    %>
                          <tr>
                              <td colspan="8" align="center"><b>Trenutno nema rezervacija</b></td>
                          </tr>
                    <% 
                        }
                    %>
                    <tr>
                        <td colspan="9" align="center">
                            <a href="podesavanja.jsp"  class="btn btn-secondary btn-lg ml-3">Podesavanja</a>
                        </td>
                    </tr>
                        </tbody>
                    </table>
                    <%
                        }
                        else if(korisnik.getTipKorisnika().equals("Administrator"))
                        {
                            ArrayList<Bioskop> listaBioskopa = (ArrayList<Bioskop>)request.getAttribute("listaBioskopa");
                    %>
                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th>ID bioskopa</th>
                            <th>Naziv bioskopa</th>
                            <th>Adresa</th>
                            <th>Telefon</th>
                            <th>Opis</th>
                            <th>Menadzer ID</th>
                          </tr>
                        </thead>
                        <tbody>
                    <%
                            if(listaBioskopa != null)
                            {
                                for(Bioskop b : listaBioskopa)
                                {
                    %>
                    <form action="razdvajanjeBioskopa" method="post">
                        <tr>
                        <input type="hidden" name="idBioskopa" value="<%= b.getId() %>">
                            <td><%= b.getId() %></td>
                            <td><%= b.getNaziv()%></td>
                            <td><%= b.getAdresa() %></td>
                            <td><%= b.getTelefon() %></td>
                            <td><%= b.getOpis() %></td>
                            <td><%= b.getMenadzer() %></td>
                            <td>
                                <input type="submit" value="Izmeni" name="akcija" class="btn btn-light btn-lg">
                                <input type="submit" value="Obrisi" name="akcija" class="btn btn-danger btn-lg">
                            </td>
                        </tr>
                    </form>
                    <%
                                }
                            }
                            else
                            {
                    %>
                    <tr>
                        <td colspan="6" align="center"><b>Trenutno nema bioskopa</b></td>
                    </tr>
                    <%  
                            }
                        ArrayList<Korisnik> listaKorisnika = (ArrayList<Korisnik>)request.getAttribute("listaKorisnika");
                    %>
                    <tr>
                        <td colspan="7" align="center">
                            <a href="dodajB" class="btn btn-secondary btn-lg ml-3">Dodaj bioskop</a>
                        </td>
                    </tr>
                        </tbody>
                    </table>
                        
                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th>ID korisnika</th>
                            <th>Korinicko ime</th>
                            <th>Lozinka</th>
                            <th>Email</th>
                            <th>Telefon</th>
                            <th>Poeni</th>
                            <th>Tip korisnika</th>
                          </tr>
                        </thead>
                        <tbody>
                    <%
                            if(listaKorisnika != null)
                            {
                                for(Korisnik k : listaKorisnika)
                                {
                    %>
                        <form action="razdvajanjeKorisnika" method="post">
                        <tr>
                            <input type="hidden" name="idKorisnika" value="<%= k.getId() %>">
                            <td><%= k.getId() %></td>
                            <td><%= k.getKorisnickoIme() %></td>
                            <td><%= k.getLozinka() %></td>
                            <td><%= k.getEmail() %></td>
                            <td><%= k.getTelefon() %></td>
                            <td><%= k.getPoeni() %></td>
                            <td><%= k.getTipKorisnika() %></td>
                            <td>
                                <input type="submit" value="Izmeni" name="akcija" class="btn btn-light btn-lg">
                                <input type="submit" value="Obrisi" name="akcija" class="btn btn-danger btn-lg">
                            </td>
                        </tr>
                        </form>
                    <%
                                }
                                }
                                else
                                {
                    %>
                        <tr>
                            <td colspan="6" align="center"><b>Trenutno nema korisnika</b></td>
                        </tr>
                    <%  
                                }
                                ArrayList<Sala> listaSala = (ArrayList<Sala>)request.getAttribute("listaSala");
                    %>
                    <tr>
                        <td colspan="8" align="center">
                            <a href="dodajKorisnika.jsp" class="btn btn-secondary btn-lg ml-3">Dodaj korisnika</a>
                        </td>
                    </tr>
                        </tbody>
                    </table>
                    
                    
                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th>ID sale</th>
                            <th>iD bioskopa</th>
                            <th>Opis</th>
                            <th>Broj mesta</th>
                            <th>Broj slobodnih mesta</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                    <%
                            if(listaSala != null)
                            {
                                for(Sala s : listaSala)
                                {
                    %>
                        <form action="razdvajanjeSala" method="post">
                        <tr>
                            <input type="hidden" name="idSale" value="<%= s.getId() %>">
                            <td><%= s.getId() %></td>
                            <td><%= s.getIdBioskopa()%></td>
                            <td><%= s.getOpis()%></td>
                            <td><%= s.getBrojMesta()%></td>
                            <td><%= s.getBrojSlobodnihMesta()%></td>
                            <td>
                                <input type="submit" value="Izmeni" name="akcija" class="btn btn-light btn-lg">
                                <input type="submit" value="Obrisi" name="akcija" class="btn btn-danger btn-lg">
                            </td>
                        </tr>
                        </form>
                    <%
                                }
                                }
                                else
                                {
                    %>
                        <tr>
                            <td colspan="6" align="center"><b>Trenutno nema sala</b></td>
                        </tr>
                    <%  
                                }
                    %>
                    <tr>
                        <td colspan="8" align="center">
                            <a href="dodajS" class="btn btn-secondary btn-lg ml-3">Dodaj salu</a>
                        </td>
                    </tr>
                        </tbody>
                    </table>
                    <%
                        }
                    %>
            </div>
        </div>
    </body>
</html>
