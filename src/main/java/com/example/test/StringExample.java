package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		// squareOfSortedArray();
		// jwelsAndStones();
		// System.out.println(ranSumNotes());

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
