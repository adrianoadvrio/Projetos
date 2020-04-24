
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

<form action="LoginServlet" method="post">
Login:
<input type="text" id="Login" name="login">
<br/>
Senha:
<input type="text" id="Senha" name="senha">
<br/>
<input type="submit" value="Logar">


</form>

</body>
</html>