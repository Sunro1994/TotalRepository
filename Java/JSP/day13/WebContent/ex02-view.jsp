<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLEncoder, java.net.URLDecoder, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-view.jsp</title>
</head>
<body>

<h1>ex02-view.jsp</h1>
<hr>

<h3>현재 조회중인 상품 : ${param.idx }</h3>

<p>
	<a href="ex02.jsp"><button>목록으로</button></a>
</p>

<%
	String value = "";	// 최근 상품을 문자열로 저장하기 위한 변수
	String idx = request.getParameter("idx");	// 현재 선택받은 상품의 고유번호
	
	value += idx;	// 먼저 선택값을 추가하고
	
	Cookie[] cookies = request.getCookies();	// 쿠키를 가져와서
	
	for(int i = 0; cookies != null && i < cookies.length; i++) {
		if(cookies[i].getName().equals("recent")) {	// 이름이 recent인 쿠키를 찾아서
			
			String tmp = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
			ArrayList<String> list = new ArrayList<>(Arrays.asList(tmp.split(",")));
			
			System.out.println("before : " + list);
			if(list.contains(value) == false) {		// 비교를 먼저 한 이후, 
				if(value.equals("") == false) {		// 기존 값이 있으면서, 포함하지 않으면
					value += ",";					// 콤마를 추가하고
				}
				value += tmp;
				// 인코딩된 내용을 디코딩한 이후 value에 더한다
			}
			else {	// idx가 기존 쿠키에 포함되어 있다면
				System.out.println(2);
				list.remove(value);
				list.add(0, value);
				value = list.toString().replace(" ", "");
				value = value.substring(1, value.length() - 1);
			}
			System.out.println("after : " + list);
			System.out.println();
		}
	}
	
	if(value.split(",").length > 5) {
		int lastIndex = value.lastIndexOf(",");
		value = value.substring(0, lastIndex);
	}

	Cookie c = new Cookie("recent", URLEncoder.encode(value, "UTF-8"));
	c.setMaxAge(60 * 60 * 24 * 7);
	response.addCookie(c);
%>


</body>
</html>