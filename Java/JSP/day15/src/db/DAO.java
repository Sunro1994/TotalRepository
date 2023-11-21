package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	private Context init;
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	protected DAO() {
		try {
			init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.err.println("생성자 오류 : "+e.getMessage());
		}
	}
	
	
	public Context getInit() {
		return init;
	}
	public void setInit(Context init) {
		this.init = init;
	}
	public DataSource getDs() {
		return ds;
	}
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	protected void close() {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
	}
}
