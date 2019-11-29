<%-- 
    Document   : loginadmin
    Created on : 19/11/2019, 02:15:56 PM
    Author     : Mauricio
--%>

<%@page import="Utils.RequestUtils"%>

<%@page import="java.util.List"%>

<%@page import="javax.naming.Context"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	 <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<!-- css del proyecto -->
    <link rel="stylesheet" href="css/login.css">


	<link rel="icon" href="imagenes/icon.ico">
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="plugins/jQuery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>

   
  </head>
  <body   style="background-color : #f6f6f6;">
<br>
  <div class="d-flex justify-content-center">
<img src="imagenes/logo.png" alt="Logo" style="width:10%;">
</div>	

	 
<div class="container" >
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5" style="background-color : white;">
          <div class="card-body">
            <font size ="5">Ingrese el usuario y contraseña del administrador</font>
            <br>
            
            <form class="form-signin" method="POST" action="Inicioadmin" enctype="multipart/form-data">
              <div class="form-label-group">
			  <label for="inputName">Usuario</label>
                <input type="text"  class="form-control" name="nameUserxz" placeholder="usuario" required autofocus>
                <small id="nameHelp" class="form-text text-muted">*Ingrese su nombre de usuario o su correo electrónico</small>
              </div>
              <div class="form-label-group">
			   <label for="inputName">Contraseña</label>
                <input type="password" class="form-control" name="nameUserxxz" placeholder="********" required>
			<small id="PasswordHelp" class="form-text text-muted">*ingrese su contraseña</small>
              </div>
              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Recordar contraseña</label>
              </div>
              <button href="ShowLanding?mod=sss" type="submit" class="btn btn-primary btn-block" style="background-color: #b82b21; border-color : #b82b21;  color: white; "> ENTRAR </button>
			  <br>
      
			   <div class="d-flex justify-content-center">
			  <a href="login.jsp">Volver</a>
			    </div>
                           <br>
                           
            </form>
            
            
            
          </div>
        </div>
      </div>
    </div>
    
    


  </div>

  </body>