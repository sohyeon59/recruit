<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구인공고 상세 및 지원자 목록</title>
</head>
<body>
	<div class="container">

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
							<tr
								onclick="location.href='/company/detailApplicant?rno=${resume.rno}'"
								style="cursor: pointer;">
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
			<a href="/company/editJobForm?jno=${job.jno}" class="btn-edit">수정하기</a><br>

			<button onclick="deleteJob(${job.jno})" class="btn-delete">삭제하기</button><br>

			<a href="/company/main" class="btn-back">목록으로 돌아가기</a>
		</div>
	</div>
	<script>
       function deleteJob(jno) {
           if(confirm("정말 이 공고를 삭제하시겠습니까? 지원자 정보도 함께 영향을 받을 수 있습니다.")) {
               location.href = "/company/deleteJob?jno=" + jno;
           }
       }
   	</script>
</body>
</html>