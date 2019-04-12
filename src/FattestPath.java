public class FattestPath {
    private DirectedEdge[] edgeTo;
    private double[] fattestTo;
    private IndexMaxPQ<Double> pq;

    public FattestPath(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.V()];
        fattestTo = new double[graph.V()];
        pq = new IndexMaxPQ<>(graph.V());
        fattestTo[0] = Double.POSITIVE_INFINITY;

        pq.insert(s, Double.POSITIVE_INFINITY);
        while (!pq.isEmpty()) {
            relax(graph, pq.delMax());
        }
    }

    private void relax(EdgeWeightedDigraph graph, int v) {
        for (DirectedEdge edge : graph.adj(v)) {
            int w = edge.to();
            if (fattestTo[w] < Math.min(fattestTo[v], edge.weight())) {
                fattestTo[w] = Math.min(fattestTo[v], edge.weight());
                edgeTo[w] = edge;

                if (pq.contains(w)) {
                    pq.changeKey(w, fattestTo[w]);
                } else {
                    pq.insert(w, fattestTo[w]);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return edgeTo[v] != null;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<DirectedEdge> stack = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            stack.push(e);
        }
        return stack;
    }
}
