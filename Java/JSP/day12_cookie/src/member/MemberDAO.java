package member;

import javax.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.*;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
//	<c:set var="login" value="${dao.login(user) }" scope="session" />
	public MemberDTO login(MemberDTO user) {
		MemberDTO login = null;
		String sql = "select * from member where userid=? and userpw=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				login = new MemberDTO();
				login.setBirth(rs.getString("birth"));
				login.setEmail(rs.getString("email"));
				login.setUserid(rs.getString("userid"));
				login.setUsername(rs.getString("username"));
				login.setUserpw(rs.getString("userpw"));
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
		return login;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

