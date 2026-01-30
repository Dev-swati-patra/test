package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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
		findDuplicateElement();

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
