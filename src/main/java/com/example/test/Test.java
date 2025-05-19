
package com.example.test;

import java.util.Arrays;

class Pair implements Comparable<Pair> {
	String x;
	int y;

	public Pair(String x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int compareTo(Pair a) {
		if (this.x.compareTo(a.x) != 0) {
			return this.x.compareTo(a.x);
		} else {
			return this.y - a.y;
		}
	}
}

public class Test {

	public static void main(String[] args) {

		int n = 4;
		Pair arr[] = new Pair[n];

		arr[0] = new Pair("abc", 3);
		arr[1] = new Pair("a", 4);
		arr[2] = new Pair("bc", 5);
		arr[3] = new Pair("a", 2);

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
//		print(arr);
	}

	public static void print(Pair[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
