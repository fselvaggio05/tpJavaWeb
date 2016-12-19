<%@page import="entities.Personaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleccion jugadores</title>
</head>
<body>
<form action="SeleccionPersServlet" method="post" id="formSeleccion">

  <div align="center"><strong>Seleccion jugadores:</strong></div>

   	  <div align="center">Jugador 1: 
	  <input type="text" name="txtJugador1" id="jugador1"  />
      

	  </div>

   	  <div align="center">Jugador 2: 
	  <input type="text" name="txtJugador2" id="jugador2" />
      <input type="submit" name="btnBuscar" id="buscar" value="Buscar" />


	 </div>
	<% 
		Personaje p1= ((Personaje)session.getAttribute("Jugador1"));
		Personaje p2= ((Personaje)session.getAttribute("Jugador2"));
		
	%>
</form>
</body>
</html>
