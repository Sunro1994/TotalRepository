package thread;

/**
 * 싱글 스레드와 두개의 쓰레드로 두개의 작업을 동시에 수행하는 경우를 예시로 사용한다.
 * 
 * 싱글 스레드는 A,B 두개의 작업이 있는 경우
 * A를 모두 마치고 B를 수행한다.(t2)
 * 
 * 두개의 쓰레드로 두개의 작업을 동시에 수행하는 경우
 * A와B를 번갈아가며 수행한다.
 * 이땐 작업간의 전환에 시간이 걸리기 때문에 (t2+a)의 시간이 걸린다.
 * 
 * 컨텍스트 스위칭(프로세스 또는 스레드 간의 작업 전환)
 * 작업 전환을 할 경우 현재 진행 중인 작업의 상태 정보를 저장하고 읽어 오는 시간이 소요된다.
 * 쓰레드의 스위칭에 비해 프로세스의 스위칭이 더 많은 정보를 저장해야 하므로 더 많은 시간이 소요된다.
 * 
 * 그래서 싱글 코어에서 단순히 CPU만을 사용하는 계산작업이라면 오히려 멀티쓰레드보다 싱글 쓰레드 프로그래밍이 더 효율적이다
 * 
 * 해당 결과는 실행할때마다 다른 결과를 얻을 수 있는데 예제프로그램이 OS의 프로세스 스케줄러의 영향을 받기 때문이다.
 * JVM이 쓰레드 스케줄러에 의해서 어떤 스레드가 얼마동안 실행될 것인지 결정되는 것과 같이 프로세스도 프로세스 스케줄러에 의해서 실행순서와
 * 실행 시간이 결정되기 때문에 매 순간 상황에 따라 프로세스에게 할당되는 실행시간이 일정하지 않고 쓰레드에게 할당되는 시간역시 일정하지 않다.
 * 
 * 자바가 OS(플랫폼) 독립적이라고 하지만 실제로는 OS종속적인 부분이 몇 가지 있는데 쓰레드도 그 중 하나이다.
 * 
 * 두 쓰레드가 서로 다른 자원을 사용하는 작업의 경우 싱글쓰레드보다 멀티쓰레드가 더 효율적이다.
 * 예시 ) 외부기기의 입출력을 받는 경우 입력을 기다리는 작업 동안 다른 업무가 수행된다.
 * 
 * 
 * @author Sunro
 * 
 *
 */



public class SingleThreadAndMultiThread {
public static void main(String[] args) {
	
}
}