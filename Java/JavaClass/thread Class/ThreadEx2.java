package thread;

/**
 * 실행결과
 * 
 * 메인은 t1객체를 호출하고 종료된다.
 * t1.start()로 새로운 호출스택이 생성되고 그안에서 run이 호출되며 run스택위에 throwexception이 호출된다.
 * 따라서 Main쓰레드의 호출스택은 종료되고 run과 throwException만 남는다. 
 * @author Sunro
 *
 */
class ThreadEx2 {
	public static void main(String[] args) {
		ThreadEx2_11 t1 = new ThreadEx2_11();
		t1.start();
	}
}
class ThreadEx2_11 extends Thread {
	@Override
	public void run() {
		throwexception();
	}
	public void throwexception() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
