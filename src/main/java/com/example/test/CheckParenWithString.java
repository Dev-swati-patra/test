package com.example.test;

import java.util.Stack;

public class CheckParenWithString {

	public static void main(String[] args) {
		checkParenthesis1();
	}

	private static void checkParenthesis1() {
		String s = "{)}";
		Stack<String> stack = new Stack<String>();
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("(") || s.substring(i, i + 1).equals("{")) {
				stack.push(s.substring(i, i + 1));
				str.append(s.substring(i, i + 1));
			} else if (!stack.isEmpty() && (s.substring(i, i + 1).equals(")") || s.substring(i, i + 1).equals("}"))) {
				if (s.substring(i, i + 1).equals(")")) {
					for (int k = stack.size(); k > 0; k--) {
						String string = stack.peek();
						if (string.equals("(")) {
							str.append(")");
							stack.pop();
							break;
						} else {
							str.append("}");
							stack.pop();
						}
					}
				} else if (s.substring(i, i + 1).equals("}")) {
					for (int k = stack.size(); k >= 0; k--) {
						String string = stack.peek();
						if (string.equals("{")) {
							str.append("}");
							stack.pop();
							break;
						} else {
							str.append(")");
							stack.pop();
						}
					}
				}
			} else if (stack.isEmpty() && (s.substring(i, i + 1).equals(")") || s.substring(i, i + 1).equals("}"))) {
				if (s.substring(i, i + 1).equals(")")) {
					str.append("(");
					str.append(")");
				} else if (s.substring(i, i + 1).equals("}")) {
					str.append("{");
					str.append("}");
				}
			} else {
				str.append(s.substring(i, i + 1));
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek().equals("(")) {
				str.append(")");
				stack.pop();
			} else if (stack.peek().equals("{")) {
				str.append("}");
				stack.pop();
			}
		}
		System.out.println(s + "------------" + str.toString());
	}

}
