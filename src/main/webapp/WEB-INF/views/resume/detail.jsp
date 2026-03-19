<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>디테일 페이지</title>
<link rel="stylesheet" href="../css/detail.css">
</head>
<body>

	<%@ include file="../heafoo/header.jsp"%>

	<section id="resume_section">
		<div id="resume_title">
			<h1>Resume Detail</h1>
		</div>

		<form action="/regResume" method="POST">
			<input type="hidden" name="rno" value="${detail.rno}">

			<div class="form_row">
				<label>성명</label> <input type="text" name="mname"
					value="${detail.mname}" readonly>
			</div>

			<div class="form_row">
				<label>생년월일</label> <input type="text" name="mbirth"
					value="<fmt:formatDate value='${detail.mbirth}' pattern='yyyy-MM-dd'/>"
					readonly>
			</div>

			<div class="form_row">
				<label>이메일</label> <input type="text" name="memail"
					value="${detail.memail}" readonly>
			</div>

			<div class="form_row">
				<label>전화번호</label> <input type="text" name="mphone"
					value="${detail.mphone}" readonly>
			</div>

			<div class="form_row">
				<label>주소</label> <input type="text" name="address"
					value="${detail.address}">
			</div>

			<div class="form_row">
				<label>학력</label> <input type="text" name="univ"
					value="${detail.univ}">
			</div>

			<div class="form_row">
				<label>전공</label> <input type="text" name="major"
					value="${detail.major}">
			</div>

			<div class="form_row">
				<label>경력</label> <input type="text" name="career"
					value="${detail.career}">
			</div>

			<div class="form_row">
				<label>경험</label> <input type="text" name="experi"
					value="${detail.experi}">
			</div>

			<div class="form_row textarea_row">
				<label>자기소개</label>
				<textarea name="intro">${detail.intro}</textarea>
			</div>
			<button onclick="deleteResume(${detail.rno})">삭제</button>
			<button type="submit">저장 및 제출</button>
		</form>

		<script>
function deleteResume(rno) {
    if (confirm("정말 삭제하시겠습니까?")) {
        // 컨트롤러의 @GetMapping("/deleteResume")으로 이동
        location.href = "/deleteResume?rno=" + rno;
    }
}
</script>

	</section>
</body>
</html>