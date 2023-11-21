package board;

import java.sql.Date;

//	create table board (
//		idx		number		  	default board_seq.nextval primary key,
//		title		varchar2(500)		not null,
//		writer		varchar2(100)		not null,
//		content		clob		    	not null,
//		wdate		date		    	default sysdate,
//
//		constraint board_member_fk
//		foreign key(writer)
//		references member(userid)
//	);

public class BoardDTO {
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
}




