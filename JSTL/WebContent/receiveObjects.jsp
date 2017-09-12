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

<c:out value="${user1.name}" /> <br/>
<c:out value="${user2.name}" /> <br/>
<c:out value="${user3.name}" /> <br/>

<p/>
<c:out value="${sessionScope.user2.name}" /> <br/>

<p/>
<c:out value='${map1["fruit"]}' /> <br/>

<p/>
<c:out value="${link}" /> <br/>

${link}<br/>

<p/>
<table style="border: 1px solid gray; padding: 10px;">
<c:forEach var="animal" items="${list1}">
	<tr><td>${animal.id}</td><td>${animal.name}<td> </tr>
</c:forEach>
</table>

</body>
</html>