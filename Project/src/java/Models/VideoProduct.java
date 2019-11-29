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
public class VideoProduct {
    
    
    private int productoid;
    private byte[] vid;
    
    public int getproductoid() {
        return productoid;
    }

    public void setproductoid(int productoid) {
        this.productoid = productoid;
    }

    public byte[] getvid() {
        return vid;
    }
   
    public void setvid(byte[] vid) {
        this.vid = vid;
    }
    
    
     //Constructores
    public VideoProduct() {
    }

    public VideoProduct(int productoid, byte[] vid) {
        this.productoid = productoid;
        this.vid = vid;
    }
    
    //Agregar un video
    static public void AddVideoProduct(InputStream PRODUCTvideox){
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

            statement = con.prepareCall(ProjectUtils.P_ADD_VIDEO);
            statement.setBlob(1, PRODUCTvideox);

           
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
    
    
      //Obtenemos la imagen
    static public byte[] GetVideoP(int productoid){
        byte[] videoBytes = null;
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

            statement = con.prepareCall(ProjectUtils.P_VIDEO_PRODUCT);
            statement.setInt(1, productoid);
            rS = statement.executeQuery();
            while(rS.next()){
                videoBytes = rS.getBytes("vid");
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
        return videoBytes;
    }
}
