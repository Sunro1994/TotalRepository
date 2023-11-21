package member;

import java.sql.SQLException;

import db.DAO;

public class MemberDAO extends DAO{
	private static MemberDAO instance;

	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	public int addMember(MemberDTO user) {
		int row =0;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1,user.getUserid() );
			getPstmt().setString(2, user.getUserpw() );
			getPstmt().setString(3, user.getUsername());
			getPstmt().setString(4, user.getEmail());
			getPstmt().setString(5, user.getBirth());
			
			row = getPstmt().executeUpdate();
		} catch (SQLException e) {
			System.err.println("addMember에러 : "+e.getMessage());
		} finally {
			close();
		}
		return row;
	}

	public MemberDTO login(MemberDTO user) {
		MemberDTO dto = null;
		String sql = "select * from member where userid= ? and userpw=?";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, user.getUserid());
			getPstmt().setString(2, user.getUserpw());
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				dto = new MemberDTO();
				dto.setBirth(getRs().getString("birth"));
				dto.setEmail(getRs().getString("email"));
				dto.setUserid(getRs().getString("userid"));
				dto.setUsername(getRs().getString("userid"));
				dto.setUserpw(getRs().getString("userpw"));
			}
		} catch (SQLException e) {
			System.err.println("login에러 : "+e.getMessage());
		} finally {
			close();
		}
		return dto;
	}
	
	public int update(MemberDTO user) {
		int row = 0;
		String sql = "update member set userpw=?, username=?, email=?, birth=? where userid=?";
		
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, user.getUserpw());
			getPstmt().setString(2, user.getUsername());
			getPstmt().setString(3, user.getEmail());
			getPstmt().setString(4, user.getBirth());
			getPstmt().setString(5, user.getUserid());
			row = getPstmt().executeUpdate();
		} catch (SQLException e) {
			System.err.println("update 오류 : "+e.getMessage());
		} finally {
			close();
		}
		return row;
	}
	
	public int delete(String userid) {
		int row = 0;
		String sql = "delete from member where userid=?";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, userid);
			row = getPstmt().executeUpdate();
		} catch (SQLException e) {
			System.err.println("delete에러 : "+e.getMessage());
		} finally {
			close();
		}
		return row;
	}
	// true면 DB에 없기 때문에 
	public boolean checkId(String userid) {
		boolean isValid = true;
		String sql = "select * from member where userid=?";
		try {
			setConn(getDs().getConnection());
			setPstmt(getConn().prepareStatement(sql));
			getPstmt().setString(1, userid);
			setRs(getPstmt().executeQuery());
			while(getRs().next()) {
				isValid = false;
			}
		} catch (SQLException e) {
			System.err.println("checkId에러 : "+e.getMessage());
		} finally {
			close();
		}
		System.out.println(isValid);
		return isValid;
	}
	
	
}
