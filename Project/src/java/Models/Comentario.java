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
import java.time.LocalDateTime;
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
 * 
 */
/**
 *
 * @author Mauricio
 */
public class Comentario {
    private int id_comentario;
    private String texto;
    private String usertext;
    private String fecha;
    private int productoid;
    private int usuarioid;
    private boolean active;

    
     public int getid_comentario() {
        return id_comentario;
    }

    public void setid_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }
    
    
    
     public int getproductoid() {
        return productoid;
    }

    public void setproductoid(int productoid) {
        this.productoid = productoid;
    }
    
    
    
     public int getusuarioid() {
        return usuarioid;
    }

    public void setIusuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }
    
    
    
    
    public String gettexto() {
        return texto;
    }

    public void settexto(String texto) {
        this.texto = texto;
    }
    
    
        public String getusertext() {
        return usertext;
    }

    public void setusertext(String usertext) {
        this.usertext = usertext;
    }
        
    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
    public Comentario() {
    }

    public Comentario(int id_comentario, String texto, String fecha, int productoid , int usuarioid ,boolean active) {
        this.id_comentario = id_comentario;
        this.texto = texto;
        this.fecha = fecha;
        this.productoid = productoid;
        this.usuarioid = usuarioid;
        this.active = active;
    }
    
    
    public Comentario(int id_comentario, String texto, String fecha, int productoid , int usuarioid, String usertext) {
        this.id_comentario = id_comentario;
        this.texto = texto;
        this.fecha = fecha;
        this.productoid = productoid;
        this.usuarioid = usuarioid;
        this.usertext = usertext;
    }
        
     static public void Nuevocomentario(String msj, int idprod,  int idus){
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

            statement = con.prepareCall(ProjectUtils.P_ADDCOMENT);
            statement.setString(1, msj);
            statement.setInt(2, idprod);
            statement.setInt(3, idus);
           
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
    
    static public List<Comentario> productcoments (int idpdto, int active){
        List<Comentario> coms = new ArrayList<Comentario>();
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
            statement = con.prepareCall(ProjectUtils.P_VIEWCOMENT);
            statement.setInt(1, idpdto);
            statement.setInt(2, active);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista
            while(rS.next()){
                int idc = rS.getInt("id_comentario");
                String text = rS.getString("texto");
                String datec = rS.getString("fecha");
                int idp = rS.getInt("productoid");
                int idcl = rS.getInt("usuarioid");
                String ustx = rS.getString("nameUser");
                Comentario com = new Comentario (idc, text, datec,idp, idcl, ustx);
                coms.add(com);
                
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
        return coms;
    }
    
    
   
}
