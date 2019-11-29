<%-- 
    Document   : registro
    Created on : 30/10/2019, 08:36:19 PM
    Author     : Mauricio
--%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	 <title>Registro de Usuario</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<!-- css del proyecto -->
	<link rel="stylesheet" href="css/registro.css">

	<link rel="icon" href="imagenes/icon.ico">
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="plugins/jQuery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
	
	
	<script>
		$(document).ready(function(){
			$("#alertMsg").hide();
			$( "#formUser" ).submit(function( event ) {
				var canSubmit = true;
				var user = $("#formUser input[name=user]").val();
				  if(user.length < 6)
				  {
				  	canSubmit = false;
				  	$("#alertMsg").show();
				  	$("#alertMsg").html("Requiere 	 caracteres como minimo");
				  }
				  if(!canSubmit)
				  	event.preventDefault();
				});
		});
	</script>

   
  </head>
  <body   style="background-color : #f6f6f6;">
  


	 
<br>
	 


<section class="maincontainer">


<div class="d-flex justify-content-center">
<img src="imagenes/logo.png" alt="Logo">
</div>	

<br>
<div class="d-flex justify-content-center">
<h2 class="display-4">Registro de usuario</h2>
</div>	




<br>


<div class="row justify-content-center justify-content-md-center">



<form method="POST" action="AddUser" enctype="multipart/form-data">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Nombre</label>
      <input type="name" name="namep" pattern="[a-zA-Z0-9]{6,}" class="form-control" aria-describedby="namelHelp" placeholder="Nombre">
	  <small id="nameHelp" class="form-text text-muted">Escribe tu nombre</small>
    </div>
	
    <div class="form-group col-md-6">
      <label >Apellido</label>
      <input type="name" name="lastname" pattern="[a-zA-Z0-9]{6,}" class="form-control" aria-describedby="nameHelp" placeholder="Apellido">
	  <small id="nameHelp" class="form-text text-muted">Escribe tu apellido</small>
    </div>			
  </div>	
  
  <div class="form-row">
  <div class="form-group col-md-12">
      <label>Correo electrónico</label>
      <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2, 4}$" class="form-control"  aria-describedby="emailHelp" placeholder="alguien@ejemplo.com">
	  <small id="emailHelp" class="form-text text-muted">Escribe tu dirección de correo electrónico</small>
    </div>		
	  </div>
	  
	  
	  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Nombre de usuario</label>
      <input type="user"  name="nameUser" pattern="[a-zA-Z0-9]{6,}" class="form-control" aria-describedby="userHelp" placeholder="usuarioejemplo123">
	  <small id="userHelp" class="form-text text-muted">*Mínimo 6 carácteres</small>
    </div>
	
    <div class="form-group col-md-6">
      <label>Contraseña</label>
      <input type="password" name="pass" pattern="[a-zA-Z0-9]{6,}" class="form-control" aria-describedby="PasswordHelp" placeholder="********">
	  <small id="PasswordHelp" class="form-text text-muted">* mínomo 8 carácteres, una mayuscula, una minuscula y un número</small>
    </div>			
  </div>	
  
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Dirección</label>
      <input type="adress" name="adress" pattern="[a-zA-Z0-9]{6,}" class="form-control" aria-describedby="adressHelp" placeholder="calle ejemplo #812">
	  <small id="adressHelp" class="form-text text-muted">*Opcional</small>
    </div>
	
    <div class="form-group col-md-6">
        <label> Teléfono</label>
      <input type="number"  name="phone" pattern="[a-zA-Z0-9]{6,}" class="form-control" aria-describedby="numHelp" placeholder="XX-XX-XX-XX">
	  <small id="numHelp" class="form-text text-muted">*Opcional</small>
    </div>			
  </div>	
  
  
   <div class="form-row">
  <div class="form-group col-md-12">
  <label >Imágen de perfil</label>
		    <div class="input-group mb-3">
			  <input type="file" class="form-control"   placeholder="Avatar" aria-label="Username" aria-describedby="basic-addon1" name="imageUser">
			  <small id="foto" class="form-text text-muted">Cargra una imágen de perfil desde tu computadora</small>
			</div>
	  	</div>
		</div>
	  
<br>
  <button type="submit" class="btn-block" >Registrarse  <i class="fa fa-paper-plane" aria-hidden="true"></i></button>
<br>
<br>
<br>
</form>
		</div>
		
		<br>
</section>

</body>
		  
			  
	
	
			  
	
			

		
