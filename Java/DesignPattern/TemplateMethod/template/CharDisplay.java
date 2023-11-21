package template;
/**
 * AbstactDisplay를 상속받아 추상메서드를 구현한 클래스
 * @author Sunro
 *
 */
public class CharDisplay extends AbstractDisplay{
	private char ch; //표시해야 하는 문자
	
	public CharDisplay(char ch) {
		this.ch = ch;
	}

	@Override
	public void open() {
		System.out.print("<<");
	}

	@Override
	public void print() {
		System.out.print(ch);
	}

	@Override
	public void close() {
		System.out.print(">>");
	}
	
	
}
