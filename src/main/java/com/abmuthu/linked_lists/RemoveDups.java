package com.abmuthu.linked_lists;

import java.util.Set;
import java.util.HashSet;

/*
	Core concept: Remember the items visited in the past. 
*/

public class RemoveDups {

	// version 1: using HashSet. time: O(n) space:O(n)
	public Node removeDupsV1(Node head) {
		Node currentNode = head;
		Set<Integer> mySet = new HashSet<>();
		mySet.add(currentNode.data);
		while(head.next != null) {
			if (mySet.contains(head.next.data)) {
				head.next = head.next.next;
			} else {
				head = head.next;
				mySet.add(head.data);
			}
		}
		return currentNode;
	} 

	// version 2: using two pointers or 2nd loop. time: O(n^2) space: O(1) 
	public Node removeDupsV2(Node head) {
		Node tempNode = head; // firstPointer
		Node secondPointer = null;
		while(head.next != null) {
			secondPointer = head;
			while(secondPointer.next != null) {
				if (secondPointer.next.data == head.data) {
					secondPointer.next = secondPointer.next.next;
				} else {
					secondPointer = secondPointer.next;
				}
			}
			head = head.next;
		}
		return tempNode;
	}		

	public static void main(String[] args) {
		
		Node head = null;
		head = createList(head, 7);
		createList(head, 1);
		createList(head, 1);
		createList(head, 2);
		createList(head, 9);
		createList(head, 1);
		System.out.println("Before removing");
		display(head);
		
		head = new RemoveDups().removeDupsV2(head);
		System.out.println("\n After removing");
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

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}