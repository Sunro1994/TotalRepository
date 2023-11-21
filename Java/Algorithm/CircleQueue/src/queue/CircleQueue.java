package queue;

import java.util.Deque;
import java.util.LinkedList;

public class CircleQueue {
	private int qSize =10;
	private int front = 0;
	private int rear = 0;
	private int[] queueArray = new int[qSize];
	
	
	//isEmpty
	public boolean isEmpty() {
		
		return rear==front;
	}
	
	//isFull
	public boolean isFull() {
		
		return (rear+1)%qSize == front;
	}
	//Inqueue
	public void Inqueue(int n) {
		if(isFull()) {
			System.out.println("isFull");
			throw new ArrayIndexOutOfBoundsException();
		}
		queueArray[rear]= n;
		rear++;
		rear %= qSize;
	}
	
	//Dequeue
	
	public int getqSize() {
		return qSize;
	}

	public void setqSize(int qSize) {
		this.qSize = qSize;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int[] getQueueArray() {
		return queueArray;
	}

	public void setQueueArray(int[] queueArray) {
		this.queueArray = queueArray;
	}

	public int Dequeue() {
		if(isEmpty()) {
			System.out.println("empty");
			throw new ArrayIndexOutOfBoundsException();
		}
		int tmp = queueArray[front];
		front++;
		front%=qSize;
		
		return tmp;
	}
	
}
