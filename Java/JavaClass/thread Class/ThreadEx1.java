package thread;

class ThreadEx1_1 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<5;i++) {
			System.out.println(getName());//조상인Thread의 getName()을 호출
		}
	}
}
class ThreadEx2_1 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<5;i++) {
			//Thread클래스를 상속받으면, 자손 클래스에서 조상인 Thread클래스의 메서드를 직접 호출할 수 있지만
			//Runnable을 구현하면 Thread클래스의 static메서드인 currentThread()를 호출하여 쓰레드에 대한 참조를 얻어와야만 호출이 가능하다.
			System.out.println(Thread.currentThread().getName());//현재 실행중인 Thread를 반환한다.
		}
	}
}
public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();  // Thread의 자손 클래스의 인스턴스를 생성
		
		
		Thread t2 = new Thread(new ThreadEx2_1());	//Runnable을 구현한 클래스의 인스턴스 생성, 생성자 Thread(Runnable target)
		
		//쓰레드를 생성해도 start를 호출해야만 쓰레드가 실행된다.
		// 그리고 호출되었다고 해서 바로 실행되는 것이 아니라, 일단 실행대기 상태에 있다가 자신의 차례가 되어야 실행된다.
		// 실행대기중인 쓰레드가 없다면 바로 실행된다.
		// 쓰레드의 실행순서는 OS의 스케줄러가 작성한 스케줄에 의해 결정된다.
		// 한 번 수행한 쓰레드는 다시 실행할 수 없다. 새로운 쓰레드를 생성한 후에 start()를 다시 호출해야 한다.
		t1.start();
		t2.start();
		

	}
}
