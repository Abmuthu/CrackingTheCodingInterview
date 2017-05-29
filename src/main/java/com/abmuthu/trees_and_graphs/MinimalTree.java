package com.abmuthu.trees_and_graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimalTree {

	public Node formMinimalTree(Node root, int[] nums) {
		if (nums.length == 1) {
			root = addNode(root, nums[0]);
			return root;
		}

		int midIndex = nums.length/2;
		root = addNode(root, nums[midIndex]);

		int[] leftArray = new int[midIndex];
		int i = 0;
		while (i < midIndex) {
			leftArray[i] = nums[i];
			i++;
		}
		i++;
		System.out.println("left array" + Arrays.toString(leftArray));
		int[] rightArray = new int[nums.length - leftArray.length - 1];
		int j = 0;
		while (i < nums.length) {
			rightArray[j] = nums[i];
			i++;
			j++;
		}
		System.out.println("right array" + Arrays.toString(rightArray));

		root.left = formMinimalTree(root.left, leftArray);
		root.right = formMinimalTree(root.right, rightArray);

		return root;

	}

	public static void main(String[] args) {
		Node root = null;
		int[] nums = {2, 4, 8, 9, 11, 19, 100};
		root = new MinimalTree().formMinimalTree(root, nums);
		// printTreeInOrder(root);
		// System.out.println(root.data + "");
		// System.out.println(root.left.data + "");
		// System.out.println(root.right.data + "");
		// System.out.println(root.left.left.data + "");
		// System.out.println(root.left.right.data + "");
		// System.out.println(root.right.left.data + "");
		// System.out.println(root.right.right.data + "");
		printLevelByLevel(root);
		// root = addNode(root, 10);
		// addNode(root, 12);
		// addNode(root, 9);
		// addNode(root, 11);
		// printTreeInOrder(root);

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

	public static void printTreeInOrder(Node root) {
		if (root == null) {
			return;
		}

		printTreeInOrder(root.left);
		System.out.print(root.data + " ");
		printTreeInOrder(root.right);
	}

	public static void printLevelByLevel(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node node = null;
		while ((node = queue.peek()) != null)  {
			System.out.print(node.data + " ");
			queue.add(node.left);
			queue.add(node.right);
			queue.remove(node);
		}
	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}