<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import=" java.util.*, com.pildorita. *" %>
     
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
<%

//obtinee los productos de lcontrolador
List<Articulos> losarticulos = (List<Articulos>) request.getAttribute("listaarticulos");//ya tenfo almacenada la lista que viene del controlador a la lista losarticulos



%>
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

<% for (Articulos temparticulo:losarticulos){ %>

<tr>
<td> <%= temparticulo.getNcodigoString() %></td>
<td><%=temparticulo.getNdescripcion() %></td>
<td><%=temparticulo.getNexistencia() %></td>
<td><%=temparticulo.getNid() %></td>
<td><%=temparticulo.getNnombre() %></td>
<td><%=temparticulo.getNprecio() %></td>


</tr>

	<% } %>

</table>

</body>

</html>