<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- Output text --%>
<c:out value="Hello world jstl!"></c:out>

<%-- Access bean properties in JSTL --%>
<jsp:useBean id="test" class="beans.TestBean" scope="page"></jsp:useBean>

<p>Value of info "attribute": <c:out value="${test.info}" /></p>

<%-- Getting parameters --%>
Name parameter: <c:out value="${param.name}" />

<%-- JSTL if --%>
<p/>

<c:if test='${param.name == "Bob"}'>
Hello Bob
</c:if>

<c:if test='${param.name != "Bob"}'>
Hello there
</c:if>

<p/><p/>
<%-- JSTL choose --%>
<c:choose>
	<c:when test="${param.id == 1}">
		<b>ID is equal to 1</b>
	</c:when>
	<c:when test="${param.id == 2}">
		<b>ID is equal to 2</b>
	</c:when>
	<c:otherwise>
		ID is neither 1 nor 2.
	</c:otherwise>
</c:choose>

<p/><p/>

<%-- JSTL "for" loop --%>

<c:forEach var="i" begin="0" end="10" step="2" varStatus="status">

	Loop counter is: <c:out value="${i}" /> <br/>
	
	<c:if test="${status.first}">
	This was the first iteration
	</c:if>
	
	<c:if test="${status.last}">
	This was the last iteration
	</c:if>

</c:forEach>

</body>
</html>