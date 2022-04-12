

public class Lab3_StartFile {

	private class Node {
		
		Integer item;
		Node left, right;
		
		public Node(Integer item) {
			this.item = item;
		}
		
		public Node(Integer item, Node left, Node right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
		
	}
	
	private Node root;
	
	//just letting a standard No-arg constructor be created so the class name can be changed without issue
	
	
	public void makeTestTree1() {
		root = new Node(30, new Node(20, new Node(10), null), new Node(70, new Node(50, new Node(40), new Node(60)), new Node(90)));
	}

	public void makeTestTree2() {
		root = new Node(10, 
				new Node(8, new Node(2, new Node(1), new Node(6, new Node(4, new Node (3), new Node(5)), null)), null), 
				new Node(11, null, new Node(14, new Node(13), new Node(16))));
	
	}

	//METHODS TO BE ADDED
	
	//1) PRINTING
	//a) 	In-order
	public void printIn() {
		printIn(root);
	}
	private void printIn(Node r) {
		if(r == null) return;
		printIn(r.left);
		System.out.print(r.item + " ");
		printIn(r.right);
	}
	//b) 	Print Pre-order
	public void printPre() {
		printPre(root);
	}
	private void printPre(Node r) {
		if(r == null) return;
		System.out.print(r.item + " ");
		printPre(r.left);
		printPre(r.right);
	}
	//c) 	Print Post-order
	public void printPost() {
		printPost(root);
	}
	private void printPost(Node r) {
		if(r == null) return;
		printPost(r.left);
		printPost(r.right);
		System.out.print(r.item + " ");
	}
		
	//2) INFORMATION METHODS
	//a)	Count the number of nodes in the tree. 
	public int count() {
		return count(root);
	}
	private int count(Node r) {
		if(r == null) return 0;
		return count(r.left) + count(r.right) + 1;
	}
	//b)	Compute the height of the tree.
	public int height() {
		return height(root);
	}
	private int height(Node r) {
		if(r == null) return 0;
		return Math.max(height(r.left), height(r.right)) + 1;
	}
	//c)	Find the maximum element.
	public int max() {
		return max(root);
	}
	private int max(Node r) {
		if(r == null) return Integer.MIN_VALUE;
		return Math.max(r.item, Math.max(max(r.left), max(r.right)));
	}
	//d)	Find the sum of the elements
	public int sum() {
		return sum(root);
	}
	private int sum(Node r) {
		if(r == null) return 0;
		return r.item + sum(r.left) + sum(r.right);
	}
	//e)	Find the average of the elements
	public int average() {
		return average(root);
	}
	private int average(Node r) {
		if(r == null) return 0;
		return sum(r)/count(r);
	}
	//f)	Find a specific element
	public boolean find(int val) {
		return find(val, root) != null;
	}
	private Node find(int val, Node r) {
		if(r == null) return null;
		if(r.item == val) return r;
		Node leftVal = find(val, r.left);
		Node rightVal = find(val, r.right);
		return leftVal == null ? find(val, r.right) : leftVal;
	}
	//g)	Determine whether one item is an ancestor or another
	public boolean isancestor(int a, int c) {
		return isancestor(a, c, root);
	}
	private boolean isancestor(int a, int c, Node r) {
		if(a == c) return false;
		Node ancestor = find(a, r);
		return find(c, ancestor) != null;
	}
	//h)	Determine the highest level that is full 
	public int fullLevel() {
		return fullLevel(root);
	}
	private int fullLevel(Node r) {
		if(r == null) return 0;
		return Math.min(fullLevel(r.left), fullLevel(r.right)) + 1;
	}
	
	
}