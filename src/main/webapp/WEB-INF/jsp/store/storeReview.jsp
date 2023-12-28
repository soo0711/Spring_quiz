<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족 - 리뷰</title>
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
			<div class="display-4 py-4">${storeName }-리뷰</div>
			<c:choose>
				<c:when test="${not empty reviews }">
					<c:forEach items="${reviews }" var="review">
						<div class="border border-info p-3 mb-4">
							<div>
								<span class="font-weight-bold">${review.userName }</span>
								<c:set var="value" value="${review.point }" />
								<c:choose>
									<c:when test="${not empty review.point }">
										<c:choose>
											<%-- 0.5 --%>
											<c:when test="${(review.point * 10) % 10 eq 5}">
												<c:forEach begin="1" end="${review.point }" step="1">
													<img src="/img/star_fill.png" alt="별 한개" width="15">
												</c:forEach>
												<img src="/img/star_half.png" alt="별 반개" width="15">
												<c:forEach begin="${review.point + 1 }" end="4" step="1"
													varStatus="status">
													<img src="/img/star_empty.png" alt="별 없음" width="15">
												</c:forEach>
											</c:when>
											<%--0.0 --%>
											<c:when test="${(review.point * 10) % 10 ne 5}">
												<c:forEach begin="1" end="${review.point }" step="1">
													<img src="/img/star_fill.png" alt="별" width="15">
												</c:forEach>
												<c:forEach begin="${review.point }" end="4" step="1"
													varStatus="status">
													<img src="/img/star_empty.png" alt="별 없음" width="15">
												</c:forEach>
											</c:when>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:forEach begin="1" end="5" step="1">
											<img src="/img/star_empty.png" alt="별 없음" width="15">
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
							<small class="text-secondary"> <fmt:formatDate
									value="${review.createdAt}" pattern="yyyy년 M월 dd일" />
							</small>
							<div class="my-2">${review.review }</div>
							<span class="menu-color rounded">${review.menu }</span>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h1 class="text-center font-weight-bold mt-4">작성된 리뷰가 없습니다.</h1>
				</c:otherwise>
			</c:choose>
		</div>
		<footer
			class="pl-4 border-top d-flex align-items-center border-secondary">
			<div>
				<div>(주)우와한 형제</div>
				<small class="text-secondary">고객센터: 1500-1500</small>
			</div>
		</footer>
	</div>
</body>
</html>