package testPrototype;


public class UnderLinePen implements Product{

		private char ulchar;
		
		public UnderLinePen(UnderLinePen proto) {
			this.ulchar = proto.ulchar;
		}
		
		
	public UnderLinePen(char c) {
			this.ulchar = c;
		}


	@Override
	public void use(String s) {
		int ulen = s.length();
		System.out.print(s);
		System.out.println();
		for(int i=0; i<ulen;i++) {
			System.out.print(ulchar);
		}
		System.out.println();
	}
	
	@Override
	public Product creatCopy() {
	return new UnderLinePen(this);
	}

	
}
