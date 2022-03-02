package com.reyes.jvm.jstat;

/**
 * 案例
 * https://juejin.cn/post/7004833666769633310
 * 
 * (內存200M設置、新生代100M(Eden 80)、老年代100M)
 *	-XX:NewSize=100m -XX:MaxNewSize=100m -XX:InitialHeapSize=200m -XX:MaxHeapSize=200m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 *  -XX:PretenureSizeThreshold=20m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *
 *	jstat -gc -t -h5 4792 1000 1000
 *
 *	備註。gc log，補充https://codertw.com/%E4%BC%BA%E6%9C%8D%E5%99%A8/154164/
 *	GC (Allocation Failure)
 *		Allocation Failure表示向young generation(eden)給新物件申請空間，但是young generation(eden)剩餘的合適空間不夠所需的大小導致的minor gc
 *		[PSYoungGen: 74956K->653K(92160K) =>(eden空間情況) ] 74956K->31381K(194560K) => 整個heap區, 0.0144787 secs]
 *	Full GC (Ergonomics)
 *		預設開啟了UseAdaptiveSizePolicy，jvm自己進行自適應調整引發的full gc
 *	Full GC (Metadata GC Threshold)
 *		由metaspace引起gc
 *
 *	[Full GC (Ergonomics) 
 *			[PSYoungGen: 0K->0K(101888K)] => eden
 *			[ParOldGen: 82452K->21012K(102400K)] => old 
 *			82452K->21012K(204288K), all heap
 *			[Metaspace: 3085K->3085K(1056768K)], => Metaspace 
 *			0.0049049 secs] 
 *			[Times: user=0.02 sys=0.00, real=0.01 secs] 
 *
 */
public class JstatCase2 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(30000);
		
		while(true){
			loadData();
		}
	}
	
	public static final int _1MB = 1024 * 1024;
	
	private static void loadData() throws InterruptedException {
		byte[] data = null;
		for(int i = 0; i < 4; i++) {
			data = new byte[10 * _1MB];
			data = null;
		}
		
		byte[] data1 = new byte[10 * _1MB];
		byte[] data2 = new byte[10 * _1MB];
		byte[] data3 = new byte[10 * _1MB];
		data3 = new byte[10 * _1MB];
		
		Thread.sleep(1000);
	}
}
