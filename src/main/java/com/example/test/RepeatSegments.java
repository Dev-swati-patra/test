package com.example.test;

import java.util.Stack;

public class RepeatSegments {
	public static Object convert(String S) {
		boolean flag = false;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.substring(i, i + 1).equals("C") && flag == false) {
				flag = true;
			} else if (S.substring(i, i + 1).equals("C") && flag == true) {
				flag = false;
			} else if (flag) {
				if (S.substring(i, i + 1).equals("B")) {
					stack.pop();
				} else {
					stack.push(S.substring(i, i + 1).toUpperCase());
				}
			} else if (!flag) {
				if (S.substring(i, i + 1).equals("B")) {
					stack.pop();
				} else {
					stack.push(S.substring(i, i + 1));
				}
			}
		}
		return stack;
	}

	public static void main(String[] args) {
		String S = "CgCoodlBClCuck";
		convert(S);
		System.out.println(convert(S));
	}

}
