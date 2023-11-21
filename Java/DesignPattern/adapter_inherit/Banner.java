package adapter_inherit;

/**
 * 미리제공되는 클래스
 * @author Sunro
 *
 */
public class Banner {
	private String string;
	
	public Banner(String string) {
		this.string = string;
	}
	
	public void showWithParen() {
		System.out.println("("+string+")");
	}
	public void showWithAster() {
		System.out.println("*"+string+"*");
	}
}
