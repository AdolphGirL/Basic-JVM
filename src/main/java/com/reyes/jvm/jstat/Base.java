package com.reyes.jvm.jstat;

/**
 * http://www.mstacks.com/131/1369.html#content1369
 * 
 * jstat，主要觀察
 *		新生代對象的增長速度
 *		YoungGC觸發的頻率
 *		YoungGC執行的時間
 *		每次YoungGC執行後的新生代對象存活大小
 *		每次YoungGC執行後的晉升老年代的大小
 *		老年代增長的速度
 *		FullGC觸發的頻率
 *		FullGC執行的時間
 *
 *		YoungGC後的存活與晉升老年代的對象大小，沒辦法直接觀察。只能推敲
 *		也就是，每次GC後留在Survivor區的大小(可以看成存活)，而old增長的大小，
 *		可以看成晉升的對象
 *		
 *	jmap -dump:live,format=b,file=dump.hprof PID
 */
public class Base {

}
