package adapter_inherit;

/**
 * 준비된 Banner클래스를 확장하여 showWithParen메서드와 showWithAster
 * 메서드를 상속받으며, 필요한 Print인터페이스를 구현하여 printWeak메서드와 
 * printStrong메서드를 구현합니다.
 * @author Sunro
 *
 */
public class PrintBanner extends Banner implements Print{
	public PrintBanner(String string) {
		super(string);
	}
	
	@Override
	public void printWeak() {
		showWithParen();
	}
	
	@Override
	public void printStrong() {
		showWithAster();
	}
}
