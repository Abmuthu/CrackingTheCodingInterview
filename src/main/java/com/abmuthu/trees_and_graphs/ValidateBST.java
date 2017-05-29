package com.abmuthu.trees_and_graphs;

import java.util.LinkedList;

public class ValidateBST {

	public static boolean isBST(Node root) {
		if (root == null) {
			return true;
		}

		return (root.left == null || findMax(root.left) <= root.data) && (root.right == null || findMin(root.right) > root.data)
				&& isBST(root.left) && isBST(root.right); 
	}

	public static boolean isBSTOptimal(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		return (root.data > min) && (root.data <= max) 
				&& isBSTOptimal(root.left, min, root.data) && isBSTOptimal(root.right, root.data, max);
	}

	public static int findMin(Node root) {
		if (root == null) {
			return -1;
		}
		if (root.left == null) {
			return root.data;
		}

		return findMin(root.left);
	}

	public static int findMax(Node root) {
		if (root == null) {
			return -1;
		}
		if (root.right == null) {
			return root.data;
		}
		return findMin(root.right);
	}

	public static void main(String[] args) {
		Node root = null;
		root = addNode(root, 7);
		addNode(root, 5);
		addNode(root, 9);
		printLevelByLevel(root);
		System.out.println("is BST: " + isBSTOptimal(root, -100, 100));
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

		if (num > root.data) {
			root.left = addNode(root.left, num);
		} else {
			root.right = addNode(root.right, num);
		}

		return root;
	}
}