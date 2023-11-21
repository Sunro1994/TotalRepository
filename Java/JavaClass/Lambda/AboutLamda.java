package ch14;

import java.util.Arrays;

public class AboutLamda {
//		1.�ڹ��� ū ��ȭ
	/*
	 	JDK1.5 ���� �߰��� generics, JDK 1.8 ���� �߰��� ���ٽ��� ����
	 	
	 	�޼��带 ���ٽ����� �ϸ� �޼����� �̸��� ��ȯ���� ��������. ���ٽ��� �͸� �Լ���� �Ѵ�.
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		Arrays.setAll(arr,(i) -> (int)(Math.random()*5)+1);
		
/*	���� �Ŀ��� ���ٽ��� �Ʒ��� ���� ǥ���ȴ�.
/
	 int method() {
	 return (int) (Math.random()*5)+1;
	 }
*/
		
		
//	2.���ٽ� �ۼ��ϱ�
/*
 	��ȯŸ�� �޼����̸�(�Ű����� ����) {
 	�����
 	}
 	int max(int a, int b) {return a>b?a:b;
 	
 	(1) ��ȯŸ�԰� �޼��� �̸��� �����Ѵ�.
 	(int a, int b) {return a>b?a:b;}
 	
 	(2) �Ű����� ����ο� ����{} ���̿� '->'�� �߰��Ѵ�.
 	(int a, int b) -> {return a>b?a:b;}
 	
 	(3) ��ȯ���� �ִ� �޼����� ���, return�� ��� '��(expression)���� ����� �� �ִ�.' �̶� ����';'�� ���� �ʴ´�.
 	(int a, int b) -> a>b? a: b
 	
 	(4)���ٽĿ� ����� �Ű������� Ÿ���� �߷��� ������ ��� ���� �����ϴ�.
 	(a , b) -> a > b ? a : b
 	
 	(5)����� �Ű������� �ϳ����� ��쿡�� ��ȣ()�� ������ �� �ִ�. �� �Ű����� Ÿ���� ������ ��ȣ()�� ������ �� ����.
 	(a) -> a* a             =>             a - > a * a //OK
 	(int a) -> a * a		=>		   int a - >  a *a //Err
 
 	(6) ��ȣ ���� ������ return���� ��� ������ �� ����.
 
 */	
	}
	
	
}
