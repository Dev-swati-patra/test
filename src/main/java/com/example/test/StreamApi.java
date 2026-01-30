package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
		findAllEvenNum();
//		startsWith1();
//		findDuplicate();
//		removeDuplicateInt();
//		firstNonRepeatchar();
//		System.out.println(repeatAtleastTwice());
//		cubeOfElement();
//		convertArrayToStream();
//		convertObjectIntoUppercase();
//		maxInanArray();
//		countEachWord();
//		countOnlyDuplicate();
//		countCharInString();
//		checkListEmptyOrNot();
//		joinListOfString();
//		mergeArray();
//		maxMinFromList();
//		secondLargeInArray();
//		sortStringByLength();
//		sumOfAllDigit();
//		commonElement();
//		averageOfElements();
//		reverseEachWordOfString();
//		stringAnagram();
//		sumOfFirstTenNos();
//		reverseIntArray();
//		StringStartWithNumber();
//		lastElementOfAnArray();
//		stringPalindrome();
//		longestStringInAnArray();
//		removeDuplicateFromString();
//		secondHighestLengthWordInSentence();
//		occuranceOfEachWord();
		wordWithNoOfVowels();

		// 17. How to convert a List of objects into a Map by considering duplicated
		// keys
		// and store them in sorted order?
	}

	private static void wordWithNoOfVowels() {
		String s = "I am learning java api in springboot";
		char[] ar = { 'a', 'e', 'i', 'o', 'u' };
		String[] str = s.split(" ");
		int[] intar = new int[str.length];
		int count = 0;
//		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < str.length; i++) {
			String key = str[i].toLowerCase();
			int k = 0; count = 0;
			for (char c : ar) {
				if (key.contains(c + "")) {
					intar[i] = ++count;
				}
			}
		}
		System.out.println(Arrays.toString(intar));

	}

	private static void occuranceOfEachWord() {
		String s = "I am learning java api in springboot java";
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Long> collect = Arrays.stream(s.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
		// or
		String[] str = s.split(" ");
		for (String string : str) {
			if (map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			} else {
				map.put(string, 1);
			}
		}
		System.out.println(map);
	}

	private static void secondHighestLengthWordInSentence() {
		String s = "I am learning api in springboot";
		String string = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1)
				.findFirst().get();
		// and to find length of it
		Integer length = Arrays.stream(s.split(" ")).map(x -> x.length()).sorted(Comparator.reverseOrder()).skip(1)
				.findFirst().get();
		System.out.println(string + "------" + length);
		// or
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] ar = s.split(" ");
		for (String st : ar) {
			map.put(st, st.length());
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());
		System.out.println(list.get(list.size() - 2).getKey() + "---" + list.get(list.size() - 2).getValue());

	}

	private static void removeDuplicateFromString() {
		String s = "dabcaefg";// output--dabcefg
		Arrays.stream(s.split("")).distinct().forEach(System.out::print);
		// or
		Set<Character> set = new HashSet<>();
		StringBuilder st = new StringBuilder(s);
		for (int i = 0; i < st.length(); i++) {
			if (!set.add(st.charAt(i))) {
				st.deleteCharAt(i);
			}
		}
		System.out.println(st.toString());
	}

	private static void longestStringInAnArray() {
		String[] ar = { "Java", "Stream", "Optional", "Lambda", "Expression" };
		String result = Arrays.stream(ar).max(Comparator.comparingInt(String::length)).get();
		System.out.println(result);
		// or
		String result1 = Arrays.stream(ar).reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
				.orElse(null);
		System.out.println(result1);
	}

	private static void stringPalindrome() {
		String str = "Racecar";// madam
		String lower = str.toLowerCase();
		boolean allMatch = IntStream.range(0, lower.length() / 2)
				.allMatch(i -> lower.charAt(i) == lower.charAt(lower.length() - 1 - i));
		System.out.println(allMatch);
		// or
		String revString = IntStream.range(0, str.length())
				.mapToObj(i -> String.valueOf(str.charAt(str.length() - 1 - i))).collect(Collectors.joining());
		System.out.println(revString.equalsIgnoreCase(str));
	}

	private static void lastElementOfAnArray() {
		String[] arr = { "swati", "smruti", "ishita", "kalyani", "purna" };
		Arrays.stream(arr).skip(arr.length - 1).forEach(System.out::printf);

	}

	// find string which start with number
	private static void StringStartWithNumber() {
		List<String> list = Arrays.asList("1apple", "banana", "3mango", "orange", "42grapes");
		List<String> collect = list.stream().filter(ch -> Character.isDigit(ch.charAt(0))).collect(Collectors.toList());
		System.out.println(collect);

	}

	// reverse an integer array
	private static void reverseIntArray() {
		Integer[] ar = { 1, 2, 3, 4, 5, 6 };
		List<Integer> stt = Arrays.stream(ar).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(stt);
	}

	// sum of first 10 natural numbers
	private static void sumOfFirstTenNos() {
		int sum = IntStream.range(1, 11).sum();
		System.out.println(sum);
	}

	private static void stringAnagram() {
		String st = "sgeek", st1 = "geeks";
		String rev1 = Stream.of(st.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		String rev2 = Stream.of(st1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		System.out.println(rev1.equals(rev2) ? "Anagram" : "Not Anagram");
	}

	private static void reverseEachWordOfString() {
		String st = "Java 8 makes things easier";
		String str = Arrays.stream(st.split(" ")).map(w -> new StringBuilder(w).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println(str);
	}

	// average of all elements of an array or list
	public static void averageOfElements() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		double average1 = list.stream().mapToInt(i -> i).average().getAsDouble();
		System.out.println(average1);
		// OR
		System.out.println();
		Integer[] arr = { 1, 2, 3, 4, 5 };
		double average = Arrays.stream(arr).mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(average);
	}

	// common elements between two arrays
	private static void commonElement() {
		Integer[] arr1 = { 1, 2, 3, 4, 5, 7 };
		Integer[] arr2 = { 5, 6, 7, 8, 9 };
		Set<Integer> set = Arrays.stream(arr2).collect(Collectors.toSet());// Convert arr2 to Set for faster
																			// lookup (O(1))
		Arrays.stream(arr1).filter(set::contains).forEach(n -> System.out.print(n + "-"));
		// or
		System.out.println();
		List<Integer> li1 = Arrays.asList(1, 2, 3, 4, 5, 7);
		List<Integer> li2 = Arrays.asList(5, 6, 7, 8, 9);
		li1.stream().filter(li2::contains).forEach(n -> System.out.print(n + "-"));
	}

	// sum of all digits of a number
	private static void sumOfAllDigit() {
		int num = 1234567;
		int sum = String.valueOf(num).chars() // IntStream of ASCII values
				.map(i -> i - '0') // convert ASCII to digit 0=48,1=49
				.sum();
		System.out.println(sum);
	}

	// sort list of strings in increasing order of their length
	private static void sortStringByLength() {
		List<String> list = Arrays.asList("swati", "smruti", "ishita", "kalyani", "purna");
		List<String> collect = list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println(collect);
	}

	// second largest number in an int array
	private static void secondLargeInArray() {
		int[] arr = { 2, 9, 10, 5, 4 };
		Integer integer = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(integer);
	}

	// Three max and min nos from the list
	private static void maxMinFromList() {
		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> minInt = li.stream().sorted().limit(3).collect(Collectors.toList());
		List<Integer> maxInt = li.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println(maxInt + "---" + minInt);
	}

	// merge two unsorted array into single sorted array
	private static void mergeArray() {
		int[] ar = { 2, 1, 15, 3, 10 };
		int[] arr = { 20, 11, 5, 8 };
		int[] array = IntStream.concat(Arrays.stream(arr), Arrays.stream(ar)).sorted().distinct().toArray();
		System.out.println(Arrays.toString(array));

	}

	// join list of strings with prefix,suffix and delimeter
	private static void joinListOfString() {
		List<String> items = Arrays.asList("Apple", "Banana", "Cherry");
		String collect = items.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(collect);
	}

	// How to check if list is empty using Optional, if not null iterate through the
	// list and print the object?
	private static void checkListEmptyOrNot() {
		List<String> list = Arrays.asList("Java", "Spring", "Hibernate");
		Optional.ofNullable(list).filter(l -> !l.isEmpty()).ifPresent(n -> n.forEach(System.out::print));
	}

	// Write a program to print the count of each character in a String?
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

	// How to find only duplicate elements with its count from the String ArrayList
	// in Java8?
	private static void countOnlyDuplicate() {
		List<String> list = Arrays.asList("AA", "FF", "FF", "WW");
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().filter(n -> n.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	// How to count each element/word from the String ArrayList
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
		// or
		Integer[] ar = { 2, 3, 4, 5, 6, 2, 8, 8 };
		Set<Integer> set1 = new HashSet<Integer>();
		Arrays.stream(ar).filter(n -> !set1.add(n)).forEach(n -> System.out.print(n + " "));
	}

	private static void removeDuplicateInt() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 8);
		list.stream().distinct().forEach(n -> System.out.print(n + ","));
	}

	private static void findMaxElement() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 78, 8);
//		int max = list.stream().max(Comparator.naturalOrder()).get();
		int max = list.stream().max(Integer::compare).get();
		System.out.println(max);
	}

	// sum of all elements of an array or list
	public static void sumOfElements() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 78, 8);
		int sum = list.stream().mapToInt(i -> i).sum();
		System.out.println(sum);
		// OR
		System.out.println();
		Integer[] arr = { 2, 3, 4, 5, 6, 78, 8 };
		int sum1 = Arrays.stream(arr).mapToInt(Integer::intValue).sum();
		System.out.println(sum1);
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
