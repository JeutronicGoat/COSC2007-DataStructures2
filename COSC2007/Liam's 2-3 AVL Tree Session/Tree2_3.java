import java.util.ArrayList;

public class Tree2_3<T extends Comparable> {

	private class Node<T extends Comparable>{
		
		private ArrayList<T> items=  new ArrayList<T>();
		private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
		
		public boolean isLeaf() {
			return children.size() == 0;
		}
		
		public boolean hasTreeItems() {
			return children.size() == 3;
		}
		
		public Node(T item) {
			items.add(item);
		}
		
		public Node(T item, Node<T> left, Node<T> right) {
			items.add(item);
			
			children.add(left);
			children.add(right);
			children.add(null);
		}
		
		public boolean add(T item) {
			
			if(isLeaf()) return addToLeaf(item);
			
			return addToInterior(item);
		}
		
		private boolean addToLeaf(T item) {
			int compare;
			
			for(int i = 0; i < items.size(); i++) {
				
				compare = item.compareTo(items.get(i));
				
				if(compare == 0) return false;
				
				else if(compare < 0) {
					items.add(i, item);
					return true;
				}
			}
			
			items.add(item);
			return true;
			
		}
		
		private boolean addToInterior(T item) {
			
			int compare;
			
			for(int i = 0; i <= items.size(); i++) {
				
				if(i == items.size()) compare = -1;
				
				else {
					
					compare = item.compareTo(items.get(i));
				}
				
				if(compare == 0) return false;
				
				else if(compare < 0) {
					boolean retVal = children.get(i).add(item);
					if(children.get(i).hasTreeItems()) split(i);
					return retVal;
				}
			}
				
			return false;
		}
		
		private void split(int pos) {
			
			Node<T> splitNode = children.get(pos);
			if(pos == 2) items.add(children.get(pos).items.get(1));
			
			else {
				
				items.add(pos, children.get(pos).items.get(1));
			}
			
			Node<T> newChild1, newChild2;
			
			if(children.get(pos).isLeaf()) {
				
				newChild1 = new Node<T>(children.get(pos).items.get(0));
				newChild2 = new Node<T>(children.get(pos).items.get(2));
			}
			else {
				
				newChild1 = new Node<T>(children.get(pos).items.get(0), children.get(pos).children.get(0), children.get(pos).children.get(1));
				newChild2 = new Node<T>(children.get(pos).items.get(2), children.get(pos).children.get(2), children.get(pos).children.get(3));
			}
			
			children.remove(splitNode);
			children.add(pos, newChild2);
			children.add(pos, newChild1);
		}
		
		@Override
		public String toString() {
			String msg = "Node Values: ";
			
			if(items.size() == 2) {
				msg += ("First " + items.get(0).toString() + ", ");
				msg += ("Second " + items.get(0).toString() + ", ");
				return msg;
			}
			
			return msg += ("First " + items.get(0).toString() + ", ");
		}
		
	}
	
	//********************************************************* Tree
	
	Node<T> treeRoot;
	
	public Tree2_3() {
		treeRoot = null;
	}
	
	public void add(T item) throws TreeException{
		
		if(treeRoot == null) {
			treeRoot = new Node<T>(item);
		}
		else {
			Node<T> left, right;
			
			if(treeRoot.add(item) == false) throw new TreeException("Duplicate Found!!!");
			if(treeRoot.items.size() == 3) {
				left = new Node<T>(treeRoot.items.get(0));
				right = new Node<T>(treeRoot.items.get(2));
			}
			else {
				left = new Node<T>(treeRoot.items.get(0), treeRoot.children.get(0), treeRoot.children.get(1));
				right = new Node<T>(treeRoot.items.get(2), treeRoot.children.get(2), treeRoot.children.get(3));
			}
			
			treeRoot = new Node<T>(treeRoot.items.get(1), left, right);
		}
	}
	
	private void postOrderPrint(Node<T> root) {
		
		if(root == null) return;
		
		for(int i = 0; i < root.children.size(); i++) {
			
			postOrderPrint(root.children.get(i));
		}
		
		System.out.println(root);
	}
	
	public void postOrderPrint() {
		postOrderPrint(treeRoot);
	}
	
	private int height(Node<T> root) {
		
		if(root == null) return 0;
		
		if(root.children.size() == 0) return 1;
		
		if(root.children.size() == 3) {
			
			int lheight = height(root.children.get(0));
			int mheight = height(root.children.get(1));
			int rheight = height(root.children.get(2));
			
			return 1 + Integer.max(Integer.max(lheight, mheight), rheight);
		}
		
		int lheight = height(root.children.get(0));
		int rheight = height(root.children.get(1));
		return 1 + ((lheight > rheight) ? lheight : rheight);
	}
	
	public int height() {
		return height(treeRoot);
	}
}
