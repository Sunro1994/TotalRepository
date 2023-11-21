package simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 앞에서 날짜를 계산하는 방법을 배웠으니 이제는 날짜를 출력하는 방법에 대해서 배울 차례다.
 * Date와  Calendar만으로 출력하기에는 복잡하고 불편하다. 
 * 이러한 점을 개선하기 위해 SimpleDateFormat을 사용하낟.
 * 
 * G : 연대(BC,AD)
 * y : 연도
 * M : 월(1~12월 또는 1월~12월)
 * w : 년의 몇 번째 주(1~53)
 * W : 월의 몇 번째 주(1~5)
 * D : 년의 몇 번째 일(1~366)
 * d : 월의 몇 번째 일(1~31)
 * F : 월의 몇 번째 요일(1~5)
 * E : 요일
 * a : 오전/오후
 * H : 시간(0~23)
 * k : 시간(1~24)
 * K : 시간(0~11)
 * h : 시간(1~12)
 * m : 분(0~59)
 * s : 초(0~59)
 * S : 천분의 일초
 * z : Time zone(General time zone)		GMT +9:00
 * Z : Time zone(RFC 822 time zone)		+0900
 * ' : escape문자
 * 
 * 작성 방법 : 먼저 원하는 출력 형식의 패턴을 작성하여 SimpleDateFormat인스턴스를 생성한 다음, 출력하고자 하는 Date인스턴스를 가지고 format(Date d)
 * 를 호출하면 지정한 출력형식에 맞게 변환된 문자를 얻게 된다.
 * @author Sunro
 *
 */


public class AboutSimpleDateFormat {
public static void main(String[] args) {
	Date today = new Date();
	
	SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf5 ,sdf6,sdf7,sdf8,sdf9;
	
	sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	sdf2 = new  SimpleDateFormat("''yy년 MM월 dd일 E요일");
	sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
	
	sdf5 = new SimpleDateFormat("오늘은 올해의 D번째 날입니다.");
	sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
	sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
	sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
	sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일 입니다.");
	
	System.out.println(sdf1.format(today));
	System.out.println(sdf2.format(today));
	System.out.println(sdf3.format(today));
	System.out.println(sdf4.format(today));
	System.out.println(sdf5.format(today));
	System.out.println(sdf6.format(today));
	System.out.println(sdf7.format(today));
	System.out.println(sdf8.format(today));
	System.out.println(sdf9.format(today));
	
}
}
