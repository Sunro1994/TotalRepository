package thread;

/**
 * 해당 예제는 전 예제와 달리 쓰레드가 새로 생성되지 않았다.
 * run()으로 호출되었을 뿐이기 때문이다. 
 * main쓰레드의 위에 run() 그 위에 throwException이 호출되어있다.
 * @author Sunro
 *
 */
public class ThreadEx3 {
public static void main(String[] args) {
	ThreadEx3_1 t1 = new ThreadEx3_1();
	t1.run();
}
}

class ThreadEx3_1 extends Thread {
	@Override
	public void run() {
		throwException();
	}
	
	private void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}