import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {	//BST Only Accepts Comparable Objects
															//BinarySearchTree<T extends Comparable>
															//And Only Accepts Objects Comparable to itself
															//BinarySearchTree<T extends Comparable		<T>		>
	
//******************************************************************* Node
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
	
//******************************************************************* Tree
	private Node root = null;
	
	BinarySearchTree(){}
	
//******************************************************************* search/return item
	public T search(T item) {
		return (T)search(item, root);
	}
	private Node search(T item, Node r) {
		if(r == null) return null;
		
		if(r.item.equals(item)) return r;
		
		if(item.compareTo((T) r.item) > 0) return search(item, r.right);
		
		return search(item, r.left);
	}
	
//******************************************************************* rebuild
	public void rebuild() {
		ArrayList<T> a = new ArrayList<T>();
		buildNodeArray(a, root);
		root = null;
		rebuild(a, 0, count());
	}
	private void buildNodeArray(ArrayList<T> a, Node r) {
		if(r == null) return;
		buildNodeArray(a, r.left);
		a.add((T) r.item);
		buildNodeArray(a, r.right);
	}
	private void rebuild(ArrayList<T> a, int startVal, int endVal) {
		if(startVal <= endVal) return;
		int index = (startVal + endVal) / 2;
		insert(a.get(index));
		rebuild(a, startVal, index);
		rebuild(a, index + 1, endVal);
	}
	
//******************************************************************* insert
	public void insert(T item) {
		root = insert(item, root);
	}
	private Node insert(T item, Node r) {
		if(r == null) return new Node(item, null, null);
		
		if(item.compareTo((T) r.item) < 0) r.left = insert(item, r.left);
		
		else r.right = insert(item, r.right);
		
		return r;
	}
	
//******************************************************************* replace
	public boolean replace(T item) {
		Node x = search(item, root);
		if(x == null) return false;
		x.item = item;
		return true;
	}
	
//******************************************************************* counts
	public int count() {
		return count(root);
	}
	private int count(Node r) {
		if(r == null) return 0;
		return count(r.left) + count(r.right) + 1;
	}	
	
	public int height() {
		return height(root);
	}
	private int height(Node r) {
		if(r == null) return 0;
		return Math.max(height(r.left), height(r.right)) + 1;
	}
	
	public int fullLevel() {
		return fullLevel(root);
	}
	private int fullLevel(Node r) {
		if(r == null) return 0;
		return Math.min(fullLevel(r.left), fullLevel(r.right)) + 1;
	}
	
//******************************************************************* prints
	public void printIn() {
		printIn(root);
	}
	private void printIn(Node r) {
		if(r == null) return;
		printIn(r.left);
		System.out.println(r.item.toString());
		printIn(r.right);
	}
	
//******************************************************************* is functions
	public boolean isLeaf() {
		return root != null && root.left == null && root.right == null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
//*******************************************************************
}
