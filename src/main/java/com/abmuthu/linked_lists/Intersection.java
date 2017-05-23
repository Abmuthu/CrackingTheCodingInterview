package com.abmuthu.linked_lists;

/*
 	Core concept: Check last node reference, pad smaller list with zero and
 				  traverse together to find intersecting node.
*/

public class Intersection {

	// version 1: time: O(m + n) space: O(1)
	public Node isIntersecting(Node head1, Node head2) {
		int length1 = 0;
		int length2 = 0;
		Node tempHead1 = head1;
		Node tempHead2 = head2;

		while (tempHead1.next != null) {
			length1++;
			tempHead1 = tempHead1.next;
		}
		length1++;

		while (tempHead2.next != null) {
			length2++;
			tempHead2 = tempHead2.next;
		}
		length2++;

		if (tempHead1 != tempHead2) {
			return null;
		}

		if (length1 < length2) {
			// pad list 1 with 0's
			for (int i = 0; i < (length2 - length1); i++) {
				Node padNode = new Node(0);
				padNode.next = head1;
				head1 = padNode;
			}
		}

		if (length2 < length1) {
			// pad list 2 with 0's
			for (int i = 0; i < (length1 - length2); i++) {
				Node padNode = new Node(0);
				padNode.next = head2;
				head2 = padNode;
			}
		}

		while (head1 != null) {
			if (head1 == head2) {
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}

		return null;
	}

	public static void main(String[] args) {
		
		Node head1 = null;
		head1 = createList(head1, 7);
		createList(head1, 1);
		createList(head1, 2);
		
		Node head2 = null;
		head2 = createList(head2, 7);
		createList(head2, 1);

		Node head3 = null;
		head3 = createList(head3, 10);
		createList(head3, 11);
		createList(head3, 12);

		Node tempHead1 = head1;
		while(tempHead1.next != null) {
			tempHead1 = tempHead1.next;
		}
		tempHead1.next = head3;

		Node tempHead2 = head2;
		while(tempHead2.next != null) {
			tempHead2 = tempHead2.next;
		}	
		tempHead2.next = head3;

		Node intersectingNode = new Intersection().isIntersecting(head1, head2);

		System.out.println("result" + intersectingNode);

	}

	public static Node createList(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			System.out.println(data + "" + head);
			return head;
		} else {
			while(head.next != null) {
				head = head.next;
			}
			Node newNode = new Node(data);
			System.out.println(data + "" + newNode);
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