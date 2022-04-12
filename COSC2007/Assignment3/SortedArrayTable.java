
public class SortedArrayTable {

	String[] dictionary;
	int MAX_SIZE;
	int size;
	
	public SortedArrayTable(int a){
		dictionary = new String[a];
		MAX_SIZE = a;
		size = 0;
	}
	
	public void insert(String s) {
		if(size == MAX_SIZE) throw new DictionaryFullException("The Dictionary is Full.");
		else if(size == 0) dictionary[size++] = s;
		else {
			
			for(int i = size; i > 0; i--) {
				if(s.compareTo(dictionary[i - 1]) == 0) throw new DuplicateElementException("This String is a Duplicate.");
				else if(s.compareTo(dictionary[i - 1]) < 0) dictionary[i] = dictionary[i - 1];
				else {
					dictionary[i] = s;
					size++;
					return;
				}
			}
			dictionary[0] = s;
			size++;
		}
	}
	
	public boolean delete(String s) {
		if(size == 0) throw new DictionaryEmptyException("Dictionary Empty");
		if(!search(s)) return false;
		else {
			boolean deleted = false;
			for(int i = 0; i < size; i++) {
				if(s.compareTo(dictionary[i]) == 0) deleted = true;

				else if(deleted) dictionary[i - 1] = dictionary[i];
			}
			size--;
			return true;
		}
	}
	
	public boolean search(String s) {
		if(size == 0) return false;
		
		int high = size - 1;
		int low = 0;
		while(low != high) {
			int midVal = (high + low) / 2;
			if(dictionary[midVal].compareTo(s) > 0) high = midVal - 1;
			else if(dictionary[midVal].compareTo(s) < 0) low = midVal + 1;
			else return true;
		}
		return dictionary[low].compareTo(s) == 0;
	}
	
	public void print() {
		int i;
		System.out.print("[");
		for(i = 0; i < size - 1; i++) {
			System.out.print("(" + dictionary[i] + "), ");
		}
		System.out.println("(" + dictionary[i] + ")]");
	}
	
}
