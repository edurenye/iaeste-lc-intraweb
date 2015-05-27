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
    <title>Nominations</title>
</head>
<body>
<ul>
    <c:if test="${not empty nominations}">
        <c:forEach var="nomination" items="${nominations}">
            <li>
                <a href="/api/nominations/${nomination.getId()}">${nomination.getId()}</a>: ${fn:escapeXml(nomination.getName())} <a href="/api/nominations/${nomination.getId()}/form">Edit nomination</a>
            </li>
        </c:forEach>
    </c:if>
</ul>
<a href="/api/nominations/form">New nomination</a>
</body>
</html>
