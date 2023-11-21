package simpledateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatEx2 {
public static void main(String[] args) {
	
	//cal을 활용한 sdf구문 만들기
	Calendar cal = Calendar.getInstance();
	cal.set(2015, 9,3);
	
	Date day = cal.getTime();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yy-MM-dd E요일");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	//parse를 사용하여 년월일 추출하기
	DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
	DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

	try {
		//d = 해당 문자열을 date형식으로 추출
		Date d = df.parse("2015년 11월 23일");
		//추출한 값을 가진 d를 df2의 형식으로 포맷
		System.out.println(df2.format(d));
		
	} catch (Exception e) {
	}
}
}
