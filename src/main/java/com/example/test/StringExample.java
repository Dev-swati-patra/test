package com.example.test;

import java.security.Identity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringExample {
//	public static void main(String[] args) {
//		String s = "aa2b3c4", str = "";
//		for (int j = 0; j < s.length(); j++) {
//			if (Character.isAlphabetic(s.charAt(j))) {
//				str += s.substring(j, j + 1);
//			} else {
//				int k = Integer.parseInt(s.substring(j, j + 1));
//				for (int i = 0; i < k; i++) {
//					str += s.substring(j - 1, j);
//
//				}
//			}
//		}
//		System.out.println(str);
//
//	}
//	public static void main(String[] args) {
//		String s = "Hello @123 World", str = "swati";
//		StringBuilder dig = new StringBuilder(), st = new StringBuilder();
//		for (int i = 0; i < s.length(); i++) {
//			if (!Character.isAlphabetic(s.charAt(i))) {
//				dig.append(s.substring(i, i + 1));
//			} else {
//				st.append(s.substring(i, i + 1).toLowerCase()); 
//			}
//
//		}
//		for (int i = 0; i < str.length(); i++) {
//			if (!Character.isAlphabetic(str.charAt(i))) {
//				dig.append(str.substring(i, i + 1));
//			} else {
//				st.append(str.substring(i, i + 1).toLowerCase());
//			}
//
//		}
//		System.out.println(dig.append(st).toString());
//
//	}
//	public static void main(String[] args) {
//		int[] ar = { 1, 3, 4, 7, 5, 9 };
//		int[] arr = { 1, 3, 4, 2 };// 2,5,7,9
//		Set<Integer> set = new HashSet<>();
//		for (int i = 0; i < ar.length; i++) {
//			set.add(ar[i]);
//		}
//		List<Integer> list = new ArrayList<>();
//		for (int n : arr) {
//			if (set.contains(n)) {
//				list.add(n);
//			}
//		}

//	}
	public static void main(String[] args) {
//		System.out.println(commonSubString());
//		romanToDigit();
//		checkSubsequence();
//		productExceptSelf();
		// summaryRange();
		// sumUptoTarget();
//		 squareOfSortedArray();
		// jwelsAndStones();
		// System.out.println(ranSumNotes());
//		groupAnagrams();
//		reverseString();
//		checkPalindrome();
//		checkOccuranceChar();
//		findDuplicateElement();
//		secondLargestNumber();
//		findMissingNumInArray();
//		intersectionOfArray();
//		mergeTwoArray();
//		lengthOflongSubStringwithoutRepeating();
//		kthLargestElementInArray();
//		kthSmallestElementInArray();
//		largest3digitOddN();
//		sortHashmapByvalue();
//		reverseLinkedList();

	}


	private static void reverseLinkedList() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(23);
		list.add(43);
		list.add(25);
		list.add(67);
		Collections.reverse(list);
		System.out.println(list);

	}

	private static void sortHashmapByvalue() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 30);
		map.put("B", 50);
		map.put("C", 20);

		// Convert map entries to List
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());// ascending order
//		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));//decending order

		// Put into LinkedHashMap to maintain order
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(sortedMap);
		// or---------------------------------------------------------------------java 8
		// Collectors.toMap takes four arguments: key mapper, value mapper, merge
		// function to handle duplicate keys,
		// and a map supplier to specify the map type.
		Map<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		// or
