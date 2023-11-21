package ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {

	// conn, pstmt, rs
	// url, user, password
	private Connection conn;
	private PreparedStatement pstmt;	// Statement 의 서브클래스 (상속)
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	// 생성자에서 Class.forName()
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("클래스를 불러올 수 없습니다 : " + e);
		}
	}
	
	// 전체 목록을 ArrayList<MovieDTO>으로 반환하는 함수
	public ArrayList<MovieDTO> selectList() {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String sql = "select * from movie order by movie_rank";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setMovie_rank(rs.getInt("movie_rank"));
				dto.setTitle(rs.getString("title"));
				dto.setOpenningDate(rs.getString("openningDate"));
				dto.setReserveRate(rs.getDouble("reserveRate"));
				dto.setReserveCount(rs.getInt("reserveCount"));
				dto.setWatchCount(rs.getInt("watchCount"));
				list.add(dto);
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
		
		return list;
	}
}










