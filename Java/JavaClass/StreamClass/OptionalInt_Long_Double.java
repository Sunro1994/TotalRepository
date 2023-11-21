package ch14_Stream;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalInt_Long_Double {
public static void main(String[] args) {
//	IntStream과 같은 기본형 스트림에는 Optional도 기본형을 값으로 하는 OptionalInt, OptionalLong, OptionalDouble을 반환한다.
	
//	OptionalInt findAny()
//	OptionalInt findFirst()
//	OptionalInt reduce(IntBinaryOperator op)
//	OptionalInt max()
//	OptionalInt min()
//	OptionalInt average()
	
//	값을 반환하는 메서드
//	Optional<T> -> T get()
//	OptionalInt -> int getAsInt()
//	OptionalInt -> long getAsLong()
//	OptionalInt -> Double getAsDouble()
	
//	OptionalInt 메서드 내부 내용
//	public final class OptionalInt {
//		...
//	private final boolean isPresent;		//값이 저장되어 있으면 true
//	private final int value;				//int 타입의 변수
	

// 기본형 int의 기본값 0과 OptionalInt에 저장되는 값0은 같은 값을 반환하는가?
//	OptionalInt에 0을 입력하는 것과 초기화 0의 값은 다르게 취급한다.
	OptionalInt opt  = OptionalInt.of(0);
	OptionalInt opt2 = OptionalInt.empty();
	
	System.out.println(opt.isPresent());			//true
	System.out.println(opt2.isPresent());			//false
	
	System.out.println(opt.getAsInt());  			//0
//	System.out.println(opt2.getAsInt());  			//java.util.NoSuchElementException: No value present
	
	System.out.println(opt.equals(opt2));

// 하지만 Optional객체의 경우에는 동일하게 취급한다.
	
	Optional<String> opt3 = Optional.ofNullable(null);
	Optional<String> opt4 = Optional.empty();
	
	System.out.println(opt3.equals(opt4));









}
}

