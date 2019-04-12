import java.util.LinkedList;

public class FlowNetwork {
    private final int V;
    private LinkedList<FlowEdge>[] adj;

    public FlowNetwork(int V) {
        this.V = V;
        adj = (LinkedList<FlowEdge>[]) new LinkedList[this.V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(FlowEdge edge) {
        int v = edge.from();
        int w = edge.to();
        adj[v].add(edge);
        adj[w].add(edge);
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }

    public Iterable<FlowEdge> edges() {
        var list = new LinkedList<FlowEdge>();
        for (int v = 0; v < V; v++)
            for (FlowEdge e : adj(v)) {
                if (e.to() != v)
                    list.add(e);
            }
        return list;
    }
}
