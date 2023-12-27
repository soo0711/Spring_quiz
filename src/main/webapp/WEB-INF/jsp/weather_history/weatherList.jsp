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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
	
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
			<section id="cotent1" class="col-10">
				<div class="mx-4 my-2">
					<h3>과거 날씨</h3>
					<table class="table text-center">
						<thead>
							<tr>
								<th>날짜</th>
								<th>날씨</th>
								<th>기온</th>
								<th>강수량</th>
								<th>미세먼지</th>
								<th>풍속</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lists }" var="list">
							<tr>
								<td>${list.date }</td>
								<td>
								<c:choose>
									<c:when test="${list.weather eq '맑음'}">
										<img src="/img/sunny.jpg" alt="맑음">
									</c:when>
									<c:when test="${list.weather eq '비'}">
										<img src="/img/rainy.jpg" alt="비">
									</c:when>
									<c:when test="${list.weather eq '구름조금'}">
										<img src="/img/partlyCloudy.jpg" alt="구름조금">
									</c:when>
									<c:when test="${list.weather eq '흐림'}">
										<img src="/img/cloudy.jpg" alt="흐림">
									</c:when>
								</c:choose>
								</td>
								<td>${list.temperatures }°C</td>
								<td>${list.precipitation }mm</td>
								<td>${list.microDust }</td>
								<td>${list.windSpeed }km/h</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
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