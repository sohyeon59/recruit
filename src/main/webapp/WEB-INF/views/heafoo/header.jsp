<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/header.css">

<%
    // 알럿 메시지 처리
    String alertMsg = (String) session.getAttribute("alertMsg");
    if (alertMsg != null) {
        session.removeAttribute("alertMsg");
%>
    <script>
        alert("<%= alertMsg %>");
    </script>
<%
    }

    // 로그인 상태 체크
    Object loginMember  = session.getAttribute("loginMember");
    Object loginCompany = session.getAttribute("loginCompany");
    boolean isLogin     = loginMember != null || loginCompany != null;
    boolean isCompany   = loginCompany != null;
%>

<header>
    <h2 class="logo"><a href="/">구인구직 사이트</a></h2>

    <div id="header_menu">

        <% if (!isLogin) { %>
            <ul id="lgsg">
                <li><a href="/loginForm">로그인</a></li>
                <li>/</li>
                <li><a href="/registForm">회원가입</a></li>
            </ul>
        <% } else { %>
            <ul id="lgsg">
                <% if (isCompany) { %>
                    <li><a href="/company/main"><%= session.getAttribute("loginName") %>님 환영합니다.</a></li>
                <% } else { %>
                    <li><a href="/resume/myPage"><%= session.getAttribute("loginName") %>님 환영합니다.</a></li>
                <% } %>
                <li>/</li>
                <li><a href="/logout">로그아웃</a></li>
            </ul>
        <% } %>

        <ul id="headermenu">
            <li><a href="/goResume">지원서 작성</a></li>
            <li>메뉴 2</li>
            <li>메뉴 3</li>
        </ul>

    </div>
</header>
