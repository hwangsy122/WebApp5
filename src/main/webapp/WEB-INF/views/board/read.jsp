<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>write.jsp</title>
</head>
<body>
<h1>상세 글보기 페이지</h1>
<ul>
	<li>글번호 : ${board.seq}</li>
	<li>제목 : ${board.title}</li>
	<li>작성자 : ${board.writer}</li>
	<li>내용 : ${board.content}</li>
</ul>
<br><br>
<input type="button" value="수정" onclick="location.href='update.board?seq=${board.seq}'"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="삭제"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="목록"/>&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html>





