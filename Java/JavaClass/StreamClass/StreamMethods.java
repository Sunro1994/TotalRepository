	package ch14_Stream;

public class StreamMethods {

	/*
	 Stream<T> 	distinct()							중복을 제거
	 Stream<T>	filter(Predicate<t> predicate)		조건에 안 맞는 요소 제외
	 Stream<T>	limit(long maxSize)					스트림의 일부를 잘라낸다.
	 Stream<T>	skip(long n)						스트림의 일부를 건너뛴다.
	 Stream<T>	peek(Consumer<T> action)			스트림의 요소에 작업 수행, Consumer는 반환값이 없다!
	 Stream<T> 	sorted()
	 Stream<T> 	sorted(Comparator<T> comparator)	스트림의 요소를 정렬한다.
	 Stream<R>	map(Function<T,R> mapper)							스트림의 모든 요소를 반환	
	 DoubleStream	mapToDouble(ToDoubleFunction<T> mapper)					""
	 IntStream		mapToInt(ToIntFunction<T>	mapper)						""
	 LongStream		maptoLong(ToLongFunction<T>	mapper)						""
	 
	 Stream<R>		flatMap(Function<T,Stream<R> mapper)					""
	 DoubleStream	flatMapToDouble(Function<T, DoubleStream> m)			""
	 IntStream		flatMapToInt(Function<T, IntStream> m)					""
	 LongStream		flatMapToLong(Function<T,LongStream) m)			스트림의 모든 요소를 반환	
	 
	 void forEach(consumer<? super T> action)		각 요소에 지정된 작업 수행
	 void forEachOrdered(Consumer<? super T> action) 		""
	 
	 long count()
	 
	 Optional<T>	max (comparator<? super T> comparator)	스트림의 최대값 반환
	 Optional<T>	min(Comparator<? super T> comparator)	스트림의 최소값 반환
	 
	 boolean allMatch(Predicate<T> p) 	//모두 만족?
	 boolean anyMatch(Predicate<T> p) 	//하나라도 만족?
	 boolean noneMatch(Predicate<T> p) 	//모두 만족하지 않음
	 
	 Object[] toArray()
	 A[]	toArray(intFunction<A[]> generator)				스트림의 모든 요소를 배열로 반환
	 
	 Optional<T> reduce(BinaryOperator<T> accumulator)
	 T reduce(T identity, BinaryOperator<T> accumulator)
	 U reduce(U identity, BiFunction<U,T,T> accumulator, BinaryOeprator<T> combiner)	스트림의 요소를 하나씩 줄여가면서 계산
	 
	 R collect(Collector<T,A<R> collector)
	 R collect(Supplier<R> supplier, biConsumer<R,T>		스트림의 요소를 수집, 주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 반환하는 데 사용
	 
	 !!중간 연산 map과 flatMap(), 최종연산 reduce() 와 collect()가 핵심이다. 
	 !!Optional은 일종의 래퍼 클래스로 내부에 하나의 객체를 저장할 수 있다.
	 
	 
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 */
}
