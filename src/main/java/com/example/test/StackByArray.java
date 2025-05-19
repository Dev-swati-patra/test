package com.example.test;

import java.util.Stack;

public class StackByArray {
	static final int MAX = 100;
	int a[] = new int[MAX];
	int top = -1;

	void push(int x) {
		if (top >= MAX) {
			System.out.println("stack overflow");
		} else {
			a[++top] = x;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("stack underflow");
			return -1;
		} else {
			int x = a[top--];
			return x;
		}
	}

	void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(a[i] + " ");
		}
	}     

	public static void main(String[] args) {
		String string = "GeeksQuiz", str = "";
		Stack<Character> ch = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			ch.push(string.charAt(i));
		}
		while (!ch.isEmpty()) {
			str += ch.pop();
		}
		System.out.println(str);
		StackByArray stackk = new StackByArray();
		stackk.push(10);
		stackk.push(20);
		stackk.push(30);
		stackk.push(40);
		stackk.print();
		System.out.println("\ndelete element is:" + stackk.pop());
		stackk.print();
		System.out.println();
		StackByArray stackk2 = new StackByArray();
		stackk2.push(10);
		stackk2.push(20);
		stackk2.push(30);
		stackk2.push(40);
		stackk2.print();

	}
}
