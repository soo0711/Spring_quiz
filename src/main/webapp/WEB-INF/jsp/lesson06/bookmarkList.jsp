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
				<c:forEach items="${bookmarkList }" var="bookmark" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td class="name">${bookmark.name }</td>
						<td class="url">${bookmark.url }</td>
						<td><button type="button" class="deleteBtn btn btn-danger">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
<script>
	$(document).ready(function() {
		
		// 삭제
		$(".deleteBtn").on("click", function() {
			// alert("delete");
			let deleteBtn = $(this);
			let tr = deleteBtn.parent().parent();
		    let td = tr.children();
			
		    let name = td.eq(1).text();
	        let url = td.eq(2).text();
	
	        console.log(name);
	        console.log(url);
	        
	        $.ajax({
	        	// request
	        	type: "get"
	        	, url: "/lesson06/deleteBookmark"
	        	, data: {"name":name, "url":url}
	        
	        	// response
	        	, success: function(data) {
	        		if (data.result == "성공"){
	        			location.href="/lesson06/quiz01/bookmark-list";
	        		}
	        	} // -- success
	        	, error: function(request, status, error) {
	        		alert("삭제 실패 했습니다.");
	        	} // -- error
	        	
	        }) // -- ajax
	        
		}); // -- deleteBtn
		
	}); // -- document
</script>
</body>
</html>