package com.example.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackPrblm {
	static int precedence(char c) {
		if (c == '+' || c == '–') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		} else if (c == '^') {
			return 3;
		} else {
			return -1;
		}
	}

	// Infix To Postfix
	static String infixToPostfix(String s) {
		StringBuffer str = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				str.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					str.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && (precedence(c) <= precedence(stack.peek()))) {
					str.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			str.append(stack.pop());
		}
		return str.toString();

	}

	// Infix To Prefix
	static String infixToPrefix(String s) {
		String string = reverse(s);
		StringBuilder revs = new StringBuilder(string);
		System.out.println(string);
		for (int i = 0; i < revs.length(); i++) {
			if (revs.charAt(i) == '(') {
				revs.setCharAt(i, ')');
			} else if (revs.charAt(i) == ')') {
				revs.setCharAt(i, '(');
			}
		}
		System.out.println(revs);
		String str = infixToPostfix(revs.toString());
		System.out.println(str);
		String ss = reverse(str);

		return ss;
	}

	static String reverse(String s) {
		String str = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			str += s.charAt(i) + "";
		}
		return str;
	}

	// Prefix To Postfix
	static String preToPostfix(String str) {
		Stack<String> stack = new Stack<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				String op1 = stack.peek();
				stack.pop();
				String op2 = stack.peek();
				stack.pop();
				String result = op1 + op2 + c;
				stack.push(result);

			} else {
				stack.push(c + "");
			}
		}
		return stack.peek();
	}

	// Prefix To Infix
	static String preToInfix(String str) {
		Stack<String> stack = new Stack<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%') {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String result = "(" + op1 + c + op2 + ")";
				stack.push(result);

			} else {
				stack.push(c + "");
			}
		}
		return stack.pop();
	}

	// Postfix To Prefix
	static String PostToPrefix(String str) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String result = c + op2 + op1;
				stack.push(result);

			} else {
				stack.push(c + "");
			}

		}
		return stack.peek();
	}

	//Postfix To Infix
	static String PostToInfix(String str) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String result = "(" + op2 + c + op1 + ")";
				stack.push(result);

			} else {
				stack.push(c + "");
			}
		}
		return stack.peek();
	}

	//Reverse a string using stack
	static String reverseUsingStack(String s) {
		StringBuilder str = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		while (!stack.isEmpty()) {
			str.append(stack.pop());
		}
		return str.toString();
	}

	// check for balanced parenthesis
	static boolean balanceParenthesis(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char ch;
			switch (c) {
			case ')':
				ch = stack.pop();
				if (ch == '}' || ch == ']')
					return false;
				break;

			case '}':
				ch = stack.pop();
				if (ch == ')' || ch == ']')
					return false;
				break;
			case ']':
				ch = stack.pop();
				if (ch == '}' || ch == ')')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}

	static void nextGreaterelement(int[] a) {
		int next;
		for (int i = 0; i < a.length; i++) {
			next = -1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					next = a[j];
					break;
				}
			}
			System.out.println(a[i] + "-->" + next);

		}
	}

	public static void main(String[] args) {
		String s = "((A+B)–C*(D/E))+F", str = "*+P/QR-/STU", ss = "ab*c+", sp = "[]()";
		int a[] = { 4, 2, 5, 9};
		System.out.println("infixToPostfix: " + infixToPostfix(s));
		System.out.println("infixToPrefix: " + infixToPrefix(s));
		System.out.println("preToPostfix: " + preToPostfix(str));
		System.out.println("preToInfix: " + preToInfix(str));
		System.out.println("PostToPrefix: " + PostToPrefix(ss));
		System.out.println("PostToInfix: " + PostToInfix(ss));
		System.out.println("Reverse string is: " + reverseUsingStack(ss));
		System.out.println(balanceParenthesis(sp));
		nextGreaterelement(a);
	}

}
