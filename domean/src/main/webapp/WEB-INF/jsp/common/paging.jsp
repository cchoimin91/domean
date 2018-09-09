<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${searchVO.totPage>1}">
        <div> 
		<c:if test="${searchVO.page>1}">
			<a href="javascript:pasingFormSubmit(1);">[처음]</a>
			<a href="javascript:pasingFormSubmit(${searchVO.page-1});">[이전]</a>
		</c:if>
		<span class="num">
			<c:forEach var="i" begin="${searchVO.sPage}" end="${searchVO.ePage}" step="1" varStatus="status">
	            <c:choose>
	                <c:when test="${i eq searchVO.page}">
	                	<b><a href="javascript:pasingFormSubmit(${i})"><c:out value="${i}"/></a></b>
	                </c:when>
	                <c:otherwise>
	                	<a href="javascript:pasingFormSubmit(${i})"><c:out value="${i}"/></a>
	                </c:otherwise>
	            </c:choose>
	            <c:if test="${not status.last}">|</c:if>
	        </c:forEach>
		</span>		
		<c:if test="${searchVO.totPage > searchVO.page}">
			<a href="javascript:pasingFormSubmit(${searchVO.page+1});">[다음]</a>
			<a href="javascript:pasingFormSubmit(${searchVO.totPage});">[마지막]</a>
		</c:if>
		
		</div>
</c:if>

<input type="hidden" name="page" id="page" value="" />
	
<script type="text/javascript">
function pasingFormSubmit(page){ 
	document.f1.page.value=page;
	document.f1.submit();
}
</script>
<div style="float:left;  margin-top:10px;">
	<select name="displayRowCount" id="displayRowCount" onchange="formSubmit()"  title="페이지" style="width:70px">
		<option value='10' <c:if test="${searchVO.displayRowCount==10}">selected="selected"</c:if>>10</option>
		<option value='20' <c:if test="${searchVO.displayRowCount==20}">selected="selected"</c:if>>20</option>	
		<option value='30' <c:if test="${searchVO.displayRowCount==30}">selected="selected"</c:if>>30</option>	
		<option value='40' <c:if test="${searchVO.displayRowCount==40}">selected="selected"</c:if>>40</option>	
		<option value='50' <c:if test="${searchVO.displayRowCount==50}">selected="selected"</c:if>>50</option>	
	 </select>
	총 <fmt:formatNumber value="${searchVO.totRow}" pattern="#,###" />개
</div>