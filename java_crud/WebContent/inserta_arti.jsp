<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center ">Insertar Registro</h1>
<form name="form1" action="ControladorArticulos" method="get" ">
<input type="hidden" name="instruccion" value="insertarBBDD">

  <p>Nombre: <input type="text" name="nombre" size="40"></p>
  <p>codigo: <input type="text" name="codigo" size="40"></p>
  <p>Id: <input type="text" name="id" size="40"></p>
  <p>Descripcion: <input type="text" name="descripcion" size="40"></p>
  <p>Existencia: <input type="text" name="existencia" size="40"></p>
  <p>Precio: <input type="text" name="precio" size="40"></p>
 
  
  <p>
    <input type="submit" value="Enviar">
    <input type="reset" value="Borrar">
  </p>
</form>

</body>
</html>