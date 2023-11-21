package calendar;

import java.util.Calendar;
import java.util.Date;

public class AboutCalendar {
/*
 	Date는 JDK1.0부터 제공해온 클래스로 매우  기능이 부족했다. 
 	JDK1.1에는 calendar가 나와 훨씬 개선됐지만 몇 가지 단점들이 발견됐다.
 	JDK1.8부터는 ㄴjava.time패키지로 기존의 단점들을 개선한 새로운 클래스들이 추가되었다.
 	
 	===Calendar와 GregorianCalendar
 	Calendar는 추상 클래스이므로 직접 객체를 생성할 수 없고, 메서드를 통해 완전히 구현된 클래스의 인스턴스를 얻어야한다.
 	

 */
	//Cannot instantiate the type calendar
//	calendar cal =new calendar();
	public static void main(String[] args) {
		
	Calendar cal = Calendar.getInstance();
	
	/*완전히 구현한 클래스로는 GregorianCalendar(태국 외 지역)와 BuddihistCalendar(태국)가 있다.
		이처럼 최소한의 변경으로 프로그램이 동작하도록 하기 위한 것이다.
		
		//다른 인스턴스가 필요로 하는 경우 MyApplication을 변경해야 한다.
		class MyApplication{
		public static void main(String args[]) {
		calendar cal = new GregorianCalendar();		//경우에 따라 이부분을 변경해야 한다.
		
		하지만 인스턴스를 불러 올 경우 클래스에서는 크게 변경하지 않아도 된다.
		class MyApplication{
		public static void main(String args[]) {
		calendar cal = calendar.getInstance();		//경우에 따라 이부분을 변경해야 한다.
		getInstance는 메서드 내의 코드에서 인스턴스 변수를 사용하거나 인스턴스 메서드를 호출하지 않기 때문에 static메서드이다.
		또 다른 이유는 static이 아니라면 객체를 생성해서 호출해야 하는데 Calendar는 추상클래스이기때문에 객체를 생성할 수 없다.
		 
	*/	 
	
	//Date와 Calendar간의 변환
	//1. calendar >> Date
	cal = Calendar.getInstance();
	Date d = new Date(cal.getTimeInMillis());  	//Date(long date)
	
	//2. Date >> calendar
	Date da = new Date();
	Calendar cal1 = Calendar.getInstance();
	cal1.setTime(da);
	}
}