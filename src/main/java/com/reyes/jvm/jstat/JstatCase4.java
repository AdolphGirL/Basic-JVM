package com.reyes.jvm.jstat;

/**
 * http://www.mstacks.com/131/1371.html#content1371
 * 
 * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 
 * -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 
 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 
 * -XX:PretenureSizeThreshold=20971520 
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC 
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:jstat-fullcase-gc.log
 *
 */
public class JstatCase4 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(30000);
		while (true) {
			loadData();
		}
	}
	
	private static void loadData() throws InterruptedException {
		byte[] data = null;
		for (int i = 0; i < 4; i++) {
//			10MB
			data = new byte[10 * 1024 * 1024];
		}
		
		data = null;

		byte[] data1 = new byte[10 * 1024 * 1024];
		byte[] data2 = new byte[10 * 1024 * 1024];

		byte[] data3 = new byte[10 * 1024 * 1024];
		data3 = new byte[10 * 1024 * 1024];

//		模擬以上操作一秒內，完成
		Thread.sleep(1000);
		
	}
	
}
