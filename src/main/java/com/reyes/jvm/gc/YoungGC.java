package com.reyes.jvm.gc;

/**
 * 案例
 * http://www.mstacks.com/131/1364.html#content1364
 * 
 * 模擬
 * http://www.mstacks.com/131/1366.html#content1366
 * 
 * 新生代(Eden)大小5MB、Heap 10M、Eden4M、Survivor各0.5M、大對象(晉升老年代10M)
 * 新生代GC使用ParNew、老年代使用CMS
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 
 * -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 
 * -XX:SurvivorRatio=8 
 * -XX:PretenureSizeThreshold=10485760 
 * -XX:+UseParNewGC 
 * -XX:+UseConcMarkSweepGC
 *
 * -XX:+PrintGCDetails		gclog
 * -XX:+PrintGCTimeStamps	gc時間
 * -Xloggc:gc.log			寫入檔案名
 * 
 * GC (Allocation Failure -> GC原因
 * 0.253: [GC (Allocation Failure) 0.253:
 *  
 * [ParNew: 3944K->512K(4608K), 0.0019552 secs] 3944K->546K(9728K), 0.0021502 secs] 
 * [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 
 * ParNew: 3944K->512K(4608K), 0.0019552 secs；使用ParNew進行新生代的GC，GC前新生代使用3944K，GC後使用512K
 * 			4608K表示新生代的總空間 eden + 1個Survivor；本次耗時0.0018168
 * 
 * 3944K->546K(9728K), 0.0021502 secs。java heap區總空間為9728K；GC前使用3944K，GC後使用546K
 * 
 * YoungGC後512K存活下來，從Eden轉到Survivor區
 */

public class YoungGC {
	
	public static void main(String[] args) {
//		1M
		byte[] array1 = new byte[1024 * 1024];
		
//		重新賦值引用
		array1 = new byte[1024 * 1024];
		array1 = new byte[1024 * 1024];
		
//		讓前三個array對象，失去引用
		array1 = null;
		
//		2M (此時eden區為 1+1+1+2 > 4)，觸發YoungGC
		byte[] array2 = new byte[2 * 1024 * 1024];
	}
}
