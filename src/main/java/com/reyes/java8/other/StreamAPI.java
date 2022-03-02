package com.reyes.java8.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 三步驟
 * 
 * 1. 創建
 * 			Collection系列集合的 stream()，串流 pallerStream()，並行流
 * 			Arrays數組系列
 * 			Stream靜態方法
 * 			創建無限流
 * 
 * 2. 中間操作
 * 
 * 3. 終止操作
 */
public class StreamAPI {
	
	private static List<Employee> a = Arrays.asList(
			new Employee("Aa", 18, 15800),
			new Employee("Bb", 20, 45800),
			new Employee("Cc", 68, 1500),
			new Employee("Dd", 3, 800)
		);
	
	public static void main(String[] args) {
//		create1();
//		filter1();
//		reflect1();
//		find1();
//		reduce1();
//		collect1();
		group1();
	}
	
	public static void create1(){
//		Collection系列集合的 stream()
		
		Stream<Employee> stream1 = a.stream();
		stream1.forEach((x) -> System.out.println(x));
//		方法引用，上句已經操作過流，這句在執行時會錯誤
		stream1.forEach(System.out::println);
//		=========================================
		
		
//		Arrays數組系列
		Employee[] b = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(b);
//		=========================================
		
		
//		Stream靜態方法
		Stream<String> stream3 = Stream.of("2", "1");
		stream3.forEach(System.out::println);
//		=========================================
		
		
//		創建無限流，會一直創建從0開始到無限
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
		Stream<Double> stream5 = Stream.generate(() -> Math.random());
//		=========================================
	}

	/**
	 * 篩選與切片
	 * filter 接收Lambda，從數據流當中排除某些元素
	 * limit 截斷流，使元素不超過幾定數量
	 * skip(n) 跳過元素，返回一個扔掉了前n個元素後的流，若流中元素不足n個，則返回一個空流
	 * 			與limit互補
	 * distinct，篩選，通過流所元素的hashcode equals去除重複元素
	 */
	public static void filter1(){
//		中間操作，不會執行任何操作(如果沒有下一句中止操作的話)
		Stream<Employee> stream5 = a.stream().filter((x) -> {
			System.out.println("不會被操作到");
			return x.getAge() > 10;
		});
		
//		中止操作，一次全部執行，稱惰性求值
//		stream5.forEach(System.out::println);
		
		a.stream().filter((x) -> x.getAge() > 10).limit(2).distinct().forEach(System.out::println);
	}
	
	/**
	 * 映射
	 * map 接收lambda，將元素替換成其他形式或提取訊息。接收一函數作為參數，該函數會被應用到
	 * 每個元素上，將其應設為另一個元素
	 * flatmap 接收lambda，將流中的每一個值都換成另一個流，然後把所有的流都串成一個流
	 */
	public static void reflect1(){
		a.stream().map((x) -> x.getName().toUpperCase()).forEach(System.out::println);
		
//		類::實例方法，參數是方法的調用者
		a.stream().map(Employee::getName).forEach(System.out::println);
		
	}
	
	/**
	 * 排序
	 * 	sorted() 自然排序
	 * 	sorted(Comparator com) - 客製排序
	 */
	public static void order1(){
		
	}
	
	/**
	 * 中止操作
	 * 	查找與匹配
	 * 		allMatch 檢查是否匹配所有元素
	 * 		anyMatch 檢查是否至少匹配一個元素
	 * 		noneMatch檢查是否沒有匹配元素
	 * 		findFirst返回第一個
	 * 		findAny  反為當前流中任一元素
	 * 		count	返回流中元素的總數
	 * 		max		返回流中最大值
	 * 		min		返回流中最小值
	 */
	public static void find1(){
		boolean r1 = a.stream().filter((x) -> x.getAge() > 10).allMatch((x) -> x.getName().equals(""));
		boolean r2 = a.stream().filter((x) -> x.getAge() > 10).anyMatch((x) -> x.getName().equals(""));
		boolean r3 = a.stream().filter((x) -> x.getAge() > 10).noneMatch((x) -> x.getName().equals(""));
		System.out.println(r1 + " " + r2 + " " + r3);
			
	}
	
	/**
	 * reduce
	 * 	反覆結合，流中的資料
	 */
	public static void reduce1(){
		List<Integer> a = Arrays.asList(1, 2, 3);
		System.out.println(a.stream().reduce(0, (x, y) -> x + y));
	}
	
	/**
	 * collect
	 * 	收集，將流轉換為其他形式，接收一個Collector接口的實現
	 * 	用於給stream中元素做匯總的方法
	 * 
	 * 	collector接口中的方法，決定如何對流執行收集操作
	 * 	由Collectors提供靜態方法
	 */
	public static void collect1(){
//		取出姓名
		a.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);
		
//		特殊資料
		HashSet<String> s = a.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		s.forEach(System.out::println);
	}
	
	/**
	 * 分組
	 * 	
	 * 多級分組
	 * 
	 * 分區
	 */
	public static void group1(){
		Map<String, List<Employee>> x = a.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println(x);
	}
}
