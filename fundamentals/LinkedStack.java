import java.util.Iterator;


public class LinkedStack<T> implements Iterable<T>{
	private Node first;
	
	private class Node{
		T item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(T item){
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
	}
	
	public T pop(){
		T tmp = null;
		
		if(!isEmpty()){
			tmp = first.item;
			first = first.next;
		}
		return tmp;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedStackIterator();
	}
	
	private class LinkedStackIterator implements Iterator<T>{
		private Node n = first;
		
		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public T next() {
			T item = n.item;
			n = n.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}
}
