<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript">

</script>

<div class="input-group custom-search-form" style="float: left">

	<select name="searchType" id="searchType" class="form-control">
		<option value="BOARD_TITLE"
			<c:if test="${searchVO.searchType=='BOARD_TITLE'}">selected="selected"</c:if>>글제목</option>
		<option value="MEMBER_NAME"
			<c:if test="${searchVO.searchType=='MEMBER_NAME'}">selected="selected"</c:if>>등록자</option>
	</select> 
	
	<input type="text" class="form-control" id="searchKeyword" name="searchKeyword"	value="<c:out value="${searchVO.searchKeyword}"/>" maxlength="50"
		style="width: 150px;" onkeydown="if(event.keyCode == 13) { fn_formSubmit();}" /> 
		
	<a href="javascript:formSubmit();"  class="btn btn-primary" id="searchBtn"  style="cursor: pointer;">검색</a>

</div>
