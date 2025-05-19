package com.example.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
	int data;
	Node next, prev;

	Node(int d) {
		data = d;
		next = null;
		//for doblyLinkedList
		prev=null;
	}
}

public class SingleLinkedList {
	Node head;

	// Insert node at the beginning
	void insertAtFirst(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	// Insert node at end
	void insertAtEnd(int data) {
		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			return;
		}
		new_node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}

	// Insert node at specific position
	void insertAt(int pos, int data) {
		Node pre_node = head;
		while (pre_node != null && pre_node.data != pos) {
			pre_node = pre_node.next;
		}
		Node new_node = new Node(data);
		new_node.next = pre_node.next;
		pre_node.next = new_node;
	}

	// delete node
	void deleteByKey(int key) {
		Node currNode = head, preNode = null;
		if (currNode.data == key) {
			head = currNode.next;
			System.out.println(key + " found and deleted");
			return;
		}
		while (currNode != null && currNode.data != key) {
			preNode = currNode;
			currNode = currNode.next;
		}
		if (currNode != null) {
			preNode.next = currNode.next;
			System.out.println(key + " found and deleted");

		}
		if (currNode == null) {
			System.out.println(key + " not found");
		}
	}

	// find length
	int findLength() {
		int len = 0;
		Node node = head;
		while (node != null) {
			node = node.next;
			len++;
		}
		return len;
	}

	// swap nodes
	void swapping(int n1, int n2) {
		Node node1 = head, node2 = head, prv1 = null, prv2 = null;
		if (head == null) {
			return;
		}
		if (n1 == n2) {
			return;
		}
		while (node1 != null && node1.data != n1) {
			prv1 = node1;
			node1 = node1.next;
		}
		while (node2 != null && node2.data != n2) {
			prv2 = node2;
			node2 = node2.next;
		}
		if (node1 != null && node2 != null) {
			if (prv1 != null) {
				prv1.next = node2;
			}
			if (prv2 != null) {
				prv2.next = node1;
			}
			Node tempNode = node1.next;
			node1.next = node2.next;
			node2.next = tempNode;

		} else {
			System.out.println("swapping not possible");
		}

	}

	// Reverse nodes
	Node reverseNode() {
		Node currNode = head, prvNode = null, nextNode = null;
		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prvNode;
			prvNode = currNode;
			currNode = nextNode;
		}
		head = prvNode;
		return head;
	}

	// merge two sorted linkedlist
	void merge(Node aNode, Node bNode) {
		List<Integer> ll = new ArrayList<>();
		while (aNode != null) {
			ll.add(aNode.data);
			aNode = aNode.next;
		}
		while (bNode != null) {
			ll.add(bNode.data);
			bNode = bNode.next;
		}
		Collections.sort(ll);
		Node resultNode = new Node(-1);
		Node tempNode = resultNode;
		for (int i = 0; i < ll.size(); i++) {
			resultNode.next = new Node(ll.get(i));
			resultNode = resultNode.next;
		}
		tempNode = tempNode.next;
		while (tempNode != null) {
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
	}

	// Rotate linkedlist from a position
	void rotate(int k) {
		int count = 1;
		Node curNode = head;
		while (count < k && curNode != null) {
			curNode = curNode.next;
			count++;
		}
		if (curNode == null) {
			return;
		}
		Node kthNode = curNode;
		while (curNode.next != null) {
			curNode = curNode.next;
		}
		curNode.next = head;
		head = kthNode.next;
		kthNode.next = null;
	}

	// print the list
	void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtFirst(6);
		list.insertAtFirst(5);
		list.insertAtFirst(3);
		list.insertAtFirst(2);
		list.insertAtFirst(1);
		list.insertAtEnd(7);
		list.insertAt(3, 4);
		list.print();
		System.out.println();
		list.deleteByKey(7);
		list.print();
		System.out.println("\nlength is " + list.findLength());
		list.swapping(5, 8);
		list.print();
		System.out.println();
		list.reverseNode();
		list.print();
		System.out.println();
		// merge two sorted linkedlist
		Node aNode = new Node(5);
		aNode.next = new Node(10);
		aNode.next.next = new Node(15);
		aNode.next.next.next = new Node(40);
		Node bNode = new Node(2);
		bNode.next = new Node(3);
		bNode.next.next = new Node(20);
		list.merge(aNode, bNode);
		System.out.println();
		list.rotate(4);
		list.print();

	}

}
