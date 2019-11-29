/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Comentario;
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

@WebServlet(name = "AddComentario", urlPatterns = {"/AddComentario"})

/**
 *
 * @author magoc
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class AddComentario extends HttpServlet {

 private int iduss;
  private int idproo;
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

        String namez = request.getParameter("formtexto");
        iduss = Integer.parseInt(request.getParameter("formiduser")); 
        idproo = Integer.parseInt(request.getParameter("formidproduct")); 
        Part file = request.getPart("imageUser");
        

        
        //Agregamos a la base de datos
       Comentario.Nuevocomentario(namez, idproo, iduss);
        //Redirecciona a la pagina que gustemos
        request.setAttribute("productagain",idproo);
        request.setAttribute("useragain",iduss);
        RequestDispatcher rd = request.getRequestDispatcher("ShowProducta");
        rd.forward(request, response);
        
       
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
