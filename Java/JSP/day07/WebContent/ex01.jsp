<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>

<h1>ex01.jsp - ojdbc</h1>
<hr>
<%@ page import="java.sql.*" %>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String driverClass = "oracle.jdbc.driver.OracleDriver";
	String sql = "select banner from v$version";
	String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	String user = "c##itbank";
	String password = "it";
	String version = null;
	
	Class.forName(driverClass);
	conn = DriverManager.getConnection(url, user, password);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
		version = rs.getString(1);
	}
	rs.close();
	stmt.close();
	conn.close();
%>
<h3>version : <%=version %></h3>

</body>
</html>








