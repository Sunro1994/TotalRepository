package day05;

public class Movie {

	private int rank;				//순위
	private String title;			//제목
	private String openningDate;	//개봉일
	private double reserveRate;		//에매율
	private int reserveCount;		//예매관객수
	private int watchCount;			//누적관객수

	
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpenningDate() {
		return openningDate;
	}
	public void setOpenningDate(String openningDate) {
		this.openningDate = openningDate;
	}
	public double getReserveRate() {
		return reserveRate;
	}
	public void setReserveRate(double reserveRate) {
		this.reserveRate = reserveRate;
	}
	public int getReserveCount() {
		return reserveCount;
	}
	public void setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
	}
	public int getWatchCount() {
		return watchCount;
	}
	public void setWatchCount(int watchCount) {
		this.watchCount = watchCount;
	}
	
	
}
