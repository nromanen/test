<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC and Hibernate Template</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


</head>

<body>
<link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/bootstrap/3.2.0/css/bootstrap.min.css" media="all"/>

<div class = "panel">

<h3 class="panel-header"> <spring:message
                                code="label.title" /> ${principal.username}</h3>
         <form:form method="post" action="add" modelAttribute="person" class="form-vertical">
         <div id = "gridContainer">
            <div class = "row grid-row">
            <div class = "col-sm-3"><form:label path="firstName">First Name</form:label></div>
            <div class = "col-sm-3"> <form:label path="lastName">Last Name</form:label></div>
            <div class = "col-sm-3"><form:label path="Money">Money</form:label></div>
            </div>
            </div>
            <div id = "gridContainer">
            <div class = "row grid-row">
            <div class = "col-sm-3"><form:input path="firstName" /></div>
            <div class = "col-sm-3"> <form:input path="lastName" /></div>
            <div class = "col-sm-3"> <form:input path="Money" /></div>
             </div>          
             </div>
             <br/>
          
  <div ><input type="submit" value="Add Person" class=" btn btn-primary"/></div>


</form:form>
                        
            </div>
            
         <%--    <form:form method="post" action="add" modelAttribute="person" class="form-vertical">

               
                
                <br/>
                <br/>
                
                <input type="submit" value="Add Person" class="btn"/>
            </form:form>
 --%>

            <c:if  test="${!empty peopleList}">
                <h3>People</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${peopleList}" var="person">
                        <tr>
                            <td>${person.lastName}, ${person.firstName}, ${person.money}</td>
                            <td><form action="delete/${person.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
