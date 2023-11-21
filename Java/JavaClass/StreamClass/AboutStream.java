package ch14_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class AboutStream {
public static void main(String[] args) {
	/*for과 Iterator의 문제점
		1. 코드가 너무 길고 알아보기 어렵다.
		2. 재사용성이 떨어진다.
		3. 데이터 소스마다 다른 방식으로 다뤄야 한다. ( List - Collection.sort() 를 사용, 배열 - Arrays.sort()를 사용)
		
	  해결 방안으로 나온 것이 Stream이다.
	  ! 장점
	   	1. 데이터 소스의 추상화 : 데이터 소스가 무엇이든 간에 같은 방식으로 다를 수 있으며 재사용가능하다.
	  	2. 배열과 컬렉션뿐만아니라 저장된 데이터도 모두 같은 방식으로 다룰 수 있다. 
	  	
	  ! 특징
	  	1. 스트림은 데이터 소스로부터 데이터를 읽기만 할 뿐, 데이터 소스를 변경하지 않는다는 차이가 있다.
	  	2. 필요하다면, 정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수도 있다.
	  	3. 스트림은 일회용이다. 사용한 후에 또 필요한 경우 다시 생성해야 한다.
	  	4. 스트림은 작업을 내부 반복으로 처리한다. 다시 말하자면, 메서드의 내부에 반복문을 숨길 수 있다는 것이다. 
	*/
	
	//예시 : 문자열 배열과 같은 내용을 저장하는 List가 있을 떄
	String[] strArr =  { "aaa", "bbb","ccc"};						//문자열 배열
	List<String> strList = Arrays.asList(strArr);					//문자열 List
	
	// 위 데이터 소스를 기반으로 하는 스트림을 생성
	Stream<String> strStream2 = Arrays.stream(strArr);				//스트림을 생성
	Stream<String> strStream1 = strList.stream();					//스트림을 생성
	
	// 위 두 스트림으로 데이터 소스를 읽기, 정렬, 출력하는 방법
	// forEach()는 스트림에 정의된 메서드 중의 하나로 매개변수에 대입된 람다식을 데이터 소스 모든 요소에 적용한다.
	/* forEach() 메서드 예시
	void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);			//매개변수의 널 체크
		
		for(T t: src) {							//내부 반복
			action.accept(T);
		}
	}
	*/
	
	strStream1.sorted().forEach(System.out::print);
	System.out.println();
	strStream2.sorted().forEach(System.out::print);
	
	//스트림의 연산
	// 중간연산 : 연산 결과가 스트림인 연산, 스트림에 연속해서 중간 연산이 가능하다.
	// 최종연산 : 연산 결과가 스트림이 아닌 연산, 스트림의 요소를 소모하므로 단 한번만 가능
	// 주의할 점 : 최종 연산이 수행되기 전까지 중간 연산이 수행되지 않는다는 것. 중간 연산은 즉각 연산이 되는 것이 아닌 최종 연산이 수행되어야 비로소 소모된다.


	//병렬 스트림
	//parallel()이라는 메서드를 호출해서 병렬로 연산을 수행하고 병렬로 처리하지 않으려면 sequential()을 호출하면 된다.
	//sequential()은 parallel을 호출한 것을 취소할 때에만 사용한다.


}
}
