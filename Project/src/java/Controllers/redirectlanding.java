/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Categoria;
import Models.Product;
import Models.Usuario;
import Utils.RequestUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Mauricio
 */
public class redirectlanding extends HttpServlet {
            /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * 
     */
    
  public  boolean veri = false;
   String mod;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Categoria> cats = Categoria.GetCategoria(1);
        List<Product> prods = Product.TopProducts(1);
        int iduser = Integer.parseInt(request.getParameter("iduser"));
        Usuario user = Usuario.getsingleuser(iduser);
        //Agregamos los usuarios obtenidos a nuestro request
        request.setAttribute(RequestUtils.KEY_ALL_CATEGORIAS, cats);
        request.setAttribute(RequestUtils.KEY_ALL_PRODUCTS, prods);
        request.setAttribute(RequestUtils.KEY_ALL_USUARIOS, user);
        //Mandamos nuestro Request al JSP llamado showUsers
        //response.sendRedirect("showUsers.jsp");

        request.getRequestDispatcher("landing.jsp").forward(request, response);


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        processRequest(request, response);
    }

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
                         
        processRequest(request, response);
         
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