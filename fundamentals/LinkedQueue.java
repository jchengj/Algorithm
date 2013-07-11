import java.util.Iterator;


public class LinkedQueue<T> implements Iterable<T> {
	
	Node front = new Node();
	Node last = front;
	
	private class Node{
		T item;
		Node next;
	}
	
	public boolean isEmpty(){
		return front == null;
	}
	
	public void enqueue(T item){
		Node tmp = last;
		last = new Node();
		last.item = item;
		if(isEmpty()){
			front = last;
		}else{
			tmp.next = last;
		}
	}
	
	public T dequeue(){
		if(isEmpty()){
			return null;
		}
		
		T item = front.item;
		front = front.next;
		if(isEmpty()){
			last = null;
		}
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<T>{

		@Override
		public boolean hasNext() {
			return isEmpty();
		}

		@Override
		public T next() {
			return dequeue();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}
