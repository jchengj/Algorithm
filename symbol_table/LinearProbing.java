
public class LinearProbing<K, V> {
	int M;
	int N;
	
	K keys[];
	V values[];
	
	@SuppressWarnings("unchecked")
	public LinearProbing(){
		this(16);
	}
	
	public LinearProbing(int M){
		this.M = M;
		keys = (K[]) new Object[M];
		values = (V[]) new Object[M];		
	}
	
	public int hash(K key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V value){
		if(N >= M){
			resize(2 * M);
		}
		
		int i = 0;
		for(i = hash(key); keys[i] != null; i = (i + 1) % M);
		keys[i] = key;
		values[i] = value;
		N++;
	}
	
	public void delete(K key){
		if(N == 0){ return; }
		int i = 0;
		for(i = hash(key); keys[i] != null; i = (i + 1) % M){
			if(keys[i] == key){
				break;
			}
		}
		
		keys[i] = null;
		values[i] = null;
		
		i = (i+1) % M;
		
		while(keys[i] != null){
			K tmp_k = keys[i];
			V tmp_v = values[i];
			
			keys[i] = null;
			values[i] = null;
			
			put(tmp_k, tmp_v);
			N--;
		}
		
		if(N <= M/8){
			resize(M/2);
		}
	}
	
	public V get(K key){
		int i = 0;
		for(i = hash(key); keys[i] != null; i = (i + 1) % M){
			if(keys[i] == key){
				return values[i];
			}
		}
		return null;
	}
	
	public void resize(int size){
		LinearProbing<K,V> tmp = new LinearProbing<>(size);
		for(int i = 0; i < keys.length; i++){
			if(keys[i] != null){
				tmp.put(keys[i], values[i]);
			}
		}
		
		keys = tmp.keys;
		values = tmp.values;
		M = tmp.M;
	}
	
}
