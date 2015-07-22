<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Login page</title>
</head>
<body>
<h1>Login page</h1>


<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        ${SPRING_SECURITY_LAST_EXCEPTION}.
      </font>
</c:if>

<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
<table>
<tbody>
<tr>
<td>Login:</td>
<td><input type="text" name="username" id="j_username" size="30" maxlength="40"  /></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" id="j_password" size="30" maxlength="32" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login" /></td>
</tr>
</tbody>
</table>
</form>	

<p>
<a href="${pageContext.request.contextPath}/hello.html">Home page</a><br/>
</p>
</body>
</html>