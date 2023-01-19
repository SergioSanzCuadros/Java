<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AGENDA DE CONTACTOS(JSP)</title>
</head>
<body>
	<h1>AGENDA DAO</h1>
	
	<%
	ArrayList<String[]> agenda = (ArrayList<String[]>)request.getAttribute("agenda");
	if(agenda != null && agenda.size() > 0){
		out.print("<ul>");
		for(int i = 0; i < agenda.size(); i++){
			String nombre = agenda.get(i)[0];
			String apellidos = agenda.get(i)[1];
			out.print("<li>" + nombre + " - " + apellidos + "</li>");		
		}	
		out.print("</ul>");
	}
	%>
	
	<hr/>
	<form action="servletPrincipal" method="get">
		  <label for="nombre">Nombre:</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  <label for="apellidos">Apellidos:</label>
		  <input type="text" id="apellidos" name="apellidos"><br>
		  <p>
		  <label>
	            <input type="radio" name="operacion" value="alta" checked> Alta
	      </label>
	      <label>
	            <input type="radio" name="operacion" value="baja"> Baja
	      </label>
	      <label>
	            <input type="radio" name="operacion" value="modificacion"> Modificación
	      </label>
      </p>
		  <br><br>	              
		  <input type="submit" value="Submit">
	</form>
</body>
</html>