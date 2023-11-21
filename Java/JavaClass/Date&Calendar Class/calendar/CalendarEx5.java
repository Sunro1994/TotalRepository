package calendar;

import java.util.Calendar;

public class CalendarEx5 {
public static String toString(Calendar date) {
		
		return date.get(Calendar.YEAR)+"년"+ (date.get(Calendar.MONTH)+1+"월"+date.get(Calendar.DATE)+"일");
	}
public static void main(String[] args) {
	Calendar date = Calendar.getInstance();
	
	date.set(2015, 6,31);
	System.out.println(toString(date));
	//roll로 달을 증가 시켰을 때, 일 필드에 영향을 미칠 수 있다.(마지막 날인 경우) 7월은 31일까지이나 9월은 30일까지이므로
	date.roll(Calendar.MONTH, 2);
	System.out.println(toString(date));
}
}
