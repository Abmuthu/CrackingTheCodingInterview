package com.abmuthu.linked_lists;

import java.util.Stack;

public class Palindrome {

	// version 1: reverse linked list and compare first half
	public boolean isPalindromeV1(Node head) {
		Node reversedHead = reversedList(head);
		Node slowPointer1 = head;
		Node fastPointer1 = head;
		Node slowPointer2 = reversedHead;


		while (fastPointer1.next != null && fastPointer1.next.next != null) {
			if (slowPointer1.data != slowPointer2.data) {
				return false;
			}
			
			slowPointer1 = slowPointer1.next;
			fastPointer1 = fastPointer1.next.next;
			slowPointer2 = slowPointer2.next;
		}
		return true;
	}

	// version 2: make char array and compare
	public boolean isPalindromeV2(Node head) {
		StringBuilder str = new StringBuilder();

		while(head != null) {
			str.append(head.data);
			head = head.next;
		}

		char ch[] = str.toString().toCharArray();
		int firstPointer = 0;
		int lastPointer = ch.length - 1;

		while (firstPointer <= lastPointer) {
			if (ch[firstPointer] != ch[lastPointer]) {
				return false;
			}
			firstPointer++;
			lastPointer--;
		}
		return true;

	}

	// version 3: put elements till half to stack and compare with remaining elements
	public boolean isPalindromeV3(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;

		Stack<Integer> charStack = new Stack<>();
		while (fastPointer.next != null && fastPointer.next.next != null) {
			charStack.push(slowPointer.data);
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		if (fastPointer.next == null) {
			
		} else {
			charStack.push(slowPointer.data);
		}
		slowPointer = slowPointer.next;

		// compare with last half elements
		while (slowPointer != null) {
			if (charStack.peek() != slowPointer.data) {
				return false;
			}
			charStack.pop();
			slowPointer = slowPointer.next;
		}
		return true;
	}

	// support method for version 1
	public Node reversedList(Node head) {
		Node reversedHead = null;
		while (head != null) {

			Node newNode = new Node(head.data);
			if (reversedHead == null) {
				reversedHead = newNode;
			} else {
				newNode.next = reversedHead;
				reversedHead = newNode;
			}
			head = head.next;	
		}
		return reversedHead;
	}

	public static void main(String[] args) {
		
		Node head = null;
		head = createList(head, 7);
		createList(head, 7);
		createList(head, 1);
		createList(head, 7);
		// createList(head, 8);
		display(head);

		System.out.println(new Palindrome().isPalindromeV3(head));

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