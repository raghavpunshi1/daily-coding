package dailyCode.binaryTree;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree(new Scanner(System.in));
		binaryTree.display();
	}
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private Node root;
	
	public Node createBinaryTree(Scanner scanner) {
		System.out.println("Enter root value");
		int val = scanner.nextInt();
		root = new Node(val);
		create(scanner, root);
		return root;
	}
	
	private void create(Scanner scanner, Node node) {
		System.out.println("Do you want to enter the LEFT value of "+ node.value);
		boolean left=scanner.nextBoolean();
		if(left) {
			System.out.println("Enter LEFT value of "+node.value);
			int val = scanner.nextInt();
			node.left = new Node(val);
			create(scanner, node.left);
		}
		
		
		System.out.println("Do you want to enter the RIGHT value of "+ node.value);
		boolean right=scanner.nextBoolean();
		if(right) {
			System.out.println("Enter RIGHT value of "+node.value);
			int val = scanner.nextInt();
			node.right = new Node(val);
			create(scanner, node.right);
		}
	}
	
	public void display() {
		display(this.root, "");
	}
	private void display(Node node, String indent) {
		if(node == null) {
			return;
		}
		
		System.out.println(indent + node.value);
		display(node.left, indent+"\t");
		display(node.right, indent+"\t");
		
	}
	

}
