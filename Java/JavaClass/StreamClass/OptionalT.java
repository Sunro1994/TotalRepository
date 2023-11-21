package ch14_Stream;

import java.util.Optional;

public class OptionalT {
	public static void main(String[] args) {
//	Optional<T>은 지네릭 클래스로 T타입의 객체를 감싸는 래퍼 클래스이다. 그래서 Optional타입의 객체는 모든 타입의 참조변수를 담을 수 있다.
//	최종 연산의 결과를 그냥 반환하는 게 아니라 Optional객체에 담아서 반환하는 것이다.
//	이처럼 객체에 담아서 반환을 하면, 반환된 결과가 null인지 매번 if문으로 체크하는 대신 Optional에 정의된 메서드를 통해서 간단히 처리할 수 있다.
//	Objects클래스에 isNull(), nonNull(), requireNonNull()과 같은 메서드가 있는 것도 널 체크를 위한 if문을 메서드 안으로 넣어서 복잡도를 낮추기 위함이다.
	
//	1.Object객체 생성하기
//	of() 또는 ofNullable()을 사용한다.
	
		String str ="abc";
		Optional<String> optVal = Optional.of(str);
		Optional<String> optVal2 = Optional.of("abc");
		Optional<String> optVal3 = Optional.of(new String("abc"));
		
//		만일 참조변수의 값이 Null일 가능성이 있으면, of()대신 ofNullable()을 사용해야한다.
//		of()는 매개변수의 값이 Null이면 NullPointerException이 발생하기 때문이다.
		
//		Optional<String> optVal4 = Optional.of(null); 	//Exception in thread "main" java.lang.NullPointerException
		Optional<String> optVal5 = Optional.ofNullable(null); //OK
		
//		Optional<T>타입의 참조변수를 기본값으로 초기화할때는 empty()를 사용한다.
//		null로 초기화하는 것이 가능하지만, empty()로 초기화하는 것이 바람직하다.
		
		Optional<String> optVal6 = null;	//널로 초기화
		Optional<String> optVal7 = Optional.<String>empty();	//빈 객체로 초기화
		
//	2.Optional객체의 값 가져오기
//		get()을 사용한다. 값이 null일 떄에는 NoSuchElementExceptional이 발생하며, 이를 대비해서 orElse()로 대체할 값을 지정할 수 있다.
		
		Optional<String> optVal8 = Optional.of("abc");
		String str1 = optVal8.get();				//저장된 값을 반환, null이면 예외 발생
		Optional<String> optVal9 = Optional.of("");
		String str2 = optVal9.orElse("");		//저장된 값이 null일때는, ""를 반환
		
		System.out.println(str1);
		System.out.println(str2);
		
//		orElse()의 변형으로는 null을 대체할 값을 반환하는 람다식을 지정할 수 있는 orElseGet()과 null일 때 지정된 예외를 발생시키는 orElseThrow()가 있다.
		String str3 = optVal8.orElseGet(String::new);	//() -> new String()과 동일
		String str4 = optVal8.orElseThrow(NullPointerException::new); 	//널이면 예외 발생
		
		int result = Optional.of("123")
				.filter(x->x.length()>0)
				.map(Integer::parseInt).orElse(-1);		//result =123
		
		int result2 = Optional.of("")
				.filter(x ->x.length()>0)
				.map(Integer::parseInt).orElse(-1);		//result=-1
		
//		parseInt()는 예외가 발생하기 쉬운 메서드이다. 만일 예외처리 된 메서드를 만든다면 다음과 같다.
//		static int optStrToInt(Optional<String> optStr, int defaultValue) {
//			try {
//				return optStr.map(Integer::parseInt).get();
//				} catch(Exception e) {
//				return defaultValue;
//					}
//				}
		
//		3.isPresent와 ifPresent
//		isPresent()는 null이면 false를 아니면 true를 반환한다.
//		ifPresent(Consumer<T> block)은 값이 있으면 주어진 람다식을 실행하고, 없으면 아무일도 하지 않는다.
		
		if(Optional.ofNullable(str).isPresent()) {
			System.out.println(str);
		}
		
//		ifPresent()는 findAny()나 findFirst()와 같은 최종 연산자와 잘 어울린다.
//		Stream클래스에 정의된 메서드 중에서 Optional<T>를 반환하는 것들은 다음과 같다.
		
//		Optional<T> findAny()
//		Optional<T> findFirst()
//		Optional<T>	max(comparator<? super T> comparator)
//		Optional<T>	min(comparator<? super T> comparator)
//		Optional<T> reduce(BinaryOperator<T> accumulator)
	
	
	}
}
