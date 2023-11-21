package member;

//	create table member (
//	    userid      varchar2(100)       primary key,
//	    userpw      varchar2(100)       not null,
//	    username    varchar2(100)       not null,
//	    email       varchar2(100)       not null,
//	    birth       varchar2(100)       not null
//	);
	
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
