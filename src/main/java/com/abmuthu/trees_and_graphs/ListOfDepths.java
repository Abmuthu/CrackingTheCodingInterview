package com.abmuthu.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

	public static ArrayList<ArrayList<Node>> lists(Node root) {
		
		ArrayList<ArrayList<Node>> masterList = new ArrayList<ArrayList<Node>>();
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Node> currentList = new ArrayList<>();

			while (size > 0) {
				Node node = queue.remove();
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
				currentList.add(node);
				size--;
			}
			masterList.add(currentList);
		}

		return masterList;
 
	}

	public static void main(String[] args) {
		Node root = null;
		root = addNode(root, 7);
		addNode(root, 5);
		addNode(root, 9);
		addNode(root, 1);
		addNode(root, 6);
		addNode(root, 8);
		addNode(root, 10);
		ArrayList<ArrayList<Node>> list = lists(root);

		for (ArrayList<Node> l : list) {
			for (Node node : l) {
				System.out.print(node.data + " ");
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