package ch12;


public class Generics {
/*���׸����� ���� 
	1. Ÿ���� �������� ����
	2. Ÿ��üũ�� ����ȯ�� ������ �����Ͽ� �ڵ尡 ��������
*/
	public static void main(String[] args) {
		class Box<T> {} 				// Box : ���� Ÿ�� BOX<T> : T��Box�Ǵ� T Box��� ����
										// T : Ÿ�� ���� �Ǵ� Ÿ�� �Ű�����
	Box<String> b = new Box<String>(); //String : ���Ե� Ÿ��(�Ű�����ȭ�� Ÿ��), ���׸� Ÿ�� ȣ��
	
	
	
	
//	���׸� Ÿ������ �迭�� ������ ���� ������ �����ϳ� �迭 ������ �Ұ��ϴ�.
//	�� �迭�� �����ؾ� �Ѵٸ� newInstance()�Ǵ� Object�迭�� �����ؼ� ������ ���� T[]�� ����ȯ�����ش�.
	class Box2<T> {
		T[] itemArr;							//TŸ���� �迭�� ���� ���� ����
		
//		T[] toArray() {
//			T[] tmpArr = new T[itemArr.length];  Err.���׸� �迭 ���� �Ұ�
			
	}//Box2
		
/*	�� Ÿ���� ��Ӱ��迡 �־ ���������� ���Ե� Ÿ���� �ٸ��� ������ ������ �߻��Ѵ�.
	Box<Fruit> appleBox = new Box<Apple>();	
	������ Ÿ�� T�� Fruit�� ��� void add(Fruit item)�� �ǹǷ� Fruit�� �ڼյ��� �� �޼����� �Ű������� �� �� �ִ�.
	Box<Fruit> fruitBox = new Box<Fruit>();		OK
	fruitBox.add(new Fruit());					OK
	fruitBox.add(new Apple());					OK
*/
	
	
	
/*	���ѵ� ���׸� Ŭ���� 
 	
 	class FruitBox<T extends Fruit> { �̿� ���� extends�� ���� ����Ͽ� Ư�� Ÿ���� �ڼո� Ÿ������ ���� �����ϴ�.
 	ArrayList<T> list = new ARrayList<T>();
 	}
 	
 	���� Ŭ������ �ƴ϶� �������̽��� �����ؾ� �Ѵٴ� ������ �ʿ��ϴٸ� �̶���extends�� ����ϴ� ���� �������
 	interface Eatable{}
 	class FruitBox<T extends Eatable> {...}
 	
 	Ŭ������ Fruit�� �ڼ��̸鼭 Eatable�������̽��� �����ؾ� �Ѵٸ� &��ȣ�� �����Ѵ�.
 	
 	
 	<? extends T> : ���ϵ� ī���� ���� ����, T�� �� �ڼյ鸸 ����
 	<? super   T> : ���̵� ī���� ���� ����. T�� �� ����鸸 ����
 	<?>			  : ���� ����. ��� Ÿ���� ����.<? extends Object>�� ����
 */
	
	/*	���׸� �޼���
	 	
	 	static <T> void sort(List<T> list, comparator<T> c) ���⼭ Ÿ���� Apple�� ���Ѵ�.
	 	static <Apple> void sort(List<Apple> list, comparator<Apple> c) Grape�� �ʿ��ϸ� �� �ϳ��� ���׸� �޼��带 ������ �Ѵ�.
	 	static <Grape> void sort(List<Grape> list, comparator<Grape> c) 
	 	��ó�� ���ŷο� �۾��� ȿ�������� �ϱ� ���� <? super Apple>�� ����Ѵ�. 
	 	��ó�� ���ŷο� �۾��� ȿ�������� �ϱ� ���� <? super Grape>�� ����Ѵ�. 
	 	
	 	class FruitComp implements Comparator<Fruit> {
	 	public int compare(Fruit t1, Fruit t2)	return t1.weight-t2.weight;
	 	}
	 	�� ó�� FruitComp�� ����� Apple�� Grape�� ��� ������ �� �ִ�.
	 	
	 	Collections.sort(appleBox.getList(), new FruitComp());
	 	Collections.sort(grapeBox.getList(), new FruitComp());
	 	
	 	public static void printAll(ArrayList<? extends Product> list, ArrayList<? extends Product>list2) {
	 	}
	 	
	 	public static <T extends Product> void printAll(ArrayList<T> list, ArrayList<T> list2)�� �ڵ带 ����ȭ ����
	 	
	 	
	 	������ ���ʸ� �޼���
	 	public static <T extends Comprable<? super T>> void sort(List<T> list)
	 	�ؼ� : list�� Comparable�� �����ؾ��ϸ� T�Ǵ� �� ������ Ÿ���� ���ϴ� Comparable�̾�� �Ѵٴ� ��
	 	
	 */
	
	
	/*���׸� Ÿ���� ����ȯ
		
		Box<Object> objBox = null;
		Box<String> strBox = null;
		
		objBox = (Box<Object>)strBox;	Err
		strBox = (Box<String>)objBox;	Err
		
		Box<? extends Object> wbox = new Box<String>(); 	Ok
		
		FruitBox<? extends Fruit> box = null;
		
		FruitBox<Apple> appleBox = (FruitBox<Apple>)box; 	OK, ��Ȯ��Ÿ������ ���
		��� �ߴ� ���� : extends Fruite�� ������ ���� box�� FruitŸ���� �������ε��ٰ� Apple�� ������ �ٸ� Ÿ���� Apple�� 
					   ��ȯ�� �� ���� �����̴�.
					   
		Optional<?> EMPTY = new Optional<>();
		���⼭ ?�� <? extends Object>�� �ٿ� ����
		
		== Optional<?> EMPTY = new Optional<>();
		== Optional<?> EMPTY = new Optional<Object>();
		!= Optional<?> EMPTY = new Optional<>(?); Err ��Ȯ�� Ÿ���� ��ü�� ���� �Ұ�
	
	
		����
		Optional<Obejct> -> Optional<T>   Err ����ȯ �Ұ���
		Optional<Object> -> Optional<?> -> Optional<T>	����ȯ �����ϳ� ��� �߻�
		
		���ϵ� ī�尡 ���� ���׸� Ÿ�Գ����� ����ȯ�� �����ϱ� �ϴ�.
		FruitBox<? extends Object> objBox = null;
		FruitBox<? extends String> strBox = null;
		
		strBox = (FruitBox<? extends String>)objBox;	OK,������ ���
		objBox = (FruitBox<? extends Object>)strBox;	OK,������ ���
		
	*/
	}//main
	}

