package thread;

/** 
 * 두 개의 쓰레드가 작업을 하나씩 나누어 수행한 실행결과를 비교해보자
 * 
 * 이전 예제와 달리 두 작업이 아주 짧은 시간동안 번갈아가면서 실행되었으며 거의 동시에 작업이 완료되었음을 알 수 있다.
 * 두 개의 쓰레드로 작업을 처리하는데 더 많은 시간이 걸린 이유는 작업전환간의 시간소요이다.
 * 다른 하나의 이유는 한 스레드가 화면에 출력하고 이쓴ㄴ 동안 다른 쓰레드는 대기해야하는 시간이 발생한다.
 * 
 * 싱글 코어인 경우 멀티 쓰레드를 쓰더라도 하나의 코어가 번갈아가면서 작업을 수행하는 것이므로 절대 작업이 겹치지 않는다.
 * 멀티 코어인 경우 멀티스레드로 두 작업을 수행하면 동시에 스레드가 수행될 수 있으므로 겹치는 경우가 발생한다. 이때는 화면이라는
 * 자원을 놓고 두 스레드가 경쟁하는 부분이 발생한다. 
 * 
 * 병행(concurrent) : 여러 쓰레드가 여러 작업을 동시에 진행
 * 
 * 병렬(parellel) : 하나의 작업을 여러 쓰레드가 나눠서 처리하는 것
 * 
 * @author @Sunro
 *
 */
public class ThreadEx5 {
	static long startTime =0;
	public static void main(String[] args) {
		ThreadEx5_1 th = new ThreadEx5_1();
		th.start();
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<300;i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.print("소요시간1:"+(System.currentTimeMillis()-startTime));
		
	}
}
class ThreadEx5_1 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<300; i++) System.out.printf("%s",new String("|"));
		
		System.out.println("소요시간2 : "+(System.currentTimeMillis()-ThreadEx5.startTime));
	}
}
