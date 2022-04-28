<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 %>
 <% 
 	String nombre = (String)request.getAttribute("nombre");
 	String apellido = (String)request.getAttribute("apellido");
 	String rut = (String)request.getAttribute("rut");
 %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<title>Inicio</title>
</head>
<body>
	<div class="container" style="margin-top: 30px;">
		<form method="POST" action="/Login/index.jsp?rspta=3">
			<div class="card" style="width: 30rem;">
				<div class="card-body">
					<h2 style="text-align: center; margin-bottom: 30px">Ingreso</h2>
					<p>Nombre: <%=nombre %></p>
					<p>Apellido: <%=apellido %></p>
					<p>Rut: <%=rut %></p>
					<p style="text-align: center; margin-bottom: 50px">Ha ingresado de forma exitosa</p>
					<input type="submit" class="btn btn-info btn-block mt-2" name="btn-logout" value="Salir">	
				</div>
			</div>
		</form>
	</div>
</body>
</html>