<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<%@ include file="heafoo/header.jsp" %>

	<section id="login_section">
		
		<div id="login_headsection">
			<div id="login_logo">
				<h2>로그인</h2>	
			</div>
			<div id="comORmem">
				<button onclick="switchTab('member', this)">개인회원</button>
				<button onclick="switchTab('company', this)">기업회원</button>			
			</div>
		</div>
	
		<div id="panel-member">
			<h3>개인회원 로그인</h3>
			
			<c:if test="${not empty error}">
				<p>${error}</p>
			</c:if>
			
			<form action="/login/member" method="post">
				<div>
					<label for="mid">아이디</label>
					<input type="text" name="mid" id="mid" required autofocus>
				</div>
				<div>
					<label for="mpw">비밀번호</label>
					<input type="password" name="mpw" id="mpw" required>
				</div>
				<button type="submit">로그인</button>
			</form>
			<a href="/registForm">회원 가입으로 이동</a>
		</div>
	
		<div id="panel-company" style="display:none;">
			<h3>기업회원 로그인</h3>
			
			<c:if test="${not empty error}">
				<p>${error}</p>
			</c:if>
			
			<form action="/login/company" method="post">
				<div>
					<label for="cid">기업 아이디</label>
					<input type="text" name="cid" id="cid" required>
				</div>
				<div>
					<label for="cpw">비밀번호</label>
					<input type="password" name="cpw" id="cpw" required>
				</div>
				<button type="submit">로그인</button>
			</form>
			<a href="/registForm">회원 가입으로 이동</a>
		</div>
	</section>


	<script>
		function switchTab(type, btn) {
			document.getElementById('panel-member').style.display = 'none';
			document.getElementById('panel-company').style.display = 'none';
			document.getElementById('panel-' + type).style.display = 'block';

			document.querySelectorAll('#comORmem button').forEach(b => b.classList.remove('active'));
			btn.classList.add('active');
		}
	</script>

</body>
</html>