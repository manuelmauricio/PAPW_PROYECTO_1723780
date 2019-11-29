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
 * @author Mauricio
 */
public class Compra {
        private int idcompra;
    private String namep;
    private String descriptionp;
    private int idproducto;
    private int idusuario;

    
    public int getidcompra() {
        return idcompra;
    }

    public void setidcompra(int idcompra) {
        this.idcompra = idcompra;
    }
    
    public int getidproducto() {
        return idproducto;
    }

    public void setidproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
    
    public int getidusuario() {
        return idusuario;
    }

    public void setidusuario(int idusuario) {
        this.idusuario = idusuario;
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
    
     public Compra() {
    }

    public Compra(int idcompra, String namep, String descriptionp, int idproducto , int idusuario) {
        this.idcompra = idcompra;
        this.namep = namep;
        this.descriptionp = descriptionp;
        this.idproducto = idproducto;
        this.idusuario = idusuario;
        
    }
    
    static public void COMPRARD(int idsgop){
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

            statement = con.prepareCall(ProjectUtils.COMPRARD);
            statement.setInt(1, idsgop);
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
    
    
  static public List<Compra> carritouser (int iduser, int active){
        List<Compra> shops = new ArrayList<Compra>();
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
            statement = con.prepareCall(ProjectUtils.SHOW_CARRO);
            statement.setInt(1, iduser);
            statement.setInt(2, active);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista
            while(rS.next()){
                int idc = rS.getInt("idcompra");
                int idu = rS.getInt("idusuario");
                int idp = rS.getInt("idproducto");
                String namex = rS.getString("namep");
                String descx = rS.getString("descriptionp");
                Compra shop = new Compra (idc, namex, descx, idp, idu);
                shops.add(shop);
                
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
        return shops;
    }


  
     static public void NuevaCompra(int idus,  int idprod){
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

            statement = con.prepareCall(ProjectUtils.ADD_SHOP);
            statement.setInt(1, idus);
            statement.setInt(2, idprod);

           
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
    
    
}
