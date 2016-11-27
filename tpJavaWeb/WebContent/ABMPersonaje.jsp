<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM Personajes</title>
</head>
<body>
<table width="200">
<form id="inicio" name="form" method="post" action="">
  <tr>
  
    <td>ID:</td>
    <td><input name="id" type="text" disabled="disabled" /></td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" name="buscar" id="buscar" value="Buscar" />
	</td>
  </tr>
  <tr>
    <td>Nombre:</td>
    <td>
      <label for="nombre"></label>
      <input type="text" name="nombre" id="nombre" />
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Vida:</td>
    <td>
      <label for="vida"></label>
      <input type="text" name="vida" id="vida" />
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Energia:</td>
    <td>
      <label for="energia"></label>
      <input type="text" name="energia" id="energia" />
	</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Defensa:</td>
    <td>
      <label for="defensa"></label>
      <input type="text" name="defensa" id="defensa" />
	</td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" name="agregar" id="agregar" value="Agregar" />
	</td>
  </tr>
  <tr>
    <td>Evasion:</td>
    <td>
      <label for="evasion"></label>
      <input type="text" name="evasion" id="evasion" />
	</td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" name="modificar" id="modificar" value="Modificar" />
</td>
  </tr>
  <tr>
    <td>Puntos disponibles:</td>
    <td>
      <label for="ptsDisponibles"></label>
      <input type="text" name="ptsDisponibles" id="ptsDisponibles" />
    </td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" name="eliminar" id="eliminar" value="Eliminar" />
   </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" name="volver" id="volver" value="Volver" />
      </form>
    </td>
  </tr>
  
</table>
</body>
</html>
