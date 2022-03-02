package com.reyes.java8.other;

@FunctionalInterface
public interface MyValue <T, R> {
	
	public R getValue(T t1, T t2);
	
}
