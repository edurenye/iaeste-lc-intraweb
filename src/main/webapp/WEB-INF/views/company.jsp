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
    <title>Company</title>
</head>
<body>
    <h3>Company:</h3>
    <p>${fn:escapeXml(company.getName())}</p>
    <p>${fn:escapeXml(company.getHeadquarters())}</p>
    <p>${fn:escapeXml(company.getWorkPlace())}</p>
    <a href="/companies">Return to list</a>
</body>
</html>
