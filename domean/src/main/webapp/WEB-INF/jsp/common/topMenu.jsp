<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 



<div align="right" style="border:1px solid black;">
		<div align="center">
   			[<b><sec:authentication property="principal.memberName"/></b>]님 안녕하세요
   		</div>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
    		<a href="/admin/main">[관리자 매뉴]</a>
    	</sec:authorize>
    	
    	<a href="/member/main">[메인페이지]</a>
		
		<sec:authorize access="isAuthenticated()">
    	    <a href="logout">[로그아웃]</a>
   		</sec:authorize>
</div>