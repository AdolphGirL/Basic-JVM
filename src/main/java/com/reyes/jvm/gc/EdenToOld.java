package com.reyes.jvm.gc;


/**
 * jvm 對象晉升
 * 
 * 案例
 * http://www.mstacks.com/131/1367.html#content1367
 * 
 * 
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 
 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 
 * -XX:PretenureSizeThreshold=10485760
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC 
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps 
 * -Xloggc:EdenToOldGc.log
 * 
 * young GC後無法清除的大對象(Survivor區無法儲存的)，直接進入老年代
 */
public class EdenToOld {
	
	public static void main(String[] args) {
		byte[] array1 = new byte[2 * 1024 * 1024];
		array1 = new byte[2 * 1024 * 1024];
		array1 = new byte[2 * 1024 * 1024];

		byte[] array2 = new byte[128 * 1024];
		array2 = null;

		byte[] array3 = new byte[2 * 1024 * 1024];
	}
	
}
