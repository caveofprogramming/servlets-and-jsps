<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hello

<!-- Forward to another page (server side; the browser never sees forward.jsp, 
only index.jsp, but the url remains forward.jsp) the using jsp:forward tag -->
<jsp:forward page="index.jsp"></jsp:forward>



<%

// forward to another page (server side) via Java
// request.getRequestDispatcher("index.jsp").forward(request, response);

// redirect to another page (client side) via Java. The browser will briefly
// see forward.jsp, before going to the url for index.jsp
// response.sendRedirect("index.jsp");

%>

</body>
</html>