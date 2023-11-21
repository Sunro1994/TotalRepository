package board2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDAO instance = new BoardDAO();
	
	private Context init;
	private DataSource ds;
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	
	private BoardDTO mapping(ResultSet rs) throws SQLException {
		BoardDTO dto = new BoardDTO();
		dto.setIdx(rs.getInt("idx"));
		dto.setTitle(rs.getString("title"));
		dto.setWriter(rs.getString("writer"));
		dto.setContent(rs.getString("content"));
		dto.setUploadFile(rs.getString("uploadFile"));
		dto.setWdate(rs.getDate("wdate"));	// java.sql.Date
		return dto;
	}
	
	public int insert(BoardDTO dto) {
		int row = 0;
		String sql = "insert into board2 (title, writer, content, uploadFile) ";
		sql += "values (?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getUploadFile());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
	public ArrayList<BoardDTO> selectList() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board2 order by idx desc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public BoardDTO selectOne(int idx) {
		BoardDTO dto = null;
		String sql = "select * from board2 where idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public int delete(int idx) {
		int row = 0;
		String sql = "delete board2 where idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
	public int removeFile(int idx) {
		int row = 0;
		String sql = "update board2 set uploadFile = null where idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	
	public int modify(BoardDTO dto) {
		String sql;
		if(dto.getUploadFile() != null) {
			sql = "update board2 set title=?, content=?, uploadFile=? where idx=?";
		}
		else {
			sql = "update board2 set title=?, content=? where idx=?";
		}
		
		int row = 0;
		int paramIndex = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++paramIndex, dto.getTitle());
			pstmt.setString(++paramIndex, dto.getContent());
			if(dto.getUploadFile() != null) {
				pstmt.setString(++paramIndex, dto.getUploadFile());
			}
			pstmt.setInt(++paramIndex, dto.getIdx());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return row;
	}
	
	
}








 