package com.reyes.java8.other;

import java.util.function.Consumer;

public class LambdaInterface {
	
	public static void main(String[] args){
		LambdaInterface LambdaInterface = new LambdaInterface();
		LambdaInterface.happy(100.0, (x) -> System.out.println(x));
		
	}
	
	public void happy(double m, Consumer<Double> c){
		c.accept(m);
	}
	
}
