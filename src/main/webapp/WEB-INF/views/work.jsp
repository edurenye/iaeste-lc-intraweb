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
    <title>Work</title>
</head>
<body>
<h3>Work:</h3>
<p>${fn:escapeXml(work.getPoints())}</p>
<p>${fn:escapeXml(work.getWorker())}</p>
<p>${fn:escapeXml(work.isFinished())}</p>
<a href="/works">Return to list</a>
</body>
</html>
