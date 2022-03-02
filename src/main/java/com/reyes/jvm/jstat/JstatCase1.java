package com.reyes.jvm.jstat;


/**
 * 案例
 * https://zhuanlan.zhihu.com/p/410048725
 *
 *	1. 每秒多少請求、每次請求分配多少資源
 *	2. 確認是否頻繁觸及GC
 *
 *	每秒鐘50個請求、每個請求加載100KB數據(內存200M設置、新生代100M(Eden 80)、老年代100M)
 *
 *	-XX:NewSize=100m
 *	-XX:MaxNewSize=100m 
 *	-XX:InitialHeapSize=200m 
 *	-XX:MaxHeapSize=200m 
 *	-XX:SurvivorRatio=8 
 *	-XX:MaxTenuringThreshold=15 	-> 晉升到老年代的閥值次數	
 *	-XX:PretenureSizeThreshold=3m 	-> 大於這個值、直接在老年代分配
 *	-XX:+UseParNewGC 
 *	-XX:+UseConcMarkSweepGC 
 *	-XX:+PrintGCDetails 
 *	-XX:+PrintGCTimeStamps 
 *	-Xloggc:gc.log
 *
 */
public class JstatCase1 {
	
	public static void main(String[] args) throws InterruptedException {
//		先睡30秒，讓我們有足夠時間下指令監控
		Thread.sleep(30000);
		
		while(true){
			loadData();
		}
	}
	
	public static final int _1KB = 1024;
	
	private static void loadData() throws InterruptedException {
		byte[] data = null;
		for (int i = 0; i < 50; i++) {
			data = new byte[100 * _1KB];
		}
		data = null;

		Thread.sleep(1000);
	}
	
}
