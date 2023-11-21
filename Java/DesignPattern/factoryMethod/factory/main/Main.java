package main;

import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;

public class Main {
	public static void main(String[] args) {
		
		
		Factory factory = new IDCardFactory();
		Product card1  = factory.create("Youngjin Kim");
		Product card2 = factory.create("Heungmin Son");
		
		card1.use();
		card2.use();
	}
}
