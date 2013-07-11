public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	
	@SuppressWarnings("unchecked")
	public Graph(int v){
		V = v;
		adj = (Bag<Integer>[]) new Object[v];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int i, int j){
		adj[i].add(j);
		adj[j].add(i);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
}
