package calendar;

import java.util.Calendar;

class CalendarEx1 {
public static void main(String[] args) {
	//기본적으로 현재날짜와 시간으로 설정된다.
	//get을 통해 현지 시간에 대한 정보를 담고 있다.
	//원하는 날짜나 시간으로 설정하려면 set을 사용하면 된다.
	Calendar today = Calendar.getInstance();
	System.out.println("이 해의 년도 : "+ today.get(Calendar.YEAR));
	System.out.println("월(0~11, 0:1월) : "+today.get(Calendar.MONTH));
	System.out.println("이 해의 몇 째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
	System.out.println("이 달의 몇 째 주 :"+ today.get(Calendar.WEEK_OF_MONTH));
	System.out.println("이 달의 몇 일 :"+ today.get(Calendar.DAY_OF_MONTH));
	System.out.println("이 달의 몇 일 : "+ today.get(Calendar.DATE));
	System.out.println("요일(1~7), (1:일요일) : "+today.get(Calendar.DAY_OF_WEEK));
	System.out.println("이 달의 몇 째 요일 :"+ today.get(Calendar.DAY_OF_WEEK_IN_MONTH));			//이달의 몇번째 요일
	System.out.println("오전 _ 오후(0:오전 1:오후):"+today.get(Calendar.AM_PM));
	System.out.println("시간(0~11):"+today.get(Calendar.HOUR));
	System.out.println("시간(0~23):"+today.get(Calendar.HOUR_OF_DAY));
	System.out.println("분(0~59) :"+today.get(Calendar.MINUTE));
	System.out.println("초(0~59) :"+today.get(Calendar.SECOND));
	System.out.println("1000분의 1초(0~999) :" + today.get(Calendar.MILLISECOND));
	//1000분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.
	System.out.println("TimeZone(-12 ~ +12) : " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
	System.out.println("이 달의 마지막 날 :" + today.getActualMaximum(Calendar.DATE));
}
}
