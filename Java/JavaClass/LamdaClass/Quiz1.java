package ch14_Lamda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Quiz1 {

// 1.짝수를 출력하는 람다식 생성
public static void main(String[] args) {
	int[] num = {1,2,3,4,5,6,7,8};
	
	IntPredicate p = i-> i%2==0;
	for(int k: num) if(p.test(k)) System.out.println(k);

// 2.길이가 3이하인 문자열만 출력하기
	
	String[] a = {"a","ab","abc","abcd"};
	Predicate<String> p1 = i -> i.length()<=3;
	for(String x : a) if(p1.test(x)) System.out.println(x);
	
	int[] arr = new int[10];
	IntSupplier s = () -> (int)(Math.random()*10)+1;
	
	makeRandomNumber(s, arr);
	System.out.println(Arrays.toString(arr));
}
//	3. 랜덤한 숫자를 생성하는 메서드 생성
	static void makeRandomNumber(IntSupplier s , int[] arr) {
		for(int i=0;i<arr.length;i++) arr[i] = s.getAsInt();
		
	}
	








}

