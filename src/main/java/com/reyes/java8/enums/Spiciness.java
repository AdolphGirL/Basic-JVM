package com.reyes.java8.enums;

public enum Spiciness {
//	NOT, MILD, MEDIUM, HOT, FLAMING
	
	MAX(10), NORM(5), MIN(1);
	
	private int value;
	private Spiciness(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
	
}
