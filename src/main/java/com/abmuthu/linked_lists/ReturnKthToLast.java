package com.abmuthu.linked_lists;

public class ReturnKthToLast {

	// asking next guy to tell my index. time: O(n)  space: O(n)
	public int giveMyIndex(Node head, int k) {
		if (head == null) {
			return 0;
		} 
		int index = giveMyIndex(head.next, k) + 1;
		if (index == k) {
			System.out.println(head.data);
		}
		return index;
	}

	// using two pointers. time: O(n) 
	public Node kThElementFromLast(Node head, int k) {
		Node leftPointer = head;
		Node tempNode = head;
		for (int i = 0; i < k - 1; i++) {
			tempNode = tempNode.next;
		}
		Node rightPointer = tempNode;
		while (rightPointer.next != null) {
			leftPointer = leftPointer.next;
			rightPointer = rightPointer.next;
		} 
		return leftPointer;
		// place the right pointer in the correct place
	}


	public static void main(String[] args) {
		Node head = null;
		head = createList(head, 7);
		createList(head, 1);
		createList(head, 1);
		createList(head, 2);
		createList(head, 9);
		createList(head, 1);
		// Node kThEle = new ReturnKthToLast().giveMyIndex(head, 2);
		System.out.println(new ReturnKthToLast().kThElementFromLast(head, 2).data);
		
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

}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}