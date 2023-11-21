package board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DAO;

public class BoardDAO extends DAO{
	
	private static BoardDAO instance;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}	
	
	public String test() {
		String result = null;
		String sql  = "select banner from v$version";
		
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				result = getRs().getString("banner");
			}
		} catch (SQLException e) {
			System.err.println("test에러 : "+e.getMessage());
		} finally {
			close();
		}
		return result;
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
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from board order by idx desc";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				list.add(mapping(getRs()));
			}
		} catch (SQLException e) {
			System.err.println("selectList()에러 : "+e.getMessage());
		} finally {
			close();
		}
		return list;
	}
	
	public BoardDTO selectOne(int idx) {
		BoardDTO dto = null;
		String sql = "select * from board where idx=?";
		
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setInt(1, idx);
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				dto = mapping(getRs());
			}
		} catch (SQLException e) {
			System.err.println("selectOne()에러 : "+e.getMessage());
		} finally {
			close();
		}
		return dto;
	}
	
	// 게시글 추가
	public int insert(BoardDTO dto) {
		int row = 0;
		String sql = "insert into board(title,writer,content) values(?,?,?)";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, dto.getTitle());
			getPstmt().setString(2, dto.getWriter());
			getPstmt().setString(3, dto.getContent());
			row = getPstmt().executeUpdate();
		} catch (SQLException e) {
			System.err.println("write에러 : "+e.getMessage());
		} finally {
			close();
		}
		return row;
	}
	
	// 게시글 수정
	public int update(BoardDTO dto) {
		int row = 0;
		String sql = "update board set title=?, writer=?, content=? where idx=?";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, dto.getTitle());
			getPstmt().setString(2, dto.getWriter());
			getPstmt().setString(3, dto.getContent());
			getPstmt().setInt(4, dto.getIdx());
			row = getPstmt().executeUpdate();
		} catch (SQLException e) {
			System.err.println("update() 에러 : "+e.getMessage());
		} finally {
			close();
		}
		return row;
	}
	
	public int delete(int idx) {
		int row = 0;
		String sql = "delete from board where idx = ?";
		
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setInt(1, idx);
			row = getPstmt().executeUpdate();
		} catch (SQLException e) {
			System.err.println("update() 에러 : "+e.getMessage());
		} finally {
			close();
		}
		return row;
	}
	
	public int selectMaxIdx() {
		int idx = 0;
		String sql = "select MAX(idx) from board";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				idx = getRs().getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("selectMaxIdx()에러 : "+e.getMessage());
		} finally {
			close();
		}
		return idx;
	}
	
	public ArrayList<BoardDTO> searchList(String keyword){
		ArrayList<BoardDTO> list2 = new ArrayList<BoardDTO>();
		String sql = "select * from board where title like ? or content like ? order by idx desc";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, "%"+ keyword+"%");
			getPstmt().setString(2, "%"+ keyword+"%");
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				BoardDTO dto = new BoardDTO();
				dto.setContent(getRs().getString("content"));
				dto.setIdx(getRs().getInt("idx"));
				dto.setTitle(getRs().getString("title"));
				dto.setWdate(getRs().getDate("wdate"));
				dto.setWriter(getRs().getString("writer"));
				list2.add(dto);
			}
		} catch (SQLException e) {
			System.err.println("selectList(String)에러 : "+e.getMessage());
		} finally {
			close();
		}

		return list2;
	}
	
}
