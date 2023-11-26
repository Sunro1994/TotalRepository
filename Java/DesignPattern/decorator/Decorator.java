package dec;

abstract class Decorator implements IComponent{
	
	IComponent wrapee; //원 본 객체를 composition
	public Decorator(IComponent component) {
		this.wrapee = component;
	}
	
	
	@Override
	public void operation() {
		wrapee.operation();//위임
	}
	
	
}
