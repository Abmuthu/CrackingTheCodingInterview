package com.abmuthu.linked_lists;

/*
	Core concept : Add larger elements to the tail and smaller 
				   elements to the head.
*/

public class Partition {

	// version 1: time: O(n) space: O(n)
	public Node partitionMe(Node node, int pivot) {
		DoubleEndedLinkedList list = new DoubleEndedLinkedList();
		while (node != null) {
			if (node.data < pivot) {
				list.addFromHead(node);
			} else {
				list.addFromTail(node);
			}
			node = node.next;
		}
		return list.head;
	}

	public static void main(String[] args) {
		Node head = null;
		head = createList(head, 3);
		createList(head, 5);
		createList(head, 8);
		createList(head, 5);
		createList(head, 10);
		createList(head, 2);
		createList(head, 1);
		System.out.println("Before manipulating");
		display(head);
		
		head = new Partition().partitionMe(head, 5);
		System.out.println("\n After manipulating");
		display(head);
	}

	public static Node createList(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		} else {
			while(head.next != null) {
				head = head.next;
			}
			Node newNode = new Node(data);
			head.next = newNode;
		}
		return null;
	}

	public static void display(Node head) {
		while(head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}	
	}
}

class DoubleEndedLinkedList{
	Node head;
	Node tail;

	public void addFromHead(Node node) {
		Node copyNode = new Node(node.data);
		if (head == null) {
			head = copyNode;
			tail = head;
		}
		copyNode.next = head;
		head = copyNode;
	}

	public void addFromTail(Node node) {
		Node copyNode = new Node(node.data);
		if (tail == null) {
			tail = copyNode;
			head = tail;
		}
		tail.next = copyNode;
		tail = copyNode;
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}