<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<c:set var="test" value="${boardDAO.test() }" />
<div class="container">
	<!-- Carousel -->
	<div id="demo" class="carousel slide" data-bs-ride="carousel">
		<!-- Indicators/dots -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
				class="active"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
		</div>

		<!-- The slideshow/carousel -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://img.daumcdn.net/daumblog_admin/static/top/images/openGraph/opengraph.png?v=1"
					alt="Los Angeles" class="d-block" style="width: 1320px">
			</div>
			<div class="carousel-item">
				<img
					src="https://library.gabia.com/wp-content/uploads/2016/04/%ED%8F%AC%ED%84%B8-%EC%82%AC%EC%9D%B4%ED%8A%B8%EC%9D%98-%EB%B8%94%EB%A1%9C%EA%B7%B8%EB%82%98-%EC%B9%B4%ED%8E%98%EC%97%90-%EB%8F%84%EB%A9%94%EC%9D%B8-%EC%97%B0%EA%B2%B0%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95.jpeg"
					alt="Chicago" class="d-block" style="width: 1320px">
			</div>
			<div class="carousel-item">
				<img
					src="https://www.publog.co.kr/main_img/publog_mobile_blue.png?t=1"
					alt="New York" class="d-block" style="width: 1320px">
			</div>
		</div>

		<!-- Left and right controls/icons -->
		<button class="carousel-control-prev" type="button"
			data-bs-target="#demo" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#demo" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>

	<div class="container-fluid mt-3">
		<h1>블로그 인덱스 페이지</h1>
		<p>내가 만든 블로그 인덱스페이지</p>
	</div>
</div>
</body>
</html>