package com.reyes.java8.other;

import java.util.Arrays;
import java.util.List;

/**
 * 方法引用；lambda體中的功能，已有函數實現，則可以使用方法引用
 * 
 * 	對象::實例的方法 -> 引用的方法，需與lambda提供的參數、返回值都要一致
 *
 * 	類::靜態方法
 * 
 * 	類::實例方法
 * 
 * 構造器引用，同方法引用，引用時，需與lambda提供的參數、返回值都要一致
 * 	ClassName::new
 * 
 * 數組引用
 * 	Type[]::new
 */
public class MethodRef {

	/*
	public static void main(String[] args) {
		
//		對象::實例的方法，範例一
		PrintStream ps0 = System.out;
		Consumer<String> c0 = (x) -> ps0.println(x);
		
		PrintStream ps1 = System.out;
		Consumer<String> c1 = ps1::println;
		
		Consumer<String> c2 = System.out::println;
//		====================================
		
//		對象::實例的方法，範例二
		Employee e1 = new Employee("Aa", 18, 15800);
		Supplier<String> su1 = () -> e1.getName();
		
//		可以改寫為
		Employee e2 = new Employee("Aa", 18, 15800);
		Supplier<String> su2 = e2::getName;
//		====================================
		
//		類::靜態方法
		Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
		Comparator<Integer> com2 = Integer::compare;
//		====================================
		
//		類::實例方法，如果第一個參數是方法的調用者，第二個參數是要調用方法的傳入參數
//		該參數是方法的調用者，即可以使用(如果只有一個參數的情況)
//		(一定是lambda表达式所接收的第一个参数来调用实例方法，如果lambda表达式接收多个参数，其余的参数作为方法的参数传递进去。)
		BiPredicate<String, String> a1 = (x, y) -> x.equals(y);
		BiPredicate<String, String> a2 = String::equals;
//		====================================
		
//		構造器引用，調用無參數的建構子
		Supplier<Employee> s1 = () -> new Employee();
		Supplier<Employee> s2 = Employee::new;
		
		Function<Integer, Employee> f1 = (x) -> new Employee(x);
		Function<Integer, Employee> f2 = Employee::new;
		
//		無法引用，因為沒有兩個參數的建構子
//		BiFunction<String, Integer, Employee> v = Employee::new;
//		====================================
		
//		數組引用
		Function<Integer, String[]> q1 = (x) -> new String[x];
		Function<Integer, String[]> q2 = String[]::new;
		
		String[] xx1 = q1.apply(10);
		String[] xx2 = q2.apply(20);
//		====================================
	}
	*/
	
//	練習二
//	public static void main(String[] args) {
//		Student student1 = new Student("zhangsan", 60);
//		Student student2 = new Student("lisi", 70);
//		Student student3 = new Student("wangwu", 80);
//		Student student4 = new Student("zhaoliu", 90);
//		List<Student> students = Arrays.asList(student1, student2, student3, student4);
//
////		students.sort((o1, o2) -> o1.getScore() - o2.getScore());
////		students.forEach(student -> System.out.println(student.getScore()));
//		
////		sort接收Comparator - int compare(T o1, T o2)，使用Student靜態方法，compareStudentByScore(同樣接收2個參數，返回一個值)
//		students.sort(Student::compareStudentByScore);
//		students.forEach(student -> System.out.println(student.getScore()));
//		
//		
//	}
	
	
	
}


class Student {
	private String name;
	private int score;

	public Student() {

	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int compareStudentByScore(Student student1, Student student2) {
		return student1.getScore() - student2.getScore();
	}

	public static int compareStudentByName(Student student1, Student student2) {
		return student1.getName().compareToIgnoreCase(student2.getName());
	}
}