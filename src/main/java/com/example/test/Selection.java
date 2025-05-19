package com.example.test;

public class Selection {
	public static void main(String[] args) {
		int[] ar= {12,5,11,87,4,1,90};
		sort(ar);
		for (int i : ar) {
			System.out.print(i+" ");
		}
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min_idx]) {
					min_idx = j;
				}
			}
			int temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}

	}

}
