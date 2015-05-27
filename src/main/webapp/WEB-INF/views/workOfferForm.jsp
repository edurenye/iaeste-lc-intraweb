<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: eduard
  Date: 27/04/15
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WorkOffer Form</title>
</head>
<body>
<c:choose>
    <c:when test="${workOffer.getId()>=0}">
        <h3>Update WorkOffer</h3>
        <c:set var="method" value="PUT"/>
        <c:set var="action" value="/api/workOffers/${workOffer.getId()}"/>
    </c:when>
    <c:otherwise>
        <h3>Create WorkOffer</h3>
        <c:set var="method" value="POST"/>
        <c:set var="action" value="/api/workOffers"/>
    </c:otherwise>
</c:choose>
<form:form method="${method}" action="${action}" modelAttribute="workOffer">
    <table>
        <tr>
            <td><form:label path="minNumWeeks">Minim number of weeks</form:label></td>
            <td><form:input path="minNumWeeks"/> <i><form:errors path="minNumWeeks"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="maxNumWeeks">Maxim number of weeks</form:label></td>
            <td><form:input path="maxNumWeeks"/> <i><form:errors path="maxNumWeeks"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="country">Country</form:label></td>
            <td><form:input path="country"/> <i><form:errors path="country"></form:errors></i></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
