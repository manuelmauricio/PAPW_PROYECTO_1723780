/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Mauricio
 */
public class ProjectUtils {

    public static String P_GET_CATEGORIA = "CALL GetCategoria(?);";
    public static String P_ADD_USER = "CALL AddUser(?,?,?,?,?,?,?,?);";
    public static String P_ADD_PRODUCT = "CALL AddProduct(?,?,?,?,?);";
    public static String P_ADD_IMAGE = "CALL AddImage(?);";
    public static String P_TOP_PRODUCT= "CALL TopProducts(?);";
    public static String P_ERASE_PRODUCT= "CALL EraseProducts(?);";
    public static String P_ADD_VIDEO = "CALL AddVideo(?);";
    public static String P_IMAGE_PRODUCT = "CALL GetImageProductT(?);";
    public static String P_IMAGESS_PRODUCT = "CALL GetAllImageProduct(?);";
    public static String P_IMAGESS_PRODUCTA = "CALL GetAllImageProducta(?);";
    public static String P_VIDEO_PRODUCT = "CALL GetVideoProduct(?);";
    public static String P_GET_PRODUCT = "CALL GetProduct(?,?);";
    public static String P_REMOVE_USER = "CALL RemoveUser(?);";
    public static String P_GETALL_USER = "CALL GetAllUsers(?);";
    public static String P_IMAGE_USER = "CALL GetImageUser(?);";
    public static String P_LOGIN = "CALL LOGINPROC(?,?);";
    public static String P_LOGIN2 = "CALL LOGINPROC2(?,?);";
    public static String P_GETIDUSER = "CALL GETIDUSER(?);";
    public static String P_SINGLEUSER = "CALL SINGLEUSER(?);";
    public static String P_SINGLEIMAGEUSER = "CALL SINGLEIMAGEUSER(?);";
    public static String P_VIEWCOMENT = "CALL ViewComent(?,?);";
    public static String P_ADDCOMENT = "CALL AddComent(?,?,?);";
    public static String P_ADDCAT = "CALL AddCat(?);";
     public static String P_DELPROD = "CALL RemoveProducto(?);";
    public static String P_PUBLISH = "CALL Publish(?);";
    public static String ADD_SHOP = "CALL AddShop(?,?);";
        public static String SHOW_CARRO = "CALL ViewCarrito(?,?);";
                public static String COMPRARD = "CALL Confirmarcompra(?);";
}
