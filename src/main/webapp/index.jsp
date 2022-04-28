<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="tect/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<%
	String rspta="";
	String cl="";
	if(request.getParameter("rspta") != null){
		int r= Integer.parseInt(request.getParameter("rspta"));
		if(r==0){
			rspta="Error: usuario o contraseña incorrectos";
			cl = "color:red;";
		}
		if(r==3){
			rspta="Ha salido con exito";
			cl = "color:green;";
		}
	}
%>
<body>
	<div class="container" style="margin-top: 30px;">
		<form method="POST" action="/Login/ServletAuth">
			<div class="card" style="width: 30rem;">
				<div class="card-body">
					<h2 style="text-align: center;">Iniciar Sesion</h2>
					<input type="text" id="username" name="txtusuario" class="form-control mt-2" placeholder="Nombre de Usuario" required>
					<input type="password" id="password" name="txtclave" class="form-control mt-2" placeholder="Contraseña" required>
					<input type="submit" id="loginbtn" class="btn btn-primary btn-block mt-2" name="btn-login" value="Ingresar">	
					<p style="<%=cl %> text-align:center; margin-top:15px;"><%=rspta %></p>
				</div>
			</div>
		</form>
	</div>

</body>
</html>