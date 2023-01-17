<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="dao.BookDAO"%>
<%@page import="dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>図書一覧</h1>
	<%request.setCharacterEncoding("UTF-8"); 
	String ID;
	String ISBN;
	String bookname;
	String writer;
	String shupansha;%>
	
	<form action="reserchiservlet">
	ISBN:<input type=""text name="ISBN">
	<input type="submit" value="検索">
	</form>
	
	<table border=1>
		<tr>
		<th>ID</th>
		<th>ISBN</th>
		<th>図書名</th>
		<th>著者</th>
		<th>出版社</th>
		</tr>
		
		<% List <Book> list=BookDAO.selectAllBook(); 
	for(Book e : list){ %>
	<tr>
		<td><%=ID=e.getID() %></td>
	<td><%=ISBN=e.getISBN() %></td>
	<td><%=bookname=e.getBookname() %></td>
	<td><%=writer=e.getWriter() %></td>
	<td><%=shupansha=e.getShupansha() %></td><br>
	</tr>
		
		<% } %>

	
	</table>
	
		<a href="menuservlet">メニュー</a>
</body>
</html>