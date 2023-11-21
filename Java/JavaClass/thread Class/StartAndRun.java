package thread;
/**
 * start()와 run()
 * 
 * @run
 * run()을 호출하는 것은 단순히 클래스에 선언된 메서드를 호출하는 것일 뿐이다.
 * 
 * 
 * @start
 * 새로운 쓰레드가 작업하는데 필요한 호출스택(call stack)을 생성한 다음에 run()을 호출해서, 생성된 호출스택에 run()이 첫번째로 올라가게 한다.
 * 모든 쓰레드는 독립적인 작업을 수행하기 때문에 자신만의 호출스택을 필요로 한다. 쓰레드가 종료되면 작업에 사용된 호출스택은 소멸된다.
 * 
 * @mainThread
 * 우리가 main메서드의 작업을 수행하는 것도 쓰레드이며, 이를 main쓰레드라고 한다.
 * 
 * 
 * @author Sunro
 *
 */

public class StartAndRun {
public static void main(String[] args) {
	
}
}
