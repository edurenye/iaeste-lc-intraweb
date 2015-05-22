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
    <title>User Form</title>
</head>
<body>
<c:choose>
    <c:when test="${user.getUsername()>=0}">
        <h3>Update User</h3>
        <c:set var="method" value="PUT"/>
        <c:set var="action" value="/users/${user.getUsername()}"/>
    </c:when>
    <c:otherwise>
        <h3>Create User</h3>
        <c:set var="method" value="POST"/>
        <c:set var="action" value="/users"/>
    </c:otherwise>
</c:choose>
<form:form method="${method}" action="${action}" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username"/> <i><form:errors path="username"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="birthdate">Birthday</form:label></td>
            <td><form:input path="birthdate"/> <i><form:errors path="birthdate"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/> <i><form:errors path="email"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/> <i><form:errors path="name"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname"/> <i><form:errors path="surname"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="join_date">join_date</form:label></td>
            <td><form:input path="join_date"/> <i><form:errors path="join_date"></form:errors></i></td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
