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
   
   <title>Behinder</title>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   	<script type="text/javascript">
   	
   	$(document).on("click","input[type='text']", function(){   
   		$("#loginfailmsg").hide();
   	});
   	
	$(document).on("click","input[type='password']", function(){   
   		$("#loginfailmsg").hide();
   });
  
			function join()	{
 			if($("#join_member_name").val()==''){
 				alert("이름를 입력해주세요");
 				$("#join_member_name").focus();
 				return false
 			}
 			
 			if($("#join_member_id").val()==''){
 				alert("아이디를 입력해주세요");
 				$("#join_member_id").focus();
 				return false;
 			}
 			
 			if($("#join_member_pw").val()==''){
 				alert("비밀번호를 입력해주세요");
 				$("#join_member_pw").focus();
 				return false;
 			}
 			
 			if($("#join_member_pw2").val()==''){
 				alert("비밀번호를 입력해주세요");
 				$("#join_member_pw2").focus();
 				return false;
 			}	
 			
 			if($("#join_member_pw1").val()!=$("#join_member_pw2").val()){
 				alert("두 비밀번호가 일치하지 않습니다.");
 				$("#join_member_pw").focus();
 				return false;
 			}
 			
 			 else
 				document.joinForm.submit();
 		}
    	
 		
 		function memberLogin(){
 			if($("#member_id").val()==''){
 				alert("아이디를 입력해주세요");
 				$("#member_id").focus();
 				return false;
 			}
 			else if($("#member_pw").val()=='' || $("#member_pw").val()=='undefind' ){
 				alert("비밀번호를 입력해주세요");
 				$("#member_pw").focus();
 				return false;
 			}
 			else
				document.LoginForm.submit();
 				return true;
 		}

 		var result="<c:out value='${result}'/>";
 		if(result==="1"){
 			alert("가입성공");	
 		}
		 			
   	</script>
 </head>
  
<body>
	<header>
    <div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="logo">
					<a href="/index">Behinder</a>
				</div>
				
				<div class="visible-xs block col-xs-offset-8" >
						<a href="/index" >회원가입하러 가기</a>
				</div>
			</div>
		</div>
	</div>
</header>

<article class="container">
		<div class="row">
		
			<div class="col-sm-8">
				<div class="login-main">
				</div>
			</div>
			
			<div class="col-sm-4 xs-4">
				<form action="domean/logincheck" method="post" name="LoginForm" id="LoginForm">
				<input type="hidden" name="M" value="Y">
					<div class="form-group">
					  <label class="control-label" for="">아이디</label>
					  <input type="text" id="member_id" name="member_id" class="form-control" placeholder="ID"  value="${member_id_name}">
						<c:if test="${not empty loginFailMassage}">
					    	<div id="loginfailmsg"><font color="red">${loginFailMassage}</font></div>
					    </c:if>
					</div>
	
					<div class="form-group">
					  <label class="control-label" for="">비밀번호</label>
					  <input type="password" id="member_pw" name="member_pw" class="form-control" placeholder="Password" >
					</div>
	
					<div style="height:10px;"></div>
					
					<div class="form-group">
					  <input type="submit" class="btn btn-base" onclick="memberLogin();return false;" value="로그인" id="bt_main_join">
					</div>	
 				</form>
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