<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"
   		import="modelo.Usuario"
   		import="modelo.UsuarioModelo"%>

   		
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   		

   
<% 
ArrayList<Usuario> usuarioss = (ArrayList)request.getAttribute("usuariosB");

%>

<%
Object objeto = session.getAttribute("user");
Object obj = session.getAttribute("password");
if (objeto == "" && obj == "") {
	response.sendRedirect("login.html");
}else{


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

	
			<div class="container">
		<div class ="row">
			<div class="col">
			<h1>La lista de usuarios con BBDD</h1><hr><br>
				<c:forEach items="${usuariosB}" var="usuariosB">
					${usuariosB.nombre}<br>
					</c:forEach>
	
			</div>
		</div>
	
	</div>

</body>
<%
}

%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>