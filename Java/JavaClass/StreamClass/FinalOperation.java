package ch14_Stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FinalOperation {
//	최종 연산은 스트림의 요소를 소모해서 결과를 만들어낸다. 최종 연산후에는 스트림이 닫히게 되고 더 이상 사용할 수 없다.
//	연산의 결과는 스트림 요소의 합과 같은 단일 값이거나, 스트림의 요소가 담긴 배열 또는 컬렉션일 수도 있다.
	
//	1.forEacy()
//	peek()과 달리 스트림의 요소를 소모하는 최종 연산이다. 반환 타입은 void
	
//	2. 조건 검사 - allMatch(), anyMatch(), nonMatch(), findFirst(), findAny()
//	지정된 조건에 모든 요소가 일치하는 지, 일부가 일치하는지 아니면 어떤 요소도 일치하지 않는지 확인하는데 사용되는 메서드들이다.
//	모두 Predicate를 요구하며, 연산결과로 boolean을 반환한다.
	
//	예시
//	학생들의 성적 정보 스트림 stuStream에서 총점이 낙제점인 학생이 있는지 확인하는 방법
	
//	boolean noFailed = stuStream.anyMatch(s->s.getTotalScore() <=100)
//	findAny와 findFirst는 Optional<T>를 반환한다. 스트림의 요소가 없을 때에는 비어있는 Optional객체를 반환한다.
//	boolean noFailed = stuStream.filter(s->s.getTotalScore() <=100).findFirst() = 조건에 일치하는 가장 처음 값 반환
//	boolean noFailed = parallelStream.filter(s->s.getTotalScore() <=100).findAny = 병렬 스트림인 경우 사용
	
//	3.통계 - count,sum,average,max,min
	
//	대부분 기본형 스트림으로 변환하거나, 아니면 reduce와 collect를 사용해서 통계 정보를 얻는다.
	
//	4. reducing
//	스트림의 요소를 줄여나가면서 연산을 수행하고 최종 결과를 반환한다.
//	그래서 매개변수의 타입이 BinaryOperator<T>이다. 처음 두 요소를 가지고 연산한 결과를 갖고 그 다음 요소와 연산한다.
//	이 과정에서 스트림의 요소를 하나씩 소모하게 되며, 스트림의 모든 요소를 소모하게 되면 그 결과를 반환한다.
//	이 외에도 연산결과의 초기값을 갖는 reduce도 있는데, 이 메서드들은 초기값과 스트림의 첫 번째 요소로 연산을 시작한다.
//	스트림의 요소가 하나도 없는 경우, 초기값이 반환되므로, 반환 타입이 Optional<T>가 아니라 T이다.
	
//	앞에서 소개했던 sum, count 모두 reduce를 활용하여 작성된것이다.
	public static void main(String[] args) {
//		IntStream intstream = Stream.of("1234").mapToInt(Integer::parseInt);
//		reduce(IntBinaryOperator accumulator)
//		int count = intstream.reduce(0, (a,b) -> a+1);
//		int sum = intstream.reduce(0, (a,b) -> a+b);
//		int max = intstream.reduce(Integer.MAX_VALUE, (a,b)->a>b?a:b);
//		OptionalInt max2 = intstream.reduce(Integer::max);
//		OptionalInt min2 = intstream.reduce(Integer::min);
//		
//		int maxValue = max2.getAsInt();
//		int minValue = min2.getAsInt();
//		int min = intstream.reduce(Integer.MIN_VALUE, (a,b)-> a<b? a:b);
//		System.out.println(maxValue);
//		System.out.println(minValue);
	}
}