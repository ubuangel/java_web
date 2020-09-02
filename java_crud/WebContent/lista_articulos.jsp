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
border-bottom:solid #F00 2px;
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
<td>${tempar.nid} </td>
<td> ${tempar.ncodigoString} </td>
<td>${tempar.nnombre} </td>
<td>${tempar.ndescripcion} </td>
<td>${tempar.nexistencia} </td>
<td>${tempar.nprecio} </td>



</tr>
</c:forEach>
	

</table>

</body>

</html>