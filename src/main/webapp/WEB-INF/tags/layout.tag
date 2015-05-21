<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
    <meta name="google-site-verification" content="xxxxxxxxx" />
    <title><jsp:invoke fragment="title"/></title>
    <meta name="description" content="<tiles:insertAttribute name='page_description' ignore='true'/>">
    <c:url var="cssURL" value="/static/css/style.min.css"/>
    <link href="${cssURL}" rel="stylesheet" type="text/css"/>
    <link rel="icon" href="<c:url value='/static/images/favicon.ico'/>" type="image/x-icon" />
    <link rel="shortcut icon" href="<c:url value='/static/images/favicon.ico'/>" type="image/x-icon" />
    <meta charset="utf-8">
    <meta property="og:image" content="<tiles:insertAttribute name='og_image' ignore='true'/>" />
    <meta property="og:title" content="<tiles:insertAttribute name='og_title' ignore='true'/>" />
    <meta property="og:description" content="<tiles:insertAttribute name='og_desc' ignore='true'/>"/>
    <link rel="stylesheet" href="<tiles:insertAttribute name='jquery_ui_css' ignore='true'/>" />
</head>
<body>
<div id="pageheader">
    <jsp:invoke fragment="header"/>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>