package servletEx;

public class Movie {
	private String name;
	private String date;
	private int view;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public Movie(String name, String date, int view) {
		this.name = name;
		this.date = date;
		this.view = view;
	}
	public Movie() {
	}
	
	
}
