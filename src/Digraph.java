import java.util.LinkedList;

public class Digraph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    /**
     * Create a V -vertex digraph with no edges
     *
     * @param V number of Vertices
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;

        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    /**
     * Add edge v->w to this digraph
     */
    public void addEdge(int v, int w) {
        this.E++;
        adj[v].add(w);
    }

    /**
     * Vertices connected to v by edges pointing from v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Number of vertices
     */
    public int V() {
        return V;
    }

    /**
     * Number of edges
     */
    public int E() {
        return E;
    }

    /**
     * Reverse of this digraph
     */
    public Digraph reverse() {
        Digraph reveredDigraph = new Digraph(V());
        for (int v = 0; v < V(); v++)
            for (int w : adj(v)) {
                reveredDigraph.addEdge(w, v);
            }
        return reveredDigraph;
    }
}
