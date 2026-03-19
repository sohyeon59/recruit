<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 상세</title>
</head>
<body>
<%@ include file="../heafoo/header.jsp" %>

<h2>공고 상세</h2>
<hr>

<table border="1">
    <tr><th>제목</th><td>${job.title}</td></tr>
    <tr><th>마감일</th><td>${job.deadline}</td></tr>
    <tr><th>내용</th><td>${job.content}</td></tr>
</table>

<hr>

<c:choose>
    <c:when test="${job.deadline lt today}">
        <p>마감된 공고입니다.</p>
    </c:when>
    <c:when test="${isLogin}">
        <a href="/goResume?jno=${job.jno}">
            <button>이력서 등록하기</button>
        </a>
    </c:when>
    <c:otherwise>
        <p>이력서를 등록하려면 <a href="/loginForm">로그인</a>이 필요합니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>