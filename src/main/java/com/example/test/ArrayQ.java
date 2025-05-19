package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayQ {
	public static void main(String[] args) {
//		int ar[] = { 2, 4, 8, 9, 3 };
//		int a[] = { 1, 9, 0, 2 };
//		union(ar, a);
//		IntersectionType(ar, a);
//		System.out.println();
//		int a[] = { 1, -1, 3, 2, -7, -5, 11, 6 };
//		moveElement(a);
		int a[] = { 1, 1, 1, 1, 1, 3, 9, 3, 2, 7, 5, 9 };
		frequencyOfElement(a);
	}

	private static void frequencyOfElement(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		System.out.println(map);
	}

	private static void IntersectionType(int[] ar, int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ar.length; i++) {
			set.add(ar[i]);
		}
		List<Integer> list = new ArrayList<>();
		for (int n : a) {
			if (set.contains(n)) {
				list.add(n);
			}
		}
		System.out.println(list);
	}

	public static void union(int[] ar, int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ar.length; i++) {
			set.add(ar[i]);
		}
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		int[] arr = new int[set.size()];
		int j = 0;
		for (int i : set) {
			arr[j] = i;
			j++;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void moveElement(int[] a) {
		int[] arr = new int[a.length];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				arr[j] = a[i];
				j++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				arr[j] = a[i];
				j++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
