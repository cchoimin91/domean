<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> <!--제이쿼리 -->
	<script src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript">

function fn_fileopen(){
var file = $('#getfile');
alert(file);

file.onchange = function () {
    var fileList = file.files ;

    // 읽기
    var reader = new FileReader();
    reader.readAsDataURL(fileList [0]);

    //로드 한 후
    reader.onload = function  () {
        document.querySelector('#preview').src = reader.result ;
    };
}
}
</script>

</head>

<body>
이동페이지
<img id="preview" src="" width="200" alt="로컬에 있는 이미지가 보여지는 영역">
<input type="file" id="getfile" accept="image/*" onclick="javacripit:fn_fileopen();">

</body>
</html>