<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/header.css">

<header>
	<h2 class="logo"><a href="/">구인구직 사이트</a></h2>
	
	<div id="header_menu">
<% 		if(session.getAttribute("loginMember") == null){ %>
		<ul id="lgsg">
			<li><a href="/loginForm">로그인</a></li>
			<li>/</li>
			<li><a href="/registForm">회원가입</a></li>
		</ul>
<% 		}else{	%>		
		<ul id="lgsg">
			<li><a href="/myPage"><%= session.getAttribute("loginName") %>님 환영합니다.</a></li>
			<li>/</li>
			<li><a href="/logout">로그아웃</a></li>
		</ul>
<%		}	 %>
		<ul id="headermenu">
			<li><a href="/goResume">이력서작성</a></li>
			<li>메뉴 2</li>
			<li>메뉴 3</li>
		</ul>
	</div>
</header>