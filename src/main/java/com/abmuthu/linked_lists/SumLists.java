package com.abmuthu.linked_lists;
/*
	Core concept : 
*/

public class SumLists {

	// version 1: add digit by digit.
	public Node sumV1(Node head1, Node head2) {
		Node head3 = null;
		int carry = 0;
		while(head1 != null && head2 != null) {
			int sum = head1.data + head2.data;
			head3 = carry == 1 ? addNode(head3, (sum + 1)%10) : addNode(head3, (sum)%10);
			carry = sum > 9 ? 1 : 0;
			head1 = head1.next;
			head2 = head2.next;
		}

		while(head1 != null) {
			head3 = addNode(head3, head1.data);
			head1 = head1.next;
		}

		while(head2 != null) {
			head3 = addNode(head3, head2.data);
			head2 = head2.next;
		}
		return head3;
	}

	public Node addNode(Node head, int num) {
		Node tempHead = head;
		if (head == null) {
			head  = new Node(num);
			return head;
		} 
		while(head.next != null) {
			head = head.next;
		}

		Node newNode = new Node(num);
		head.next = newNode;
		return tempHead;
	}

	public static void main(String[] args) {
		
		Node head1 = null;
		head1 = createList(head1, 7);
		createList(head1, 1);
		createList(head1, 6);
		display(head1);

		Node head2 = null;
		head2 = createList(head2, 5);
		createList(head2, 9);
		createList(head2, 2);
		display(head2);

		Node head3 = new SumLists().sumV1(head1, head2);
		display(head3);
		// System.out.println("Sum " + new SumLists().sum(head1, head2));
		

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
		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}