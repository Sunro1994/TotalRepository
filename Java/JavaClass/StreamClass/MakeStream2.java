package ch14_Stream;

import java.nio.file.Path;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeStream2 {
public static void main(String[] args) {
//	5. 람다식-iterator(), generate()
//	람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성
	
//	static <T> Stream<T> iterate(T seed, unaryOperator<T> f)
//	static <T> Stream<T> generate(Supplier<T> s)
	
	// iterate() 는 seed로 지정된 값부터 해서 람다식 f에 의해 계산된 결과를 다시 seed값으로 해서 계산을 반복한다.
	// 0부터 시작해서 값이 2씩 계속 증가한다.
	Stream<Integer> evenStream = Stream.iterate(0,  n->n+2);
	evenStream.limit(5).forEach(System.out::print);
	System.out.println();
	//generate도 iterate()처럼 , 람다식에 의해 계산되는 값을 요소로 하는 무한 스트림을 생성해서 반환하지만, 이전 결과를 이용해서 다음 요소를 계산하지 않는다.
	//generate()에 정의 된 매개변수의 타입은 Supplier<T>이므로 매개변수가 없는 람다식만 허용된다.
	
	Stream<Double> randomStream = Stream.generate(Math::random);
	randomStream.limit(5).forEach(System.out::print);
	System.out.println();
	Stream<Integer> oneStream 	= Stream.generate(() -> 1);
	oneStream.limit(5).forEach(System.out::print);
	System.out.println();
	
	// 한가지 주의할 점 : iterate()와 generate()에 의해 생성된 스트림을 아래와 같이 기본형 스트림 타입의 참조변수로 다룰 수 없다는 것
	//	IntStream evenStream2 = Stream.iterate(0, n->n+2);					//Err
	//	DoubleStream randomStream2 = Stream.generate(Math::random);			//Err
	
	//위 코드를 굳이 필요하다면 , mapToInt()와 같은 메서드로 변환을 해야 한다.
	IntStream evenStream3 =  Stream.iterate(0, n->n+2).mapToInt(Integer::valueOf);
	evenStream3.limit(5).forEach(System.out::print);
	System.out.println();

	
	// Intstream타입 스트림을 Stream<Integer>타입으로 변환하려면, bxed()를 사용하면 된다.
//	Stream<Integer> stream = evenStream3.boxed();	//Intstream > Stream<integer>
//	stream.forEach(System.out::print);


	//파일
//	java.nio.file.files는 파일을 다루는데 필요한 메서드를 제공한다.
//	list()는 지정된 디렉토리에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.
	
//	파일의 한 행을 요소로 하는 스트림을 생성하는 메서드도 있다.
//	Stream<String> 	Files.lines(Path path)
//	Stream<String>	Files.lines(Path path, Charset cs)
//	Stream<String> lines()			//	buffredReader클래스
	
	
	//빈스트림
	
	Stream emptyStream	= Stream.empty();  			//빈 스트림을 생성해서 반환
	long count = emptyStream.count();				// 0
	System.out.println(count);
	
	//두 스트림의 연결
	
	String[] str1 = {"123","456","789"};
	String[] str2 = {"ABC", "DEF", "GHI"};
	
	Stream<String> str11 = Stream.of(str1);
	Stream<String> str22 = Stream.of(str2);
	Stream<String> str33 = Stream.concat(str11, str22);
	str33.forEach(System.out::print);
	
	
}
}
