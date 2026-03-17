<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h2>회원가입</h2>

	<button onclick="switchTab('member')">개인회원</button>
	<button onclick="switchTab('company')">기업회원</button>

	<hr>

	<div id="panel-member">
		<h3>개인회원 가입</h3>
		<c:if test="${not empty error}">
			<script>
      			alert(${error});
      		</script>
		</c:if>
		<form action="${pageContext.request.contextPath}/register/member"
			method="post">
			<div>
				<label>아이디</label> <input type="text" name="mid" required>
			</div>
			<div>
				<label>비밀번호</label> <input type="password" name="mpw" required>
			</div>
			<div>
				<label>이름</label> <input type="text" name="mname" required>
			</div>
			<div>
				<label>생년월일</label> <input type="date" name="mbirth">
			</div>
			<div>
				<label>이메일</label> <input type="email" name="memail">
			</div>
			<div>
				<label>핸드폰</label> <input type="tel" name="mphone">
			</div>
			<button type="submit">가입하기</button>
		</form>
		<a href="/loginform">로그인으로 돌아가기</a>
	</div>

	<div id="panel-company" style="display: none;">
		<h3>기업회원 가입</h3>
		<c:if test="${not empty error}">
			<script>
      			alert(${error});
      		</script>
		</c:if>
		<form action="${pageContext.request.contextPath}/register/company"
			method="post">
			<div>
				<label>기업 아이디</label> <input type="text" name="cid" required>
			</div>
			<div>
				<label>비밀번호</label> <input type="password" name="cpw" required>
			</div>
			<div>
				<label>기업명</label> <input type="text" name="cname" required>
			</div>
			<div>
				<label>기업 규모</label> <select name="csize">
					<option value="">선택하세요</option>
					<option value="대기업">대기업</option>
					<option value="중견기업">중견기업</option>
					<option value="중소기업">중소기업</option>
					<option value="스타트업">스타트업</option>
				</select>
			</div>
			<button type="submit">가입하기</button>
		</form>
		<a href="/loginform">로그인으로 돌아가기</a>
	</div>

	<script>
    const params = new URLSearchParams(window.location.search);
    const type = params.get('type');
    if (type === 'company') switchTab('company');

    function switchTab(type) {
      document.getElementById('panel-member').style.display = 'none';
      document.getElementById('panel-company').style.display = 'none';
      document.getElementById('panel-' + type).style.display = 'block';
    }
  </script>

</body>
</html>
