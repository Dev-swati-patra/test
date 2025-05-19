package com.example.test;


//class Node {
//	Node prev, next;
//	int data;
//
//	Node(int d) {
//		data = d;
//		prev = null;
//		next = null;
//	}
//}

public class DoublyLinkedList {
	Node head;

	// Insert node at the beginning
	void insertAtFirst(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		new_node.prev = null;
		if (head != null) {
			head.prev = new_node;
		}
		head = new_node;
	}

	// Insert node after a given node
	void insertAfter(int prev, int data) {
		Node prNode = head;
		while (prNode != null && prNode.data != prev) {
			prNode = prNode.next;
		}
		Node new_node = new Node(data);
		new_node.next = prNode.next;
		prNode.next = new_node;
		new_node.prev = prNode;
		if (new_node.next != null) {
			new_node.next.prev = new_node;
		}

	}

	// Insert node before a given node
	void insertBefore(int pos, int data) {
		Node prNode = head;
		while (prNode != null && prNode.data != pos) {
			prNode = prNode.next;
		}
		Node new_node = new Node(data);
		new_node.prev = prNode.prev;
		prNode.prev = new_node;
		new_node.next = prNode;

		if (new_node.prev != null) {
			new_node.prev.next = new_node;
		}

	}

	// Insert node at end
	void insertAtEnd(int data) {
		Node new_node = new Node(data);
		if (head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}
		new_node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		new_node.prev = last;
	}

	// delete node
	void deleteNode(Node del) {
		if (head == del) {
			head = del.next;
		}
		if (del.next != null) {
			del.next.prev = del.prev;
		}
		if (del.prev != null) {
			del.prev.next = del.next;
		}
		return;
	}

	// delete by key
	void delete(int key) {
		Node curNode = head, prNode = null;
		if (curNode.data == key) {
			head = curNode.next;
			System.out.println(key + " found and deleted");
			return;
		}
		while (curNode != null && curNode.data != key) {
			prNode = curNode;
			curNode = curNode.next;
		}
		if (curNode == null) {
			System.out.println(key + " not found");
			return;
		}
		if (curNode.next != null) {
			prNode.next = curNode.next;
			curNode.next.prev = prNode;
			System.out.println(key + " found and deleted");

		} else if (curNode.prev != null) {
			prNode.next = curNode.next;
			System.out.println(key + " found and deleted");

		}

	}

	// Reverse nodes
	void reverse() {
		Node curNode = head, temp = null;
		while (curNode != null) {
			temp = curNode.prev;
			curNode.prev = curNode.next;
			curNode.next = temp;
			curNode = curNode.prev;
		}
		// Before changing head, check for the cases like empty list and list with only
		// one node
		if (temp != null) {
			head = temp.prev;
		}
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
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtFirst(6);
		list.insertAtFirst(5);
		list.insertAtFirst(4);
		list.insertAtFirst(3);
		list.insertAtFirst(2);
		list.insertAtFirst(1);
		list.print();
		System.out.println();
		list.insertAfter(6, 8);
		list.print();
		System.out.println();
		list.insertBefore(8, 7);
		list.print();
		System.out.println();
		list.insertAtEnd(9);
		list.print();
		System.out.println();
		list.delete(7);
		list.print();
		System.out.println();
		list.reverse();
		list.print();
	}
}
