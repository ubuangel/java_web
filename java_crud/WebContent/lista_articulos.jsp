<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.cabecera{
font-size:1.2em;
font-weight:bold;
color:#FFF;
background-color:#08088A;

}

.filas{
text-align:centeer;
background-color:#5882FA;

}
.table{
float:left;
}
#contenedorboton{

margin-left:1000px;
}


</style>

</head>


<body>



	<table>

<tr>

<td class="cabecera"> id </td>
<td class="cabecera"> codigo </td>
<td class="cabecera"> nombre </td>
<td class="cabecera"> descripcion</td>
<td class="cabecera"> existencia</td>
<td class="cabecera"> precio</td>
<td class="cabecera"> Accion</td>

</tr>

<c:forEach  var="tempar" items="${listaarticulos}">

<<!-- un input tag hiden pasarel alcontrolador desde la lista articulos el coidgo articulo del registro pulsado   -->


<!-- jsp tag url -->

<!--  linck para cada  Articulos con su campo clave -->

<!--el nombre igual a =instruccion porque el controlador esta evaluando a cada momento lo que es la instruccion-->

<!-- para enviar un parametro -->
<!-- nos va permitir desde el controlador detectar que tarea queremos que haga -->
<!-- pasar el codigo articulo  -->


<!--  lo importante el valor= value=conseguir que cada vinculo que aparecera ala derecha de cada registro cargue el codigo articulo-->
<c:url var="linktemp" value="ControladorArticulos" > 


<c:param name="instruccion" value="cargar"></c:param> 


<c:param name="carticulo" value="${tempar.nid}"></c:param>
 

</c:url>

<tr>
<td class="filas">${tempar.nid} </td>
<td class="filas">${tempar.ncodigoString} </td>
<td class="filas">${tempar.nnombre} </td>
<td class="filas">${tempar.ndescripcion} </td>
<td class="filas">${tempar.nexistencia} </td>
<td class="filas">${tempar.nprecio} </td>
<td class="filas"><a href="${linktemp}">actualizar</a> </td>



</tr>
</c:forEach>
	

</table>

<div id="contenedorboton" >
  
<input type="button" value="insertar_regsitro" onclick="window.location.href='inserta_arti.jsp'"/>


</div>

</body>

</html>