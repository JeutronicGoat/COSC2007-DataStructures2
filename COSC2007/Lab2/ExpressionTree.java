
public class ExpressionTree {

	private class Node{
		char item;
		Node left;
		Node right;
		
		Node(char item, Node left, Node right){
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	
	public void buildExpression(String s) {
		StringBuilder sb = new StringBuilder(s);
		root = buildExpressionTree(sb);
		if(sb.length() > 0) throw new ExpressionTreeException("Not valid prefix");
	}
	
	public Node buildExpressionTree(StringBuilder s){
		
		if(s.length() == 0) throw new ExpressionTreeException("Invalid prefix");
		
		char temp = s.charAt(0);
		s.deleteCharAt(0);
		
		if(Character.isDigit(temp)) return new Node(temp, null, null);
		
		return new Node(temp, buildExpressionTree(s), buildExpressionTree(s));
	}
	
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	
	private void printInOrder(Node r) {
		if(r == null) return;
		if(r.left != null) System.out.print("(");
		printInOrder(r.left);
		System.out.print(r.item);
		printInOrder(r.right);
		if(r.right != null) System.out.print(")");
	}
	
	public int eval(Node root) {
		
		char nodeValue = root.item;
		if(Character.isDigit(nodeValue)) return Character.getNumericValue(nodeValue);
		
		int valueLeft = eval(root.left);
		int valueRight = eval(root.right);
		
		int result = 0;
		switch(nodeValue) {
			case '+': result = valueLeft + valueRight; break;
			case '-': result = valueLeft - valueRight; break;
			case '*': result = valueLeft * valueRight; break;
			case '/': result = valueLeft / valueRight; break;
		}
		return result;
	}
	
	
}
