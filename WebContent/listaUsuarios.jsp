<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"
   		import="modelo.Usuario"
   		import="modelo.UsuarioModelo"%>

   		
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   		

   
<% 
ArrayList<Usuario> usuarioss = (ArrayList)request.getAttribute("usuarios");

%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
	  crossorigin="anonymous">

<title>Lista de Usuarios</title>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
      <h5 class="my-0 mr-md-auto font-weight-normal">Bienvenido ${sessionScope.user.nombre}</h5>
      <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="#">1</a>
        <a class="p-2 text-dark" href="#">2</a>
        <a class="p-2 text-dark" href="#">3</a>
        <a class="p-2 text-dark" href="#">4</a>
      </nav>
      <a class="btn btn-outline-primary" href="LogOut">Salir</a>
</div>
	
			<div class="container">
		<div class ="row">
			<div class="col">
			<h1>La lista de usuarios con BBDD</h1><hr><br>
				<c:forEach items="${usuarios}" var="usuarios">
					${usuarios.nombre}<br>
					</c:forEach>
	
			</div>
		</div>
	
	</div>

</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>