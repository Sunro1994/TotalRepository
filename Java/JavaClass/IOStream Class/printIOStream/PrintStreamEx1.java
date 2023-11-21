package printIOStream;

import java.util.Date;

public class PrintStreamEx1 {
public static void main(String[] args) {
	int i = 65;
	float f = 1234.56789f;
	
	Date d = new Date();
	
	System.out.printf("문자 %c의 코드는 %d%n",i,i);
	System.out.printf("%d는 8진수로 %o, 16진수로 %x %n",i,i,i);
	System.out.printf("%3d%3d%3d\n",100,90,80);
	System.out.println();
	System.out.printf("오늘은 %tY년 %tm월 %td일입니다.%n",d,d,d);
	System.out.printf("지금은 %tH시 %tM분 %tS초입니다.%n",d,d,d);
//	$1을 사용하면 매개변수의 첫번째를 사용한다는 뜻이다.
	System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초입니다.%n",d);

}
}
