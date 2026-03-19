<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 구인공고 등록</title>
<link rel="stylesheet" href="../css/write.css">
</head>
<body>
<%@ include file="../heafoo/header.jsp" %>
<section id="jobwrite_section">

    <div class="container">
        <h2>새 구인공고 등록</h2>
        
        <form action="/company/write" method="post">
            <table>
                <tr>
                    <th>공고 제목</th>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>마감일</th>
                    <td><input type="date" name="deadline" required></td>
                </tr>
                <tr>
                    <th>공고 내용</th>
                    <td>
                        <textarea name="content" required></textarea>
                    </td>
                </tr>
            </table>
            
            <div class="btn-area">
                <button type="submit">공고 등록하기</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>

</section>
</body>
</html>