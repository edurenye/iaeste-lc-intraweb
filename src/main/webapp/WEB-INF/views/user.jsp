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
    <h3>User:</h3>
        <p>${fn:escapeXml(user.getUsername())}</p>
        <p>${fn:escapeXml(user.getEmail())}</p>
        <p>${fn:escapeXml(user.getBirthdate())}</p>
    <a href="/users">Return to list</a>
</body>
</html>
