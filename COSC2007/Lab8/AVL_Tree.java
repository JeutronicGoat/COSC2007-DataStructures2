
public class AVL_Tree<T extends Comparable<T>> {

	//******************************************************************* Node
		private class Node<T>{
			T item;
			int height = 1;
			Node left;
			Node right;
			
			Node(T item, Node left, Node right){
				this.item = item;
				this.left = left;
				this.right = right;
			}
		}
		
	//******************************************************************* Tree
	private Node root = null;
	
	AVL_Tree(){}
	
	
	private int balanceValue(Node r) {
		return getHeight(r.left) - getHeight(r.right);
	}
	
	//******************************************************************* insert
	public void insert(T item) {
		root = insert(item, root);
	}
	private Node insert(T item, Node r) {
		if(r == null) return new Node(item, null, null);
		
		if(item.compareTo((T) r.item) < 0) r.left = insert(item, r.left);
		
		else r.right = insert(item, r.right);
		
		//Balance Code
		r.height = Math.max(getHeight(r.left), getHeight(r.right)) + 1;
		
		if(balanceValue(r) > 1 || balanceValue(r) < -1) {
			
			if(getHeight(r.left) < getHeight(r.right)) {
				r = rotateLeft(r);
				if(balanceValue(r) > 1 || balanceValue(r) < -1) {
					r = rotateRight(r);
					r.right = rotateRight(r);
					r = rotateLeft(r);
				}
			}
			else {
				r = rotateRight(r);
				if(balanceValue(r) > 1 || balanceValue(r) < -1) {
					r = rotateLeft(r);
					r.right = rotateLeft(r);
					r = rotateRight(r);
				}
			}
		}
		return r;
	}
	
	//******************************************************************* Rotates
	
	private Node rotateLeft(Node r) {
		Node newR = r.right;
		Node temp = newR.left;
		newR.left = r;
		r.right = temp;
		r.height = Math.max(getHeight(r.left), getHeight(r.right)) + 1;
		newR.height = Math.max(getHeight(newR.left), getHeight(newR.right)) + 1;
		return newR;
	}
	
	private Node rotateRight(Node r) {
		
		Node newR = r.left;
		newR.height = 1;
		Node temp = newR.right;
		newR.right = r;
		r.left = temp;
		r.height = Math.max(getHeight(r.left), getHeight(r.right)) + 1;
		newR.height = Math.max(getHeight(newR.left), getHeight(newR.right)) + 1;
		return newR;
	}
	
	//******************************************************************* Height
	
	public int getTreeHeight() {
		return getHeight(root);
	}
	private int getHeight(Node x) {
		return x == null ? 0 : x.height;
	}
		
	//******************************************************************* prints
	public void printIn() {
		printIn(root);
	}
	private void printIn(Node r) {
		if(r == null) return;
		printIn(r.left);
		System.out.print(r.item.toString() + " ");
		printIn(r.right);
	}
	
	public void printPre() {
		printPre(root);
	}
	private void printPre(Node r) {
		if(r == null) return;
		System.out.print(r.item.toString() + " ");
		printPre(r.left);
		printPre(r.right);
	}
	
	public void printPost() {
		printPost(root);
	}
	private void printPost(Node r) {
		if(r == null) return;
		printPost(r.left);
		printPost(r.right);
		System.out.print(r.item.toString() + " ");
	}
}
