<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	
<%-- AJAX를 사용하려면 jqeury 원본 필요!! --%>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
	
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" class="form-control"id="name">
		</div>
		<div class="form-group">
			<label for="url">url</label>
			<div class="d-flex">
			<input type="text" class="form-control col-10" id="url">
			<button type="button" class="btn btn-info ml-2" id="urlCheckBtn">중복 확인</button>
			</div>
			<small id="urlStatusArea">
			</small>
		</div>
		
		<input type="button" id="addBtn" class="btn btn-success w-100" value="추가">
		
	</div>
	
<script>
	$(document).ready(function() {
		
		// 추가 버튼 클릭
		$("#addBtn").on('click', function() {
			// validation
			let name = $("#name").val().trim();
			if (!name){
				alert("제목을 입력하세요");
				return false;
			}
			let url = $("#url").val().trim();
			if (!url){
				alert("url을 입력하세요");
				return false;
			} 
			
			// http:// 또는 https:// 프로토콜
			if(!(url.startsWith("http://") && url.startsWith("https://"))){
				alert("정확한 url을 입력하세요");
				return false;
			}
			
			console.log(name);
			console.log(url);
			
			// ajax
			$.ajax({
				type: "post"
				, url: "/lesson06/quiz01/add-bookmark"
				, data: {"name":name, "url":url}
			
				// response - call back 함수
				, success: function(data){ // data: JSON String => parsing(jquery ajax 함수)
					alert(data);		   //  => dictionary로 변경 ★★★
					if(data.code == 200){
						location.href="/lesson06/quiz01/bookmark-list"
					}
				}
				, error: function(request, status, error){
					alert(request);
					alert(status);
					alert(error); 
				}
			}); // -- ajax
			
		}) // -- click
		
		$("#urlCheckBtn").on("click", function() {
			// alert("click");
			let 
		});
		
	}); // -- document
</script>
</body>
</html>