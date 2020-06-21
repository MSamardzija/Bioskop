package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import binovi.Korisnik;
import java.util.ArrayList;
import binovi.Bioskop;

public final class bioskopi_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/zaglavlje.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>\n");
      out.write("        <title></title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-image: url('Slike/background.jpg')\">\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light p-3 mb-2 bg-transparent text-white\">\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo03\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"index.jsp\">\n");
      out.write("                            <img src=\"Slike/Logo.jpg\" width=\"50\" height=\"47\" class=\"rounded-circle float-left\" alt=\"Nece da se ucita\">\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");

                        Korisnik korisnik = (Korisnik)request.getSession().getAttribute("korisnik");
                        if(korisnik == null)
                        {
                    
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"listaBioskopa\" class=\"btn btn-secondary btn-lg ml-3\">Bioskopi</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-success btn-lg ml-3\" href=\"registracijaForma.jsp\">Registruj se</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-danger btn-lg ml-3\" href=\"logovanjeForma.jsp\">Uloguj se</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");

                        }
                        else if(korisnik.getTipKorisnika().equals("Menadzer"))
                        {
                    
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"listaBioskopaMenadzera\" class=\"btn btn-secondary btn-lg ml-3\">Bioskopi</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"dodajFilm.jsp\" class=\"btn btn-secondary btn-lg ml-3\">Dodaj film</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"dodajP\" class=\"btn btn-secondary btn-lg ml-3\">Dodaj projekciju</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-secondary btn-lg ml-3\" href=\"profil\">Moj profil</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"odjava\" class=\"btn btn-secondary btn-lg ml-3\">Odjavi se</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");

                        }
                        else if(korisnik.getTipKorisnika().equals("Administrator") || korisnik.getTipKorisnika().equals("Klijent"))
                        {
                    
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"listaBioskopa\" class=\"btn btn-secondary btn-lg ml-3\">Bioskopi</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-secondary btn-lg ml-3\" href=\"profil\">Moj profil</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a href=\"odjava\" class=\"btn btn-secondary btn-lg ml-3\">Odjavi se</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.bundle.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Bioskopi</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            String msg = (String)request.getAttribute("msg");
            if(msg != null)
            {
        
      out.write("\n");
      out.write("        ");
      out.print( msg );
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        ");

            ArrayList<Bioskop> bioskopi = (ArrayList<Bioskop>)request.getAttribute("bioskopi");
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");

                    for(Bioskop b : bioskopi)
                    {
                
      out.write("\n");
      out.write("                <div class=\"col-4\">\n");
      out.write("                    <div class=\"card-deck bg-dark text-white shadow p-3 mb-5 rounded\" style=\"width: 18rem;\">\n");
      out.write("                        <img src=\"Slike/");
      out.print( b.getSlika() );
      out.write("\" class=\"card-img-top\" height=\"200px\" width=\"300px\" alt=\"Nije moguce ucitati sliku\">");
      out.write("\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">");
      out.print( b.getNaziv());
      out.write("</h5>\n");
      out.write("                            <p class=\"card-text\">");
      out.print( b.getOpis());
      out.write("</p>\n");
      out.write("                            ");
 
                                if(korisnik == null)
                                {
                            
      out.write("\n");
      out.write("                            <form action=\"listaFilmova\" method=\"post\">\n");
      out.write("                                <input type=\"hidden\" name=\"bioskopID\" value=\"");
      out.print( b.getId() );
      out.write("\">\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\" value=\"Detaljnije\">\n");
      out.write("                            </form>\n");
      out.write("                            ");
  
                                }
                                else if(korisnik.getTipKorisnika().equals("Administrator"))
                                {
                            
      out.write("\n");
      out.write("                            <form action=\"razdvajanjeBioskopa\" method=\"post\" style=\"display: inline\">\n");
      out.write("                                <input type=\"hidden\" name=\"idBioskopa\" value=\"");
      out.print( b.getId() );
      out.write("\">\n");
      out.write("                                <input type=\"submit\" name=\"akcija\" class=\"btn btn-light\" value=\"Izmeni\">\n");
      out.write("                                <input type=\"submit\" name=\"akcija\" class=\"btn btn-danger\" value=\"Obrisi\">  \n");
      out.write("                            </form>\n");
      out.write("                            ");
 } 
                                else if(korisnik.getTipKorisnika().equals("Menadzer"))
                                {
                            
      out.write("\n");
      out.write("                            <form action=\"listaFilmova\" method=\"post\" style=\"display: inline\">\n");
      out.write("                                <input type=\"hidden\" name=\"bioskopID\" value=\"");
      out.print( b.getId() );
      out.write("\">\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\" value=\"Detaljnije\">\n");
      out.write("                            </form>\n");
      out.write("                                ");
 }
                                    else if(korisnik.getTipKorisnika().equals("Klijent"))
                                    {
                                
      out.write("\n");
      out.write("                                <form action=\"listaFilmova\" method=\"post\">\n");
      out.write("                                <input type=\"hidden\" name=\"bioskopID\" value=\"");
      out.print( b.getId() );
      out.write("\">\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\" value=\"Detaljnije\">\n");
      out.write("                                </form>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
