<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
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

		<h1>즐겨찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookmarkList }" var="bookmark">
					<tr>
						<td>${bookmark.id }</td>
						<td>${bookmark.name }</td>
						<td>${bookmark.url }</td>
						<!-- 1) value 값 넣기 (여러값 세팅 불가) -->
						<!-- <td><button type="button" class="deleteBtn btn btn-danger" value="${bookmark.id }">삭제</button></td> -->
						<!-- 2) data로 값 넣기(무조건 소문자, 여러개 넣기 가능) -->
						<td><button type="button" class="deleteBtn btn btn-danger" data-bookmark-id="${bookmark.id }">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
<script>
	$(document).ready(function() {
		
		// 삭제
		$(".deleteBtn").on("click", function(e) {
			// 1) button value에 담은 값 가져오기
			// 단점: 여러개의 값을 심어둘때는 이거 가지고 안된다. 단 하나의 값만 가져오기 가능하다.
			// alert("delete");
			// 1. let id = $(this).val();
			// 2. let id = $(this).attr("value");
			// 3.let id = e.target.value;
	
			// 2) data를 이용해서 값을 가져오기
			// 태그 영역: data-bookmark-id
			// 스크립트 영역: .data('bookmark-id')로 가져와야한다.
			let id = $(this).data('bookmark-id');
	
	        console.log(id);
	        
	        $.ajax({
	        	// request
	        	type: "delete"
	        	, url: "/lesson06/deleteBookmark"
	        	, data: {"id":id}
	        
	        	// response
	        	, success: function(data) {
	        		if (data.code == 200){
	        			location.reload(true); // reload는 그 자리에서 다시 새로고침
	        		} else if (data.code == 500) {
	        			// logic상 error
	        			alert(data.error_message);
	        		}
	        	} // -- success
	        	, error: function(request, status, error) {
	        		alert("삭제 실패 했습니다. 관리자에게 문의해주세요.");
	        	} // -- error
	        	
	        }) // -- ajax
	        
		}); // -- deleteBtn
		
	}); // -- document
</script>
</body>
</html>