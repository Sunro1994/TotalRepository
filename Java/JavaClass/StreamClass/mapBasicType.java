package ch14_Stream;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class mapBasicType {
	public static void main(String[] args) {
//	map은 연산의 결과로 Stream<T> 타입의 스트림을 반환한다.
//	요소를 숫자로 변환하는 경우 mapToDouble,Int,Long을 사용한다.
		
		
//	!앞서 사용했던 studentStream에서 스트림에 포함된 모든 학생의 성적을 합산해야 한다면, map()으로 학생의 총점을 뽑아서 새로운 스트림을 만들어 낼 수 있다.
		
//	Stream<Integer> studentScoreStream = studentStream.map(Student::getTotalScore);
		
//	!더 효율적인 방법 : mapToint()를 사용해 Stream<integer>가 아닌 IntStream타입의 스트림을 생성해서 사용하는 것이 효율적이다.
		
//	IntStream studentScoreStream = studentStream.mapToInt(Student::getTotalScore);
//	int allTotalScore = studentScoreStream.sum();			//int sum();
		
//	count()만 지원하는 Stream<T>와 달리 IntStream과 같은 기본형 스트림은 아래와 같이 숫자를 다루는데 편리한 메서드를 제공한다.
//	최종 연산 메서드이기 때문에 호출 후 닫힌다는 점을 주의하자.
//	int 			sum()
//	OptionalDouble 	average()		sum() /(double)count()
//	OptionalInt		max()			요소중 제일 큰값
//	OptionalInt		min()			요소중 제일 작은 값
		
//	IntStream scoreStream = studentStream.mapToInt(Student::getTotalScroe);
//	long totalScore = scoreStream.sum();
//	OptionalDouble average = scoreStream.average();		//Err. 스트림이 이미 닫혔음
		
//	double d = average.getAsDouble();	//OptionalDouble에 저장된 값을 꺼내서 d에 저장
		
		
//	sum() 과 average()를 모두 호출해야 할 때, 스트림을 도 생성해야 하는 불편함이 있다.
//	그래서 summaryStatics()라는 메서드가 따로 제공된다.
		
//		IntSummaryStatistics stat = scoreStream.summaryStatistics();
//		
//		long totalCount = stat.getCount();
//		long totalScore = stat.getSum();
//		double avgScore = stat.getAverage();
//		int minScore 	= stat.getMin();
//		int maxScore	= stat.getMax();
//		
//  Int/long/Double Stream 을 Stream<T>로 변환할 때는 mapToObj()를, Stream<Integer>로 변환할 때는 boxed()를 사용한다.
//	로또번호를 생성하는 코드를 mapToObj를 통해 IntStream을 Stream<String>으로 변환
		
		IntStream intStream = new Random().ints(1,46);
		Stream<String> lottoStream = intStream.distinct().limit(6).sorted().mapToObj(i->i+",");
		lottoStream.forEach(System.out::print);
	}





















}