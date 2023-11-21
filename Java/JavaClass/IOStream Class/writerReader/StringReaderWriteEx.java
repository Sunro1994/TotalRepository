package writerReader;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriteEx {
public static void main(String[] args) {
	String inputData = "ABCDE";
	StringReader input= new StringReader(inputData);
	StringWriter output = new StringWriter();
	
	int data =0;
	try {
	while((data=input.read()) != -1)  output.write(data);
	}catch (IOException e) {}
	
	System.out.println("Input data: "+ inputData);
	System.out.println("Output Data : "+ output.toString());
	System.out.println("Output Data : "+ output.getBuffer().toString());
}
}
