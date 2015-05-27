<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: eduard
  Date: 27/04/15
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<h1>Users</h1>

<c:if test="${not empty user}">
    <h2>User ${user.getUsername()}</h2>
    <c:if test="${not empty user.getEmail()}">
        <p>E-mail: ${user.getEmail()}</p>
    </c:if>
    <p>${fn:escapeXml(user.getBirthdate())}</p>
</c:if>
<a href="/api/users">Return to list</a>
</body>
</html>
