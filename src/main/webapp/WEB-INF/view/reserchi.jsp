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
<% request.setCharacterEncoding("UTF-8");
String ISBN=request.getParameter("ISBN");
String ID;
String bookname;
String writer;
String shupansha;
%>

<table border=1>
		<tr>
		<th>ID</th>
		<th>ISBN</th>
		<th>図書名</th>
		<th>著者</th>
		<th>出版社</th>
		</tr>
<%List <Book>list= BookDAO.searchBookByISBN(ISBN); 
for(Book e : list){ %>

	<tr>
		<td><%=ID=e.getID() %></td>
	<td><%=ISBN=e.getISBN() %></td>
	<td><%=bookname=e.getBookname() %></td>
	<td><%=writer=e.getWriter() %></td>
	<td><%=shupansha=e.getShupansha() %></td>
	</tr>
	<% } %>
	</table>
			<a href="menuservlet">メニュー</a>
</body>
</html>