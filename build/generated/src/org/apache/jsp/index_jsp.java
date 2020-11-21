package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(7);
    _jspx_dependants.add("/WEB-INF/jspf/cmeta.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/cstyles.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/cheader.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/cnav.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/caside.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/cfooter.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/cjs.jspf");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        ");
      out.write("<link href=\"RESOURCES/CSS/estilosfooter.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("<link href=\"RESOURCES/CSS/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"RESOURCES/CSS/estilosregistro.css\" rel=\"stylesheet\" type=\"text/css\"/>");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            ");
      out.write("<header class=\"header\">\n");
      out.write("    <div class=\"contenedor\">\n");
      out.write("        <div class=\"header-contenido\">\n");
      out.write("            <p class=\"logo\">CLÍNICA LOREN</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("<section class=\"banner\">\n");
      out.write("    <div class=\"banner-descripcion\">\n");
      out.write("        <div class=\"contenedor\">\n");
      out.write("            <h1>SERVICIOS DE SALUD DE CALIDAD PARA TODA TU FAMILIA</h1>\n");
      out.write("            <!--<input type=\"button\" value=\"comprar\" class=\"button-banner\">-->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>");
      out.write("\n");
      out.write("            ");
      out.write("<nav class=\"navbar sticky-top navbar-light\" style=\"background-color: #00c6ee;\">\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: #00c6ee;\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"login.jsp\">Reservar cita</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"index.jsp\">Principal <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"especialidades.jsp\">Especialidades</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"");
      out.print(request.getContextPath());
      out.write("/usuarioController.do?txtProceso=listarDoc\">Doctores</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"registro.jsp\">Registrate</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"sedes.jsp\" id=\"navbarDropdownMenuLink\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                        Sedes\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Todas</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Lima</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Huancayo</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Juliaca</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Tacna</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Arequipa</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("            <div class=\"container-fuid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-10 offset-lg-1\">\n");
      out.write("                        <div class=\"accordion\" id=\"accordionExample\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\" id=\"headingOne\">\n");
      out.write("                                    <h2 class=\"mb-0\">\n");
      out.write("                                        <button style=\"color: #00c6ee;\" class=\"btn btn-link\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\n");
      out.write("                                            ¿Quiénes somos?\n");
      out.write("                                        </button>\n");
      out.write("                                    </h2>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div id=\"collapseOne\" class=\"collapse show\" aria-labelledby=\"headingOne\" data-parent=\"#accordionExample\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\" id=\"headingTwo\">\n");
      out.write("                                    <h2 class=\"mb-0\">\n");
      out.write("                                        <button style=\"color: #00c6ee;\" class=\"btn btn-link collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">\n");
      out.write("                                            ¿Por qué confiar en nostros?\n");
      out.write("                                        </button>\n");
      out.write("                                    </h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionExample\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\" id=\"headingThree\">\n");
      out.write("                                    <h2 class=\"mb-0\">\n");
      out.write("                                        <button style=\"color: #00c6ee;\" class=\"btn btn-link collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">\n");
      out.write("                                            ¿Cuál es nuestro horario de atención?\n");
      out.write("                                        </button>\n");
      out.write("                                    </h2>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"collapseThree\" class=\"collapse\" aria-labelledby=\"headingThree\" data-parent=\"#accordionExample\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            ");
      out.write("<section class=\"info\"> \n");
      out.write("    <div class=\"contenedor\">\n");
      out.write("        <article class=\"info-columna\">\n");
      out.write("            <h1>25</h1><hr>\n");
      out.write("            <p>Especialiades</p>\n");
      out.write("\n");
      out.write("            <h1>10</h1><hr>\n");
      out.write("            <p>Sedes</p>\n");
      out.write("\n");
      out.write("            <h1>3000</h1><hr>\n");
      out.write("            <p>Pacientes</p>\n");
      out.write("        </article>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("            ");
      out.write("<div class=\"info-container\">\n");
      out.write("    <div class=\"info-main\">\n");
      out.write("        <h3>Contáctanos</h3>\n");
      out.write("        <p>\n");
      out.write("            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis laboriosam blanditiis esse cumque vitae velit, quos doloremque, molestiae corrupti dicta iusto voluptates quis. Ducimus sapiente amet obcaecati esse quasi nostrum.\n");
      out.write("        </p>\n");
      out.write("        <a href=\"\">Más información</a>\t\t\t\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<footer>\n");
      out.write("    <div class=\"footer-container\">\n");
      out.write("        <div class=\"footer-main\">\n");
      out.write("            <div class=\"footer-columna\">\n");
      out.write("                <h3>Suscríbete</h3>\n");
      out.write("                <input type=\"email\" placeholder=\"Ingrese su correo\">\n");
      out.write("                <input type=\"submit\" value=\"Suscribirse\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-columna\">\t\t\t\t\n");
      out.write("                <h3>Dirección</h3>\t\t\t\t\t\n");
      out.write("                <span><p><i class=\"fas fa-map-marker-alt\"></i> 244 av. Los Incas-Perú</p></span>\n");
      out.write("                <span><p><i class=\"fas fa-phone-alt\"></i> (+51) 25 689745</p></span>\n");
      out.write("                <span><p><i class=\"fas fa-envelope\"></i> jkbujaico@gmail.com</p></span>\t\t\t\t\t\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-columna\">\n");
      out.write("                <h3>Sobre nosotros</h3>\n");
      out.write("                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur minus labore quo consequatur magnam, culpa velit est quae possimus nostrum numquam, doloribus quos eos aliquam. Debitis ex odit vitae iusto.</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer-copy-redes\">\n");
      out.write("        <div class=\"main-copy-redes\">\n");
      out.write("            <div class=\"footer-copy\">\n");
      out.write("                &copy; Todos los derechos reservados - | Jerson Bujaico  |.\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-redes\">\n");
      out.write("                <a href=\"https://www.facebook.com\" target=\"_blank\"><i class=\"fab fa-facebook-square\" title=\"Síguenos en Facebook\"></i></a>\n");
      out.write("                <a href=\"https://twitter.com/login?lang=es\" target=\"_blank\"><i class=\"fab fa-twitter\" title=\"Síguenos en Twitter\"></i></a>\n");
      out.write("                <a href=\"https://www.youtube.com/?hl=es-419&gl=PE\" target=\"_blank\"><i class=\"fab fa-youtube\" title=\"Síguenos en Youtube\"></i></a>\n");
      out.write("                <a href=\"https://play.google.com/store/apps?hl=es\" target=\"_blank\"><i class=\"fab fa-google-play\" title=\"Descarga nuestra app para Android\"></i></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\t\t\t\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    ");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://kit.fontawesome.com/bf5614bac9.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"RESOURCES/JS/script.js\" type=\"text/javascript\"></script>\n");
      out.write(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>");
      out.write("\n");
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
