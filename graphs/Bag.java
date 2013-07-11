import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Bag<V> implements Iterable<V>{
	private Node root;
	
	private class Node{
		Node next;
		V value;
	}
	
	public void add(V value){
		Node t = new Node();
		t.value = value;
		
		t.next = root;
		root = t;
	}
	
	private class BagIterator implements Iterator<V>{
		@Override
		public boolean hasNext() {
			return root != null;
		}

		@Override
		public V next() {
			V value = root.value;
			root = root.next;
			return value;
		}

		@Override
		public void remove() {
			// Not Supported
		}
	}
	
	public Iterator<V> iterator(){
		return new BagIterator();
	}
	
//	public static void main(String[] args) throws FileNotFoundException, IOException{
//		String file = "/Users/jcheng/j.txt";
//		Bag<Integer> b = new Bag<>();
//		
//		try(BufferedReader br = new BufferedReader(new FileReader(file))){
//			String tmp;
//			while((tmp = br.readLine()) != null){
//				b.add(Integer.parseInt(tmp));
//			}
//		}
//	
//		Iterator<Integer> i = b.iterator();
//		while(i.hasNext()){
//			System.out.println(i.next());
//		}
//	}
}
