import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new File("src/input.txt"));
			File outputFile = new File("src/output.txt");
			outputFile.createNewFile();
			FileWriter out = new FileWriter(outputFile);
			
			SortedArrayTable st = new SortedArrayTable(10);
			//SortedListTable st = new SortedListTable(10);
			
			while(in.hasNext()) {
				String operatingString = "";
				String tempString = in.nextLine();
				char operation;
				operation = tempString.charAt(0);
				int numOfQuotes = 0;
				
				for(int i = 1; i< tempString.length(); i++) {
					char temp = tempString.charAt(i);
					if(temp == '"') numOfQuotes++;
					else if(numOfQuotes == 1) {
						operatingString += temp;
					}
				}
				
				if(operation == 'I') {
					try {
						st.insert(operatingString);
						out.append("Inserted Element \"" + operatingString + "\"\n");
					} catch(DictionaryFullException dfe) {
						out.append("Insert Failed: Dictionary Full\n");
					} catch(DuplicateElementException dupee) {
						out.append("Inserted Duplicate Element\n");
					}
				}
				else if(operation == 'D') {
					try {
						if(st.delete(operatingString)) out.append("Element \"" + operatingString + "\" Deleted\n");
						else out.append("Element_not_Found\n");
					} catch(DictionaryEmptyException dee) {
						out.append("Delete Failed: Dictionary Empty\n");
					}
				}
				else if(operation == 'S') {
					if(st.search(operatingString)) out.append(operatingString + "\n");
					else out.append("Element_not_Found\n");
				}
				else if(operation == 'P') {
					st.print();
				}
			}
			
			out.close();
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("oops!");
		} catch (IOException ioe) {
			System.out.println("Something went wrong with the output file");
		}
		
	}
}
