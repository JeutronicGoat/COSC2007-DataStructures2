
public class Test {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		for(int i = 0;  i < 100; i++) {
			bst.insert(i + 1);
		}
		
		bst.printIn();
	}
}
