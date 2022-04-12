import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a file name: ");
		String fileName = in.next();
		System.out.println();
		
		try {
			in = new Scanner(new File("src/" + fileName));
			Tree t = new Tree();
			while(in.hasNext()) t.add(in.nextLine());
			
			System.out.println("Height = " + t.height() + "\n");
			
			System.out.println("Pre-order traversal:");
			t.preOrderPrint();
			System.out.println();
			
			System.out.println("In-order traversal:");
			t.inOrderPrint();
			System.out.println();
			
			System.out.println("Post-order traversal:");
			t.postOrderPrint();
			System.out.println();
			
			System.out.println("Finding Values:");
			t.Find(15);
			t.Find(20);
			t.Find(14);
			t.Find(5);
			t.Find(25);
			t.Find(8);
			t.Find(22);
			t.Find(1);
			t.Find(19);
			t.Find(2);
			t.Find(17);
			t.Find(13);
			t.Find(18);
			t.Find(9);
			
			
		}catch(TreeException te) {
			System.out.println("There was an error with the tree");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		}
		
	}
}
