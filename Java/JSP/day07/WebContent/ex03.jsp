<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
<style>
	div {
		box-sizing: border-box;
	}
	#root {
		border: 2px solid black;
		width: fit-content;
	}
	div.item {
		width: fit-content;
		display: flex;
	}
	div.item > div {
		width: 120px;
		padding: 10px;
		border: 1px solid grey;
	}
	div.item > div:nth-child(2) {
		width: 250px;
	}
	div.header {
		background-color: #dadada;
		font-weight: bold;
		text-align: center;
	}
	div.item.white {
		background-color: white;
	}
	div.item.grey {
		background-color: #eee;
	}
</style>
</head>
<body>

<h1>ex03.jsp</h1>
<hr>

<details>
	<summary>SQL</summary>
	<fieldset>
	<pre>create table movie (
    movie_rank      number,
    title           varchar2(100),
    openningDate    varchar2(100),
    reserveRate     number(3,1),
    reserveCount    number,
    watchCount      number
);

insert into movie values (1,  '오펜하이머',            '2023-08-15', 32.2, 157679, 0);
insert into movie values (2,  '콘크리트 유토피아',      '2023-08-09', 29.5, 144524, 14126);
insert into movie values (3,  '밀수',                 '2023-07-26',  9.3, 45709, 3667880);
insert into movie values (4,  '보호자',               '2023-08-15',  4.1, 20135, 401);
insert into movie values (5,  '비공식작전',            '2023-08-02',  4.1, 19848, 759613);
insert into movie values (6,  '더 문',                '2023-08-02',  3.7, 18321, 384791);
insert into movie values (7,  '엘리멘탈',              '2023-06-14',  3.3, 15985, 6354883);
insert into movie values (8,  '달짝지근해:7510',       '2023-08-15',  2.7, 13302, 6637);
insert into movie values (9,  '런닝맨: 리벤져스',       '2023-08-10',  1.7,  8388, 2062);
insert into movie values (10, '명탐정코난: 흑철의 어영', '2023-07-20',  1.6,  8058, 685440);

commit;

select * from movie order by movie_rank;</pre></fieldset>
</details>

<h3>dao 객체를 생성</h3>
<jsp:useBean id="dao" class="ex03.MovieDAO" />

<h3>dao의 메서드를 호출하여 리스트 받기</h3>
<c:set var="list" value="${dao.selectList() }" />

<h3>JSTL forEach로 출력</h3>
<div id="root">
	<div class="item header">
		<div>순위</div>	
		<div>제목</div>	
		<div>개봉일자</div>	
		<div>예매율</div>	
		<div>예매관객수</div>	
		<div>누적관객수</div>	
	</div>
	<c:forEach var="dto" items="${list }" varStatus="st">
	<div class="item ${st.index % 2 == 0 ? 'white' : 'grey'}">
		<div>${dto.movie_rank }</div>	
		<div>${dto.title }</div>	
		<div>${dto.openningDate }</div>	
		<div>${dto.reserveRate }%</div>	
		<div>
			<fmt:formatNumber value="${dto.reserveCount }" />명
		</div>	
		<div>
			<fmt:formatNumber value="${dto.watchCount }" />명
		</div>	
	</div>
	</c:forEach>
</div>

</body>
</html>










