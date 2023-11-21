package member;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DAO;

public class MemberDAO extends DAO {

	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 결과집합(rs)에서 회원객체(MemberDTO)를 반환하는 함수
	private MemberDTO mapping(ResultSet rs) throws SQLException {
		MemberDTO dto = new MemberDTO();
		dto.setBirth(rs.getString("birth"));
		dto.setEmail(rs.getString("email"));
		dto.setUserid(rs.getString("userid"));
		dto.setUsername(rs.getString("username"));
		dto.setUserpw(rs.getString("userpw"));
		return dto;
	}
	
	// 로그인 함수
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
				login = mapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return login;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
