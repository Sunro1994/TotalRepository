package ch14_Stream;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx1 {
	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		}catch (Exception e) {
			return defaultValue;
		}
	}
public static void main(String[] args) {
//	String타입의 Optional객체에 문자열 주소를 참조
	Optional<String> optStr = Optional.of("avcde");
//	String타입의 Optional객체에 optStr의 길이값을 산출한 데이터 주소를 참조
	Optional<Integer> optInt = optStr.map(String::length);
	System.out.println("optStr="+optStr.get());
	System.out.println("optInt="+optInt.get());
	
//	정수 타입에 result1의 값에 Optional객체값 123을 길이가 0보다 큰 경우 정수로 전환해서 반환
	int result1 = Optional.of("123").filter(x->x.length() >0).map(Integer::parseInt).get();
//	정수 타입의 result2의 값에 Optional객체값 ""을 길이가 0보다 큰 경우 정수로 전환하고 0 
	int result2 = Optional.of("").filter(x-> x.length()>0).map(Integer::parseInt).orElse(-1);
	
	System.out.println("result1 =" + result1);
	System.out.println("result2 =" + result2 );
	
	Optional.of("456").map(Integer::parseInt).ifPresent(x->System.out.printf("result3=%d%n",x));
	
	OptionalInt optInt1 = OptionalInt.of(0);
	OptionalInt optInt2 = OptionalInt.empty();
	
	System.out.println(optInt1.isPresent());
	System.out.println(optInt2.isPresent());
	
	System.out.println(optInt1.getAsInt());
//	System.out.println(optInt2.getAsInt()); 	java.util.NoSuchElementException: No value present
	
	System.out.println("optInt1="+ optInt1);	//optInt1=OptionalInt[0]
	System.out.println("optInt2="+ optInt2);	//optInt2=OptionalInt.empty
	System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2)); //false
	
	Optional<String> opt = Optional.ofNullable(null);
	Optional<String> opt2 = Optional.empty();
	System.out.println("opt = "+ opt);		//opt = Optional.empty
	System.out.println("opt2 = "+ opt2);	//opt2 = Optional.empty
	System.out.println("opt.equals(opt2)?"+opt.equals(opt2)); //true
	
	int result3 = optStrToInt(Optional.of("123"),0);
	int result4 = optStrToInt(Optional.of(""), 0);
	
	System.out.println("result3="+result3);
	System.out.println("result4="+result4);
	}
}
