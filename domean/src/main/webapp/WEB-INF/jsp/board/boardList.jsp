<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<script type="text/javascript" src="/resources/js/jquery-3.3.1.min.js"></script>
	
	<script type="text/javascript">
	function formSubmit(){
		document.f1.submit();
	}
	</script>
</head>

<body>

    <div id="wrapper">

        <!-- left menu -->
		<jsp:include page="../common/leftMenu.jsp" />
		<!-- left menu END  -->


        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	게시물
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <form id="f1" name="f1" method="post">
                        	<a href="/member/board/insert" class="btn btn-primary" style="float:right">글등록</a>
                        	<jsp:include page="../common/search.jsp"/>
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            	<colgroup>
									<col width="*%">
									<col width="10%">
									<col width="10%">
									<col width="15%">
								</colgroup>
                                <thead>
                                    <tr>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>조회수</th>
                                        <th>등록일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${boardList}" var="boardList" varStatus="status">
                                <c:url var="linkURL" value="/member/board/view/${boardList.boardSeq}">
									<%-- <c:param name="boardSeq" value="${boardList.boardSeq}" /> --%>
								</c:url>
                                    <tr class="odd gradeX">
                                    	<td><a href="${linkURL}"><c:out value="${boardList.boardTitle}"/></a></td>
										<td><c:out value="${boardList.memberName}"/></td>
										<td>0</td>
										<td><c:out value="${boardList.boardWriteDate}"/></td>
                                    </tr>
                                  </c:forEach>
                                </tbody>
                            </table>
                            <jsp:include page="../common/paging.jsp"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <!-- <script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script> -->
  <!--   <script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script> -->
  <!--   <script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script> -->

    <script src="/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
