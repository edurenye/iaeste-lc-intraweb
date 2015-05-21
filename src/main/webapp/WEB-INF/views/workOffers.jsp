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
    <c:if test="${not empty workOffers}">
        <c:forEach var="workOffer" items="${workOffers}">
            <li>
                <a href="/workOffers/${workOffer.getId()}">${workOffer.getId()}</a>: ${fn:escapeXml(workOffer.getCountry())} <a href="/workOffers/${workOffer.getId()}/form">Edit workOffer</a>
            </li>
        </c:forEach>
    </c:if>
</ul>
<a href="/workOffers/form">New workOffer</a>
</body>
</html>
