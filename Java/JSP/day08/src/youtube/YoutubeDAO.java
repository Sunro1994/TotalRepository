package youtube;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class YoutubeDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	public YoutubeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("클래스를 불러올 수 없습니다 : " + e);
		}
	}
	
	public ArrayList<YoutubeDTO> selectList() {
		ArrayList<YoutubeDTO> list = new ArrayList<>();
		String sql = "select * from youtube order by idx";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// while(sc.hasNextLine()) { ... }
				YoutubeDTO dto = new YoutubeDTO();
				
				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				
				dto.setIdx(idx);
				dto.setTitle(title);
				
				dto.setChannel(rs.getString("channel"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setMovieTag(rs.getString("movieTag"));
				
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

	public int insert(YoutubeDTO dto) {
		int row = 0;
		String sql = "insert into youtube values (";
		sql += dto.getIdx() + ", ";
		sql += "'" + dto.getTitle() + "', ";
		sql += "'" + dto.getChannel() + "', ";
		sql += dto.getViewCount() + ", ";
		sql += "'" + dto.getThumbnail() + "', ";
		sql += "'" + dto.getMovieTag() + "') ";
		
		System.out.println(sql);
		
		sql = "insert into youtube values (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			// 물음표에 들어갈 값을 순서대로 자료형에 맞게 세팅한다
			// 단점은, 위 방식과 달리 쿼리문이 실행되는 내용을 출력하여 확인할 수 없다
			// 이후, 스프링에서 로그를 출력하게 만들면 확인 가능하다
			
			pstmt.setInt(1, dto.getIdx());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getChannel());
			pstmt.setInt(4, dto.getViewCount());
			pstmt.setString(5, dto.getThumbnail());
			pstmt.setString(6, dto.getMovieTag());
			
			row = pstmt.executeUpdate();	// insert, update, delete의 경우 exeucteUpdate()
											// SQL에 의해 영향을 받은 줄 수를 반환한다
			System.out.println(row + "행이 추가되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) 		rs.close();
				if(pstmt != null) 	pstmt.close();
				if(conn != null) 	conn.close();
			} catch(Exception e) {}
		}
		
		return row;
	}

	public YoutubeDTO selectOne(int idx) {
		YoutubeDTO dto = null;
		String sql = "select * from youtube where idx = ?";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new YoutubeDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setChannel(rs.getString("channel"));
				dto.setViewCount(rs.getInt("viewCount"));
				dto.setThumbnail(rs.getString("thumbnail"));
				dto.setMovieTag(rs.getString("movieTag"));
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
		return dto;
	}
}














