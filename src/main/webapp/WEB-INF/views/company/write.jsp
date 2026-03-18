<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 구인공고 등록</title>
</head>
<body>
    <div class="container">
        <h2>새 구인공고 등록</h2>
        
        <form action="/company/write" method="post">
            <table>
                <tr>
                    <th>공고 제목</th>
                    <td><input type="text" name="title" required style="width: 100%;"></td>
                </tr><br>
                <tr>
                    <th>마감일</th>
                    <td><input type="date" name="deadline" required></td>
                </tr><br>
                <tr>
                    <th>공고 내용</th>
                    <td>
                        <textarea name="content" rows="10" required style="width: 100%;"></textarea>
                    </td>
                </tr><br>
            </table>
            
            <div style="text-align: center; margin-top: 20px;">
                <button type="submit">공고 등록하기</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
</body>
</html>