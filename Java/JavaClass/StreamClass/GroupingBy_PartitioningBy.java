package ch14_Stream;

public class GroupingBy_PartitioningBy {
// 그룹화는 스트림의 요소를 특정 기준으로 그룹화하는 것을 의미
//	분할은 스트림의 요소를 두가지, 지정된 조건에 일치하는 그룹과 일치하지 않는 그룹으로 분할을 의미한다.
	
//	아래 메서드에서 알 수 있듯이 , 그룹화는 스트림의 요소를 Function으로, 분할은 Predicate로 분류한다.
//	그룹화의 결과는 map에 담겨 반환된다.
//	Collector groupingBy(Function classifier)
//	Collector groupingBy(Function classifier, Collector downstream)
//	Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)

//	Collector partitionBy(Predicate predicate)
//	Collector partitionBy(Predicate predicate, Collector downstream)

	

}