//		Map<String, Integer> collect1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
//				Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, () -> new LinkedHashMap<>()));
		System.out.println(collect);

	}

	private static void largest3digitOddN() {
		String str = "30112113";
		int lar = -1;
//		for (int i = 0; i <= str.length() - 3; i++) {
//			int s = Integer.parseInt(str.substring(i, i + 3));
//			if (s % 2 != 0) {
////				lar = s > lar ? s : lar;
//				lar = Math.max(lar, s);
//			}
//		}
		// or without using substring
		for (int i = 0; i <= str.length() - 3; i++) {
			int d1 = str.charAt(i) - '0';
			int d2 = str.charAt(i + 1) - '0';
			int d3 = str.charAt(i + 2) - '0';

			int num = d1 * 100 + d2 * 10 + d3;
			if (num % 2 != 0) {
				lar = Math.max(lar, num);
			}
		}
		System.out.println(lar);
	}

	private static void kthSmallestElementInArray() {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 3;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (Integer num : nums) {
			maxHeap.offer(num);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		System.out.println(maxHeap.peek());
	}

	private static void kthLargestElementInArray() {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (Integer num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		System.out.println(minHeap.peek());
	}

	private static void lengthOflongSubStringwithoutRepeating() {
		String s = "pwwkew";// "abcddef"
//		int maxL = 0, left = 0;
//		Set<Character> set = new HashSet<Character>();
//		for (int right = 0; right < s.length(); right++) {
//			while (set.contains(s.charAt(right))) {
//				set.remove(s.charAt(left));
//				left++;
//			}
//			set.add(s.charAt(right));
//			maxL = Math.max(maxL, right - left + 1);
//		}
//		System.out.println(maxL);
		// or
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, max = 0;

		for (int right = 0; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}

			map.put(s.charAt(right), right);
			max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}

	private static void mergeTwoArray() {
		int a[] = { 1, 2, 3, 4 };
		int ar[] = { 5, 6, 8, 7 };
		int arr[] = new int[a.length + ar.length];
//		System.arraycopy(ar, 0, arr, 0, ar.length);
//		System.arraycopy(a, 0, arr, ar.length, a.length);
//		System.out.println(Arrays.toString(arr));

		// or (using two pointer technique)
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < ar.length) {
			if (a[i] <= ar[j]) {
				arr[k++] = a[i++];
			} else {
				arr[k++] = ar[j++];
			}
		}
		while (i < a.length) {
			arr[k++] = a[i++];
		}
		while (j < ar.length) {
			arr[k++] = ar[j++];
		}

		System.out.println(Arrays.toString(arr));
	}

	private static void intersectionOfArray() {
		int a[] = { 1, 2, 3, 4, 4 };
		int ar[] = { 5, 6, 4, 4, 7 };
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> result = new HashSet<Integer>();
		for (int integer : a) {
			set.add(integer);
		}
		for (int integer : ar) {
			if (set.contains(integer)) {
				result.add(integer);
			}
		}
		System.out.println(result);

	}

	private static void findMissingNumInArray() {
		int a[] = { 1, 2, 3, 5, 6, 7 };
//		Arrays.sort(a);
//		int last=a[a.length-1];
//		int sum=last*(last+1)/2,digitSum=0;
//		for (int i = 0; i < a.length; i++) {
//			 digitSum += a[i];
//		}
//		System.out.println(sum-digitSum);
		// or using xor
		int n = a[a.length - 1];
		int xor = 0;
		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}
		for (int i : a) {
			xor ^= i;
		}
		System.out.println(xor);

	}

	private static void secondLargestNumber() {
		int a[] = { 12, 35, 1, 10, 34, 1 };
		Arrays.sort(a);
		System.out.println(a[a.length - 2]);
		// or
		int larg = Integer.MIN_VALUE;
		int secondLarg = Integer.MIN_VALUE;
		for (int num : a) {
			if (num > larg) {
				secondLarg = larg;
				larg = num;
			} else if (num > secondLarg && num != larg) {
				secondLarg = num;
			}
		}
		System.out.println(secondLarg + " " + larg);
	}

	private static void findDuplicateElement() {
		String s = "latitudeName";
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!set.add(c)) {
				System.out.println(c);
			}
		}
		// or
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		}
		// or
		s.chars().mapToObj(c -> (char) c).filter(n -> !set.add(n)).forEach(n -> System.out.print(n + " "));

		// or

		s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println(e.getKey()));
		// or
		s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> {
					if (v > 1)
						System.out.print(k);
				});
	}

	private static void checkOccuranceChar() {
		String s = "madam";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		for (int i = 0; i < s.length(); i++) {
//
//			if (map.containsKey(s.charAt(i))) {
//				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//			} else {
//				map.put(s.charAt(i), 1);
//			}
//		}
//		System.out.println(map);
		// or
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
		// or
		s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().forEach(n -> System.out.print(n + ","));

	}

	private static void checkPalindrome() {
		String s = "madam";
		boolean ispalin = true;
		String rev = new StringBuilder(s).reverse().toString();
		System.out.println(s.equals(rev));
		// or
		int i = 0, j = s.length() - 1;
		while (i < j) {
			String sleft = s.charAt(i) + "";
			String sright = s.charAt(j) + "";

			if (!sleft.equalsIgnoreCase(sright)) {
				ispalin = false;
				break;
			}
			i++;
			j--;
		}
		System.out.println(ispalin);
	}

	private static void reverseString() {
		String s = "RAW PASSWORD";
		String str = new StringBuilder(s).reverse().toString();
		// or
		for (int i = s.length() - 1; i >= 0; i--) {
			str += s.charAt(i) + "";

		}
		System.out.println(str);
	}

	private static void groupAnagrams() {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
//		List<String> li1 = new ArrayList<String>(Arrays.asList(input));
//		List<String> li2 = new ArrayList<String>(Arrays.asList(input));
//		Set<Set<String>> liL = new HashSet<Set<String>>();
//		Set<String> set = null;
//		for (int i = 0; i < li1.size(); i++) {
//			if (li2.contains(li1.get(i))) {
//				set = new HashSet<String>();
//				set.add(li1.get(i));
//				for (int j = i + 1; j <= li1.size() - 1; j++) {
//					boolean bool = toCompare(li1.get(i), li1.get(j));
//					if (bool) {
//						set.add(li1.get(j));
//						li2.remove(li1.get(j));
//					}
//
//				}
//				liL.add(set);
//			}
//		}
//		System.out.println(liL);

		// or------------

		Map<String, List<String>> map = new HashMap<>();
		for (String word : input) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sortedKey = new String(chars);

			// Group by sorted key
			map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(word);
		}

		// Get only the groups
		List<List<String>> groupedAnagrams = new ArrayList<>(map.values());

		System.out.println(groupedAnagrams);
	}

	private static boolean toCompare(String string, String string2) {
		char[] charArray1 = string.toCharArray();
		char[] charArray2 = string2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		return String.valueOf(charArray1).equals(String.valueOf(charArray2));

	}

	private static boolean ranSumNotes() {
		String ransum = "aab", magazine = "acab";
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			if (map.containsKey(magazine.substring(i, i + 1))) {
				map.put(magazine.substring(i, i + 1), map.get(magazine.substring(i, i + 1)) + 1);
			} else {
				map.put(magazine.substring(i, i + 1), 1);
			}
		}
		for (int i = 0; i < ransum.length(); i++) {
			if (map.containsKey(ransum.substring(i, i + 1))) {
				if (map.get(ransum.substring(i, i + 1)) > 0) {
					map.put(ransum.substring(i, i + 1), map.get(ransum.substring(i, i + 1)) - 1);
				} else {
					return false;
				}

			} else {
				return false;
			}
		}
		return true;

	}

	private static void jwelsAndStones() {
		String str = "Abbacc", jwel = "ccdc";
		int count = 0;
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < jwel.length(); i++) {
			set.add(jwel.substring(i, i + 1));
		}
		for (int i = 0; i < str.length(); i++) {
			if (jwel.contains(str.substring(i, i + 1))) {
				count++;
			}
		}
		System.out.println(count);

	}

	private static void squareOfSortedArray() {
		int[] ar = { -4, -1, 0, 3, 10 }, arr = new int[ar.length];
		int left = 0, right = ar.length - 1, index = ar.length - 1;

		while (left <= right) {
			int leftSquare = ar[left] * ar[left];
			int rightSquare = ar[right] * ar[right];

			if (leftSquare > rightSquare) {
				arr[index] = leftSquare;
				left++;
			} else {
				arr[index] = rightSquare;
				right--;
			}
			index--;
		}
		for (int i : arr) {
			System.out.println(i);
		}

	}

	private static void sumUptoTarget() {
		int[] ar = { 3, 0, 3 };
		int tar = 6, startIdx = -1, lastIdx = -1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			map.put(ar[i], i);
		}
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] < tar) {
				int temp = tar - ar[i];
				if (map.containsKey(temp)) {
					startIdx = i;
					lastIdx = map.get(temp);
					break;
				}
			}
		}
		System.out.println(startIdx + "--" + lastIdx);
	}
