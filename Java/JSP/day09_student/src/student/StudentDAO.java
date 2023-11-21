package student;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;
import javax.naming.*;

public class StudentDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	private static StudentDAO instance;
	
	public static StudentDAO getInstance() {
		if(instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	private StudentDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("생성자 예외 발생 : " + e);
		}
	}
	
	// DB에서 데이터들을 불러와서 자바 객체(리스트)로 반환하는 함수
	public ArrayList<StudentDTO> selectList() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		String sql = "select " + 
				"    student.*, " + 
				"    (kor + eng + math) as total, " + 
				"    round((kor + eng + math) / 3, 1) as avg " + 
				"    from " + 
				"        student" + 
				"	order by total desc";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTotal(rs.getInt("total"));
				dto.setAvg(rs.getDouble("avg"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// dao 내부에서만 호출하므로, 접근제한자는 private 
	private void close() {
		try {
			if(rs != null) 		rs.close();
			if(pstmt != null) 	pstmt.close();
			if(conn != null) 	conn.close();
		} catch(Exception e) {}
	}
	
	// dto를 전달받아서, dto내부의 값을 지정한 테이블에 추가하고 줄 수를 반환하는 함수
	public int insert(StudentDTO dto) {
		int row = 0;
		String sql = "insert into student values (?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMath());
			row = pstmt.executeUpdate();	// update, insert, delete에 사용한다
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
	// 문자열로 이름을 전달받아서, 이름이 일치하는 데이터를 삭제하고 줄 수를 반환하는 함수
	public int delete(String name) {
		int row = 0;
		String sql = "delete student where name = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return row;
	}
	
	// 이름을 전달받아서 단일 데이터를 반환하는 함수
	public StudentDTO selectOne(String name) {
		StudentDTO dto = null;
		String sql = "select * from student where name = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	
	
	
	
	
	
	
	

}



