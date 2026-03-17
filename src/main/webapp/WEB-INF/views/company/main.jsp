<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th style="width: 80px;">번호</th>
				<th>사명</th>
				<th style="width: 120px;">제목</th>
				<th style="width: 150px;">마감일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty jobList}">
					<c:forEach var="job" items="${jobList}" varStatus="status">
						<tr onclick="location.href='/company/detail?jno=${job.jno}'" style="cursor: pointer;">
							<td>${job.jno}</td>
							<td>${companyName}</td>
							<td>${job.title}</td>
							<td>${job.deadline}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">등록된 게시글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>