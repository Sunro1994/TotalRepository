package ex03;

//	create table upload1 (
//	    idx         number          generated as identity,
//	    title       varchar2(100)   not null,
//	    filePath    varchar2(500)   not null
//	);

public class Ex03DTO {

	private int idx;
	private String title;
	private String filePath;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
