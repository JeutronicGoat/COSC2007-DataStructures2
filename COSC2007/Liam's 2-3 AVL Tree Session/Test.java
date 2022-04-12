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
			
			while(in.hasNext()) {
				t.add(in.nextLine());
			}
			
			t.preOrderPrint();
			System.out.println();
			//t.postOrderPrint();
			
			
			
		}catch(TreeException te) {
			System.out.println("tree shid happened");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		}
		
	
	}
}
