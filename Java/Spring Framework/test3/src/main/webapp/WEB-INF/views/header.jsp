<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
html {
	margin : 0;
	padding: 0;
}

body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	background-image: url("https://www.dtoday.co.kr/news/photo/201806/268797_184100_0548.jpg");
	background-repeat: repeat-y;
	background-size: 100%;
	color: white;
	font-size: 1.1em;
	padding-top: 250px;
	padding-left: 150px;
	overflow-x:hidden;
	}

a {
	text-decoration: none;
	color: inherit;
}

ul {
	list-style: none;
	display: flex;
}

header{
	width:100%;
	height: 170px;
	position: absolute;
	top : 0;
	left : 200px;
	background: transparent;
	display: inline-block;
}
.header-nav-menubar{
	color : white;
	font-size: 2em;
	font-weight: bold;
	width: 100%;
	margin: auto 100px;
	border-bottom: 1px solid rgba(0,0,0,0.6);
	line-height: 170px;
}
.header-nav-menubar li {
	padding : 0;
	margin :0;
	padding : 5px 120px;
}
.header-nav-logo{
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1JgkTsG-Iqedwk18sHaApwpVdnRiwb2dfFQ&usqp=CAU");
	background-repeat: no-repeat;
	background-size : 200px 100px;
	background-position : 10px 40px;
	}

	#main{
		width: 1500px;
		margin :auto;
		display: flex;
		flex-flow: wrap;
	}
	.list-menuBox{
		width: 350px;
		margin: 25px;
		padding-top : 20px;
		border:  1px solid black;
		background-color: black;
		color : white;
		border-radius: 20px;
	}
	.menu-img{
		margin : 0;
		width: 320px;
		height: 300px;
		text-align : center;
		background-size: 320px 300px;
		background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiP6C1AEqKnKDD-VTxAculivMG3u0nKsbyfw&usqp=CAU");
		background-repeat: no-repeat;
		background-position: 20px 0;
	}
	.menu-title,.menu-price{
		font-size: 1.8em;
		font-weight: bold;
		text-align: center;
		padding : 20px 0;
	}
	.menu-info{
		padding : 20px 0;
		font-size: 1.4em;
		text-align: center;
		
	}
	.menu-img > a{
		display: block;
		width: 100%;
		height: 100%;
	}
	.header-nav-logo-a{
		display : block;
		width:100%;
	}
	.header-side-navbar{
		position : fixed;
		left : 0;
		right : 0;
		top : 80px;
		bottom: 0;
		width: 300px;
		border : 2px solid white;
		background-color: rgba(255,255,255,0.2);
		z-index: 999;
	}
	.header-font{
		font-size: 2em;
		text-align: center;
	}
	ol{
		padding:0;
		margin:0;
	}
	li{
		padding:0;
		margin:0;
		list-style: none;
	}
	ol>li{
		padding : 30px 10px 30px 50px;
		font-size: 1.5em;
		font-weight: bold; 
	}
	.side-navbar-btn{
		padding : 30px 10px 30px 50px;
		font-size: 2em;
		color: white;
		
	}
	.addMenu{
		margin-top: 70px;
	}
	.payment-li{
		width: 180px; 
		border : 1px solid black;
		margin:auto;
		background-color: black;
		border-radius: 20px;
	}
	.basket-li{
		width: 180px; 
		border : 1px solid black;
		margin:auto;
		background-color: black;
		border-radius: 20px;
		margin-bottom: 20px;
	}
	.paymentBtn{
		width : 140px;
		font-size: 1.2em;
		
	}
	.BasketBtn{
		width : 140px;
		font-size: 1.2em;
	}
	.menu-get{
	font-size: 1.8em;
		font-weight: bold;
		text-align: center;
		padding : 20px 0;
		background-color: white;
		color : black;
		border-radius: 0	0	 20px 20px;
	}

</style>
<body>
	<header>
	<nav class="header-nav-menubar">
		<ul>
			<li class="header-nav-logo"><a class="header-nav-logo-a" href="${cpath}"></a></li>
			<li class="header-nav-menu"><a href="${cpath}/list">전체 메뉴</a></li>
			<li><a href="${cpath}/drunkList">주류</a></li>
			<li><a href="${cpath}/additionalOrder">추가 메뉴</a></li>		
		</ul>
	</nav>
	</header>
	<nav class="header-side-navbar">
			<div class="side-navbar-btn">≣</div>
		<ol>
			<li><a href="${cpath}/search">메뉴 검색</a></li>
			<li><a href="${cpath}/recommand">메뉴 추천</a></li>
			<li><a href="${cpath}/addMember">멤버십 가입</a></li>
			<li class="addMenu"><a href="${cpath}/add" >메뉴 추가</a></li>
			<c:if test="${basketList!=null }">
			<li class="basket-li"><a href="${cpath}/basketList" class="BasketBtn">주문목록</a></li>
			</c:if>
		</ol>
	</nav>