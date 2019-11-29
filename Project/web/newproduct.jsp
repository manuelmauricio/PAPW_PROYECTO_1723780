<%-- 
    Document   : newproduct
    Created on : 31/10/2019, 10:45:56 PM
    Author     : Mauricio
--%>
<%@page import="Utils.RequestUtils"%>
<%@page import="Models.Categoria"%>
<%@page import="Models.Usuario"%>
<%@page import="java.util.List"%>
<%
    List<Categoria> cats = (List<Categoria>)request.getAttribute(RequestUtils.KEY_ALL_CATEGORIAS);
%>

<%
    Usuario user = (Usuario)request.getAttribute(RequestUtils.KEY_ALL_USUARIOS);
%>


<%@ page isELIgnored="false" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	 <title>Agregar Producto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<!-- css del proyecto -->
	<link rel="stylesheet" href="css/navbar.css">
	<link rel="stylesheet" href="css/card.css">
	<link rel="icon" href="imagenes/icon.ico">
	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="plugins/jQuery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>

   
  </head>
  <body   style="background-color : #f6f6f6;">
  

  
  
     <!-- NAVBAR PRINCIPAL-->
	 
	 


<nav class="navbar sticky-top navbar-expand-lg navbar-light"  style="background-color:  #363636;">
  <a class="navbar-brand" href="redirectlandingadmin?iduser=<%= user.getIdUser()%>"><img src = "imagenes/logo.png" width="90" height="35" ></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
  	<div class="offset-md-1"></div>
    <ul class="navbar-nav">

	  <li class="nav-item dropdown navbar-right">
        <a class="nav-link dropdown-toggle" href="#"  style="color:  white;" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categorias
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Ropa</a>
          <a class="dropdown-item" href="#">Electrónica</a>
		  <a class="dropdown-item" href="#">Accesorios</a>
          <a class="dropdown-item" href="#">Videojuegos</a>
		  <a class="dropdown-item" href="#">Electrodomésticos</a>
          <a class="dropdown-item" href="#">Zapatos</a>
        </div>
      </li>
	  <div class="offset-md-1"></div>
	   <div class="col-sm-3 col-md-12">
        <form class="navbar-form" role="search">
        <div class="input-group margin-bottom-sm">

            <input type="text" class="form-control" placeholder="Search" name="idprod">
		    	<div class="dropdown">  
  <button type="button" class="btn btn-primary dropdown-toggle"  style="background-color: #b82b21;"  data-toggle="dropdown"><i class="fa fa-search" aria-hidden="true"></i>
    Buscar por..
  </button>
  <div class="dropdown-menu">
      <a class="dropdown-item" href="ShowProduct?varx=1"><i class="fa fa-sort-alpha-desc fa-fw"></i>Nombre</a>
    <a class="dropdown-item" href="#"><i class="fa fa-pencil fa-fw"></i>Descripcion</a>
	<a class="dropdown-item" href="#"><i class="fa fa-user fa-fw"></i>Usuario</a>
	<a class="dropdown-item" href="#"><i class="fa fa-book fa-fw"></i>Categoria</a>
	<a class="dropdown-item" href="#"><i class="fa fa-calendar fa-fw"></i>Fecha</a>
  </div>
</div>			
        </div>
		
		
        </form>
		
		
  
    </div>
    </ul>
	
		<ul class="navbar-nav ml-auto">
                    
         	    <li class="nav-item dropdown navbar-right">
        <a class="nav-link dropdown-toggle" href="#"  style="color:  white;"id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-user fa-fw"></i> Clientes
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#"><i class="fa fa-comments fa-fw"></i> Conversasiones</a>

		  
        </div>
          
          
	    <li class="nav-item dropdown navbar-right">
        <a class="nav-link dropdown-toggle" href="#"  style="color:  white;"id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-gift fa-fw"></i> Productos
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="ShowCategoria?iduser=<%= user.getIdUser()%>"><i class="fa fa-cart-plus fa-fw"></i> Nuevo Producto</a>
		  
          <a class="dropdown-item" href="Borradores?IdUser=<%= user.getIdUser()%>"><i class="fa fa-eraser fa-fw"></i>Borradores</a>
		  
        </div>


	  <li class="nav-item dropdown navbar-right">
        <a class="nav-link dropdown-toggle" href="#"  style="color:  white;"id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <%= user.getNameUser()%>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#"><i class="fa fa-envelope fa-fw"></i> <%= user.getemail()%></a>
		  
          <a class="dropdown-item" href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Salir</a>
		  
        </div>
		
      </li>
	  <a class="navbar-brand" href="#"><img  src="GetPerfilImage?idUser=<%= user.getIdUser()%>" width="45" height="45" ></a>
	  </ul>
	
	
  </div>
