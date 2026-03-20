<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구인공고 수정</title>
<link rel="stylesheet" href="../css/editJobForm.css">
</head>
<body>
<%@ include file="../heafoo/header.jsp" %>
    <div class="editjob-page">
        <h2>구인공고 수정</h2>
        
        <form action="/company/editJob" method="post">
            
            <input type="hidden" name="jno" value="${job.jno}">
            
            <div>
                <label for="title">공고 제목</label>
                <input type="text" name="title" value="${job.title}" required>
            </div>
            
            <div>
                <label for="deadline">마감일</label>
                <input type="date" name="deadline" 
                       value="<fmt:formatDate value='${job.deadline}' pattern='yyyy-MM-dd'/>" required>
            </div>
            
            <div>
                <label for="content">상세 내용</label>
                <textarea name="content" required>${job.content}</textarea>
            </div>
            
            <div>
                <button type="submit">수정 완료</button>
                <a href="/company/detail?jno=${job.jno}">취소</a>
            </div>
            
        </form> 
    </div>
</body>
</html>