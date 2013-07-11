import java.util.Iterator;


public class ArrayStack<T> implements Iterable<T> {
	private T[] items;
	private int cap = 1;
	private int pointer = 0;
	
	public Iterator<T> iterator(){
		return new ArrayStackIterator();
	}
	
	private class ArrayStackIterator implements Iterator<T>{

		@Override
		public boolean hasNext() {
			return pointer > 0;
		}

		@Override
		public T next() {
			return items[--pointer];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}
	
	public boolean isEmpty(){
		return pointer > 0;
	}
	
	public void push(T item){
		if(pointer == cap){
			cap *= 2;
			resize();
		}
		
		items[pointer++] = item;
	}
	
	public T pop(){
		if(pointer <= items.length / 4){
			cap /= 2;
			resize();
		}
		
		return items[--pointer];
	}
	
	public void resize(){
		T[] tmp = (T[]) new Object[cap];
		for(int i = 0 ; i < pointer; i++){
			tmp[i] = items[i];
		}
		items = tmp;
	}
	
	
}
