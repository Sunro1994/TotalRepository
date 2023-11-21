package phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PhoneBookDAO {

	// 1) 싱글톤 (static)
	private static PhoneBookDAO instance = new PhoneBookDAO();
	
	public static PhoneBookDAO getInstance() {
		return instance;
	}
	
	// 2) 커넥션풀
	private Context init;	// context.xml		
	private DataSource ds;	// javax.sql.DataSource
	
	private PhoneBookDAO() {
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
	public ArrayList<PhoneBookDTO> selectList() {
		ArrayList<PhoneBookDTO> list = new ArrayList<>();
		String sql = "select * from phonebook order by idx";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneBookDTO dto = new PhoneBookDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setPnum(rs.getString("pnum"));
				list.add(dto);
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
		return list;
	}

	public int insert(PhoneBookDTO dto) {
		int row = 0;	// ResultSet 대신 결과를 받는다 (명령에 영향을 받은 줄 수)
		String sql = "insert into phonebook (name, pnum) values (?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPnum());
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		return row;
	}

	public int delete(int idx) {
		int row = 0;
		String sql = "delete phonebook where idx = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	// 쿼리문 세팅

			// 세팅된 쿼리문을 실행하기 전에 ? 개수만큼 값을 채워줘야 한다
			pstmt.setInt(1, idx);
			
			row = pstmt.executeUpdate();	// 쿼리문 실행
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











