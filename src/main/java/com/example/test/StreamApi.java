package com.example.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;

public class StreamApi {
	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(101, 20, 303, 40);
//		List<Integer> list2 = new ArrayList<Integer>();
//		list2 = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//		System.out.println(list2);

//		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n+" "));
//		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

//		List<String> lL = Arrays.asList("swati", "Ishita", "smruti", "kalyani");
//		List<String> list = new ArrayList<String>();
//		list = lL.stream().filter(str -> str.length() > 2 && str.length() < 6).collect(Collectors.toList());

//		List<String> lL = Arrays.asList("swati", "Ishita", "smruti", "kalyani");
//		List<String> lL1 = Arrays.asList("swsf", "kyt", "kuy", "opiyu");
//		List<String> lL2 = Arrays.asList("mnb", "fr", "yt", "uio");
//		List<List<String>> list = Arrays.asList(lL, lL1, lL2);
//		List<String> collect = list.stream().flatMap(n -> n.stream().map(i -> i + "O")).collect(Collectors.toList());
//		System.out.println(collect);

		// distinct()
		List<String> li = Arrays.asList("car", "van", "zip", "bus", "auto", "car", "van", "zip", "bus");
		List<String> collect = li.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
		li.stream().distinct().forEach(n -> System.out.println(n));

		// count()
		List<Integer> list = Arrays.asList(101, 20, 303, 40, 45, 78, 90);
		long count = list.stream().filter(n -> n % 2 == 0).count();
		System.out.println(count);

		long c = li.stream().distinct().count();
		System.out.println(c);

		// limit()
		List<String> stL = li.stream().limit(3).collect(Collectors.toList());
		System.out.println(stL);

		// max()
		int max = list.stream().max((val1, val2) -> {
			return val1.compareTo(val2);
		}).get();
		System.out.println(max);

		// reduce()
		List<String> optList = Arrays.asList("A", "B", "C", "1", "2", "3");
		Optional<String> reduce = optList.stream().reduce((val, combVal) -> {
			return combVal + val;
		});
		System.out.println(reduce.get());

		// sorted
		List<Integer> intList = Arrays.asList(2, 4, 15, 0, 12, 4, 6, 7);
		List<Integer> integers = intList.stream().sorted().collect(Collectors.toList());
		System.out.println(integers);// ascending order
		List<Integer> reverseList = intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//or	List<Integer> reverseList = intList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseList);// decending order

		List<String> strList = Arrays.asList("busy", "work", "home", "tour", "basket", "sister");
		List<String> strL = strList.stream().sorted().collect(Collectors.toList());
		System.out.println(strL);// ascending order
		List<String> revStr = strList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(revStr);

		// anyMatch()
		Set<String> fruits = new HashSet<String>();

		fruits.add("One apple");
		fruits.add("Two apple");
		fruits.add("Three apple");
		fruits.add("Three apple");
		fruits.add("One apple");
		fruits.add("One apple");

		boolean result = fruits.stream().anyMatch(val -> {
			return val.startsWith("One");
		});
		System.out.println(result);

		// allMatch()
		result = fruits.stream().allMatch(val -> {
			return val.startsWith("One");
		});
		System.out.println(result);

		// noneMatch()
		result = fruits.stream().noneMatch(val -> {
			return val.startsWith("One");
		});
		System.out.println(result);

		// findAny()
		List<String> sList = Arrays.asList("not", "One", "two", "three");
		Optional<String> optional = sList.stream().findAny();
		System.out.println(optional.get());

		// findFirst()
		List<String> ssList = Arrays.asList("One", "two", "three");
		Optional<String> opt = ssList.stream().findFirst();
		System.out.println(opt.get());

