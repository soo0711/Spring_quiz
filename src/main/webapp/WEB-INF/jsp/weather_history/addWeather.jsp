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
					<ul class="nav flex-column">
						<li class="nav-item font-weight-bold"><a href="/weather-history/weather-list-view" class="nav-link text-white font-weight-bold">날씨</a></li>
						<li class="nav-item font-weight-bold"><a href="/weather-history/add-weather-view" class="nav-link text-white font-weight-bold">날씨입력</a></li>
						<li class="nav-item font-weight-bold"><a href="#" class="nav-link text-white font-weight-bold">테마날씨</a></li>
						<li class="nav-item font-weight-bold"><a href="#" class="nav-link text-white font-weight-bold">관측 기후</a></li>
					</ul>
				</nav>
			</aside>
			<section id="cotent1" class="col-10 bg-secondary">
				<div class="mx-5 my-4">
					<h2>날씨 입력</h2>
					<form method="post" action="/weather-history/add-weather">
						<div class="d-flex justify-content-around">
							<div class="d-flex">
								<label for="datepicker">날짜 </label>
								<script>
								$(document).ready(function() {
					                $("#datepicker").datepicker({
					                    dateFormat:"yy-mm-dd" // 2023-11-10
					                });
					            });
								</script>
								<input type="text" class="form-control col-8 ml-2" name="date" id="datepicker">
							</div>
							<div class="d-flex">
								<label for="weather">날씨 </label>
								<input type="text" class="form-control col-4 ml-2" name="weather" id="weather">
							</div>
							<div class="d-flex">
								<label for="microDust">미세먼지 </label>
								<input type="text" class="form-control col-4 ml-2" name="microDust" id="microDust">
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="d-flex">
								<label for="temperatures">기온 </label>
								<input type="text" class="form-control col-4 ml-2" name="temperatures" id="temperatures">
							</div>
							<div class="d-flex">
								<label for="precipitation">강수량 </label>
								<input type="text" class="form-control col-4 ml-2" name="precipitation" id="precipitation">
							</div>
							<div class="d-flex">
								<label for="windSpeed">풍속 </label>
								<input type="text" class="form-control col-4 ml-2" name="windSpeed" id="windSpeed">
							</div>
						</div>
					</form>
				</div>
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