package com.example.test;

public class Recursion {
	static int sum(int n) {
		if (n > 0) {
			return n + sum(n - 1);
		}
		return 0;

	}

	static int variableSum(int strt, int end) {
		if (end > strt) {
			return end + variableSum(strt, end - 1);
		} else {
			return strt;
		}
	}

	static int fact(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * fact(n - 1);
	}

	static int n1 = 0, n2 = 1, n3 = 0;

	static void fibo(int n) {
		if (n > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			fibo(n - 1);
		}
	}

	static int palindrome(int n) {
		int rev = 0;
		int m = n;
		while (n > 0) {
			int r = n % 10;
			rev = rev * 10 + r;
			n /= 10;
			palindrome(n);
		}
		if (rev == m)
			return rev;
		else {
			return 0;
		}

	}

	static String reverseString(String s) {
		int n = s.length();
		if (n == 1) {
			return s.substring(0, 1);
		} else {

			return s.charAt(n - 1) + reverseString(s.substring(0, n - 1));
		}
	}

	static int minArray(int[] a, int i, int n) {
		return (n == 1) ? a[i] : Math.min(a[i], minArray(a, i + 1, n - 1));
	}

	public static void main(String[] args) {
		System.out.println(sum(10));
		System.out.println(variableSum(5, 10));
		System.out.println(fact(6));

		System.out.print(n1 + " " + n2);
		int n = 10;
		fibo(n - 2);

		System.out.println();

		System.out.println(palindrome(0));

		String s = "swati";
		System.out.println(reverseString(s));
		int a[] = { 2, 4, 8, 9, 1, 0 };
		int x = a.length;
		System.out.println(minArray(a, 0, x));

	}

}
