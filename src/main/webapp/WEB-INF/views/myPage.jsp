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
	<tbody id="tbody">
	<% int no = 1; %>
	<c:forEach var="resume" items="${resumeList }">
	<tr>
		<td style="display:none;">${resume.rno}</td>
		<td><%= no++ %></td>
		<td>${resume.cname }</td>
		<td>${resume.deadline }</td>
	</tr>
	</c:forEach>
	</tbody>

</table>

<script>

	const tbody = document.getElementById("tbody");
	
	tbody.addEventListener('click', function(e) {
    const tr = e.target.closest('tr');
    if (!tr) return;

    const rno = tr.children[0].textContent;
    location.href = "/resumeDetail?rno=" + rno;
});
	
</script>

<c:if test="${not empty regResult }">
<script>
	alert("지원서가 제출되었습니다. 마감기한까지 수정이 가능합니다.");
</script>
</c:if>

<c:if test="${not empty modResult }">
<script>
	alert("지원서가 수정되었습니다. 마감기한까지 수정이 가능합니다.");
</script>
</c:if>

<c:if test="${not empty delResult }">
<script>
	alert("지원서가 삭제되었습니다.");
</script>
</c:if>

</body>
</html>