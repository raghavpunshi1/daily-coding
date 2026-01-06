package dailyCode.binaryTree;

public class BinarySearchTree {

	public static void main(String[] args) {
		int[] arr = {1,4,6,2,8,9,11,3};
		BinarySearchTree bst = new BinarySearchTree();
		for(int i=0; i<arr.length;i++) {
			bst.insert(arr[i]);
		}
		bst.display();
	}

	public class NodeBST {
		private int val;
		private NodeBST left;
		private NodeBST right;

		public NodeBST(int val) {
			this.val = val;
		}
	}

	private NodeBST root;

	public void insert(int val) {
		root = insert(val, root);
	}

	private NodeBST insert(int val, NodeBST node) {
		if (node == null) {
			node = new NodeBST(val);
			return node;
		}
		if (val < node.val) {
			node.left=insert(val, node.left);
		} else {
			node.right=insert(val, node.right);
		}
//		if he would take height as part of Node class then,
//		we can calculate the height of each node by uncommenting below line
//		node.height = Math.max(node.left.height, node.right.height) + 1;
		return node;
	}

	public int getHeight(NodeBST node) {
		if(node == null) {
			return 0;
		}
		
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public boolean isBalancedNaive(NodeBST node) {
		if(node == null) {
			return true;
		}
		
		int leftHeight= getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		if(Math.abs(rightHeight-leftHeight)>1) {
			return false;
		}
		
		return isBalancedNaive(node.left) && isBalancedNaive(node.right);
	}
	
	public boolean isBalancedOptimised() {
		return checkHeightForBalanced(root)!= -1;
	}
	
	private int checkHeightForBalanced(NodeBST node) {
		if(node == null) return 0;
		
		int leftHeight = checkHeightForBalanced(node.left);
		if(leftHeight == -1) return -1;
		
		int rightHeight = checkHeightForBalanced(node.right);
		if(rightHeight == -1) return -1;
		
		if(Math.abs(rightHeight - leftHeight)>1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
		
		
	}
	
	public void display() {
		display(this.root, "Root value : ");
		
	}
	
	private void display(NodeBST node, String msg) {
		if(node==null) {
			return;
		}
		System.out.println(msg+node.val);
		display(node.left , "Left child of "+node.val+" is: ");
		display(node.right , "Right child of "+node.val+" is: ");
	}
	

}
