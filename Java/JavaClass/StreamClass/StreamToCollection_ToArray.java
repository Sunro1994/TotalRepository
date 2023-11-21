package ch14_Stream;

import java.util.stream.Collectors;

public class StreamToCollection_ToArray {
	public static void main(String[] args) {
//	1.toList() : 스트림의 모든 요소를 컬렉션에 수집한다.
// 	2.List나Set이 아닌 특정 컬렉션을 지정하려면, toCollection()에 해당 컬렉션의 생성자 참조를 매개변수로 넣어주면 된다.
		
//		List<String> names = stuStream.map(Student::getName).collect(Collectors.toList()); //List에 저장
//		ArrayList<String> list = names.stream().collect(Collectors.toCollection(ArrayList::new));
		
//		Person인 스트림에서 사람의 주민번호를 키로하고, 값을 Person으로 하는 객체를 그대로 저장한다.
//		p->p 대신 Function.identity()를 쓸 수도 있다.
//		Map<String,Person> map = personStream.collect(Collectors.toMap(p->p.getRegId(), p->p);
		
//	3. T[]타입의 배열로 변환하려면, toArray()를 사용한다.
//		해당 타입의 생성자 참조를 매개변수로 지정해줘야 한다. 만일 매개변수를 지정하지 않으면 반환되는 배열의 타입은 Object[]이다.
		
		Sutdent[] stuNames = studentStream.toArray
		
	
	
	
	
	
	}
}
