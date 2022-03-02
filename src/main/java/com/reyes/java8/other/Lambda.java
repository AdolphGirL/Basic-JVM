package com.reyes.java8.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
	
	public static void main(String[] args) {
		List<Employee> empolyees = Arrays.asList(
			new Employee("Aa", 18, 15800),
			new Employee("Bb", 20, 45800),
			new Employee("Cc", 68, 1500),
			new Employee("Dd", 3, 800)
		);
		
//		List<Employee> res = filter(empolyees, (e) -> e.getAge() > 10); 
//		res.forEach(System.out::println);
		Collections.sort(empolyees, (e1, e2) -> {
			if(e1.getAge() == e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for(Employee e : empolyees){
			PrintU(e.getName(), x -> x.toUpperCase());
			PrintX(e.getAge(), e.getAge(), (x, y) -> x + y);
		}
		
	}
	
	/**
	 * Lambda 方式使用一；需要創建interface。策略設計模式(根據需要的條件來處理需要的事物，比方過濾條件的變換)
	 */
	public static List<Employee> filter(List<Employee> empolyees, MyFilter<Employee> m){
		List<Employee> emps = new ArrayList<>();
		
		for(Employee emp : empolyees){
			if(m.test(emp)){
				emps.add(emp);
			}
		}
		
		return emps;
	}
	
	public static void PrintU(String s, MyToString m) {
		System.out.println(m.getValue(s));
	}
	
	public static void PrintX(int i1, int i2, MyValue<Integer, Integer> m) {
		System.out.println(m.getValue(i1, i2));
	}

}

class Employee {
	
	private String name;
	private int age;
	private double salary;
	
	public Employee(){
		
	}
	
	public Employee(int age){
		this.age = age;
	}
	
	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}