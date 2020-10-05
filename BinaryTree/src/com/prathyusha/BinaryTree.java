package com.prathyusha;

import java.util.Scanner;

class BTNode {
	BTNode left, right;
	int data;

	
	public BTNode() {
		left = null;
		right = null;
		data = 0;
	}

	
	public BTNode(int n) {
		left = null;
		right = null;
		data = n;
	}

	
	public void setLeft(BTNode n) {
		left = n;
	}

	
	public void setRight(BTNode n) {
		right = n;
	}

	
	public BTNode getLeft() {
		return left;
	}

	
	public BTNode getRight() {
		return right;
	}

	
	public void setData(int d) {
		data = d;
	}

	
	public int getData() {
		return data;
	}
}

/* Class BT */
class BT {
	
	private BTNode root;

	/* Constructor */
	public BT() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private BTNode insert(BTNode node, int data) {
		if (node == null)
			node = new BTNode(data);
		else {
			if (data > node.data)
				node.right = insert(node.right, data);
			else if (data < node.data)
				node.left = insert(node.left, data);
		}
		return node;
	}

	/* Functions to delete data */
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	public BTNode deleteRecursive(BTNode root, int value) {
		/* If the tree is empty */
		if (root == null)
			return root;

		/*  recursion down the tree */
		if (value < root.data)
			root.left = deleteRecursive(root.left, value);
		else if (value > root.data)
			root.right = deleteRecursive(root.right, value);

		
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children
			
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRecursive(root.right, root.data);
		}

		return root;
	}

	int minValue(BTNode root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	
	
	/* Function to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* Function to count number of nodes recursively */
	private int countNodes(BTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}
	
	/* Function to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	/* Function to search for an element recursively */
	private boolean search(BTNode r, int val) {
		if (r.getData() == val)
			return true;
		if (r.getLeft() != null)
			if (search(r.getLeft(), val))
				return true;
		if (r.getRight() != null)
			if (search(r.getRight(), val))
				return true;
		return false;
	}

	
	/* Function to update an element */
	public boolean update(int value) {
		return updateElement(root, value);
	}

	private boolean updateElement(BTNode current, int value) {
		Scanner sc = new Scanner(System.in);
		if (current.data == value) {
			System.out.println("Enter new element to update :");
			current.data = sc.nextInt();
			return true;

		}
		if (current.left != null) {
			if (updateElement(current.left, value)) {

				return true;
			}
		}
		if (current.right != null) {
			if (updateElement(current.right, value)) {

				return true;
			}
		}
		return false;
	}

	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(BTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(BTNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(BTNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		BT bt = new BT();
		System.out.println("Binary Tree Test\n");
		char ch;
		/* Perform tree operations */
		do {
			System.out.println("\nBinary Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. delete");
			System.out.println("3. search");
			System.out.println("4. count nodes");
			System.out.println("5. check empty");
			System.out.println("6. Modify the Element");
			System.out.println("Enter your choice: ");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				bt.insert(scan.nextInt());
				break;

			case 2:
				System.out.println("Elements  are : ");
				bt.inorder();
				System.out.println("\nEnter element to delete : ");
				bt.delete(scan.nextInt());
				break;
			
			case 3:
				System.out.println("Enter integer element to search");
				System.out.println("Search result : " + bt.search(scan.nextInt()));
				break;
			case 4:
				System.out.println("Nodes = " + bt.countNodes());
				break;
			case 5:
				System.out.println("Empty status = " + bt.isEmpty());
				break;
			case 6:
				System.out.println("Elements  are : ");
				bt.inorder();
				System.out.println("\nEnter element you want to update");
				bt.update(scan.nextInt());
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			
			
			/* Display tree */
			System.out.print("\nPost order : ");
			bt.postorder();
			System.out.print("\nPre order : ");
			bt.preorder();
			System.out.print("\nIn order : ");
			bt.inorder();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

}
