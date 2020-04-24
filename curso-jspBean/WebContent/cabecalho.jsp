
<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"/>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Adriano</title>

</head>
<body>
<h1>Index</h1>
<jsp:setProperty property="*" name="calcula"/>
<h3>Cabecalho</h3>
<jsp:getProperty property="nome" name="calcula"/>
<br/>
<jsp:getProperty property="ano" name="calcula"/>
<br/>
<jsp:getProperty property="sexo" name="calcula"/>

</body>
</html>