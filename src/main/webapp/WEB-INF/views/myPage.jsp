<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="heafoo/header.jsp" %>
<h1>MyPage</h1>
<hr>

<table border="1">
	<tr>
		<th>번호</th>
		<th>기업명</th>
		<th>마감기한</th>
	</tr>
	<% int no = 1; %>
	<c:forEach var="resume" items="resumeList">
	<tr>
		<td><%= no++ %></td>
		<td>${resume.cname }</td>
		<td>${resume.deadline }</td>
	</tr>
	</c:forEach>

</table>

<c:if test="${regResult } == 1">
<script>
	alert("지원서가 제출되었습니다. 마감기한까지 수정이 가능합니다.")
</script>
</c:if>

<c:if test="${modResult } == 1">
<script>
	alert("지원서가 수정되었습니다. 마감기한까지 수정이 가능합니다.")
</script>
</c:if>

<c:if test="${delResult } == 1">
<script>
	alert("지원서가 제출되었습니다. 마감기한까지 수정이 가능합니다.")
</script>
</c:if>

</body>
</html>