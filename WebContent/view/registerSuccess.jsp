<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>register success</title>
</head>
<body>

	<H1>You registered successfully</H1>
	<br>
	<ul>
		<li>Id:       ${customer.id}</li>
		<li>Password: ${customer.password}</li>
		<li>Gender:   ${customer.gender}</li>
		<li>Name:     ${customer.name}</li>
		<li>Email:    ${customer.email}</li>
	</ul>
	<br>

	<a href="/helloMVC/index.jsp">go to home page</a>
</body>
</html>