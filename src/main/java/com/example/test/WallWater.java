package com.example.test;

public class WallWater {
	public static void main(String args[]) {
		int a[] = { 2, 0, 10, 0, 5, 2, 7, 0, 10, 2 };
		int left = 0, right = a.length - 1, leftMax = 0, rightMax = 0, water = 0;

		while (left < right) {
			if (a[left] < a[right]) {
				if (a[left] >= leftMax)
					leftMax = a[left];
				else
					water += leftMax - a[left];
				left++;

			} else {
				if (a[right] >= rightMax)
					rightMax = a[right];
				else
					water += rightMax - a[right];
				right--;
			}

		}
		System.out.println(water);
	}

}
