<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  WorkOffer: eduard
  Date: 27/04/15
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WorkOffer</title>
</head>
<body>
    <h3>WorkOffer:</h3>
        <p>${fn:escapeXml(workOffer.getMinNumWeeks())}</p>
        <p>${fn:escapeXml(workOffer.getMaxNumWeeks())}</p>
        <p>${fn:escapeXml(workOffer.getCountry())}</p>
    <a href="/api/workOffers">Return to list</a>
</body>
</html>
