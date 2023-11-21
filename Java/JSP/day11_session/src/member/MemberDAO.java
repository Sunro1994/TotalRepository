package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	
	// 1) 싱글톤
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 2) 커넥션 풀
	private Context init;
	private DataSource ds;
	
	private MemberDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 3) conn, pstmt, rs
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 4) 함수 만들기
	// id와 pw가 일치하는 단일 멤버 객체를 반환하는 함수 (없으면 null)
	public MemberDTO login(MemberDTO user) {	// 사용자 입력값을 받아서
		MemberDTO login = null;
		String sql = "select * from member where userid = ? and userpw = ?";
						// id와 pw가 일치하는 계정 하나를 조회하고 반환한다
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid()); 	// <jsp:setProperty> 태그로 들어온 파라미터
			pstmt.setString(2, user.getUserpw());	// id와 pw를 순서대로 배치한다
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				login = new MemberDTO();
				login.setUserid(rs.getString("userid"));
				login.setUserpw(rs.getString("userpw"));
				login.setUsername(rs.getString("username"));
				login.setBirth(rs.getString("birth"));
				login.setEmail(rs.getString("email"));
				// list가 없으니 list.add() 는 호출할 필요 없다
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

	// 회원가입에 필요한 모든 정보를 입력받아서 테이블에 추가하고, 정수 반환하기
	public int insert(MemberDTO user) {
		int row = 0;
		String sql = "insert into member values (?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpw());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getBirth());
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return row;
	}

	// id를 문자열로 전달받아서 회원정보를 삭제하기
	public int delete(String userid) {
		int row = 0;
		String sql = "delete member where userid = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return row;
	}
	
	// 회원정보를 수정하는 함수
	public int update(MemberDTO user) {
		int row = 0;
		String sql = "update member set username=?, email=?, birth=?";
		sql += " where userid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getBirth());
			pstmt.setString(4, user.getUserid());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return row;
	}
}











