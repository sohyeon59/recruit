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
			<th>마감기한</th>
		</tr>

		<tbody id="tbody">
			<c:forEach var="resume" items="${resumeList}" varStatus="status">
			<tr data-rno="${resume.rno}">
			    <td>${status.count}</td>
			    <td>${resume.cname}</td>
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

<c:if test="${not empty regResult }">
	 <c:choose>
        <c:when test="${regResult == 1}">
            <script>
                alert("지원서가 제출되었습니다. 마감기한까지 수정이 가능합니다.");
            </script>
        </c:when>
        <c:otherwise>
            <script>
                alert("이미 지원한 공고입니다.");
            </script>
        </c:otherwise>
    </c:choose>
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