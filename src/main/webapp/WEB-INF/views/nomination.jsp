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
        <title>Nomination</title>
    </head>
    <body>
        <h3>Nomination:</h3>
        <p>${fn:escapeXml(nomination.getNominated())}</p>
        <p>${fn:escapeXml(nomination.getWorkOffer())}</p>
        <p>${fn:escapeXml(nomination.getOfficerDelegate())}</p>
        <a href="/nominations">Return to list</a>
    </body>
</html>
