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
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})

/**
 *
 * @author magoc
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class AddUser extends HttpServlet {

 private int phonez;
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
        
        
          response.setContentType("text/html;charset=UFT-8");
      PrintWriter out = response.getWriter();
              //Obtenemos los pArametros
              
              try{

        String namez = request.getParameter("namep");
        String lastnamez = request.getParameter("lastname");
        String nameUserz = request.getParameter("nameUser");
        String passz = request.getParameter("pass");
        String emailz = request.getParameter("email");
        String adressz = request.getParameter("adress");
        phonez = Integer.parseInt(request.getParameter("phone"));        
        Part file = request.getPart("imageUser");
        
        //out.print(file.getInputStream());
        //Creamos un folder para resguardar la imagen si es que no existe
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FilesUtils.RUTE_USER_IMAGE);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
        //Resguardamos la imagen
        String contentType = file.getContentType();//Resguarden esto para saber el tipo
        String nameImage =  file.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType);
        file.write(path + nameImage);
        
        //Agregamos a la base de datos
       Usuario.AddUser(namez,lastnamez, nameUserz, passz, emailz, phonez, adressz, file.getInputStream());
        //Redirecciona a la pagina que gustemos
        response.sendRedirect("login.jsp");
        
       
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
