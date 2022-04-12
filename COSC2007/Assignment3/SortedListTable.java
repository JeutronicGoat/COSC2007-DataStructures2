import java.util.ArrayList;

public class SortedListTable {

	
	ArrayList<String> dictionary;
	int MAX_SIZE;
	
	public SortedListTable(int a){
		dictionary = new ArrayList<String>(a);
		MAX_SIZE = a;
	}
	
	public void insert(String s) {
		if(dictionary.size() == MAX_SIZE) throw new DictionaryFullException("The Dictionary is Full.");
		else if(dictionary.size() == 0) dictionary.add(0, s);
		else if(search(s)) throw new DuplicateElementException("This String is a Duplicate.");
		else {
			for(int i = dictionary.size(); i > 0; i--) {
				if(s.compareTo(dictionary.get(i - 1)) > 0) {
					dictionary.add(i, s);
					return;
				}
			}
			dictionary.add(0, s);
		}
	}
	
	public boolean delete(String s) {
		if(dictionary.size() == 0) throw new DictionaryEmptyException("Dictionary Empty");
		return dictionary.remove(s);
	}
	
	public boolean search(String s) {
		return dictionary.contains(s);
	}
	
	public void print() {
		System.out.println(dictionary.toString());
	}
}
