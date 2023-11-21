package queue;

import java.util.Arrays;

public class Call {
 public static void main(String[] args) {
	CircleQueue cq = new CircleQueue();
	
	cq.Inqueue(5);
	cq.Inqueue(6);
	cq.Inqueue(7);
	cq.Inqueue(8);
	cq.Inqueue(9);
	cq.Inqueue(9);

	
	System.out.println(Arrays.toString(cq.getQueueArray()));
}
}
