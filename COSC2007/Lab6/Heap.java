
public class Heap<T extends Comparable> {

	private Object[] items;
	private int size;
	private final int MAX_SIZE;
	
	public Heap() {
		this(31);
	}
	
	public Heap(int maxsize) {
		MAX_SIZE = maxsize;
		items = new Object[MAX_SIZE];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(T item) {
		if(size == MAX_SIZE) throw new RuntimeException("The heap is full.");
		
		items[size++] = item;
		
		//still need to heapify --> trickleUp
		int index = size;
		while(index !=0) {
			int parent = (index - 1) / 2;
			
			if(((T) items[index]).compareTo((T) items[parent]) > 0) {
				T temp = (T) items[index];
				items[index] = items[parent];
				items[parent] = temp;
			}
			else	break;
		}
		
	}
	
	public T dequeue() {
		if(isEmpty()) throw new RuntimeException("The heap is empty.");
		
		T item = (T) items[0];
		items[0] = items[--size];
		
		//still to do - heapify --> trickleDown
		
		return null;
	}
	
	public T peek() {
		if(isEmpty()) throw new RuntimeException("The heap is empty.");
		return (T) items[0];
	}
	
	public void dequeueAll() {
		items = new Object[MAX_SIZE];
		size = 0;
	}
	
}
