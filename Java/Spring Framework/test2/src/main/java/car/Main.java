package car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:car-context.xml");
		
		Car car1 = context.getBean("car1",Car.class);
		Car car2 = context.getBean("car2",Car.class);
		Car car3 = context.getBean("car3",Car.class);
		
		car1.drive();
		car2.drive();
		car3.drive();
		
		context.close();
	}
}
