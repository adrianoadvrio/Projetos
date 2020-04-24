
<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>
    
    



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Adriano</title>

</head>
<body>

<%-- JSP comments --%>
<%--<c:out value="${'Bem vindo ao JSTL'}"/>--%>

<%-- JSP comments --%>
<%--<c:import var= "data" url="https://google.com.br"/>
<c:out value="${data}"/>--%>

<%-- JSP comments --%>

<c:set var="data" scope="page" value="${500*6}"/>

<c:remove var="data"/> <%-- nao mostra mais a variável --%>

<c:out value="${data}"/> 


<%-- captar un error --%>
<c:catch var="error">
<% int var = 100/0; %>
</c:catch>

<c:if test="${error != null }">
${error.message}
</c:if>


<p/>
<p/>
<p/>
<p/>

<form action="LoginServlet" method="post">
Login:
<input type="text" id="Login" name="login">
<br/>
Senha:
<input type="text" id="Senha" name="senha">
<br/>
<input type="submit" value="Logar">


</form>
<%@ include file="pagina-include.jsp" %>
<myprefix:minhatag/>
</body>
</html>