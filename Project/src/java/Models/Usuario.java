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
 * @author magoc
 */
public class Usuario {
    //Atributos encapsulados
    private int idUser;
    private String namep;
    private String lastname;
    private String nameUser;
    private String pass;
    private String email;
    private int phone;
    private String adress;
    private byte[] imageUser;
    private boolean active;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
    
    public String getnamep() {
        return namep;
    }

    public void setnamep(String namep) {
        this.namep = namep;
    }
    

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
    
     public String getpass() {
        return pass;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }
    
    public String getadress() {
        return adress;
    }

    public void setadress(String adress) {
        this.adress = adress;
    }
    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public int getphone() {
        return phone;
    }

    public void setphone(int phone) {
        this.phone = phone;
    }

    public byte[] getImageUser() {
        return imageUser;
    }
   
    public void setImageUser(byte[] imageUser) {
        this.imageUser = imageUser;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //Constructores
    public Usuario() {
    }

    public Usuario(int idUser, String nameUser, byte[] imageUser, boolean active, String pass) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.imageUser = imageUser;
        this.active = active;
        this.pass = pass;
    }

    public Usuario(int idUser, String nameUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public Usuario(int idUser, String nameUser, byte[] imageUser, String pass) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.imageUser = imageUser;
        this.pass = pass;
    }
    
    
    public Usuario(Usuario other) {
        this.idUser = other.idUser;
        this.nameUser = other.nameUser;
        this.imageUser = other.imageUser;
        this.active = other.active;
    }
    
   public Usuario(int idUser, String namep, String lastname, String nameUser, String pass, String email, int phone, String adress) {
        this.idUser = idUser;
        this.namep = namep;
        this.lastname = lastname;
        this.nameUser = nameUser;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }
    
    
    //Obtener todos los usuarios segun un parametro
    //1 Activos
    //0 Inactivos
    //-1 Todos
    static public List<Usuario> GetAllUsers(int Activate){
        List<Usuario> users = new ArrayList<Usuario>();
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
            statement = con.prepareCall(ProjectUtils.P_GETALL_USER);
            statement.setInt(1, Activate);
            rS = statement.executeQuery();
            
            //Conseguimos los datos y los agregamos a una lista
            while(rS.next()){
                int id = rS.getInt("idUser");
                String name = rS.getString("nameUser");
                byte[] image = rS.getBytes("imageUser");
                String passw = rS.getString("pass");
                Usuario user = new Usuario(id, name, image, passw);
                users.add(user);
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
        return users;
    }
    
    //Obtenemos la imagen
    static public byte[] GetImageUser(int idUser){
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

            statement = con.prepareCall(ProjectUtils.P_SINGLEIMAGEUSER);
            statement.setInt(1, idUser);
            rS = statement.executeQuery();
            while(rS.next()){
                imageBytes = rS.getBytes("imageUser");
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
    static public void AddUser(String namepx, String lastnamex, String nameUserx, String passx,
            String emailx , int phonex ,  String adressx, InputStream userImagex){
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

            statement = con.prepareCall(ProjectUtils.P_ADD_USER);
            statement.setString(1, namepx);
            statement.setString(2, lastnamex);
            statement.setString(3, nameUserx);
            statement.setString(4, passx);
            statement.setString(5, emailx);
            statement.setInt(6, phonex);
            statement.setString(7, adressx);
            statement.setBlob(8, userImagex);

           
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
    //Remover un usuario
    static public void RemoveUser(int idUser){
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

            statement = con.prepareCall(ProjectUtils.P_REMOVE_USER);
            statement.setInt(1, idUser);
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
    
    
    public static boolean  loginuser(String usernmae, String password){
        boolean cuenta = false;
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //conexion
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_LOGIN);
            statement.setString(1, usernmae);
            statement.setString(2, password);
            rS = statement.executeQuery();
             while(rS.next()){
             cuenta = rS.getBoolean("loginvar");
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
        return cuenta;
    }
    
    
    
    public static boolean  logiadmin(String usernmae, String password){
        boolean cuenta = false;
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //conexion
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_LOGIN2);
            statement.setString(1, usernmae);
            statement.setString(2, password);
            rS = statement.executeQuery();
             while(rS.next()){
             cuenta = rS.getBoolean("loginvar");
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
        return cuenta;
    }
    
    public static int  getiduser(String usernmae){
        int numcuenta = 0;
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //conexion
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_GETIDUSER);
            statement.setString(1, usernmae);
            rS = statement.executeQuery();
             while(rS.next()){
             numcuenta = rS.getInt("idUser");
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
        return numcuenta;
    }
    
    
    public static Usuario getsingleuser (int idus){
        Usuario user = new Usuario();
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try{
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            //conexion
            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            //Creamos el llamado
            statement = con.prepareCall(ProjectUtils.P_SINGLEUSER);
            statement.setInt(1, idus);
            rS = statement.executeQuery();
             while(rS.next()){
             int idproc = rS.getInt("idUser");
             String nameproc = rS.getString("namep");
             String apellidoproc = rS.getString("lastname");
             String userproc = rS.getString("nameUser");
             String passproc = rS.getString("pass");
             String mailproc = rS.getString("email");
             int telefono = rS.getInt("phone");
             String adressproc = rS.getString("adress");
             user = new Usuario(idproc, nameproc, apellidoproc, userproc, passproc, mailproc, telefono, adressproc);
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
        return user;
    }
           
}
