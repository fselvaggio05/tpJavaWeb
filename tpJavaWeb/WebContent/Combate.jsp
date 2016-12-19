<%@page import="entities.Personaje"%>
<%@page import="business.CtrlCombate"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Combate</title>
</head>
<body>

	<% 
		Personaje p1= ((Personaje)session.getAttribute("Jugador1"));
		Personaje p2= ((Personaje)session.getAttribute("Jugador2"));
		CtrlCombate ctrl= ((CtrlCombate)session.getAttribute("Controlador"));
	%>
<form action="CombateServlet" method="post">
<div>
<table>
<tr>
	<td>
	Personaje 1:
    </td>
    <td>
    <input type="text" name="personaje1" id="personaje1" value=<%=p1.getNombre()%> />
    </td>
    <td>
    </td>
    <td>
	Personaje 2:
    </td>
    <td>
    <input type="text" name="personaje2" id="personaje2" value=<%=p2.getNombre()%>  />
    </td>
</tr>
<tr>
	<td>
	Vida:
    </td>
    <td>
    <input type="text" name="vida1" id="vida1" value=<%=ctrl.getJugador1().getVidaActual()%> />
    </td>
    <td></td>
    <td></td>
    <td>
    <input type="text" name="vida2" id="vida2" value=<%=ctrl.getJugador2().getVidaActual()%> />
    </td>
</tr>


<tr>
	<td>Energia:  </td>
    <td> <input type="text" name="energia1" id="energia1" value=<%=ctrl.getJugador1().getEnergiaActual()%>/> </td>
    <td></td>
    <td></td>
    <td> <input type="text" name="energia2" id="energia2" value=<%=ctrl.getJugador2().getEnergiaActual()%>/> </td>
</tr>
<tr>
	<td>Defensa:</td>
    <td> <input type="text" name="defensa1" id="defensa1" value=<%=ctrl.jugador1.getDefensa()%>/></td>
    <td></td>
    <td></td>
    <td> <input type="text" name="defensa2" id="defensa2" value=<%=ctrl.jugador2.getDefensa()%>/></td>
</tr>
<tr>
	<td>Evasion:</td>
    <td> <input type="text" name="evasion1" id="evasion2" value=<%=ctrl.jugador1.getEvasion()%>></td>
    <td></td>
    <td></td>
    <td>  <input type="text" name="evasion2" id="evasion2" value=<%=ctrl.jugador2.getEvasion()%>/>  </td>
</tr>

<tr>
	<td>Turno:</td>
    <td> <input type="text" name="turno" id="turno" value=<%=ctrl.getPersonajeTurno().getNombre()%>/></td>   
</tr>

<tr>
	<td>Energia ataque:</td>
    <td><input type="text" name="energiaAtaque" id="energiaAtaque"/></td>    <td></td>
    <td></td>
    <td><input type="submit" name="accion" id="atacar" value="Atacar"/></td>
    <td><input type="submit" name="accion" id="defender" value="Defender" /></td>
</tr>
 </table>
</div>
</form>
</body>
</html>
 