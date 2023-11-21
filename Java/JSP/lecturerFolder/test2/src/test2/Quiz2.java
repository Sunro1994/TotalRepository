package test2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜 입력(yyyy-MM-dd) : ");
		String input = sc.nextLine();
		
		String output = "";
		//1) SimpleDateFormat 사용하기
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
		output = new SimpleDateFormat("yyyy년MM월dd일").format(date);
		System.out.println("1) "  +output );
		
		// 2) split() 사용하기
		String[] arr = input.split("-");
		output = arr[0] + "년" + arr[1] + "월" + arr[2] + "일";
		System.out.println("2) " +output);
		
		// 3) replace() 사용하기
		output = input.replaceFirst("-", "년");
		
		output = output.replace("-", "월");

		output += "일";
		System.out.println("3) "+ output);
		
		
		sc.close();
	}
}
