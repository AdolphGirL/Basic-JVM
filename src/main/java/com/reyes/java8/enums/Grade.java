package com.reyes.java8.enums;

public enum Grade {
	A(9, "優異"),
	B(8, "佳");
	
	private int score;
	private String description;
	
	private Grade(int score, String desc){
		this.score = score;
		this.description = desc;
	}

	public int getScore() {
		return score;
	}
	
	public String getDescription() {
		return description;
	}
}
