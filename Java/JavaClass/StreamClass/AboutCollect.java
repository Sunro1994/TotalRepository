package ch14_Stream;

public class AboutCollect {
//	스트림의 최종 연산중에서 가장 복잡하면서도 유용하게 활용될 수 있는 것이 collect()이다.
//	스트림의 요소를 수집하는 최종 연산으로  앞서 배운 reducing과 유사하다.
//	collect()가 스트림의 요소를 수집하려면, 어떻게 수집할 것인가에 대한 방법이 정의되어 잇어야 하는데, 이 방법을 정의한 것이 바로 컬렉터이다.
//	컬렉터는 Collector인터페이스를 구현한 것으로, 직접 구현할 수도 있고 미리 작성된 것을 사용할 수 있다.
//	Collectors클래스는  미리 작성된 다양항 종류의 컬렉터를 반환하는 static메서드를 갖고 있으며, 유용하게 사용할 수 있다.
	
//	collect()  : 스트림의 최종연산, 매개변수로 컬렉터를 필요로 한다.
//	Collector  : 인터페이스, 컬렉터는 이 인터페이스를 구현해야 한다.
//	Collectors : 클래스, static메서드로 미리 작성된 컬렉터를 제공한다.
	
//	collect()는 매개변수로 Collector를 받는데, 다른 뜻으로는 Collector를 구현한 클래스의 객체여야 한다는 뜻이다.
	
//	Object collect(Collector collector)
//	Object collect(Supplier supplier, BiConsumer accumulator, Bi consumer combiner)
//	나중에 Collector를 구현하는 방법을 배우고 나면 이 메서드를 어떻게 활용해야 하는지 쉽게 이해할 수있으므로 지금은 알아만 두자

}
