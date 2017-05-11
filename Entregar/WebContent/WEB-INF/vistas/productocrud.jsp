<%@  include file="includes/cabecera.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<style>



h2{
text-align: center;
margin-top: 30px;
}
ul{

margin-left: 380px;
margin-top: 0px;

}

li{
background-color: #EFEFEF;
width:100px;
border:solid #EFEFEF;
-webkit-border-radius: 19px;
-moz-border-radius: 19px;
border-radius: 19px;
color:blue;
text-align:center;
display: inline-block;

}

li a:hover {
	color:red;
}

li a{
text-decoration: none;
}

table{

margin-left: 370px;
margin-top: 30px;
border: solid;
background-color: green;

border-color: green;
}
table tr{
background-color: white;
}
table tr td a{

color:blue;
font-weight: bold;


}
table tr td a:hover{

color:red;
background-color: white;

}


table tr th{

height:25px;
background-color: red;

}

table tr td{

text-align: center;}

a{

text-decoration: none;}



</style>
<h2>Mantenimiento de usuarios</h2>

<table border=1 width="700" height=150px;>

<thead>

<tr>

	<th>Operaciones</th>
	<th>ID</th>
	<th>Usuario</th>
	<th>Descripcion</th>
	<th>Precio</th>
	
	</tr>
	
	</thead>
	
	<tbody>
	
	<c:forEach items="${requestScope.productos}" var="producto">
	<tr>
		<td><a href="?op=modificar&id=${producto.id }">Modificar</a>
		<a href="?op=borrar&id=${producto.id }">Borrar</a></td>
		<td>${producto.id }</td>
		<td>${producto.nombre}</td>
		<td>${producto.descripcion}</td>
		<td>${producto.precio}</td>
	
	</tr>
	</c:forEach>
			
	
	
	</tbody>



</table>




<%@  include file="includes/pie.jsp" %>