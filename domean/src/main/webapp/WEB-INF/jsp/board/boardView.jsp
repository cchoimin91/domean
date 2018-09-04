<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>domean</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript">
		function downloadFileEncode(fileName, originalName) {
			var agent = navigator.userAgent.toLowerCase();
			if ((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1)) {
				downname = encodeURI(downname);
				document.location.href = '/downloadFile?fileName='+ fileName + '&originalName=' + originalName;
			} else
				document.location.href = '/downloadFile?fileName='+ fileName + '&originalName=' + originalName;
		}
	</script>
</head>

<body>
    <sec:authentication property="principal.memberSeq" var="principal_memberSeq"/>
    <div id="wrapper">
        <!-- left menu -->
		<jsp:include page="../common/leftMenu.jsp" />
		<!-- left menu END  -->

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">게시물 조회</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            
            <c:if test="${principal_memberSeq eq boardDTO.boardWriterSeq}">
            	<a href="/member/board/update/${boardDTO.boardSeq}" class="btn btn-primary" style="float:right">수정</a>
            </c:if>
            <a href="javascript:history.go(-1)" class="btn btn-primary" style="float:right">뒤로가기</a>
            
             <table class="table table-hover" id="dataTables-example">
             <colgroup>
             	<col width="15%">
             	<col width="70%"> 
             </colgroup>
             	<tr>
             		<th>글제목</th>
             		<td><c:out value="${boardDTO.boardTitle}"/></td>
             	</tr>
             	<tr>
             		<th>작성자</th>
             		<td><c:out value="${boardDTO.memberName}"/></td>
             	</tr> 
             	<tr>
             		<th>작성일</th>
             		<td><c:out value="${boardDTO.boardWriteDate}"/></td>
             	</tr> 
				<tr>
             		<th>글 내용</th>
             		<td><c:out value="${boardDTO.boardContent}"/></td>
             	</tr>   
             	<tr>
             		<th>첨부 파일</th>
             		<td>
             		<c:choose>
             			<c:when test="${fileList.size()>0}">
             				<c:forEach items="${fileList}" var="fileList">
             					<a href="javascript:downloadFileEncode('<c:out value="${fileList.fileName}"/>','<c:out value="${fileList.fileOriginalName}"/>')">
             						<c:out value="${fileList.fileOriginalName}"/><br>
             					</a>
             				</c:forEach>
             			</c:when>
             			<c:otherwise>
             				파일없음
             			</c:otherwise>
             		</c:choose>
             		
             		</td>
             	</tr>           
             </table>
            
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
