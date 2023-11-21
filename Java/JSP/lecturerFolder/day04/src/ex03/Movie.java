package ex03;

public class Movie {

	private String title;	// 영화 제목
	private String date;	// 개봉 일자
	private int viewCount;	// 누적 관객 수
	
	public Movie(String title, String date, int viewCount) {
		this.title = title;
		this.date = date;
		this.viewCount = viewCount;
	}
	
	public Movie() {}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
