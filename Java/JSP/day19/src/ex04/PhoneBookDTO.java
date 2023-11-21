package ex04;

//	IDX  NOT NULL NUMBER       
//	NAME NOT NULL VARCHAR2(50) 
//	PNUM NOT NULL VARCHAR2(50)

public class PhoneBookDTO {

	private int idx;
	private String name;
	private String pnum;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
}
