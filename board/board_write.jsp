<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../BoardWrite.bo" method="post">
		<table border="1">
			<tr>
				<td colspan="2">게시판글 글쓰기</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" cols="50" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>