package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamapiPractice {
	public static void main(String[] args) {
		// second highest salary of employee
//		removeDuplicate();
//		findDuplicate();
//		reverseEachWord();
//		rough();
	}
	private static void rough() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
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
