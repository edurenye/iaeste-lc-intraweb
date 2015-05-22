<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Company Form</title>
</head>
<body>
<c:choose>
    <c:when test="${company.getId()>=0}">
        <h3>Update Company</h3>
        <c:set var="method" value="PUT"/>
        <c:set var="action" value="/companies/${company.getId()}"/>
        <c:set var="exist" value="${true}"/>
    </c:when>
    <c:otherwise>
        <h3>Create Company</h3>
        <c:set var="method" value="POST"/>
        <c:set var="action" value="/companies"/>
        <c:set var="exist" value="${false}"/>
    </c:otherwise>
</c:choose>
<form:form method="${method}" action="${action}" modelAttribute="company">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/> <i><form:errors path="name"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="headquarters">Headquarters</form:label></td>
            <td><form:input path="headquarters"/> <i><form:errors path="headquarters"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="workPlace">Work Place</form:label></td>
            <td><form:input path="workPlace"/> <i><form:errors path="workPlace"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="foundationDate">Foundation Date</form:label></td>
            <td><form:input path="foundationDate"/> <i><form:errors path="foundationDate"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone Number</form:label></td>
            <td><form:input path="phoneNumber"/> <i><form:errors path="phoneNumber"></form:errors></i></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

<c:if test="${!exist}">
    <form:form method="GET" action="results" modelAttribute="company">
        <table>
            <tr>
                <td><form:label path="name">Search company by name</form:label></td>
                <td><form:input path="name"/> <i><form:errors path="name"></form:errors></i></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
</c:if>

</body>
</html>
