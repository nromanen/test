<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access is denied</title>
</head>
<body>

<%-- <img alt="forbidden" src="/resources/f.jpg" />
--%>

<img alt="forbidden" src="<spring:url value="/resources/f1.png"/>" />
<br/>

<h1>HTTP Status 403 - Access is denied</h1>
	<h2>${msg}</h2>
</body>
</html>