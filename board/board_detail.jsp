<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.db.BoardBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	BoardBean board=(BoardBean)request.getAttribute("boarddetail");
	System.out.println("board_detail.jsp="+board);
%>
</head>
<body>
	<form action="BoardModify.bo" method="post">
		<table border="1">
			<tr>
				<td>게시물번호</td>
				<td><b><%=board.getBno()%></b><input type="hidden" name="bno" value="<%=board.getBno()%>"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="<%=board.getSubject()%>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="<%=board.getContent() %>"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><b><%=board.getWriter() %></b><input type="hidden" name="writer" value="<%=board.getWriter() %>"></td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td><b><%=board.getWritedate() %></b><input type="hidden" name="writedate" value="<%=board.getWritedate() %>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="게시글정보수정"></td>
				<td><a href="BoardDel.bo?bno=<%=board.getBno() %>">게시글삭제</a></td>
			</tr>
		</table>
	</form>
</body>
</html>