<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>통나무 펜션 - 예약하기</title>
<meta charset="utf-8">

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

<!-- datepicker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 외부 스타일 시트 -->
<link rel="stylesheet" type="text/css" href="/css/booking/booking.css">
</head>
<body>
	<div id="wrap" class="container">
		<header
			class="bg-light d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 펜션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">펜션소개</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="/booking/make-booking-view"
					class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/booking/booking-list-view"
					class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="list d-flex justify-content-center">
			<div class="w-50">
				<h2 class="font-weight-bold py-3">예약하기</h2>
				<div class="mb-2">
					<lable for="name">이름</lable>
					<input type="text" class="form-control" id="name">
				</div>
				<div class="mb-2">
					<lable for="date">예약날짜</lable>
					<input type="text" class="form-control mt-2" id="date">
				</div>
				<div class="mb-2">
					<lable for="day">숙박일수</lable>
					<input type="text" class="form-control mt-2" id="day">
				</div>
				<div class="mb-2">
					<lable for="headcount">숙박인원</lable>
					<input type="text" class="form-control mt-2" id="headcount">
				</div>
				<div class="mb-2">
					<lable for="phoneNumber">전화번호</lable>
					<input type="text" class="form-control mt-2" id="phoneNumber">
				</div>
				<button type="button" id="reserveBtn" class="btn btn-warning w-100">예약하기</button>
			</div>
		</section>
		<footer class="d-flex align-items-center pl-3">
			<div class="address">
				제주특별자치도 제주시 애월읍<br> 사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 /
				대표:김통목<br> Copyright 2025 tongnamu. All right reserved.
			</div>
		</footer>
	</div>
<script>
	$(document).ready(function() {
		// datepicker
		$("#date").datepicker({
			dateFormat: "yy년 mm월 dd일"
		});
		
		// 예약하기 버튼
		$("#reserveBtn").on("click", function(){
			
			//alert("click");
			let name = $("#name").val().trim();
			let date = $("#date").val().trim();
			let day = $("#day").val().trim();
			let headcount = $("#headcount").val().trim();
			let phoneNumber = $("#phoneNumber").val().trim();
			
			console.log(name);
			console.log(date);
			console.log(day);
			console.log(headcount);
			console.log(phoneNumber);
			
			// vaildation
			if (!name){
				alert("이름을 입력하세요.");
				return false;
			}
			if (!date){
				alert("예약날짜를 입력하세요.")
				return false;
			}
			if (!day){
				alert("숙박일수를 입력하세요.")
				return false;
			}
			if (!headcount){
				alert("숙박인원을 입력하세요.")
				return false;
			}
			if (!phoneNumber){
				alert("전화번호를 입력하세요.")
				return false;
			}
			
			
			$.ajax({
				type: "post"
				, url: "/booking/make-booking"
				, data: {
					"name":name, "date":date, "day":day, "headcount":headcount,
					"phoneNumber":phoneNumber
				}
				, success: function(data) {
					if(data.code == 200){
						location.href="/booking/make-booking-view"
					} else if (data.code == 500){
						alert(data.error_message);
					}
				}
				, error: function(request, status, error){
					alert("예약에 실패했습니다.");
					alert(request);
					alert(status);
					alert(error);
				}
			}); // - ajax
			
		}); // - reservebtn
		
	}); // - docu
</script>
</body>
</html>