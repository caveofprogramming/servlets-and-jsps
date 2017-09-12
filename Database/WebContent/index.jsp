<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=login") %>">Click here to login</a></p>
<p><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=createaccount") %>">Click here to create a new account</a></p>
</body>
</html>