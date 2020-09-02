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

</tr>

<c:forEach  var="tempar" items="${listaarticulos}">

<tr>
<td class="filas">${tempar.nid} </td>
<td class="filas"> ${tempar.ncodigoString} </td>
<td class="filas">${tempar.nnombre} </td>
<td class="filas">${tempar.ndescripcion} </td>
<td class="filas">${tempar.nexistencia} </td>
<td class="filas">${tempar.nprecio} </td>



</tr>
</c:forEach>
	

</table>

<div id="contenedorboton" >

<input type="button" value="insertar_regsitro" onclick="window.location.href='inserta_arti.jsp'"/>


</div>

</body>

</html>