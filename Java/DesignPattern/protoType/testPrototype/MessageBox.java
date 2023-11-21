package testPrototype;


public class MessageBox implements Product{
	
	private char decochar;
	
	public MessageBox(MessageBox prototype) {
		
		this.decochar = prototype.decochar;
	}
	
	
	public MessageBox(char c) {
		this.decochar = c;
	}


	@Override
	public void use(String s) {
		int decolen = 1 + s.length() +1;
		for(int i=0; i<decolen;i++) {
			System.out.print(decochar);
		}
		System.out.println();
		System.out.print(decochar+s+decochar);
		System.out.println();
		for(int i=0; i<decolen;i++) {
			System.out.print(decochar);
		}
		System.out.println();
	}
	
	@Override
	public Product creatCopy() {
		return new MessageBox(this);
	}
	
	
	

}
