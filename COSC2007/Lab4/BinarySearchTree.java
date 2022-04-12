public class BinarySearchTree<T extends Comparable<T>> {	//BST Only Accepts Comparable Objects
															//BinarySearchTree<T extends Comparable>
															//And Only Accepts Objects Comparable to itself
															//BinarySearchTree<T extends Comparable		<T>		>
	
	private class Node<T>{
		T item;
		Node left;
		Node right;
		
		Node(T item, Node left, Node right){
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root = null;
	
	BinarySearchTree(){}
	
	public T search(T item) {
		return (T)search(item, root);
	}
	private Node search(T item, Node r) {
		if(r == null) return null;
		
		if(r.item.equals(item)) return r;
		
		if(item.compareTo((T) r.item) > 0) return search(item, r.right);
		
		return search(item, r.left);
	}
	
	
	public void insert(T item) {
		root = insert(item, root);
	}
	private Node insert(T item, Node r) {
		if(r == null) return new Node(item, null, null);
		
		if(item.compareTo((T) r.item) > 0) r.left = insert(item, r.left);
		
		else r.right = insert(item, r.right);
		
		return r;
	}
	
	
	public void printIn() {
		printIn(root);
	}
	private void printIn(Node r) {
		if(r == null) return;
		printIn(r.left);
		System.out.println(r.item.toString());
		printIn(r.right);
	}

	
	public boolean isEmpty() {
		return root == null;
	}
}
