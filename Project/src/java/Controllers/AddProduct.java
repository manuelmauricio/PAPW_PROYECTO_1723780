/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Product;
import Models.ImageProduct;
import Models.VideoProduct;
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

@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})

/**
 *
 * @author magoc
 */
@MultipartConfig(maxFileSize = 1000*1000*5, maxRequestSize = 1000*1000*25, fileSizeThreshold = 1000*1000)
public class AddProduct extends HttpServlet {

 private int estadoz;
  private int categoriaz;
   private int unidadesz;
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
      
   
        
              
              try{

        String namez = request.getParameter("namep");
        String descriptionpz = request.getParameter("descriptionp");
        estadoz = Integer.parseInt(request.getParameter("estado"));        
        categoriaz = Integer.parseInt(request.getParameter("categoria"));
        unidadesz = Integer.parseInt(request.getParameter("unidades"));
        Part fileq = request.getPart("fotoq");
        Part filew = request.getPart("fotow");
        Part filee = request.getPart("fotoe");
        Part filev = request.getPart("videop");

        
        //out.print(file.getInputStream());
        //Creamos un folder para resguardar la imagen si es que no existe
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FilesUtils.RUTE_PRODUCT_IMAGE);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
        //Resguardamos la imagen
        String contentType = fileq.getContentType();//Resguarden esto para saber el tipo
        String nameImage =  fileq.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType);
        fileq.write(path + nameImage);
        
        String contentType1 = filew.getContentType();//Resguarden esto para saber el tipo
        String nameImage1 =  filew.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType1);
        filew.write(path + nameImage1);
        
        
        String contentType2 = filee.getContentType();//Resguarden esto para saber el tipo
        String nameImage2 =  filee.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType2);
        filee.write(path + nameImage2);
        
         String contentType3 = filev.getContentType();//Resguarden esto para saber el tipo
        String nameImage3 =  filev.getName() + System.currentTimeMillis() + FilesUtils.GetExtension(contentType3);
        filev.write(path + nameImage3);
        
        //Agregamos a la base de datos
       Product.AddProduct(namez,descriptionpz,estadoz,categoriaz, unidadesz);
       ImageProduct.AddImageProduct(fileq.getInputStream());
       ImageProduct.AddImageProduct(filew.getInputStream());
       ImageProduct.AddImageProduct(filee.getInputStream());
       VideoProduct.AddVideoProduct(filev.getInputStream());

       
        request.setAttribute("useragain",17);
        RequestDispatcher rd = request.getRequestDispatcher("ShowCategoriaa");
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
