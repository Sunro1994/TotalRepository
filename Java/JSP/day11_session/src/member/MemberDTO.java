package member;

//	USERID   NOT NULL VARCHAR2(100) 
//	USERPW   NOT NULL VARCHAR2(100) 
//	USERNAME NOT NULL VARCHAR2(100) 
//	EMAIL    NOT NULL VARCHAR2(100) 
//	BIRTH    NOT NULL VARCHAR2(100) 

public class MemberDTO {
	
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private String birth;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	

}