</nav>




<br>
	 


<section class="maincontainer">


<br>
<div class="d-flex justify-content-center">
<h2 class="display-4">Nuevo producto</h2>
</div>	




<br>


<div class="row justify-content-center justify-content-md-center">



<form  method="POST" action="AddProduct" enctype="multipart/form-data">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputName">Nombre</label>
      <input type="name"  name="namep"  class="form-control" id="inputName" aria-describedby="namelHelp" placeholder="Nombre">
	  <small id="nameHelp" class="form-text text-muted">Nombre del producto</small>
    </div>
	
    <div class="form-group col-md-6">
      <label for="inputName2">Categoria</label>
	  <select name="categoria" class="form-control" id="exampleFormControlSelect1">
<%
                for(Categoria cat : cats){
%>
      <option  value=<%= cat.getid_categoria()%>><%= cat.getNombre()%></option>
<%
                }
%>

    </select>
	  <small id="nameHelp" class="form-text text-muted">Categoria del producto</small>
    </div>			
  </div>	
  
  <div class="form-row">
  <div class="form-group col-md-12">
      <label for="inputtext">Descripción</label>
      <input type="text" name="descriptionp" class="form-control" id="inputtext" aria-describedby="textHelp" placeholder="Descripcion breve">
	  <small id="textHelp" class="form-text text-muted">Escribe una breve descripción del producto</small>
    </div>		
	  </div>
	  
	  
	  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputnumber">Unidades</label>
      <input type="number" name="unidades" descriptionp pattern="[a-zA-Z0-9]{6,}" class="form-control" id="inputnumber" aria-describedby="numberHelp" placeholder="0">
	  <small id="numberHelp" class="form-text text-muted">Unidades del producto</small>
    </div>
	
     <div class="form-group col-md-6">
      <label for="inputName2">Estado:</label>
	  <select name="estado" class="form-control" id="exampleFormControlSelect1">
      <option  value="0">En Venta</option>
      <option  value="1">Borrador</option>
    </select>
	  <small id="nameHelp" class="form-text text-muted">Estado del producto</small>
    </div>			
  </div>
  
  
   <div class="form-row">
  <div class="form-group col-md-12">
  <label for="inputimage">Imágenes del producto</label>
		    <div class="input-group mb-3">
			  <input type="file" class="form-control"   placeholder="Image" aria-label="Image" aria-describedby="basic-addon1" name="fotoq">
			  <small id="imagenHelp" class="form-text text-muted">Cargra 3 imágenes del producto desde tu coputadora</small>
			</div>
	  	</div>
		</div>
		
		 <div class="form-row">
  <div class="form-group col-md-12">
		    <div class="input-group mb-3">
			  <input type="file" class="form-control"   placeholder="Image" aria-label="Image" aria-describedby="basic-addon1" name="fotow">
		
			</div>
	  	</div>
		</div>
		
		
		 <div class="form-row">
  <div class="form-group col-md-12">

		    <div class="input-group mb-3">
			  <input type="file" class="form-control"   placeholder="Image" aria-label="Image" aria-describedby="basic-addon1" name="fotoe">
			</div>
	  	</div>
		</div>
		
		
		 <div class="form-row">
  <div class="form-group col-md-12">
  <label for="inputimage">Agregar video</label>
		    <div class="input-group mb-3">
			  <input type="file" class="form-control"   placeholder="video" aria-label="video" aria-describedby="basic-addon1" name="videop">
			  <small id="videoHelp" class="form-text text-muted">Cargra un video promocionando el producto</small>
			</div>
	  	</div>
		</div>
	  

  <button type="submit" class="btn btn-primary btn-block" style="background-color: #b82b21; border-color : #b82b21;  color: white; ">Regitrar producto  <i class="fa fa-paper-plane" aria-hidden="true"></i></button>
  
</form>




		</div>
		
		<br>
                
                
                 <div class="row justify-content-center justify-content-md-center">               
<form  method="POST" action="AddCat" enctype="multipart/form-data">
  <div class="form-row">
    <div class="form-group col-md-12">
      <label for="inputName">Nueva categoría:</label>
      <input type="name" name="namec" class="form-control" id="inputName" aria-describedby="namelHelp" placeholder="Categoría">
	  <small id="nameHelp" class="form-text text-muted">Ingrese una nueva categoria</small>
    </div>
      <button type="submit" class="btn btn-primary btn-block" style="background-color: #b82b21; border-color : #b82b21;  color: white; ">Regitrar categoria  <i class="fa fa-paper-plane" aria-hidden="true"></i></button>
 

  </div>	
  </form>	  
 
      </div>	

</section>
			


	
  </body>
</html>