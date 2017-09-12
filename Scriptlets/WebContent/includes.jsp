<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- static include: content changes infrequently -->
<%@ include file="copyright.txt" %>

<p/>

<!--  dynamic include: content changes a lot -->
<jsp:include page="updates.txt" />

<p/>

<!--  Must use static include if it's got java code in it that we want to access -->
<%@ include file="variables.jsp" %>
<%= name %>

<p/>
<!-- Must use include jsp tag if you don't know what file you want till run time  -->

<% String id = request.getParameter("id"); %>

<% if(id == null) { %>

<jsp:include page="idnotfound.html" />

<% } else { %>

<jsp:include page="idfound.html" />

<% } %>


</body>
</html>

