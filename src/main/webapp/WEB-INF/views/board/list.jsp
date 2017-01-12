<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>리스트 페이지</h1>
<a href="write.board">글쓰기</a><br><br>
<table border="1">
	<tr>
		<th>번호</th><th>제목</th><th>등록자</th><th>등록일</th>
		<th>조회수</th>
	</tr>
<c:forEach var="row" items="${board}">
	<tr>
		<td>${row.seq}</td>
		<td><a href="read.board?seq=${row.seq}">${row.title}</a></td>
		<td>${row.writer}</td>
		<td>${row.regdate}</td>
		<td>${row.hitcount}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>










