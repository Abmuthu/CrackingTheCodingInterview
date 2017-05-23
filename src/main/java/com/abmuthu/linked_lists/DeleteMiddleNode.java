package com.abmuthu.linked_lists;

public class DeleteMiddleNode {

	public void deleteMiddle(Node head) {
		Node firstPointer = head;
		Node secondPointer = head;

		while(secondPointer.next != null && secondPointer.next.next != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next.next;
		}

		firstPointer.next = firstPointer.next.next;
	}

	public static void main(String[] args) {
		Node head = null;
		head = createList(head, 7);
		createList(head, 1);
		createList(head, 1);
		createList(head, 2);
		createList(head, 9);
		// createList(head, 1);
		System.out.println("Before removing");
		display(head);
		
		new DeleteMiddleNode().deleteMiddle(head);
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