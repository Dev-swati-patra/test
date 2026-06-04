package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamapiPractice {
	@AllArgsConstructor
	@Data
	static class Employee {
		String name;
		String department;
		int salary;
	}

	public static void main(String[] args) {
		// second highest salary of employee
//		removeDuplicate();
//		findDuplicate();
//		findSumusingReduce();
//		maxInList();
//		maxSalary();
//		secondHighestNumber();
//		sortBySalary();
//		findSumOfSalary();
//		groupByDepartment();
//		reverseEachWord();
//		groupElementsByEvenOdd();
//		removeDuplicateEmployee();
//		convertListOfListToList();
//		sortInDecending();
//		concatStringByreduce();
//		findMaxByReduce();
		rough();
	}

	private static void secondHighestNumber() {
		List<Integer> list = Arrays.asList(101, 20, 20, 303, 303, 40, 45, 78, 90, 90);
		list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).limit(1).forEach(System.out::println);
		//or
		Integer intt = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().orElse(null);
		System.out.println(intt);
	}

	private static void rough() {
		List<Integer> list = Arrays.asList(101, 20, 20, 303, 40, 45, 78, 90, 90);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> collect2 = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		list.stream().sorted(Collections.reverseOrder()).skip(1).limit(1).forEach(System.out::println);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String s = "swiss";
		s.chars().mapToObj(c -> (char) c).filter(ch -> s.indexOf(ch) == s.lastIndexOf(ch)).forEach(System.out::println);
		// limit()
		List<Integer> collect = list.stream().sorted(Collections.reverseOrder()).skip(1).limit(1)
				.collect(Collectors.toList());
		System.out.println(collect2);

		List<Employee> employee = List.of(new Employee("swati", "hr", 12), new Employee("sima", "hr", 15),
				new Employee("sima", "developer", 20));
		int sum = employee.stream().map(Employee::getSalary).reduce(0, Integer::sum);
//		Map<String, List<Employee>> collect = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//		System.out.println(sum);

//		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 6, 2, 8);
//		List<Integer> collect = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		list.stream().reduce(0,Integer::sum);
	}

	private static void findMaxByReduce() {
		List<Integer> list = Arrays.asList(10, 20, 5, 40, 25);
		Integer reduce = list.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		System.out.println(reduce);
		int max = list.stream().reduce(Integer::max).orElse(Integer.MIN_VALUE);
		System.out.println(max);
	}

	private static void concatStringByreduce() {
		List<String> list = Arrays.asList("Java", "is", "powerful");
		String reduce = list.stream().reduce("", (a, b) -> a + " " + b);
		System.out.println(reduce);
		String collect = list.stream().collect(Collectors.joining(" "));
		System.out.println(collect);
	}

	private static void findSumOfSalary() {
		List<Employee> employee = List.of(new Employee("swati", "hr", 12), new Employee("sima", "hr", 15),
				new Employee("sima", "developer", 20));
		int saalry = employee.stream().map(Employee::getSalary).reduce(0, Integer::sum);
		System.out.println(saalry);
	}

	private static void sortInDecending() {
		List<Integer> li = List.of(1, 2, 3, 4, 5, 6, 6, 2, 8);
		li.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
	}

	private static void convertListOfListToList() {
		List<List<Integer>> list = List.of(List.of(1, 2, 3, 4, 5, 6, 6, 2, 8), List.of(1, 2, 3, 4));
		List<Integer> collect = list.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void removeDuplicateEmployee() {
		List<Employee> employee = List.of(new Employee("swati", "hr", 12), new Employee("sima", "hr", 15),
				new Employee("sima", "developer", 20));
		// sort by department
		List<Employee> list2 = employee.stream().sorted(Comparator.comparing(Employee::getDepartment)).toList();
		// remove duplicate name
		ArrayList<Employee> arrayList = new ArrayList<>(employee.stream()
				.collect(Collectors.toMap(Employee::getName, e -> e, (exiting, replacement) -> exiting)).values());
		// remove duplicate name by comapring salary keep max salary
		Collection<Employee> values = employee.stream().collect(Collectors.toMap(Employee::getName, e -> e,
				(exit, replace) -> exit.getSalary() > replace.getSalary() ? exit : replace)).values();
		System.out.println(list2);
	}

	private static void findSumusingReduce() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 6, 2, 8);
		Integer int1 = list.stream().reduce(0, (a, b) -> a + b);
		// or
		Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
		System.out.println(reduce.get());
		// or
		list.stream().reduce(0, Integer::sum);
	}

	private static void maxInList() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 6, 2, 8);
		Integer orElse = list.stream().max(Integer::compareTo).orElse(0);
		System.out.println(orElse);
	}

	private static void groupByDepartment() {
		List<Employee> employee = List.of(new Employee("swati", "hr", 12), new Employee("sima", "hr", 15),
				new Employee("sima", "developer", 15));
		Map<String, List<Employee>> collect = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(collect);

	}

	private static void sortBySalary() {
		List<Employee> employee = List.of(new Employee("swati", "puri", 12), new Employee("sima", "puri", 15));
		List<Employee> list = employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
		System.out.println(list);
	}

	private static void maxSalary() {
		List<Employee> employee = List.of(new Employee("swati", "puri", 12), new Employee("sima", "puri", 15));
		Employee employee2 = employee.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(employee2);
	}

	private static void groupElementsByEvenOdd() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(n -> n % 2));
		System.out.println(collect);
	}

	private static void reverseEachWord() {
		String s = "java articles are awesome";
		Arrays.stream(s.split(" ")).map(n -> new StringBuilder(n).reverse().toString()).forEach(System.out::println);
		// or
		StringBuilder sd = null;
		String[] split = s.split(" ");
		for (int i = 0; i < split.length; i++) {
			sd = new StringBuilder(split[i]);
			split[i] = sd.reverse().toString();
		}
		System.out.println(Arrays.toString(split));

	}

	private static void findDuplicate() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 4, 5, 6);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> collect = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		System.out.println(collect);
		// or
		List<Integer> li = new ArrayList<Integer>();
		for (Integer integer : list) {
			if (!set.add(integer)) {
				li.add(integer);
			} else {
				set.add(integer);
			}
		}
		System.out.println(li);

	}

	private static void removeDuplicate() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3);
		list.stream().distinct().forEach(n -> System.out.print(n + " "));
		// or
		Set<Integer> set = new HashSet<Integer>();
		for (Integer integer : list) {
			set.add(integer);
		}
		System.out.println(set);

	}

}
