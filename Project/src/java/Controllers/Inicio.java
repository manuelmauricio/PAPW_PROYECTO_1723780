/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Usuario;
import Utils.FilesUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})

/**
 *
 * @author magoc
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class Inicio extends HttpServlet {

  
   /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean veri;
          response.setContentType("text/html;charset=UFT-8");
      PrintWriter out = response.getWriter();
              //Obtenemos los pArametros
              
              try{
        String name = request.getParameter("nameUserx");
         String namel = request.getParameter("nameUserxx");
        Part file = request.getPart("imageUser");
        
        
        //out.print(file.getInputStream());
        //Creamos un folder para resguardar la imagen si es que no existe

        
        //Agregamos a la base de datos
       boolean verim = Usuario.loginuser(name, namel);
        //Redirecciona a la pagina que gustemos
       int useridenti =  Usuario.getiduser(name);
        if (verim == true){

        request.setAttribute("attributeName",useridenti);   
        RequestDispatcher rd = request.getRequestDispatcher("ShowLanding");
        rd.forward(request, response);
        }
        
        
        else 
                    response.sendRedirect("lognnotfound.jsp");
       
        
      
              }
              catch (IOException | ServletException ex ){
              out.print(ex);
              }
        
         
         
         
        
    }
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

