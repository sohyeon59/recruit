<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구인공고 상세 및 지원자 목록</title>
<link rel="stylesheet" href="../css/Comdetail.css">
</head>
<body>
	<%@ include file="../heafoo/header.jsp" %>
	<div class="container detail-page">

		<div class="job-header">
			<h2>${job.title}</h2>
		</div>

		<div class="job-content">${job.content}</div>

		<h3 class="section-title">지원자 목록</h3>
		<table>
			<thead>
				<tr>
					<th style="width: 20%;">지원자 아이디</th>
					<th style="width: 40%;">전공</th>
					<th style="width: 40%;">경력</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty resumeList}">
						<c:forEach var="resume" items="${resumeList}">
							<tr onclick="location.href='/company/detailApplicant?rno=${resume.rno}'">
								<td>${resume.mid}</td>
								<td>${resume.major}</td>
								<td>${resume.career}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3" class="empty-msg">아직 이 공고에 지원한 인원이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		
		<div class="btn-wrap">
			<a href="/company/editJobForm?jno=${job.jno}" class="btn-edit">수정하기</a><br><br>
			<a href="/company/main" class="btn-back">목록으로 돌아가기</a>
		</div>
	</div>
</body>
</html>