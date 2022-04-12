public class WordTree {

	private class WordNode {
	
		String word;
		
		int wordCount;
		
		WordNode left;
		WordNode right;
		
		WordNode(String word, WordNode left, WordNode right) {
			this.word = word;
			this.left = left;
			this.right = right;
			wordCount = 1;
		}
		
	}
	
	
	private WordNode root = null;
	
	
	public WordTree() {}
	
//**********************************************************
	public void add(String word) {
		root = add(word, root);
	}
	private WordNode add(String word, WordNode r) {
		if(r == null) return new WordNode(word, null, null);
		
		r.word = r.word.toLowerCase();
		word = word.toLowerCase();
		
		int result = r.word.compareTo(word);
		
		if(result == 0) r.wordCount++;
		else if(result > 0) r.left = add(word, r.left);
		else r.right = add(word, r.right);
		
		return r;
	}
//**********************************************************
	
	
	public int countNodes() {
		return countNodes(root);
	}
	private int countNodes(WordNode r) {
		if(r == null) return 0;
		return countNodes(r.left) + countNodes(r.right) + 1;
	}
	
	
	public int countWordsWith4Chars() {
		return countWordsWith4Chars(root);
	}
	private int countWordsWith4Chars(WordNode r) {
		if(r == null) return 0;
		else if(r.word.length() == 4) return countWordsWith4Chars(r.left) + countWordsWith4Chars(r.right) + 1;
		else return countWordsWith4Chars(r.left) + countWordsWith4Chars(r.right);
	}
	
	
	public void print() {
		print(root);
	}
	private void print(WordNode r) {
		if(r == null) return;
		print(r.left);
		System.out.println(r.word + ": " + r.wordCount);
		print(r.right);
	}
	
}
