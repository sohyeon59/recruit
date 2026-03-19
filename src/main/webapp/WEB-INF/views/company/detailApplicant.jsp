<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<% pageContext.setAttribute("newLineChar", "\n"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지원자 이력서 상세</title>
<link rel="stylesheet" href="../css/detailApplicant.css">
</head>
<body>

<div class="resume-detail-page">

    <h2>지원자 이력서 상세 정보</h2>
    
    <hr>

    <h3>[ 인적 사항 ]</h3>
    <ul>
        <li><strong>지원 회사:</strong> ${detail.cname}</li>
        <li><strong>이름:</strong> ${detail.mname}</li>
        <li>
            <strong>생년월일:</strong> 
            <fmt:formatDate value="${detail.mbirth}" pattern="yyyy-MM-dd" />
        </li>
        <li><strong>이메일:</strong> ${detail.memail}</li>
        <li><strong>연락처:</strong> ${detail.mphone}</li>
        <li><strong>거주지:</strong> ${detail.address}</li>
    </ul>

    <hr>

    <h3>[ 학력 및 경력 ]</h3>
    <ul>
        <li><strong>출신대학교:</strong> ${detail.univ}</li>
        <li><strong>전공:</strong> ${detail.major}</li>
        <li><strong>경력:</strong> ${detail.career}</li>
        <li><strong>경험:</strong> ${detail.experi}</li>
    </ul>

    <hr>

    <h3>[ 자기소개서 ]</h3>
    <div class="intro-box">
        ${fn:replace(detail.intro, newLineChar, "<br>")}
    </div>

    <div class="btn-wrap">
        <button type="button" onclick="history.back();">목록으로 돌아가기</button>
    </div>

</div>

</body>
</html>