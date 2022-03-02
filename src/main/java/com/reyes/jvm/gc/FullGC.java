package com.reyes.jvm.gc;


/**
 * 案例
 * http://www.mstacks.com/131/1368.html#content1368
 * 
 * 新生代10M、MaxHeapSize20M，所以老年代10M
 * XX:PretenureSizeThreshold=3145728，大於3M進入老年代
 * 
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 
 * -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 
 * -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC 
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:FullGc.log
 *
 */

public class FullGC {
	
	public static void main(String[] args) {
		
//		進入老年代
		byte[] array1 = new byte[4 * 1024 * 1024];
		array1 = null;
		
		byte[] array2 = new byte[2 * 1024 * 1024];
		byte[] array3 = new byte[2 * 1024 * 1024];
		byte[] array4 = new byte[2 * 1024 * 1024];
		byte[] array5 = new byte[128 * 1024];
		
//		觸發Young GC
		byte[] array6 = new byte[2 * 1024 * 1024];
		
//		目前eden區所有引用都還存活，(array2-array5)
//		但Survivor也放不下，所以會轉移到old區
//		但old區只剩6M(array1)，容不下(array2-array5)
//		因此會觸發full gc
		
	}
	
}
