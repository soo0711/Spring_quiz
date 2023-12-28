<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>
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
	
<link rel="stylesheet" type="text/css" href="/css/store/store.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="bg-info d-flex align-items-center pl-4">
			<h3 class="font-weight-bold text-white">배탈의 민족</h3>
		</header>
		<div class="contents">
			<div class="display-4 py-4">우리동네 가게</div>
			<c:forEach items="${storeList }" var="store">
			<div class="border border-info p-3 mb-4">
			<a href="#" class="text-dark">
				<h3 class="font-weight-bold">${store.name }</h3>
				<div>전화번호: ${store.phoneNumber }</div>
				<div>주소: ${store.address }</div>
			</a>
			</div>
			</c:forEach>
		</div>
		<footer class="pl-4 border-top d-flex align-items-center border-secondary">
			<div>
				<div>(주)우와한 형제</div>
				<small class="text-secondary">고객센터: 1500-1500</small>
			</div>
		</footer>
	</div>
</body>
</html>