package ex03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Ex03DAO {

	private static Ex03DAO instance = new Ex03DAO();
	
	public static Ex03DAO getInstance() {
		return instance;
	}
	
	private Context init;
	private DataSource ds;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Ex03DAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if(rs != null) 		rs.close();
			if(pstmt != null) 	pstmt.close();
			if(conn != null) 	conn.close();
		} catch (Exception e) {}
	}

	public int insert(Ex03DTO dto) {
		int row = 0;
		String sql = "insert into upload1 (title, filePath) values (?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getFilePath());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public ArrayList<Ex03DTO> select() {
		ArrayList<Ex03DTO> list = new ArrayList<Ex03DTO>();
		String sql = "select * from upload1 order by idx";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Ex03DTO dto = new Ex03DTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setFilePath(rs.getString("filePath"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}















}
