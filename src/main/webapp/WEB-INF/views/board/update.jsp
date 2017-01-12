<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>write.jsp</title>
</head>
<body>
<h1>글수정 페이지</h1>
<form method="post" action="update.board">
	<input type="hidden" name="seq" value="${board.seq}"/>
	제목 : <input type="text" name="title" value="${board.title}"/><br><br>
	작성자 : <input type="text" name="writer" value="${board.writer}"/><br><br>
	내용 : <input type="text" name="content" value="${board.content}"/><br><br>
	<input type="submit" value="저장"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="리스트 페이지로"/>
</form>
</body>
</html>