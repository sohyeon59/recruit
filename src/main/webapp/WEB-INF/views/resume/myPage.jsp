<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link rel="stylesheet" href="../css/mypage.css">
</head>
<body>
<%@ include file="../heafoo/header.jsp" %>

<section id="mypage_section">

	<div id="mypage_title">
		<h1>MyPage</h1>
	</div>

	<table>
		<tr>
			<th>번호</th>
			<th>기업명</th>
			<th>공고명</th>
			<th>마감기한</th>
		</tr>

		<tbody id="tbody">
			<c:forEach var="resume" items="${resumeList}" varStatus="status">
			<tr data-rno="${resume.rno}">
			    <td>${status.count}</td>
			    <td>${resume.cname}</td>
			    <td>${resume.title}</td>
			    <td>
			        <fmt:formatDate value="${resume.deadline}" pattern="yyyy-MM-dd"/>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</section>

<script>

	const tbody = document.getElementById("tbody");
	
	tbody.addEventListener('click', function(e) {
	    const tr = e.target.closest('tr');
	    if (!tr) return;
	
	    const rno = tr.dataset.rno;
	    location.href = "/resumeDetail?rno=" + rno;
	});
	
</script>

</body>
</html>