/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import Utils.ProjectUtils;
import java.sql.Connection;
import com.mysql.jdbc.Statement;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author Mauricio
 */
public class Product {
    //Atributos encapsulados
 //Atributos encapsulados
    private int idproduct;
    private String namep;
    private String descriptionp;
      private String catx;
    private int estado;
    private int categoria;
    private int unidades;
    private int calificacion;
    private boolean active;
    private byte[] foto;

    public int getidproduct() {
        return idproduct;
    }

    public void setidproduct(int idproduct) {
        this.idproduct = idproduct;
    }
    
        public byte[] getfoto() {
        return foto;
    }
   
    public void setfoto(byte[] foto) {
        this.foto = foto;
    }
    
    public String getnamep() {
        return namep;
    }

    public void setnamep(String namep) {
        this.namep = namep;
    }
    

    public String getdescriptionp() {
        return descriptionp;
    }

    public void setdescriptionp(String descriptionp) {
        this.descriptionp = descriptionp;
    }
    
    public String getcatx() {
        return catx;
    }

    public void setcatx(String catx) {
        this.catx = catx;
    }
    
    
    public int getestado() {
        return estado;
    }

    public void setestado(int estado) {
        this.estado = estado;
    }

    
    public int getcategoria() {
        return categoria;
    }

    public void setcategoria(int categoria) {
        this.categoria = categoria;
    }

    
    public int getunidades() {
        return unidades;
    }

    public void setunidades(int unidades) {
        this.unidades = unidades;
    }

    
    public int getcalificacion() {
        return calificacion;
    }

    public void setcalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //Constructores
    public Product() {
    }

    public Product(int idproduct, String namep, String descriptionp, int estado , int categoria , int unidades, int calificacion, boolean active) {
        this.idproduct = idproduct;
        this.namep = namep;
        this.descriptionp = descriptionp;
        this.estado = estado;
        this.categoria = categoria;
        this.unidades = unidades;
        this.calificacion = calificacion;
        this.active = active;

    }
    
    
        public Product(int idproduct, String namep, String descriptionp, int estado , int categoria , int unidades, int calificacion) {
        this.idproduct = idproduct;
        this.namep = namep;
        this.descriptionp = descriptionp;
        this.estado = estado;
        this.categoria = categoria;
        this.unidades = unidades;
        this.calificacion = calificacion;
    }

        
 public Product(int idproduct, String namep, String descriptionp) {
        this.idproduct = idproduct;
        this.namep = namep;
        this.descriptionp = descriptionp;

    }
 
  public Product(int idproduct, String namep, String descriptionp, String catx, int unidades) {
        this.idproduct = idproduct;
        this.namep = namep;
        this.descriptionp = descriptionp;
this.unidades = unidades;
this.catx = catx;
    }

 
 
     
    static public void Publsihproduct(int idprod){
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            statement = con.prepareCall(ProjectUtils.P_PUBLISH);
            statement.setInt(1, idprod);
            rS = statement.executeQuery();

        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
    }
    
    
    
    static public void Removeproducto(int idpro){
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            statement = con.prepareCall(ProjectUtils.P_DELPROD);
            statement.setInt(1, idpro);
            rS = statement.executeQuery();

        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
    }
    
    
    
//Seleccionar producto
    static public Product ProductDetail(int idP, int Activate){
        Product prod = new Product();
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //Esto dependera del nombre de su conexion recuerden
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_GET_PRODUCT);
            statement.setInt(1, idP);
            statement.setInt(2, Activate);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista

                int idproduct = rS.getInt("idproduct");
                String namep = rS.getString("namep");
                String descriptionp = rS.getString("descriptionp");
                int estado = rS.getInt("estado");
                int categoria = rS.getInt("categoria");
                int unidades = rS.getInt("unidades");
                int calificacion = rS.getInt("calificacion");
                prod = new Product(idproduct, namep, descriptionp, estado, categoria,unidades,calificacion );


    
    
        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            //Si se finalizo bien cerramos todo
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
        return prod;
    }
    
    
    static public List<Product> TopProducts (int Activate){
        List<Product> prods = new ArrayList<Product>();
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //Esto dependera del nombre de su conexion recuerden
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_TOP_PRODUCT);
            statement.setInt(1, Activate);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista
            while(rS.next()){
                int idc = rS.getInt("idproduct");
                String name = rS.getString("namep");
                String description = rS.getString("descriptionp");
                Product prod = new Product(idc, name, description);
                prods.add(prod);
                
            }
          
        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            //Si se finalizo bien cerramos todo
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
        return prods;
    }
    
    
    
    static public List<Product> DetailProduct (int idproduct, int Active){
        List<Product> prods = new ArrayList<Product>();
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //Esto dependera del nombre de su conexion recuerden
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_GET_PRODUCT);
            statement.setInt(1, idproduct);
             statement.setInt(2, Active);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista
            while(rS.next()){
                int idc = rS.getInt("idproduct");
                String name = rS.getString("namep");
                String description = rS.getString("descriptionp");
                String catext = rS.getString("Nombre");
                int uni = rS.getInt("unidades");
                Product prod = new Product(idc, name, description,catext,uni  );
                prods.add(prod);
                
            }
          
        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            //Si se finalizo bien cerramos todo
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
        return prods;
    }
    
    static public byte[] GetImagePro(int productoid){
        byte[] imageBytes = null;
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            statement = con.prepareCall(ProjectUtils.P_IMAGE_PRODUCT);
            statement.setInt(1, productoid);
            rS = statement.executeQuery();
            while(rS.next()){
                imageBytes = rS.getBytes("foto");
            }
        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
        return imageBytes;
    }
    
    //Agregar un usuario
    static public void AddProduct(String namepx, String descriptionx,  int categoriax ,   int unidadesx,  int calificacionx){
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            statement = con.prepareCall(ProjectUtils.P_ADD_PRODUCT);
            statement.setString(1, namepx);
            statement.setString(2, descriptionx);;
            statement.setInt(3, categoriax);
            statement.setInt(4, unidadesx);
            statement.setInt(5, calificacionx);

           
            statement.execute();
            

        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
    }
    
    
    static public List<Product> EraseProducts (int Activate){
        List<Product> prods = new ArrayList<Product>();
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //Esto dependera del nombre de su conexion recuerden
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_ERASE_PRODUCT);
            statement.setInt(1, Activate);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista
            while(rS.next()){
                int idc = rS.getInt("idproduct");
                String name = rS.getString("namep");
                String description = rS.getString("descriptionp");
                Product prod = new Product(idc, name, description);
                prods.add(prod);
                
            }
          
        }catch(SQLException ex){
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        }catch(NamingException ex){
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally{
            //Si se finalizo bien cerramos todo
            try{
                if(rS != null)
                {
                    rS.close();
                }
                if(statement != null)
                {
                    statement.close();
                }
                if(con != null)
                {
                    con.close();
                }
            }catch(SQLException ex){
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
        return prods;
    }
    
    
    
    
    

}
