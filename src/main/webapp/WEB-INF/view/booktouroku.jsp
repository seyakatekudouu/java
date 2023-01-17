<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="bookservlet" method="post">
	ID:<input type="text" name="ID"><br>
	ISBN:<input type="text" name="ISBN"><br>
	図書名:<input type="text" name="bookname"><br>
	著者:<input type="text" name="writer"><br>
	出版社:<input type="text" name="shupansha"><br>
	<input type="submit" value="送信">
	</form>
	
		<a href="menuservlet">メニュー</a>
</body>
</html>