		// Concatenating Streams
		List<String> animaList = Arrays.asList("Dog", "cat", "Lion");
		List<String> birdList = Arrays.asList("peacock", "crow", "eagle");
		List<String> finalList = Stream.concat(animaList.stream(), birdList.stream()).collect(Collectors.toList());
		for (String string : finalList) {
			System.out.print(string + ",");
		}
		System.out.println();

//		sumOfElements();
//		findMaxElement();
//		findAllEvenNum();
//		startsWith1();
//		findDuplicate();
//		removeDuplicate();
//		firstNonRepeatchar();
//		System.out.println(repeatAtleastTwice());
//		cubeOfElement();
//		convertArrayToStream();
//		convertObjectIntoUppercase();
//		maxInanArray();
//		countEachWord();
//		countOnlyDuplicate();
//		countCharInString();
		// 17. How to convert a List of objects into a Map by considering duplicated
		// keys
		// and store them in sorted order?
		// 20. How to check if list is empty in Java 8 using Optional, if not null
		// iterate through the list and print the object?
	}

	private static void countCharInString() {
		String str = "string data to count each character";
		Map<Character, Long> charCount = str.chars() // returns an IntStream
				.mapToObj(c -> (char) c) // convert int to Character
				.filter(c -> !Character.isWhitespace(c)) // optional: ignore whitespaces
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charCount);
		// or
		Map<String, Long> collect = Arrays.stream(str.split("")).map(String::toLowerCase)
				.filter(s -> !s.trim().isEmpty())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
	}

	private static void countOnlyDuplicate() {
		List<String> list = Arrays.asList("AA", "FF", "FF", "WW");
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().filter(n -> n.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private static void countEachWord() {
		List<String> list = Arrays.asList("AA", "FF", "FF", "WW");
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(collect);
	}

	private static void maxInanArray() {
		int[] ar = { 12, 19, 20, 88, 00, 9 };
		int asInt = Arrays.stream(ar).max().getAsInt();
		System.out.println(asInt);

	}

	private static void convertObjectIntoUppercase() {
		List<Person> list = Arrays.asList(new Person("swati"), new Person("amam"));
		list.stream().map(n -> n.getName().toUpperCase()).forEach(n -> System.out.println(n));
	}

	private static void convertArrayToStream() {
		int[] ar = { 22, 3, 4, 1, 6, 2, 10 };
		Arrays.sort(ar);
		// List<Integer> collect =
		// Arrays.stream(ar).boxed().collect(Collectors.toList());
		Arrays.stream(ar).forEach(n -> System.out.print(n + " "));
	}

	private static void cubeOfElement() {
		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		li.stream().map(i -> i * i * i).filter(n -> n > 50).forEach(System.out::println);

	}

	private static boolean repeatAtleastTwice() {
		int[] nums = { 1, 2, 3, 4, 1 };
		List<Integer> li = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<Integer>(li);
		if (set.size() == li.size()) {
			return false;
		} else {
			return true;
		}

	}

	private static void firstNonRepeatchar() {
		String str = "java articles are awesome";
		Character cc = str.chars().mapToObj(c -> (char) c).filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
				.findFirst().orElse(null);
		System.out.println(cc);
	}

	private static void findDuplicate() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 2, 8, 8);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> collect = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void removeDuplicate() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 8);
		list.stream().distinct().forEach(n -> System.out.print(n + ","));
	}

	private static void findMaxElement() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 78, 8);
//		int max = list.stream().max(Comparator.naturalOrder()).get();
		int max = list.stream().max(Integer::compare).get();
		System.out.println(max);
	}

	public static void sumOfElements() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 78, 8);
		int sum = list.stream().mapToInt(i -> i).sum();
		System.out.println(sum);
	}

	public static void findAllEvenNum() {
		List<Integer> list = Arrays.asList(1, 2, 4, 8, 3, 10);
		List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(collect);

	}

	private static void startsWith1() {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		list.stream().map(n -> n + "").filter(n -> n.startsWith("1")).forEach(s -> System.out.print(s + " "));
	}

}

@Data
class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

}
