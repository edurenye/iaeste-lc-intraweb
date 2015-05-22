<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: eduard
  Date: 27/04/15
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<ul>
    <c:if test="${not empty users}">
        <c:forEach var="user" items="${users}">
            <li>
                <a href="/users/${user.getUsername()}">${user.getUsername()}</a>: ${fn:escapeXml(user.getName())} <a href="/users/${user.getUsername()}/form">Edit user</a>
            </li>
        </c:forEach>
    </c:if>
</ul>
<a href="/users/form">New user</a>
</body>
</html>
