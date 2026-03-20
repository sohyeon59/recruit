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
		<form action="/" method="get" style="margin-bottom: 16px; display: flex; gap: 8px;">
			<select name="cat">
				<option value="title"  ${cat == 'title'   ? 'selected' : ''}>공고 제목</option>
				<option value="cname"  ${cat == 'cname'   ? 'selected' : ''}>회사명</option>
				<option value="deadline" ${cat == 'deadline' ? 'selected' : ''}>마감일</option>
			</select>
			<input type="text" name="searchText" value="${searchText}" placeholder="검색어를 입력하세요" />
			<button type="submit">검색</button>
			<c:if test="${not empty searchText}">
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

</body>
</html>
