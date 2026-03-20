<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/pagination.css">
</head>
<body>
	<%@ include file="heafoo/header.jsp" %>

	<section id="main_menu">
		<h2>전체 공고</h2>

		<%-- 검색 폼 --%>
		<form action="/" method="get">
			<select name="cat" id="catSelect">
				<option value="title"    ${cat == 'title'    ? 'selected' : ''}>공고 제목</option>
				<option value="cname"    ${cat == 'cname'    ? 'selected' : ''}>회사명</option>
				<option value="deadline" ${cat == 'deadline' ? 'selected' : ''}>마감일</option>
			</select>
			<input type="text" name="searchText" value="${searchText}" placeholder="검색어를 입력하세요" id="searchInput" />

			<%-- 날짜 picker (화면 표시용) --%>
			<input type="date" id="startDatePicker" value="${startDate}" style="display:none" />
			<span id="dateSep" style="display:none">~</span>
			<input type="date" id="endDatePicker"   value="${endDate}"   style="display:none" />

			<%-- 실제 전송용 hidden input --%>
			<input type="hidden" name="startDate" id="startDate" value="${startDate}" />
			<input type="hidden" name="endDate"   id="endDate"   value="${endDate}" />

			<button type="submit">검색</button>
			<c:if test="${not empty searchText or not empty startDate}">
				<a href="/">초기화</a>
			</c:if>
		</form>

		<table>
            <thead>
                <tr>
                    <th style="width: 10%;">번호</th>
                    <th style="width: 25%;">사명</th>
                    <th style="width: 45%;">제목</th>
                    <th style="width: 20%;">마감일</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty jobList}">
                        <c:forEach var="job" items="${jobList}" varStatus="status">
                            <tr onclick="location.href='/job/detail?jno=${job.jno}'" style="cursor: pointer;">
                                <td>${(ph.page - 1) * 10 + status.count}</td>
                                <td>${job.cname}</td>
                                <td class="title-cell">${job.title}</td>
                                <td>${job.deadline}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="4" class="empty-message">검색 결과가 없습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>

        <%-- 페이지네이션 --%>
        <%@ include file="pagination.jsp" %>

	</section>

	<script>
		const catSelect       = document.getElementById('catSelect');
		const searchInput     = document.getElementById('searchInput');
		const startDatePicker = document.getElementById('startDatePicker');
		const dateSep         = document.getElementById('dateSep');
		const endDatePicker   = document.getElementById('endDatePicker');
		const startDate       = document.getElementById('startDate');
		const endDate         = document.getElementById('endDate');

		function updateInputType() {
			const isDeadline = catSelect.value === 'deadline';
			searchInput.style.display     = isDeadline ? 'none' : '';
			startDatePicker.style.display = isDeadline ? '' : 'none';
			dateSep.style.display         = isDeadline ? '' : 'none';
			endDatePicker.style.display   = isDeadline ? '' : 'none';
		}
		catSelect.addEventListener('change', updateInputType);
		updateInputType();

		// picker 값을 hidden input에 동기화
		startDatePicker.addEventListener('change', function () {
			startDate.value = this.value;
			endDatePicker.min = this.value;
			if (endDatePicker.value && endDatePicker.value < this.value) {
				endDatePicker.value = this.value;
				endDate.value = this.value;
			}
		});

		endDatePicker.addEventListener('change', function () {
			endDate.value = this.value;
			startDatePicker.max = this.value;
			if (startDatePicker.value && startDatePicker.value > this.value) {
				startDatePicker.value = this.value;
				startDate.value = this.value;
			}
		});
	</script>

</body>
</html>
