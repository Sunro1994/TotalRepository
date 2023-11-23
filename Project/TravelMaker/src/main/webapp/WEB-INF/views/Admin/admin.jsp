<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  
  justify-content: center;
  align-items: center;
  background: #262433;
}
a{
	text-decoration: none;
	color:#003458;
}

.navigation {
  position: absolute;
  left:45%;
  top : 40%;
  width: 70px;
  height: 70px;
  background: #171b21;
  border-radius: 10px;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.5s;
  transition-delay: 0.8s;
}
.navigation.active {
  width: 200px;
  height: 200px;
  transition-delay: 0s;
}

.navigation span {
  position: absolute;
  width: 7px;
  height: 7px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #fff;
  border-radius: 50%;
  transform: translate(calc(12px * var(--x)), calc(12px * var(--y)));
  transition: transform 0.5s, width 0.5s, height 0.5s, background 0.5s;
  transition-delay: calc(0.1s * var(--i));
  color: white;
}
.navigation.active span {
  width: 60px;
  height: 60px;
  background: white;
  transform: translate(calc(70px * var(--x)), calc(70px * var(--y)));
  color: #003458;
}

.navigation span ion-icon {
  transition: 0.5s;
  font-size: 0em;
}

.navigation.active span ion-icon {
  font-size: 0.8em;
color: #003458;
  font-weight: bold;
}
.navigation.active span:hover ion-icon {
  filter: drop-shadow(0 0 1px #008080) drop-shadow(0 0 2px #008080);
}


	.button {
		background-color: #3498db;
		color: #ffffff;
		padding: 10px 20px;
		border: none;
		border-radius: 5px;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 10px 5px;
	}

	.button:hover {
		background-color: #2980b9;
	}
	
</style>

<div class="adminPage">
	<div class="adminLodge">
		<button class="button" onclick="location.href='${cpath}/Admin/lodgeWrite'">숙소 등록</button>
		<button class="button" onclick="location.href='${cpath}/Admin/recommendWrite'">추천지 등록</button>
	</div>
</div>

<div class="navigation">
  <span style="--i:0;--x:-1;--y:0;">
    <ion-icon name="camera-outline"  ><a></a></ion-icon>
  </span>
  <span style="--i:1;--x:1;--y:0;">
    <ion-icon name="diamond-outline"><a href="${cpath }/lodge/lodge_main">숙소</a></ion-icon>
  </span>
  <span style="--i:2;--x:0;--y:-1;"> 
    <ion-icon name="chatbubble-outline"><a href="${cpath}/Admin/lodgeWrite">숙소등록</a></ion-icon>
  </span>
  <span style="--i:3;--x:0;--y:1;">
    <ion-icon name="alarm-outline"><a href="/travel_promotion/travel_promotion_main">쿠폰</a></ion-icon>
  </span>
  <span style="--i:4;--x:1;--y:1;">
    <ion-icon name="game-controller-outline"><a href="${cpath }/recommend/recommend_travel_main">여행추천</a></ion-icon>
  </span>
  <span style="--i:5;--x:-1;--y:-1;">
    <ion-icon name="moon-outline"><a href="${cpath}/Admin/recommendWrite">추천지<br> 등록</a></ion-icon>
  </span>
  <span style="--i:6;--x:0;--y:0;">
    <ion-icon name="notifications-outline"><a href="${cpath }">홈</a></ion-icon>
  </span>
  <span style="--i:7;--x:-1;--y:1;">
    <ion-icon name="water-outline"><a href="${cpath }/meeting/metting_main">만남</a></ion-icon>
  </span>
  <span style="--i:8;--x:1;--y:-1;">
    <ion-icon name="time-outline"></ion-icon>
  </span>
</div>
<script>
const navigation = document.querySelector(".navigation");

navigation.addEventListener("click", () => {
  navigation.classList.toggle("active");
});

</script>
</body>
</html>