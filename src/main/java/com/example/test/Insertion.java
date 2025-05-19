package com.example.test;

import java.util.Scanner;

public class Insertion {
	public static void insertionSort(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[i] > ar[j]) {
					int t = ar[i];
					ar[i] = ar[j];
					ar[j] = t;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ar[] = new int[5];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
		insertionSort(ar);
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}
}
