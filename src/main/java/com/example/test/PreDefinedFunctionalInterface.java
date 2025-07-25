package com.example.test;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee {
	String ename;
	int salary;

	public Employee(String ename, int salary) {
		this.ename = ename;
		this.salary = salary;
	}

}

public class PreDefinedFunctionalInterface {
	// 1.Predicate
	// 2.Function
	// 3.Consumer
	// 4.Supplier

	// 2.Function
	public static void main(String[] args) {
		ArrayList<Employee> elist = new ArrayList<Employee>();
		elist.add(new Employee("swati", 50000));
		elist.add(new Employee("john", 20000));
		elist.add(new Employee("scott", 30000));

		Function<Employee, Integer> fn = e -> {
			int sal = e.salary;
			if (sal >= 10000 && sal <= 20000) {
				return (sal * 10 / 100);
			} else if (sal >= 20000 && sal <= 30000) {
				return (sal * 20 / 100);
			} else if (sal >= 30000 && sal <= 40000) {
				return (sal * 30 / 100);
			} else {
				return (sal * 40 / 100);
			}
		};

		Predicate<Integer> predicate = b -> b > 5000;
		for (Employee employee : elist) {
			int bonus = fn.apply(employee);// Function
			if (predicate.test(bonus)) {// Predicate
				System.out.println(employee.ename + "  " + employee.salary);
				System.out.println("Bonus is: " + bonus);

			}
		}

		// Function chaining or joining
		//1-andthen()
		//2-compose()
		
		Function<Integer, Integer> fa=n->n*2;
		Function<Integer, Integer> fb=n->n*n*n;
		System.out.println(fa.andThen(fb).apply(2));
		System.out.println(fa.compose(fb).apply(2));
		
		

	}
}
