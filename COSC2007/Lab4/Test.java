import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner in;
		try {
		
			in = new Scanner(new File("src/Employees.txt"));
		
			BinarySearchTree bst = new BinarySearchTree();
		
			for(int i = 0; i < 10; i++) {
				bst.insert(new Employee(in.nextInt(), in.next(), in.next()));
			}
		
			bst.printIn();
		
		} catch (FileNotFoundException e) {
			System.out.println("UhOh");
		}
	}
}
