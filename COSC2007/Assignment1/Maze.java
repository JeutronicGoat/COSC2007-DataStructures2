import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Maze {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("What maze file would you like to use: ");
		String fileName = in.nextLine();
		
		try {
			in = new Scanner(new File("src/" + fileName));
			
			int rows = in.nextInt();
			int cols = in.nextInt();
			Cell startCell = null;
			Cell goalCell = null;
			
			Cell[][] mazeArray = new Cell[rows][cols];
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					char temp = in.next().charAt(0);
					if(temp == 'm') startCell = new Cell(i,j,temp);
					if(temp == 'e') goalCell = new Cell(i,j,temp);
					mazeArray[i][j] = new Cell(i,j,temp);
				}
			}
			
			Stack<Cell> s = new Stack<Cell>();
			
			Cell currCell = startCell;
			
			while(!currCell.equal(goalCell)) {
				
				mazeArray[currCell.getColumn()][currCell.getRow()].setSymbol('.');	//Mark current cell
				
				for(int i = 0; i < rows; i++) {										//Printing Maze
					for(int j = 0; j < cols; j++) {
						System.out.print(mazeArray[i][j].getSymbol() + " ");
					}
					System.out.println();
				}
				System.out.println();

				
				if(mazeArray[currCell.getColumn() - 1][currCell.getRow()].getSymbol() == '0'
						|| mazeArray[currCell.getColumn() - 1][currCell.getRow()].getSymbol() == 'e') {	//Check Left
					s.push(mazeArray[currCell.getColumn() - 1][currCell.getRow()]);
				}
				if(mazeArray[currCell.getColumn() + 1][currCell.getRow()].getSymbol() == '0'
						|| mazeArray[currCell.getColumn() + 1][currCell.getRow()].getSymbol() == 'e') {	//Check Right
					s.push(mazeArray[currCell.getColumn() + 1][currCell.getRow()]);
				}
				if(mazeArray[currCell.getColumn()][currCell.getRow() - 1].getSymbol() == '0'
						|| mazeArray[currCell.getColumn()][currCell.getRow() - 1].getSymbol() == 'e') {	//Check Below
					s.push(mazeArray[currCell.getColumn()][currCell.getRow() - 1]);
				}
				if(mazeArray[currCell.getColumn()][currCell.getRow() + 1].getSymbol() == '0'
						|| mazeArray[currCell.getColumn()][currCell.getRow() + 1].getSymbol() == 'e') {	//Check Above
					s.push(mazeArray[currCell.getColumn()][currCell.getRow() + 1]);
				}
				
				
				if(s.isEmpty()) {
					System.out.println("The mouse is trapped, there is no route to the exit.");
					System.exit(0);
				}
				else {
					currCell = s.pop();
				}
			}
			
			System.out.println("The found the exit and escaped the maze.");
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("The file was not found.");
		}
	}
	
}
