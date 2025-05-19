package com.example.test;

import java.io.IOException;
import java.util.Stack;

public class StackByLinklist {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		System.out.println(data + " data pushed to stack");
	}

	int pop() {
		int ele = Integer.MIN_VALUE;
		if (head == null) {
			System.out.println("stack is empty");
			
		} else {
			ele = head.data;
			head = head.next;
		}
		return ele;
	}

	int peek() {
		if (head == null) {
			return Integer.MIN_VALUE;
		} else {
			return head.data;
		}
	}

	void display() {
		Node root = head;
		if (head == null) {
			System.out.println("stack underflow");
		} else {
			while (root != null) {
				System.out.print(root.data + " ");
				root = root.next;
			}
		}
	}

	public static void main(String[] args) {
		StackByLinklist linklist = new StackByLinklist();
		System.out.println("stack is empty: " + linklist.isEmpty());
		linklist.push(10);
		linklist.push(20);
		linklist.push(30);
		linklist.push(40);
		linklist.display();
		System.out.println("\nstack is empty: " + linklist.isEmpty());
		System.out.println(linklist.pop());
		System.out.println("peek element is: " + linklist.peek());
		linklist.display();
	}

}

//Evaluation of Postfix Expression using Stack:
class evaluatePostfix {
	int evaluate(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			} else {
				int n1 = stack.pop();
				int n2 = stack.pop();
				switch (c) {
				case '+':
					stack.push(n2 + n1);
					break;
				case '/':
					stack.push(n2 / n1);
					break;
				case '-':
					stack.push(n2 - n1);
					break;
				case '*':
					stack.push(n2 * n1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) throws IOException {
		String s = "231*+9-";
		System.out.println(new evaluatePostfix().evaluate(s));
		
	}
}
