package com.abmuthu.trees_and_graphs;

import java.util.LinkedList;

public class CheckBalanced {

	public static boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}

		return (Math.abs(height(root.left) - height(root.right)) <= 1) 
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	public static int height(Node root) {
		if (root == null) {
			return -1;
		}

		return max(height(root.left), height(root.right)) + 1;
	}

	public static int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	public static void main(String[] args) {
		Node root = null;
		root = addNode(root, 7);
		addNode(root, 5);
		addNode(root, 9);
		addNode(root, 11);
		// addNode(root, 16);
		// addNode(root, 8);
		// addNode(root, 10);
		printLevelByLevel(root);
		System.out.println("is Balanced: " + isBalanced(root));


	}

	public static void printLevelByLevel(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();

			while (size > 0) {
				Node node = queue.remove();
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
				System.out.print(node.data + " ");
				size--;
			}
			System.out.println();
		}
	}

	public static Node addNode(Node root, int num) {
		if (root == null) {
			root = new Node(num);
			return root;
		}

		if (num < root.data) {
			root.left = addNode(root.left, num);
		} else {
			root.right = addNode(root.right, num);
		}

		return root;
	}
}