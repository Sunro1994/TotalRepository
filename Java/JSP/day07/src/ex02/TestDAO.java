package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO : Database Access Object (DB에 접근하여 데이터를 가져오거나, 삽입, 수정, 삭제하는 객체)

public class TestDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	
	public TestDAO() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			System.err.println("클래스를 불러올 수 없습니다 : " + e);
		}
	}

	public String getVersion() {
		String version = null;
		String sql = "select banner from v$version";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				version = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) 		rs.close();
				if(pstmt != null) 	pstmt.close();
				if(conn != null) 	conn.close();
			} catch(Exception e) {}
		}
		
		return version;
	}

	public String getSysdate() {
		String sysdate = null;
		String sql = "select sysdate from dual";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sysdate = rs.getString("sysdate");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return sysdate;
	}
}















