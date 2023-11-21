package ch14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunctionalInterface {
public static void main(String[] args) {
	/* �Լ��� �������̽�
	interface MyFunction() {
		public abstract int max(int a, int b);
	}
	
	�� �������̽��� ������ �͸� Ŭ������ ��ü�� ������ ���� �����ȴ�.
	MyFunction f = new MyFunction() {
		public int max(int a, int b) {
		return a> b? a : b;
	 
	 int big = f.max(5,3);	//�͸� ��ü�� �޼��带 ȣ��
	
	
	MyFunction f = (int a, intb) -> a> b? a:b;
	int big = f.max(5,3);
	
	��ó�� �͸� ��ü�� ���ٽ����δ�ü�� ������ ����
	(1) ���ٽĵ� �����δ� �͸� ��ü�̸� , max���� �͸� ��ü�̴�.
	(2) max()�޼���� ���ٽ��� �Ű������� Ÿ��,����, ��ȯ���� ��ġ�ϱ� ����
	
	�׷��� �������̽��� ���� ���ٽ��� �ٷ��� �����Ǿ���. �̸� �Լ��� �������̽��� �θ���� �ߴ�.
	��, �Լ��� �������̽��� ���� �ϳ��� �߻�޼��常 ���ǵǾ� �־�� �Ѵ�.
	�ݸ鿡 static �޼���� default�޼����� ������ ������ ����.
	
	@FunctionalInterface                                     //�̿� ���� ������̼��� ���̸� �ùٸ��� �����Ͽ����� �����Ϸ��� Ȯ�����ش�.
	interface MyFunction {
		public abstract int max(int a, int b);
	 */
	
	List<String>list = Arrays.asList("abc","aaa","bbb","ddd","aaa");
	//���ٽ� ��� ��
	Collections.sort(list, new Comparator<String>() {
		public int compare(String s1, String s2) {
			return s2.compareTo(s1);
		}
	});
	
	
	//���ٽ� ��� ��
	Collections.sort(list,(s1,s2)-> s2.compareTo(s1));
	
	//�Լ��� �������̽� Ÿ���� �Ű������� ��ȯŸ��
	
/*	@FunctionalInterface
	Interface MyFunction {
		void MyFunction();	
	}
	
	void aMethod(MyFunction f) {
		f.myMethod();
	
 	MyFunction f = () -> System.out.println("myMethod()");
 	aMethod(f)
 	
 	�Ǵ� �������� ���� �Ʒ��� ���� ���� ���ٽ��� �޴� �͵� �����ϴ�.
 	aMethod(() -> System.out.println("myMethod()"));	//���ٽ��� �Ű������� ����
 	
 	
 
  
  
	}
	
	*/
}
}
