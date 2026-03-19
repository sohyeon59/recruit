<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file="heafoo/header.jsp" %>
	
	<section id="main_menu">
		<table>
            <thead>
                <tr>
                    <th style="width: 10%;">번호</th>
                    <th style="width: 25%;">사명</th>
                    <th style="width: 45%;">제목</th>
                    <th style="width: 20%;">마감일</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty jobList}">
                        <c:forEach var="job" items="${jobList}">
                            <tr onclick="location.href='/job/detail?jno=${job.jno}'" style="cursor: pointer;">
                                <td>${job.jno}</td>
                                <td>${companyName}</td>
                                <td class="title-cell">${job.title}</td> 
                                <td>${job.deadline}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="4" class="empty-message">등록된 구인공고가 없습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
	</section>
	

</body>
</html>
