<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">
      Companies
    </jsp:attribute>
    <jsp:attribute name="header">
        <h1>IAESTE LC Lleida Intraweb</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <p><a href="/api/login">Login</a></p>
        <p><a href="/api/companies">List all companies</a></p>
    </jsp:body>
</t:layout>
