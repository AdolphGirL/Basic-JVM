package com.reyes.jvm.jmap;

import java.util.ArrayList;

/**
 * jmap 生成當下運行時的 
 * 	dump(二進制文件)		jmap -dump pid，生成前會發生一次full gc，
 * 										所以保存full gc後留下的資料(對於自動的產出的情況)
 * 
 * 		只取存活的對象		jmap -dump:live,format=b,file=xxx.hprof pid
 * 		一般來說，實際情況，如果取全部時，會導致資料太龐大
 * 		而效能不佳，通常是GC不掉目前內存的空間，因此取存活的對象，來分析會比較妥當
 * 		全部					jmap -dump:format=b,file=xxx.hprof pid
 * 		
 * 		手動生成dump，自動生成dump。兩者都可以選擇，但當系統發生OOM時，則只能使用自動
 * 		自動 -XX:+heapDumpOnOutOfMemoryError
 * 			 -XX:HeapDumpPath=D:\m.hprof
 * 
 * 	-Xms60m -Xmx60m -XX:SurvivorRatio=8
 * 
 *	進程內存的情形		jmap -heap pid
 *	內存各區的使用情況	jmap -histo
 *	類加載，在方法區 metaspace
 */
public class BaseJMap {
	
	public static void main(String[] args) {
		ArrayList<byte[]> list = new ArrayList<>();
		
		for (int i=0; i<100; i++) {
//			100KB
			byte[] arr = new byte[1024 * 100];
			
			list.add(arr);
			
			try {
				Thread.sleep(500);
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}
	
}
