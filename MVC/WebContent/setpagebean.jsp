<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user2" class="beans.User" scope="page"></jsp:useBean>

<jsp:setProperty name="user2" property="email" value="john@caveofprogramming.com" />
<jsp:setProperty name="user2" property="password" value="letmein" />

Email: <%= user2.getEmail() %>

</body>
</html>