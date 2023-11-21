package framework;


/**
 * 
 * @param p : createProduct와 registerProduct를 구현한 Product 객체
 * @DesignPattern : Template Method가 사용된다. 추상메서드 createProduct로 제품을 만들고 registerProduct로 등록하는 절차가 구현되어 있다.
 * 구체적인 내용은 Factory Method패턴을 적용한 프로그램에 따라 달라진다.
 * Factory Method패턴에서는 인스턴스를 생성할 떄 Template Method를 사용한다.
 * 
 * @author Sunro
 *
 */
public abstract class Factory {
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	protected abstract Product createProduct(String owner);
	protected abstract void registerProduct(Product product);
	
}