//OR------
//private static void sumUptoTarget() {
//  int[] ar = { 3,0,3 };
//  int tar = 6, startIdx = -1, lastIdx = -1;
//  for (int i = 0; i < ar.length; i++) {
//      if (ar[i] < tar) {
//          int temp = tar - ar[i];
//          for (int j = i + 1; j < ar.length; j++) {
//              if (temp == ar[j]) {
//                  startIdx = i;
//                  lastIdx = j;
//              }
//          }
//      }
//  }
//  System.out.println(startIdx + "--" + lastIdx);
//}

	private static void summaryRange() {
		int[] ar = { 1, 2, 3, 5, 7, 9 };// output=1->3,5,7,9
		List<String> list = new ArrayList<String>();
//  int i = 0;
		for (int i = 0; i < ar.length; i++) {
			int start = ar[i];
			while (i < ar.length - 1 && ar[i + 1] - ar[i] == 1) {
				i++;
			}
			if (start != ar[i]) {
				list.add(start + "->" + ar[i]);
			} else {
				list.add(ar[i] + "");
			}

		}
		System.out.println(list);
	}

	private static void productExceptSelf() {
		int[] ar = { 1, 3, 2, 5, 4 };
		int prod = 1;
		for (int i : ar) {
			prod *= i;
		}
		int[] arr = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			arr[i] = prod / ar[i];
		}
		for (int i : arr) {
			System.out.print(i + " ");
			;
		}
	}

	public static String commonSubString() {
		String arr[] = { "abcmklop", "abvmklop" };
		int n = arr.length;

		String s = arr[0];
		int len = s.length();

		String res = "";

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {

				String stem = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++) {

					if (!arr[k].contains(stem))
						break;
				}
				if (k == n && res.length() < stem.length())
					res = stem;
			}
		}

		return res;
	}

	private static void checkSubsequence() {
		String s1 = "", s2 = "wqefgyqw";
		boolean bool = false;
		if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
			bool = false;
		}
		int i = 0, j = 0;
		while (i < s2.length()) {
			if (s1.length() > j && s2.substring(i, i + 1).equals(s1.substring(j, j + 1))) {
				j++;
				i++;
			} else {
				i++;
			}
		}
		if (s1.length() == j) {
			bool = true;
		}

		System.out.println(bool);

	}

	private static void romanToDigit() {
		String s = "MDCCCLXXIX";
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int sum = 0, n = 0;
		if (s.length() == 1) {
			sum += map.get(s.charAt(0));
			System.out.println(sum);
			return;
		}
		int i = 0;
		for (i = 0; i < s.length() - 1; i++) {
			if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				n = map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
				sum += n;
				i++;
			} else {
				sum += map.get(s.charAt(i));
			}
		}
		if (i != s.length()) {
			sum += map.get(s.charAt(i));
		}
		System.out.println(sum);
	}

}
