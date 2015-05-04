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
    <title>Companies</title>
</head>
<body>
    <ul>
        <c:if test="${not empty companies}">
            <c:forEach var="company" items="${companies}">
                <li>
                    <a href="/companies/${company.getId()}">${company.getId()}</a>: ${fn:escapeXml(company.getName())} <a href="/companies/${company.getId()}/form">Edit company</a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
    <a href="/companies/form">New company</a>
</body>
</html>
