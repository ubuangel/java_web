<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertar un titulo aqui</title>
</head>
<body>
<h1 style="text-align:center ">Actualisar Articulo</h1>

<form name="form1" action="ControladorArticulos" method="get" >

<input type="hidden" name="instruccion" value="actualizarBBDD">

<input type="hidden" name="id" value="${articulo_actualizado.nid}">

<table width="50%" border="0">


<tr>

<td width="27%">nombre </td>
<td width="73%"><label for="nombre"> </label>
<input type="text" name="nombre" id="nombre" value="${articulo_actualizado.nnombre}"></td>
</tr>
            

<tr>
<td>codigo</td>
<td><label for="codigo"></label> 
<input type="text" name="codigo" id="codigo" value="${articulo_actualizado.ncodigoString}"></td>
</tr>

<!-- 
<tr>
<td>id</td>
<td><label for="id"></label> 
<input type="text" name="id" id="id"></td>
</tr>


 -->
<tr>
<td>descripcion</td>
<td><label for="descripcion"></label> 
<input type="text" name="descripcion" id="descripcion" value="${articulo_actualizado.ndescripcion}"></td>
</tr>

<tr>
<td>existencia</td>
<td><label for="existencia"></label> 
<input type="text" name="existencia" id="existencia" value="${articulo_actualizado.nexistencia}"></td>
</tr>

<tr>
<td>precio</td>
<td><label for="precio"></label> 
<input type="text" name="precio" id="precio" value="${articulo_actualizado.nprecio}"></td>
</tr>
  
  <tr>
    <td><input type="submit" name="envio" value="Enviar"></td>
  <td>  <input type="reset"  name="borrar" value="Borrar"></td>
  </tr>
  
  </table>
</form>

</body>
</html>