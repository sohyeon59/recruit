<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="pName"
	value="${not empty pageParamName ? pageParamName : 'page'}" />

<div class="pagination">
	<c:if test="${ph.showPrev}">
		<a href="?${pName}=1${searchParam}" class="btn-gray">◁</a>
		<a href="?${pName}=${ph.beginPage - 1}${searchParam}" class="btn-gray">◀</a>
	</c:if>

	<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
		<a href="?${pName}=${i}${searchParam}"
			class="${i == ph.page ? 'btn-black' : 'btn-gray'}">${i}</a>
	</c:forEach>

	<c:if test="${ph.showNext}">
		<a href="?${pName}=${ph.endPage + 1}${searchParam}" class="btn-gray">▶</a>
		<a href="?${pName}=${ph.totalPage}${searchParam}" class="btn-gray">▷</a>
	</c:if>
</div>