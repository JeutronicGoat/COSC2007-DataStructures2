import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a file name: ");
		String fileName = in.next();
		System.out.println();
		
		BufferedReader br;         
		try {
			br = new BufferedReader(new FileReader(new File("src/" + fileName)));
			
			StringBuilder s = new StringBuilder();
			WordTree t = new WordTree();
			
			int c = 0; 
			while((c = br.read()) != -1) {   			//Read char by Char
														//Found this at https://www.candidjava.com/tutorial/program-to-read-a-file-character-by-character/
			        char currChar = (char) c;           //converting integer to char 
			        
			        if(Character.isLetter(currChar)) {
			        	s.append(currChar);
			        }
			        else if(currChar == '\'') {			//Test for " ' " 
			        	//Do nothing because of issues with single quotes
			        	//So we get Dont instead of Don't etc. 
			        	//But we don't get 'hello' we get hello
			        }
			        else if(currChar == '-' || currChar == ' ' || currChar == '\n') { //Checking for Dashes, spaces, and nextLines(ENTER)
			        	t.add(s.toString());
			        	s = new StringBuilder();
			        }
			        
			        
			  }
			
			System.out.println("The number of words is: " + t.countNodes());
			System.out.println("The number of Words with 4 characters is: " + t.countWordsWith4Chars());
			System.out.println();
			t.print();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("File was not Found!!!");
		} catch (IOException e) {
			
		}

	}
}
