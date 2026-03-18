<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Resume Detail</h1>
<hr>

<form action="/regResume" method="POST">
	<input type="hidden" name="rno" value="${detail.rno}">
	성명 <input type="text" name="mname" value="${detail.mname }" readonly><br>
	생년월일 <input type="text" name="mbirth" value="<fmt:formatDate value='${detail.mbirth}' pattern='yyyy-MM-dd'/>" readonly><br>
	이메일 <input type="text" name="memail" value="${detail.memail }" readonly><br>
	전화번호 <input type="text" name="mphone" value="${detail.mphone }" readonly><br>
	주소 <input type="text" name="address" value="${detail.address }"><br>
	학력 <input type="text" name="univ" value="${detail.univ }"><br>
	전공 <input type="text" name="major" value="${detail.major }"><br>
	경력 <input type="text" name="career" value="${detail.career }"><br>
	경험 <input type="text" name="experi" value="${detail.experi }"><br>
	자기소개<br><textarea cols="100" rows="30" name="intro">${detail.intro }</textarea>
	<input type="submit" value="저장 및 제출"><br>
</form>
</body>
</html>