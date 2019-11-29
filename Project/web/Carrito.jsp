<%-- 
    Document   : Carrito
    Created on : 6/11/2019, 06:45:15 PM
    Author     : Mauricio
--%>

<%-- 
    Document   : registro
    Created on : 30/10/2019, 08:36:19 PM
    Author     : Mauricio
--%>
<%@page import="Utils.RequestUtils"%>
<%@page import="Models.Categoria"%>
<%@page import="Models.Product"%>
<%@page import="Models.Compra"%>
<%@page import="Models.Usuario"%>
<%@page import="Models.ImageProduct"%>
<%@page import="java.util.List"%>
<%
    List<Compra> shops = (List<Compra>)request.getAttribute(RequestUtils.KEY_ALL_COMPRAS);
%>

<%
    Usuario user = (Usuario)request.getAttribute(RequestUtils.KEY_ALL_USUARIOS);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	 <title>Carrito</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<!-- css del proyecto -->
	<link rel="stylesheet" href="css/navbar.css">
	<link rel="stylesheet" href="css/card.css">
	<link rel="stylesheet" href="css/tables.css">
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
  <a class="navbar-brand" href="redirectlanding?iduser=<%= user.getIdUser()%>"><img src = "imagenes/logo.png" width="90" height="35" ></a>
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
            <li class="nav-item active">
        <a class="nav-link" href="Carrito?useridd=<%= user.getIdUser()%>"   style="color:  white;" > <i class="fa fa-shopping-cart fa-fw"></i> Carrito <span class="sr-only">(current)</span></a>
      </li>
	  <li class="nav-item active">
        <a class="nav-link" href="historial?useridd=<%= user.getIdUser()%>"   style="color:  white;" > <i class="fa fa-history fa-fw"></i> Historial <span class="sr-only">(current)</span></a>
      </li>

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

	 


<section class="maincontainer">

<br>

<div class="container">

     <div class="row">
            <h1 class="display-4">Carrito de Compras</h1>
			     <div class="col text-right">
				 
				 
  
  
  
  
      </div>
    </div>

	</div>


<div class="row justify-content-center justify-content-md-center">



<div class="container">
  <div class="row">
    <div class="col-12">
		<table class="table table-image">
		  <thead>
		    <tr>
		    
		      <th scope="col">Imagen</th>
		      <th scope="col">Producto</th>
		      <th scope="col">Cantidad</th>
		      <th scope="col">Total</th>
		      <th scope="col">Eliminar</th>
			  <th scope="col">Editar</th>
		      <th scope="col">Comprar</th>
		      <th scope="col">Método de pago</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <%
                for(Compra shop : shops){
%>
		    <tr>
                        
		      <td class="w-25">
			      <img src="AllProductImagesA?productoid=<%= shop.getidproducto()%>" class="img-fluid img-thumbnail" alt="producto">
		      </td>
		      <td><%= shop.getnamep()%><br> <%= shop.getdescriptionp()%></td>
			  <td> <input type="number" name="quantity" min="1" max="100"></td>
			  <td>$200</td>
		      <td><a href="#" class="btn btn-primary" style="background-color: #b82b21; border-color : #b82b21; color: white"> <i class="fa fa-trash fa-fw"></td>
		      <td><a href="#" class="btn btn-primary" style="background-color: #b82b21; border-color : #b82b21; color: white"> <i class="fa fa-pencil fa-fw"></td>
		      <td><a href="Comprar?idshop=<%= shop.getidcompra()%>&IdUser=<%= user.getIdUser()%>" class="btn btn-primary" style="background-color: #b82b21; border-color : #b82b21; color: white"> <i class="fa fa-dollar fa-fw"></td>
			  <td>
			  <div class="dropdown">
  <button type="button" style="background-color: #b82b21; border-color : #b82b21;" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    Método
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">Tarjeta</a>
    <a class="dropdown-item" href="#">Paypal</a>
    <a class="dropdown-item" href="#">Other</a>
  </div>
			  </td>
		    </tr>
                    <%
                }
%>	
			
			
			
		
		  </tbody>
		</table>   
    </div>
  </div>
</div>
		</div>
		
		<br>
</section>
			


	
  </body>
</html>
		  
			  
	
	