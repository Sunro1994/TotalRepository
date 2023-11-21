<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<style>
	form{
		width : 800px;
		margin: auto;
	}
	input{
		text-align: center;
	}
	input::placeholder{
		color: white;
		text-align: center;
	}
	input[type="submit"]{
		text-align: center;
	}
	input[type="submit"]:hover{
		background-color: rgba(0,0,0,0.1); 
		opacity: 0.7;
	}
	textarea::placeholder{
		color: white;
	}
	
	input ,textarea{
		all :unset;
		width: 500px;
		padding : 10 50px;
		border : 1px solid white;
		border-radius: 20px;
		font-size: 2em;
	}
	textarea{
		padding-left : 20px;
	}
	select{
		all : unset;
		width: 500px;
		padding : 10 50px;
		border : 1px solid white;
		border-radius: 20px;
		font-size: 2em;
		text-align: center;
	}
	option{
		text-align: center;
		color : black;
	}
}
</style>

<form method="POST" >
	<p><input type="text" name="menu_name" placeholder="메뉴 이름" required></p>
	<p><input type="hidden" name="menu_pwd" placeholder="메뉴 이름" required value="sunro1994"></p>
	<p><select name="menu_type" required>
			<option value="메인요리">메인요리</option>
			<option value="사이드요리">사이드메뉴</option>
			<option value="술">술</option>
			<option value="추가메뉴">추가메뉴</option>
		</select></p>
	<p><input type="number" name="menu_price" placeholder="가격" min="0" required></p>
	<p><textarea name="menu_intro" placeholder="메뉴 소개"></textarea></p>
	<p><input type="submit"></p>
</form>
</body>
</html>