package com.example.test;

public class TestException {
	public static void main(String[] args) {
		int eHandling = eHandling();
		System.out.println(eHandling);
	}

	public static int eHandling() {
		try {
			int i = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
			return -1;
		}
		finally {
			System.out.println("eryuhfbvhdgb");
			return 2;
		}
		//return 0;
	}

}
