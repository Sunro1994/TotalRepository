package builder;

public class Director {
	
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void construct() {
		builder.makeTitle("Greeting");
		builder.makeString("일반적인사");
		builder.makeItems(new String[] {"How are you?","Hello","hi"});
		builder.makeString("시간대별 인사");
		builder.makeItems(new String[] {"Good moring","Good afternoon","Good evening"});
		builder.close();
	}
}
