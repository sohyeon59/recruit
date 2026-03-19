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
    
    
    // 기업회원인지 개인회원인지 구별
    Object usertype = session.getAttribute("userType");
    if(usertype == null){
    	usertype = "nologin";
    }
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


<%			if(usertype.equals("company")){%>
        <ul id="headermenu">
            <li><a href="/"><b>전체 공고</b></a></li>
            <li>/</li>
            <li><a href="/company/main"><b>내 공고</b></a></li>
            <li>/</li>
            <li><a href="/company/write"><b>새 공고 등록</b></a></li>
        </ul>

<% 			}else if(usertype.equals("member")){%>
        <ul id="headermenu">
            <li><a href="/"><b>전체 공고</b></a></li>
            <li>/</li>
            <li><a href="/resume/myPage"><b>마이페이지</b></a></li>
        </ul>

<%			}else if(usertype.equals("nologin")){ %>
        <ul id="headermenu">
            <li><a href="/"><b>전체 공고</b></a></li>
        </ul>
<%			}else{%>
	    <ul id="headermenu">
		    <li><a href="/"><b>전체 공고</b></a></li>
		</ul>
<%			} %>
    </div>
</header>
