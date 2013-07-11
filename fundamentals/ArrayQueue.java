
public class ArrayQueue<T> {
	private int capacity = 1;
	private T[] items; 
	private int front = 0;
	private int back = 0;
	
	public boolean isEmpty(){
		return back <= front;
	}
	
	public void enqueue(T item){
		if(back == capacity){
			capacity *= 2;
			resize();
		}
		items[back++] = item;
	}
	
	public T dequeue(){
		if(back-front < capacity / 4){
			capacity /= 2;
			resize();
		}
		
		return items[front++];
	}
	
	@SuppressWarnings("unchecked")
	public void resize(){
		T[] tmp = (T[]) new Object[capacity];
		for(int i = front,j = 0; i <= back; i++, j++){
			tmp[j] = items[i];
		}
		
		back = back - front;
		front = 0;
		items = tmp;
	}
}
