<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 페이지</title>
<link rel="stylesheet" href="/css/resume.css">
</head>
<body>
<section id="resume_section">

    <div id="resume_title">
        <h1>이력서 작성</h1>
    </div>

    <form action="/regResume" method="POST">
        <input type="hidden" name="mid" value="${sessionScope.loginMember.mid}">
        <input type="hidden" name="jno" value="${jno}">
        <div class="form_row">
            <label>성명</label>
            <input type="text" name="mname" value="${sessionScope.loginMember.mname}">
        </div>

        <fmt:formatDate value="${sessionScope.loginMember.mbirth}" pattern="yyyy-MM-dd" var="mbirth"/>

        <div class="form_row">
            <label>생년월일</label>
            <input type="date" name="mbirth" value="${mbirth}">
        </div>

        <div class="form_row">
            <label>이메일</label>
            <input type="email" name="memail" value="${sessionScope.loginMember.memail}">
        </div>

        <div class="form_row">
            <label>전화번호</label>
            <input type="tel" name="mphone" value="${sessionScope.loginMember.mphone}">
        </div>

        <div class="form_row">
            <label>주소</label>
            <input type="text" name="address">
        </div>

        <div class="form_row">
            <label>학력</label>
            <input type="text" name="univ">
        </div>

        <div class="form_row">
            <label>전공</label>
            <input type="text" name="major">
        </div>

        <div class="form_row">
            <label>경력</label>
            <input type="text" name="career">
        </div>

        <div class="form_row">
            <label>경험</label>
            <input type="text" name="experi">
        </div>

        <div class="form_row textarea_row">
            <label>자기소개</label>
            <textarea name="intro"></textarea>
        </div>

        <button type="submit">제출</button>
    </form>
<p>모든 항목을 기입해주시기 바랍니다. 비워야하는 항목은 없음이라고 적어주세요.</p>
</section>
</body>
</html>