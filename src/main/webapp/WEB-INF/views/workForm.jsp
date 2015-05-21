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
    <title>Work Form</title>
</head>
<body>
<c:choose>
    <c:when test="${work.getId()>=0}">
        <h3>Update Work</h3>
        <c:set var="method" value="PUT"/>
        <c:set var="action" value="/works/${work.getId()}"/>
    </c:when>
    <c:otherwise>
        <h3>Create Work</h3>
        <c:set var="method" value="POST"/>
        <c:set var="action" value="/works"/>
    </c:otherwise>
</c:choose>
<form:form method="${method}" action="${action}" modelAttribute="work">
    <table>
        <tr>
            <td><form:label path="points">Points </form:label></td>
            <td><form:input path="points"/> <i><form:errors path="points"></form:errors></i></td>
        </tr>
        <tr>
            <td><form:label path="worker">Worker</form:label></td>
            <td><form:input path="worker"/> <i><form:errors path="worker"></form:errors></i></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
