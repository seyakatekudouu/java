<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
String mail=request.getParameter("mail"); %>
	<h1>登録しました。</h1>
	<h2><%=mail%></h2>
	<a href="menuservlet">メニュー</a>
</body>
</html>