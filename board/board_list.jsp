<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.db.BoardBean" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	ArrayList<BoardBean> boardList = (ArrayList<BoardBean>)request.getAttribute("boardlist");
%>
</head>
<body>
<h1>board_list페이지</h1>
	<table border="1">
		<tr>
			<td>글리스트</td>
		</tr>
		<tr>
			<td>글번호</td><td>글제목</td><td>글내용</td><td>작성자</td><td>작성일자</td>
		</tr>
		<%for(int i=0;i<boardList.size();i++){
			BoardBean bean = (BoardBean)boardList.get(i);
		%>
		<tr>
			<td><a href="BoardDetail.bo?bno=<%= bean.getBno() %>"><%= bean.getBno() %></a></td>
			<td><%= bean.getSubject() %></td>
			<td><%= bean.getContent() %></td>
			<td><%= bean.getWriter() %></td>
			<td><%= bean.getWritedate() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>