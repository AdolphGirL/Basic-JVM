package com.reyes.jvm.other;


/**
 * openJDK8，有支援 DoEscapeAnalysis
 * 
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 *
 */
public class Escape {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		for (int i=0; i<10000000; i++) {
			alloc();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("花費時間: " + (end - start) + "ms");
		
		try {
			Thread.sleep(120000);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
	public static void alloc () {
		User User = new User();
	}
	
}

class User {
	
}
