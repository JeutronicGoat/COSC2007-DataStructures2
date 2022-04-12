
public class Test {

	public static void main(String[] args) {
		
		ExpressionTree eT = new ExpressionTree();
		eT.buildExpression("--6/3+2*481");
		eT.printInOrder();
		System.out.println(eT.eval());
		
	}
}
