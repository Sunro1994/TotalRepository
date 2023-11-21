package singleton;

public class Singleton {
	private static Singleton singleton ;
	
	private Singleton() {
		System.out.println("인스턴스를 생성함");
		slowDown();
	}
	
	public static synchronized Singleton getInstance() {	//synchronized를 사용하여 정상적으로 초기화시키기
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
		
	}
	
	private void slowDown() {
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			}
	}
}
