<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 페이지</title>
</head>
<body>
<h1>이력서 작성</h1>
<hr>

<form action="/regResume" method="POST">
	<input type="hidden" name="mid" value="${sessionScope.loginMember.mid }">
	<input type="hidden" name="jno" value="${param.jno }">
	성명 <input type="text" name="mname" value="${sessionScope.loginMember.mname }"><br>
	<fmt:formatDate value="${sessionScope.loginMember.mbirth}" pattern="yyyy-MM-dd" var="mbirth"/>
	생년월일 <input type="date" name="mbirth" value="${mbirth}"><br>
	이메일 <input type="email" name="memail" value="${sessionScope.loginMember.memail }"><br>
	전화번호 <input type="tel" name="mphone" value="${sessionScope.loginMember.mphone }"><br>
	주소 <input type="text" name="address"><br>
	학력 <input type="text" name="univ"><br>
	전공 <input type="text" name="major"><br>
	경력 <input type="text" name="career"><br>
	경험 <input type="text" name="experi"><br>
	자기소개<br><textarea cols="100" rows="30" name="intro"></textarea>
	<input type="submit" value="제출"><br>
</form>
</body>
</html>