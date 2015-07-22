<?xml version="1.0" encoding="ISO-8859-1" ?>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 --%>
 
 <head>
 
 
<title>Home page</title>

<link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/bootstrap/3.2.0/css/bootstrap.min.css" media="all"/>
 

<%--<link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script> 
 --%>
 
 </head>
<body>
<h1>Home page</h1>
<p>This is Home page. It's available for all users. <br/>
<H2> You are 
<strong>
<sec:authentication property="principal.username" />.
</strong> </H2>


<br/>

<div class = "row">
<a href = "?locale=en">English</a>
<a href = "?locale=ua" >Українська</a>

</div>

<form action = "/">
<BUTTON type = "hidden" name = locale value = en class="btn btn-danger">English</BUTTON>
</form>

<BUTTON type = button "hidden" name = locale value = en class="btn btn-primary">English</BUTTON>


<br />
<a href="${pageContext.request.contextPath}/sec/moderation.html">Moderation page</a><br/>
<a href="${pageContext.request.contextPath}/admin/first.html">First Admin page</a><br/>
<a href="${pageContext.request.contextPath}/admin/second.html">Second Admin page</a><br/>
</p>


<sec:authorize access="hasRole('ROLE_ADMIN')">
    This text is only visible to an admin
    <br/>
</sec:authorize>
</body>
</html>