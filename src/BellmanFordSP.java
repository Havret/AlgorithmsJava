public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;

        while (!queue.isEmpty() && !this.hasNegativeCycle()) {
            var v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);

        }
    }

    public double distTo(int v){
        return distTo[v];
    }
    public boolean hasPathTo(int v) {
        return edgeTo[v] != null;

    }
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        var stack = new Stack<DirectedEdge>();
        for (var edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
            stack.push(edge);
        }

        return stack;
    }


    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            if (edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(spt);
        cycle = cf.cycle();

    }

    private void relax(EdgeWeightedDigraph G, Integer v) {
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }

            if (cost++ % G.V() == 0) {
                findNegativeCycle();
            }
        }
    }
}
