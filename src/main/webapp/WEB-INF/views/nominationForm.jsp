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
    <title>Nomination Form</title>
</head>
<body>
<c:choose>
    <c:when test="${nomination.getId()>=0}">
        <h3>Update Nomination</h3>
        <c:set var="method" value="PUT"/>
        <c:set var="action" value="/nominations/${nomination.getId()}"/>
    </c:when>
    <c:otherwise>
        <h3>Create Nomination</h3>
        <c:set var="method" value="POST"/>
        <c:set var="action" value="/nominations"/>
    </c:otherwise>
</c:choose>
<form:form method="${method}" action="${action}" modelAttribute="nomination">
    <table>
        <tr>
            <td><form:label path="nominated">Nominated User</form:label></td>
            <td><form:input path="nominated"/> <i><form:errors path="nominated"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="workOffer">Work Offer</form:label></td>
            <td><form:input path="workOffer"/> <i><form:errors path="workOffer"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="officerDelegate">Officer Delegate</form:label></td>
            <td><form:input path="officerDelegate"/> <i><form:errors path="officerDelegate"></form:errors></i></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
