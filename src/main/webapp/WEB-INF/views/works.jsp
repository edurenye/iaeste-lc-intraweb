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
    <title>Works</title>
</head>
<body>
<ul>
    <c:if test="${not empty works}">
        <c:forEach var="work" items="${works}">
            <li>
                <a href="/works/${work.getId()}">${work.getId()}</a>: ${fn:escapeXml(work.getName())} <a href="/works/${work.getId()}/form">Edit work</a>
            </li>
        </c:forEach>
    </c:if>
</ul>
<a href="/works/form">New work</a>
</body>
</html>
