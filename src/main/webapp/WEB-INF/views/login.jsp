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
<h2>로그인</h2>

  <button onclick="switchTab('member', this)">개인회원</button>
  <button onclick="switchTab('company', this)">기업회원</button>

  <hr>

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
    <a href="/register?type=member">개인회원 가입</a>
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
    <a href="/register?type=company">기업회원 가입</a>
  </div>

  <script>
    function switchTab(type) {
      document.getElementById('panel-member').style.display = 'none';
      document.getElementById('panel-company').style.display = 'none';
      document.getElementById('panel-' + type).style.display = 'block';
    }
  </script>

</body>
</html>