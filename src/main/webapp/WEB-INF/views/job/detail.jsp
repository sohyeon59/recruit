<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 상세</title>
<link rel="stylesheet" href="/css/jobdetail.css">
</head>
<body>

	<%@ include file="../heafoo/header.jsp" %>
	
	<%-- today 변수 설정 --%>
	<jsp:useBean id="todayDate" class="java.util.Date" />
	<fmt:formatDate value="${todayDate}" pattern="yyyy-MM-dd" var="today" />

	<div class="jobdetail-page">

		<h2 class="page-title">공고 상세</h2>
		<hr>

		<table class="job-table">
			<tr>
				<th>제목</th>
				<td>${job.title}</td>
			</tr>
			<tr>
				<th>마감일</th>
				<td>${job.deadline}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td class="content-cell">${job.content}</td>
			</tr>
		</table>

		<hr>

		<div class="action-box">
			<c:choose>
				<c:when test="${job.deadline lt today}">
					<p class="closed-msg">마감된 공고입니다.</p>
				</c:when>
				<c:when test="${isMember}">
					<a href="/goResume?jno=${job.jno}" class="btn-apply"> 지원서 작성하기
					</a>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${!isLogin}">
							<p class="login-msg">
								이력서를 등록하려면 <a href="/loginForm">로그인</a>이 필요합니다.
							</p>
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</div>
		
		
		<div class="comment-list">
		    <table class="comment-table">

		        <tbody>
		            <c:forEach var="comment" items="${commentList}" varStatus="status">
		                <tr>
		                    <td>${status.count}</td>
		                    <td>${comment.content}</td>
		                    <td>${comment.mid}</td>
		                    <td>${comment.created_at}</td>
		                    <td>
								<button type="button" onclick="location.href='/updateComment?content=${comment.content}&comno=${comment.comno}&jno=${job.jno}'">수정</button>
								<button type="button" onclick="">삭제</button>
		                    </td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>
		
<%		if(isLogin){	 %>
		<div class="comment-section">
			<form action="/insertComment" method="post">
				<input type="hidden" name="mid" value="${sessionScope.loginMember.mid}">
				<input type="hidden" name="jno" value="${job.jno}">


				<textarea name="content" rows="1" placeholder="댓글을 입력하세요..." required></textarea>
				<button type="submit">등록</button>
			</form>
		</div>
<%		}else{	%>
		<div class="comment-section comment-section-mg">
			<h6>댓글을 입력하시려면 <a href="/loginForm"><b>로그인</b></a>을 해주세요!</h6>
		</div>
<% 		}%>



	</div>

<script>
	
	function modcom(btn){		
		
		const content = btn.dataset.content;
	    const comno = btn.dataset.comno;
	    const jno = btn.dataset.jno;
	    
		const contentCom = document.getElementById("content" + comno);		
		contentCom.innerHTML = `<input type="text" id="edit${comno}" value="${content}">`;
		
		btn.outerHTML = `<button onclick="updateCom(${comno}, ${jno})">저장</button>`;
	}
		
	function updateCom(comno, jno){		
		const editCom = document.getElementById("edit" + comno).value;
		
		location.href= "/updateComment?content=" + editCom + "&comno=" + comno + "&jno=" + jno;
	}
	
	
	

</script>
</body>
</html>