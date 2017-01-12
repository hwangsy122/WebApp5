<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>write.jsp</title>
</head>
<body>
<h1>글쓰기 페이지</h1>
<form method="post" action="write.board">
	제목 : <input type="text" name="title"/><br><br>
	작성자 : <input type="text" name="writer"/><br><br>
	내용 : <input type="text" name="content"/><br><br>
	<input type="submit" value="저장"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="리스트 페이지로"/>
</form>
</body>
</html>