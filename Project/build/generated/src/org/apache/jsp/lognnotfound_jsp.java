package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Utils.RequestUtils;
import java.util.List;
import javax.naming.Context;

public final class lognnotfound_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("\t <title>Login</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"plugins/bootstrap/css/bootstrap.min.css\">\n");
      out.write("\t<!-- font-awesome CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"font-awesome/css/font-awesome.min.css\">\n");
      out.write("\t<!-- css del proyecto -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<link rel=\"icon\" href=\"imagenes/icon.ico\">\n");
      out.write("\t\n");
      out.write("\t<!-- Optional JavaScript -->\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("    <script src=\"plugins/jQuery/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"plugins/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("   \n");
      out.write("  </head>\n");
      out.write("  <body   style=\"background-color : #f6f6f6;\">\n");
      out.write("<br>\n");
      out.write("  <div class=\"d-flex justify-content-center\">\n");
      out.write("<img src=\"imagenes/logo.png\" alt=\"Logo\" style=\"width:10%;\">\n");
      out.write("</div>\t\n");
      out.write("\n");
      out.write("\t \n");
      out.write("<div class=\"container\" >\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\n");
      out.write("        <div class=\"card card-signin my-5\" style=\"background-color : white;\">\n");
      out.write("          <div class=\"card-body\">\n");
      out.write("            <font size =\"5\">Usuario y/o contraseña incorrectos</font>\n");
      out.write("            <br>\n");
      out.write("            <font size =\"4\">Porfavor intentelo de nuevo o cree una cuenta nueva</font>\n");
      out.write("            <br>\n");
      out.write("            <form class=\"form-signin\" method=\"POST\" action=\"Inicio\" enctype=\"multipart/form-data\">\n");
      out.write("              <div class=\"form-label-group\">\n");
      out.write("\t\t\t  <label for=\"inputName\">Usuario</label>\n");
      out.write("                <input type=\"text\"  class=\"form-control\" name=\"nameUserx\" placeholder=\"usuario\" required autofocus>\n");
      out.write("                <small id=\"nameHelp\" class=\"form-text text-muted\">*Ingrese su nombre de usuario o su correo electrónico</small>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"form-label-group\">\n");
      out.write("\t\t\t   <label for=\"inputName\">Contraseña</label>\n");
      out.write("                <input type=\"password\" class=\"form-control\" name=\"nameUserxx\" placeholder=\"********\" required>\n");
      out.write("\t\t\t<small id=\"PasswordHelp\" class=\"form-text text-muted\">*ingrese su contraseña</small>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"custom-control custom-checkbox mb-3\">\n");
      out.write("                <input type=\"checkbox\" class=\"custom-control-input\" id=\"customCheck1\">\n");
      out.write("                <label class=\"custom-control-label\" for=\"customCheck1\">Recordar contraseña</label>\n");
      out.write("              </div>\n");
      out.write("              <button href=\"ShowLanding?mod=sss\" type=\"submit\" class=\"btn btn-primary btn-block\" style=\"background-color: #b82b21; border-color : #b82b21;  color: white; \"> ENTRAR </button>\n");
      out.write("\t\t\t  <br>\n");
      out.write("\t\t\t   <div class=\"d-flex justify-content-center\">\n");
      out.write("\t\t\t  <a href=\"registro.jsp\">Crear cuenta</a>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\n");
      out.write("                             <br>\n");
      out.write("                           \n");
      out.write("\t\t\t   <div class=\"d-flex justify-content-center\">\n");
      out.write("\t\t\t  <a href=\"login.jsp\">Vover a incio de sesión</a>\n");
      out.write("\t\t\t    </div>\n");
      out.write("                >\n");
      out.write("                             <br>\n");
      out.write("                           \n");
      out.write("                          <div class=\"d-flex justify-content-center\">\n");
      out.write("\t\t\t  <a href=\"loginadmin.jsp\">Ingresar como administrador</a>\n");
      out.write("\t\t\t    </div>\n");
      out.write("                           <br>\n");
      out.write("                           \n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("\t\t  \n");
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
