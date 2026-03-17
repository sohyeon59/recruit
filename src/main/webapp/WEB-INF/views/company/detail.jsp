<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${job.title}</h2>
<p>${job.content}</p>

<hr>

<h3>지원자 목록</h3>
<table>
    <c:forEach var="resume" items="${resumeList}">
        <tr>
            <td>지원자 아이디: ${resume.mid}</td>
            <td>전공: ${resume.major}</td>
            <td>경력: ${resume.career}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>