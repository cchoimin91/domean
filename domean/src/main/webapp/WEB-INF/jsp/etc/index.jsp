<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <link rel="stylesheet" href="resources/css/bootstrap.min.css" ><!-- 부트스트랩 -->
   <link rel="stylesheet" type="text/css" href="resources/css/main.css" />
   <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
   <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 기기에 맞게 자동으로최적화  -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> <!--제이쿼리 -->
   <script src="resources/js/bootstrap.min.js"></script>
   
   <title>domean</title>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   	<script type="text/javascript">
   	
   	$(document).ready(function(){
   		var result="<c:out value='${msg}'/>";
   		if(result==="1"){
   			alert("가입성공");	
   		}
   	});
   	
   	$(document).on("click","input[type='text']", function(){   
   		$("#loginfailmsg").hide();
   	});
   	
	$(document).on("click","input[type='password']", function(){   
   		$("#loginfailmsg").hide();
   });
  
			function join()	{
 			if($("#join_memberName").val()==''){
 				alert("이름를 입력해주세요");
 				$("#join_memberName").focus();
 				return false
 			}
 			
 			if($("#join_memberId").val()==''){
 				alert("아이디를 입력해주세요");
 				$("#join_memberId").focus();
 				return false;
 			}
 			
 			if($("#join_memberPw").val()==''){
 				alert("비밀번호를 입력해주세요");
 				$("#join_memberPw").focus();
 				return false;
 			}
 			
 			if($("#join_memberPw2").val()==''){
 				alert("비밀번호를 입력해주세요");
 				$("#join_memberPw2").focus();
 				return false;
 			}	
 			
 			if($("#join_memberPw1").val()!=$("#join_memberPw2").val()){
 				alert("두 비밀번호가 일치하지 않습니다.");
 				$("#join_memberPw").focus();
 				return false;
 			}
 			
 			 else
 				document.joinForm.submit();
 		}
    	
 		
 		function memberLogin(){
 			if($("#memberId").val()==''){
 				alert("아이디를 입력해주세요");
 				$("#memberId").focus();
 				return false;
 			}
 			else if($("#memberPw").val()==''){
 				alert("비밀번호를 입력해주세요");
 				$("#memberPw").focus();
 				return false;
 			}
 			else
				document.LoginForm.submit();
 		}

	
 			
   	</script>
 </head>
  
<body>
	<header>
    <div class="container">
	<div class="row">
		<div class="col-sm-6">
			<div class="logo">
				<a href="/index"> domean</a>
				</div>
		</div>
		<div class="col-sm-6 hidden-xs">
		<form action="/logincheck" method="post" name="LoginForm" id="LoginForm">
			<div class="row">
				<div class="col-sm-5">
					  <div class="form-group">
					  
					    <input type="text" class="form-control"  id="memberId" name="memberId" placeholder="ID" value="${memberId_name}">
					    	
					    <div class="login-bottom-text checkbox hidden-sm">
						    <label>
						     <c:if test="${not empty loginFailMassage}">
					    		<div id="loginfailmsg"><font color="red">${loginFailMassage}</font></div>
					    	</c:if>
						    </label>
						  </div>
					  </div>
				</div>	
				<div class="col-sm-5">
					 <div class="form-group">
					    <input type="password" class="form-control"  id="memberPw" name="memberPw"  placeholder="Password" value="" onkeypress="if(event.keyCode==13) {memberLogin()}">
					    	<div class="login-bottom-text hidden-sm">
					    		<a href=""> ID/PW를 잊으셨나요?</a> 
					    	 </div>
					  </div>
				</div>
				<div class="col-sm-2">
					 <div class="form-group">
					    <input type="button" value="로그인" class="btn btn-default btn-header-login" onclick="javascript:memberLogin();">
					 </div>
				</div>
			</div>	
			</form>
		</div>
	</div>
	</div>
</header>
<article class="container">
		<div class="row">
			<div class="col-sm-8">
				<div class="login-main">
					민이의 토이프로젝트 입니다.
					<ul>
						<li>CRUD</li>
						<li>파일 업/다운로드</li>
						<li>페이징</li>
						<li>엑셀다운로드</li>
						<li>다국어처리</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="">
				
				<h3><i class="fa fa-shield"></i> 환영 합니다</h3>
			  	
			  	<hr>
			  	<form method="post" action="/newmember/insert" id="joinForm" name="joinForm">
				<div class="form-group">
				  <label class="control-label" for="">이름</label>
				  <input type="text" id="join_memberName" name="memberName" class="form-control" placeholder="이름" >
				</div>
			  	
			  	<hr>
				<div class="form-group">
				  <label class="control-label" for="">아이디</label>
				  <input type="text" id="join_memberId" name="memberId" class="form-control" placeholder="ID" >
				</div>

				<div class="form-group">
				  <label class="control-label" for="">비밀번호</label>
				  <input type="password" id="join_memberPw1" name="memberPw" class="form-control" placeholder="Password" >
				</div>

				<div class="form-group">
				  <label class="control-label" for="">비밀번호 재입력</label>
				  <input type="password" class="form-control" id="join_memberPw2"  placeholder="Repeat Password" >
				</div>

				
		      
				<small>
					간편하게 가입이 가능 합니다.
				</small>	 
				<div style="height:10px;"></div>
				<div class="form-group">
				  <label class="control-label" for=""></label>
				  <input type="button" class="btn btn-base" onclick="javascript:join(); return false;" value="가입" id="bt_main_join">
				</div>	 
 </form>
				  </div>
			</div>
			</div>
</article>
<footer class="container">
<hr>
<div class="footer-options">
<ul >
	<li><a href="#">Developer(CM)</a></li>
	<li><a href="#">Purpose</a> </li>
	<li><a href="#">Why</a></li>
	<li><a href="#">Q&A</a></li>
	<li><a href="#">Locations</a></li>
	<li><a href="#">About</a></li>
</ul>
</div>
<div style="clear:both"></div>
<small class="copyrights"> © Copyrights reserved  2017</small>
</footer>	
</body>
</html>