package ch14_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MakeStream {
public static void main(String[] args) {
	//컬렉션 스트림 만들기
	// 스트림의 소스가 될 수 있는 대상 : 배열, 컬렉션, 임의의 수등 다양하다.
	
	// 1. 컬렉션
	// Collection에 stream()이 정의되어 있다.그래서 지손인 List와 Set을 구현한 컬렉션 클래스들은 모두 스트림 생성 가능
	// 예시
	
	List<Integer> list = Arrays.asList(1,2,3,4,5);		//가변인자
	Stream<Integer> intStream = list.stream();
	
	//forEach()는 지정된 작업을 스트림의  모든 요소에 대해 수행한다.
	//forEach()의 주의할 점 : frEach()를 두번 호출할 수 없다. 한번 더 출력하려면 새로운 스트림을 생성해야 한다.
	intStream.forEach(System.out::print);
//	intStream.forEach(System.out::print);		//Err. 이미 스트림이 닫혔다.
	
	
	// 2. 배열
	// Stream과 Arrays에 static메서드로 정의되어 있다.
	
//	Stream<T> Stream.of(T...values)	//가변인자
//	Stream<T> Stream.of(T[])
//	Stream<T> Arrays.stream(T[])
//	Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
	
//	예를 들어 문자열 스트림은 다음과 같이 생성한다.
	Stream<String> strStream= Stream.of("a","b","c");	//가변인자
	strStream.forEach(System.out::print);
	System.out.println();

	Stream<String> strStream2=Stream.of(new String[] {"a","b","c"});
	strStream2.forEach(System.out::print);
	System.out.println();
	
	Stream<String> strStream3 = Arrays.stream(new String[] {"a","b","c"});
	strStream3.forEach(System.out::print);
	System.out.println();
	
	Stream<String> strStream4 = Arrays.stream(new String[] {"a","b","c"},0,3);
	strStream4.forEach(System.out::print);
	System.out.println();
	
//	3. 특정 범위의 정수(정수는 IntStream 더 큰 범위는 LongStream)
	IntStream intStream1 = IntStream.range(1, 4);			//1,2,3      4를포함x
	IntStream intStream2 = IntStream.rangeClosed(1, 4);		//1,2,3,4	4를 포함
	
	
//	4.임의의 수
//	난수를 생성하는 Random클래스에는 아래와 같은 인스턴스 메서드들이 포함되어 있다.
//	난수 생성 스트림은 크기가 정해지지 않은 무한 스트림이므로 limit()도 같이 사용해서 크기를 제한해줘야 한다.
	IntStream intstream = new Random().ints();			
	intstream.limit(5).forEach(System.out::println);	//limit(5) : 5개의 요소만 출력
	
	//아래의 메서드들은 유한 스트림을 생성해서 반환하므로 limit()을 사용하지 않아도 된다.
	
//	IntStream ints(long streamSize);
//	LongStream longs1(long streamSize);
//	DoubleStream doubles(long streamSize)
	
	IntStream intstream3 = new Random().ints(5);  	//크기가 5인 난수 스트림을 반환
	intstream3.forEach(System.out::print);
	
	LongStream longstream = new Random().longs(4);
	longstream.forEach(System.out::print);
	System.out.println();
	DoubleStream doublestream = new Random().doubles(4);
	doublestream.forEach(System.out::print);
	//위 메서드들에 의해 생성된 난수는 아래의 범위를 갖는다.
	
//	Integer.MIN_VALUE 	<=ints()    <= Integer.MAX_VALUE
//	Long.MIN_VALUE 		<=longs()		<= Long.MAX_VALUE;
//	0.0					<=doubles()	<= 1.0

//	지정된 범위의 난수를 발생시키는 스트림을 얻는 메서드는 아래와 같다. 단, end는 범위에 포함되지 않는다.

	
	//	IntStream ints(long streamSize,int begin, int end);
	//	LongStream longs1(long streamSize,long begin, long end);
	//	DoubleStream doubles(long streamSize,double begin, double end);
	
	
	
	
	
	
	
	
	}
}
