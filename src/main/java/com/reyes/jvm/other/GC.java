package com.reyes.jvm.other;

import java.util.ArrayList;
import java.util.List;

public class GC {
	
	public static void main(String[] args) {
		GC gc = new GC();
		gc.heapOOM();
	}
	
	public void heapOOM() {
		List<GC> list = new ArrayList<>();
		
		while (true) {
			list.add(new GC());
		}
	}
	
	public void stackOverflow() {
		
	}
	
}
