<%-- 
    Document   : detail
    Created on : 6/11/2019, 10:33:23 PM
    Author     : Mauricio
--%>
<%@page import="Utils.RequestUtils"%>
<%@page import="Models.Product"%>
<%@page import="Models.Usuario"%>
<%@page import="Models.Comentario"%>
<%@page import="Models.ImageProduct"%>
<%@page import="java.util.List"%>
<%
    List<Product> prod = (List<Product>)request.getAttribute(RequestUtils.KEY_ALL_PRODUCTS);
%>

<%
    Usuario user = (Usuario)request.getAttribute(RequestUtils.KEY_ALL_USUARIOS);
%>


<%
    List<Comentario> com = (List<Comentario>)request.getAttribute(RequestUtils.KEY_ALL_COMENTARIOS);
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	 <title>Producto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<!-- css del proyecto -->
	<link rel="stylesheet" href="css/navbar.css">
	<link rel="stylesheet" href="css/card.css">
    <link rel="stylesheet" href="css/gallery.css">
	<link rel="stylesheet" href="css/commentbox.css">
	<link rel="stylesheet" href="css/tables.css">
	<link rel="stylesheet" href="css/stars.css">
<link rel="icon" href="imagenes/icon.ico">



<script src="js/validaciones.js"></script>
   

	
	
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
            <%
                for(Product prodt : prod){
            %>
<section class="maincontainer">
 <div class="row">

<div class="container">

     <div class="row">
            <h1 class="display-4"><%= prodt.getnamep()%></h1>
			     <div class="col text-right">
				 
				 
  
  
  
  
      </div>
    </div>

	</div>


<section class="posts col-md-8">
<div class="row justify-content-center justify-content-md-center">


    <a href="AllProductImagesA?productoid=<%= prodt.getidproduct()%>" data-toggle="lightbox" data-gallery="gallery" class="col-md-3">
      <img src="AllProductImagesA?productoid=<%= prodt.getidproduct()%>" height="400" width="400" class="img-fluid rounded">
    </a>
   <a href="AllProductImages?productoid=<%= prodt.getidproduct()%>" data-toggle="lightbox" data-gallery="gallery" class="col-md-3">
      <img src="AllProductImages?productoid=<%= prodt.getidproduct()%>" height="400" width="400" class="img-fluid rounded">
    </a>
       <a href="GetTopImage?productoid=<%= prodt.getidproduct()%>" data-toggle="lightbox" data-gallery="gallery" class="col-md-3">
      <img src="GetTopImage?productoid=<%= prodt.getidproduct()%>" height="400" width="400" class="img-fluid rounded">
    </a>


			
			
			<video width="480" height="360" controls>
  <source src="ShowVideo?productoid=<%= prodt.getidproduct()%>" type="video/mp4">
  <source src="movie.ogg" type="video/ogg">
Your browser does not support the video tag.
</video>


			  </div>
			  
			  

			  
			  
			  </section>
			  
			  
	 	<aside class="col-md-3 hidden-xs hidden-sm">
		<br>
<h2>Producto</h2>
<div class="row justify-content-center justify-content-md-center">
<div class="bs-example">
    <table class="table">
        <thead>
            <tr>
                <th>Detalles</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td><%= prodt.getdescriptionp()%></td>
            </tr>
            <tr>
                <td>Categoría</td>
                <td><%= prodt.getcatx()%></td>
            </tr>
            <tr>
                <td>Unidades</td>
                <td><%= prodt.getunidades()%></td>
            </tr> 
			 <td>Precio</td>
                <td>Solicite presupuesto para saber el precio del producto</td>
            </tr>
            <tr>
                <td>Calificación:</td>
                <td>
				<div class="container">
        <div class="starrating risingstar d-flex justify-content-center flex-row-reverse">
            <input type="radio" id="star5" name="rating" value="5" /><label for="star5" title="5 star">5</label>
            <input type="radio" id="star4" name="rating" value="4" /><label for="star4" title="4 star">4</label>
            <input type="radio" id="star3" name="rating" value="3" /><label for="star3" title="3 star">3</label>
            <input type="radio" id="star2" name="rating" value="2" /><label for="star2" title="2 star">2</label>
            <input type="radio" id="star1" name="rating" value="1" /><label for="star1" title="1 star">1</label>
        </div>
  </div>	
				
				
				</td>
            </tr> 
            


          
 			
        </tbody>
    </table>
	  <a href="AddShop?useridd=<%= user.getIdUser()%>&prodidd=<%= prodt.getidproduct()%>" class="btn btn-primary" style="background-color: #b82b21; border-color : #b82b21;"><i class="fa fa-shopping-cart fa-fw"></i>Carrito</a>
	  <a href="#" class="btn btn-primary" style="background-color: #b82b21; border-color : #b82b21;"><i class="fa fa-dollar fa-fw"></i>Presupuesto</a>
</div>
</div>
</aside>
	
                                  <%
                }
            %>

	

					
			  		 




			</div>
			
			
			<div class="row justify-content-center justify-content-md-center">
			
			<div class="detailBox">
    <div class="titleBox">
      <label>Comentarios</label>
        <button type="button" class="close" aria-hidden="true">&times;</button>
    </div>
    <div class="actionBox">
        <ul class="commentList">
            <%
                for(Comentario comdt : com){
            %>
            <li>
                <div class="commenterImage">
                  <img src="GetPerfilImage?idUser=<%= comdt.getusuarioid()%>" />
                </div>
                <div class="commentText">
                    <p class=""><%= comdt.gettexto()%> </p> <span class="date sub-text"><%= comdt.getusertext()%>, <%= comdt.getfecha()%> </span>

                </div>
            </li>
            
           <%
                }
            %>

        </ul>
        <form class="form-inline" method="POST" action="AddComentario" enctype="multipart/form-data">
            <div class="form-group">
                <input class="form-control" type="text" name = "formtexto" placeholder="Escribe algo....">
            </div>
            <div class="form-group">
               <button type="submit" class="btn btn-primary" style="background-color: #b82b21; border-color : #b82b21;  color: white; "><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
            </div>
            <div class="form-group">
                <input name = "formiduser" class="form-control" type="hidden" value="<%= user.getIdUser()%>" placeholder="Escribe algo...." />
            </div>
             <%
                for(Product prodtx : prod){
            %>
            <div class="form-group">
                <input name = "formidproduct" class="form-control" type="hidden" value="<%= prodtx.getidproduct()%>" placeholder="Escribe algo...." />
            </div>
            <%
                }
            %>
            
  
        </form>
    </div>
</div>
</div>
			
						  </section>
			


	
     

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="plugins/jQuery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
	 
 

	 
	 
	 
	
  </body>
</html>