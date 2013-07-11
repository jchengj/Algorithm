
class SequentialSearchST<K extends Comparable<K>, V>{
	K[] keys;
	V[] values;
	int N = 0;
	
	@SuppressWarnings("unchecked")
	public SequentialSearchST(){
		keys = (K[]) new Object[1];
		values = (V[]) new Object[1];
	}
	
	@SuppressWarnings("unchecked")
	public void resize(){
		K[] tmp_keys = (K[]) new Object[N];
		V[] tmp_values = (V[]) new Object[N];
		
		for(int i = 0; i < N; i++){
			tmp_keys[i] = keys[i];
			tmp_values[i] = values[i];
		}
	}
	
	public void put(K key, V value){
		if(N >= keys.length){
			N *= 2;
			resize();
		}
		
		int i = rank(key, 0, keys.length-1);
		if(i < N && keys[i].compareTo(key) == 0){
			values[i] = value;
			return;
		}
		
		for(int j = N; j > i; j--){
			keys[j] = keys[j-1];
			values[j] = values[j-1];
		}
		
		keys[i] = key;
		values[i] = value;
		
		N++;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public V get(K key){
		if(isEmpty()){ return null; }
		int i = rank(key, 0, keys.length-1);
		if(i < N && keys[i].compareTo(key) == 0){
			return values[i];
		}else{
			return null;
		}
	}
	
	public int rank(K key, int lo, int hi){
		if(lo > hi){ return lo;}
		int mid = (lo + hi) / 2;
		int cmp = key.compareTo(keys[mid]);
		if(cmp < 0){
			return rank(key, lo, mid-1);
		}else if(cmp > 0){
			return rank(key, mid+1, hi);
		}else{
			return mid;
		}
	}
	
	public void delete(K key){
		int i = rank(key, 0, keys.length-1);
		if(i < N && keys[i].compareTo(key) == 0){
			for(int j = i; j < N; j--){
				keys[j] = keys[j+1];
				values[j] = values[j+1];
			}
			N--;
		}
		
		if(N < keys.length / 4){
			N /= 2;
			resize();
		}
	}
}


public class SeparateChainingHash<K extends Comparable<K>, V> {
	int M;
	int N;
	SequentialSearchST<K, V>[] st;
	
	public SeparateChainingHash(){
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public SeparateChainingHash(int M){
		this.M = M;
		st = (SequentialSearchST<K, V>[]) new Object[M];
		for(int i = 0; i < M; i++){
			st[i] = new SequentialSearchST<K, V>();
		}	
	}
	
	
	public void put(K key, V value){
		if(key == null){ return; }
		
		st[hash(key)].put(key,  value);
	}
	
	
	public int hash(K key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	
}
