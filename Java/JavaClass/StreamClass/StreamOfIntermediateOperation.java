package ch14_Stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfIntermediateOperation {
public static void main(String[] args) {
	
//	스트림 자르기
//	1. skip			
	
	IntStream intStream = IntStream.rangeClosed(1, 10);		//1~10의 요소를 가진 스트림
	intStream.skip(3).forEach(System.out::print);			//3개를 건너 뛴다.
	System.out.println();
	
//	2. limit
	
	IntStream intStreamLimit = IntStream.rangeClosed(1, 10);
	intStreamLimit.limit(3).forEach(System.out::print);		//최대 3개 
	System.out.println();
//	스트림 요소 걸러내기
	
//	1. distinct	- 중복된 요소 제거
	IntStream intStreamDistinct = IntStream.of(1,2,3,4,4,5,6,1,2,3,4,2,7);
	intStreamDistinct.distinct().forEach(System.out::print);			//중복된 요소 제거
	System.out.println();
	
	
//	2.filter	- 주어진 조건에 맞지 않는 요소 걸러냄(Predicate)
	IntStream	intStreamFilter = IntStream.range(1, 10);
	intStreamFilter.filter((i)->i%2==0).forEach(System.out::print);		//필요하다면 filter()를 다른 조건으로 여러번 쓸 수 있다.
	IntStream	intStreamFilter2 = IntStream.range(1, 10);
	System.out.println();
	intStreamFilter2.filter(i->i%2!= 0).filter(i-> i<=5).forEach(System.out::print);
	System.out.println();
	
//	정렬
	
//	1.sorted
//	지정된 Comparator로 스트림을 정렬, 대신 int값을 반환하는 람다식을 사용할 수도 있다.
	
	Stream<String>	StreamSorted	=	Stream.of("aa","bb","cc","Dd");
	StreamSorted.sorted().forEach(System.out::print);
	System.out.println();
	
//	문자열 스트림 정렬 방법;
//	기본 정렬
//	strStream.sorted()
//	strStream.sorted(Comparator.naturalOrder())
//	strStream.sorted((s1,s2)->s1.compareTo(s2))
//	strStream.sorted(String::CompareTo)
	
//	역순
//	strStream.sorted(Comparator.reverseOrder())
//	strStream.sorted(Comparator.<String>naturalOrder().reversed())
	
//	strStream.sorted(String.CASE_INTENSITIVE_ORDER) // 대소문자 구분안함
//	strStream.sorted(String.CASE_INTESITIVE_ORDER.reversed())	대소문자 구분안하고 역순
	
//	strStream.sorted(Comparator.comparing(String::length))		//길이순 정렬
//	strStream.sorted(Comparator.comparingInt(String::length))	//no오토박싱
	
//	strStream.sorted(Comparator.comparing(String::length).reversed())		//길이순 역순정렬
	
//	JDK1.8부터 Comparator인터페이스에 static메서드와 디폴트 메서드가 많이 추가되었다. 이 메서드들을 이용하면 정렬이 쉬워진다.
//	이 메서드들은 모두 Comparator<T>를 반환
//	아래의 목록은 지네릭에서 와일드 카드를 제거하여 간단히 한것
	
//	comparator의 default메서드
//	reversed();
//	thenComparing(Comparator<T> other);
//	thenComparing(Function<T,U> keyExtractor);
//	thenComparing(Function<T,U> keyExtractor, Comparator<U> keycomp);
//	thenComparing(ToIntFunction<T> keyExtractor)
//	thenComparing(ToLongFunction<T> keyExtractor)
//	thenComparing(ToDoubleFunction<T> keyExtractor)
	
//	comparator의 static메서드
	
//	-- 가장 기본적인 메서드
//	스트림의 요소가 comparable을 구현한 경우 매개변수 하나를 사용하며
//	comparing(Function<T,U> keyExtractor)
//	그렇지 않은 경우 추가적인 매개변수로 정렬기준을 따로 지정해준다.
//	comparing(Function<T,U> keyExtractor, Comparator<U> keyComparator)
//	-------
//	-- 비교대상이 기본형인경우, comparing()대신 아래의 메서드를 사용하면 오토박싱과 언박싱 과정없이 사용할 수 있어 더욱 효율적이다.
//	comparingInt(ToIntFunction<T> keyExtractor)
//	comparingLong(ToLongFunction<T> keyExtractor)
//	comparingDouble(ToDoubleFunction<T> keyExtractor)

//	naturalOrder()
//	reverseOrder()
//	nullsFirst(Comparator<T> comparator)
//	nullsLast(Comparator<T>comparator )










}
}
