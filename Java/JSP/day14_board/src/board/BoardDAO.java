package board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DAO;

public class BoardDAO extends DAO {

	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDTO mapping(ResultSet rs) throws SQLException {
		BoardDTO dto = new BoardDTO();
		dto.setContent(rs.getString("content"));
		dto.setIdx(rs.getInt("idx"));
		dto.setTitle(rs.getString("title"));
		dto.setWdate(rs.getDate("wdate"));
		dto.setWriter(rs.getString("writer"));
		return dto;
	}
	
	public ArrayList<BoardDTO> selectList() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board order by idx desc";
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
		String sql = "select * from board where idx = ?";
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
		String sql = "delete from board where idx = ?";
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
	
	public int insert(BoardDTO dto) {
		int row = 0;
		String sql = "insert into board (title, writer, content) values (?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return row;
	}
	public int selectMaxIdx() {
		int idx = 0;
//		String sql = "select board_seq.currval from dual";
		String sql = "select max(idx) from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idx = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return idx;
	}
	
	public int modify(BoardDTO dto) {
		int row = 0;
		String sql = "update board set title=?, content=? where idx=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getIdx());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return row;
	}
}
















