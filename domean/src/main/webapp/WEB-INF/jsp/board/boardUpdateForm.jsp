<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<html>
<head>

    <title>domean 업데이트메소드~</title>

    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
	<script type="text/javascript">
		function contentInsert(){
			
			if($.trim($("#boardTitle").val()).length==0){
				alert("제목을 입력해주세요");
				$("#boardTitle").focus();
				return ;
			}
			
			if($("#boardContent").val().length==0){
				alert("내용을 입력해주세요");
				$("#boardContent").focus();
				return ;
			}
			
			$("#f1").submit();
		}	
		
		var fileCount = 1;
		function changeFileCount() {
			var cnt = parseInt($("#fileCount").val());
			if (fileCount == cnt){
				return;
			}
			if (fileCount < cnt) {
				for (var i = 0; i < cnt - fileCount; i++) {
					$("#fileListDiv").append('<input type="file" name="uploadFile" id="uploadFile' + (fileCount + i) + '" onchange="fileChange(this)"/>');
				}
			} else {
				for (var i = 1; i <= fileCount - cnt; i++) {
					$("#uploadFile"+(fileCount-i)).remove();
				}
			}
			fileCount = cnt;
		}
	</script>
	
</head>

<body>

    <div id="wrapper">
		<!-- left menu -->
		<jsp:include page="../common/leftMenu.jsp" />
		<!-- left menu END  -->
        
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">글수정</h1>
                    </div>
                </div>
            </div>
            
            <form id="f1" name="f1" action="/member/board/update" enctype="multipart/form-data" method="post">
            	<input type="hidden" name="boardSeq" value="${boardDTO.boardSeq}">
            	<input type="hidden" name="_method" value="PATCH"> 
            	
	           	<div class="form-group">
	            	<label>글제목</label>
	                <input class="form-control"  id="boardTitle" name="boardTitle" placeholder="글제목" value="<c:out value="${boardDTO.boardTitle}"/>"/>
	            </div>
				<div class="form-group">
					<label>글내용</label>
					<textarea class="form-control" rows="10"  id="boardContent" name="boardContent" placeholder="글내용"><c:out value="${boardDTO.boardContent}"/></textarea>
				</div>
				<div class="form-group">
					<label>첨부파일</label>
					<select id="fileCount" name="fileCount" onchange="changeFileCount()">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					<div id="fileListDiv" class="fileListDiv">
						<c:if test="${fileList.size()>0}">
							<c:forEach var="fileList" items="${fileList}">
								<input type="checkbox" id="checkRow" name="checkRow" value="<c:out value="${filelist.seq}"/>" />
								<a href="downloadFile?fileName=<c:out value="${filelist.fileName}"/>&fileOriginalName=<c:out value="${filelist.fileOriginalName}"/>">
									<c:out value="${filelist.fileOriginalName}"/>
								</a>
							</c:forEach>
						</c:if>
						
						<input type="file" id="uploadFile" name="uploadFile" multiple onchange="fileChange(this)"/> 
					</div>
					
				</div>
			</form>
			<a href="#" onclick="contentInsert()" class="btn btn-primary btn-lg btn-block">글수정</a>
			<a href="javascript:history.go(-1)" class="btn default btn-lg btn-block">취소</a>
		</div>
    </div>

    <script type="text/javascript" src="/resources/js/jquery-3.3.1.min.js" ></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>
    <script src="/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
