package com.reyes.jvm.jstat;

/**
 * 案例
 * 	http://www.mstacks.com/131/1370.html#content1370
 *
 *	-XX:NewSize=104857600 -XX:MaxNewSize=104857600 
 *	-XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 
 *	-XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 
 *	-XX:PretenureSizeThreshold=3145728 
 *	-XX:+UseParNewGC -XX:+UseConcMarkSweepGC 
 *	-XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:stat3.log
 */
public class JstatCase3 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(30000);
		while (true) {
			loadData();
		}
	}
	
	private static void loadData() throws InterruptedException {
		byte[] data = null;
		for (int i = 0; i < 50; i++) {
//			100K
			data = new byte[100 * 1024];
		}
		
		data = null;
		
//		模擬1秒內發生上述操作
		Thread.sleep(1000);
		
	}
	
}
