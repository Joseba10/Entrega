<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	
	<style type="text/css">
	
	h1,p{
	text-align: center;
}
*{
margin: 0px;
}

header h1{

border:solid 2px;
background-color: yellow;
}	

nav ul li a:hover{


color:blue;

}

nav ul li:hover{

background-color: yellow;}

nav ul li a{

color:red;
font-weight: bold;


}

nav ul li{
margin-left: 50px;
width:200px;
}


nav ul {

margin-top: 30px;


}
	
	</style>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">
	<title>Ejemplo MVC</title>

</head>

<body>

	<header>
		
		<h1>Tienda Virtual</h1><br>

	</header>
	
	<nav>
		<ul>
			
			<li><a href="productocrud?op=alta">Alta</a></li>
		
			<li><a href="productocrud">Mantenimiento Productos</a></li>
		</ul>
	</nav>
