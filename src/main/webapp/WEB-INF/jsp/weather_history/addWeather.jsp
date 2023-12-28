<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    
<!-- datapicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
<link rel="stylesheet" type="text/css" href="/css/weather_history/addWeather.css">

</head>
<body>
	<div class="container" id="wrap">
		<div class="d-flex" id="contents">
			<aside class="col-2 bg-primary">
				<div class="d-flex justify-content-center my-4">
					<img src="/img/logo_mark.png" alt="기상청 로고" width="25">
					<a href="/weather-history/weather-list-view" class="text-white font-weight-bold">기상청</a>
				</div>
				<nav>
					<ul class="nav flex-column mt-4">
						<li class="nav-item">
							<a href="/weather-history/weather-list-view" class="nav-link menu-font">날씨</a>
						</li>
						<li class="nav-item">
							<a href="/weather-history/add-weather-view" class="nav-link menu-font">날씨입력</a>
						</li>
						<li class="nav-item">
							<a href="#" class="nav-link menu-font">테마날씨</a>
						</li>
						<li class="nav-item">
							<a href="#" class="nav-link menu-font">관측 기후</a>
						</li>
					</ul>
				</nav>
			</aside>
			<section class="col-10 mt-3 ml-5">
				<h3>날씨 입력</h3>
				<form action="/weather-history/add-weather" method="post">
					<div class="d-flex justify-content-between mt-5">
						<div class="d-flex align-items-center">
							<div class="input-label">날짜</div>
							<script>
							$(document).ready(function() {
								// 날짜 선택
								$("#date").datepicker({
										dateFormat: "yy-mm-dd"
								});
							});
							</script>
							<input type="text" class="form-control" id="date" name="date">
						</div>
						<div class="d-flex align-items-center">
							<div class="input-label">날씨</div>
							<select class="form-control" name="weather">
								<option>맑음</option>
								<option>구름조금</option>
								<option>흐림</option>
								<option>비</option>
							</select>
						</div>

						<div class="d-flex align-items-center">
							<div class="input-label">미세먼지</div>
							<select class="form-control" name="microDust">
								<option>좋음</option>
								<option>보통</option>
								<option>나쁨</option>
								<option>최악</option>
							</select>
						</div>
					</div>

					<div class="d-flex justify-content-between mt-5">
						<div class="d-flex align-items-center">
							<div class="input-label">기온</div>
							<div class="input-group">
								<input type="text" class="form-control" name="temperatures">
								<div class="input-group-append">
									<span class="input-group-text">℃</span>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center">
							<div class="input-label">강수량</div>
							<div class="input-group">
								<input type="text" class="form-control" name="precipitation">
								<div class="input-group-append">
									<span class="input-group-text">mm</span>
								</div>
							</div>
						</div>

						<div class="d-flex align-items-center">
							<div class="input-label">풍속</div>
							<div class="input-group">
								<input type="text" class="form-control" name="windSpeed">
								<div class="input-group-append">
									<span class="input-group-text">km/h</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="text-right mt-4 mb-5">
						<input type="submit" class="btn btn-success" value="저장">
					</div>
				</form>
			</section>
		</div>
		<footer class="d-flex align-items-center">
			<img src="/img/foot_logo.png" alt="기상청 로고" width="120"> 
			<small class="text-secondary ml-3">
				(07062) 서울특별시 동작구 여의대방로16길 61<br>
				Copyright@2022 KMA. All Rights RESERVED.
			</small>
		</footer>
	</div>
</body>
</html>