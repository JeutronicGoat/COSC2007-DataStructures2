
public class Cell {

	private int column;
	private int row;
	
	private char symbol;
	
	Cell(){
		column = 0;
		row = 0;
		symbol = '1';
	}
	
	Cell(int c, int r, char value){
		column = c;
		row = r;
		symbol = value;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public boolean equal(Cell c) {
		return (column == c.column && row == c.row);
	}
}
