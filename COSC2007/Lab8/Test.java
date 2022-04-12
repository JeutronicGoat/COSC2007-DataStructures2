
public class Test {

	public static void main(String[] args) {
		
		AVL_Tree avl = new AVL_Tree();
		
		avl.insert(10); 
		avl.insert(20); 
		avl.insert(15);
		avl.insert(25);
		avl.insert(30);
		avl.insert(16);
		avl.insert(18);
		avl.insert(19);
		
		avl.printPre();
		System.out.println();
		avl.printIn();
		System.out.println();
		avl.printPost();
		System.out.println();
		
		System.out.println("Height = " + avl.getTreeHeight());
	}
}
