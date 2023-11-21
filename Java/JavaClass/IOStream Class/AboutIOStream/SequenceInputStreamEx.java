package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {
public static void main(String[] args) {
	byte[] arr1 = {0,1,2};
	byte[] arr2 = {3,4,5};
	byte[] arr3 = {6,7,8};
	byte[] outSrc  = null;
	
	Vector v = new Vector<>();
	v.add(new ByteArrayInputStream(arr1));
	v.add(new ByteArrayInputStream(arr2));
	v.add(new ByteArrayInputStream(arr3));
	
	SequenceInputStream input = new SequenceInputStream(v.elements());
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	int data = 0;
	
	try {
		while((data = input.read()) != -1) {
		//Vector에 저장된 순서대로 출력된다.
			output.write(data);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("Input Source1 : " + Arrays.toString(arr1));
	System.out.println("Input Source2 : " + Arrays.toString(arr2));
	System.out.println("Input Source3 : " + Arrays.toString(arr3));
	
}
}
