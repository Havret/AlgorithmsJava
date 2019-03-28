public class AcyclicLP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicLP(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.V()];
        distTo = new double[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = Double.NEGATIVE_INFINITY;
        }
        distTo[s] = 0.0;

        var topological = new Topological(graph);

        for (Integer v : topological.order()) {
            relax(graph, v);
        }
    }

    private void relax(EdgeWeightedDigraph graph, int v) {
        for (DirectedEdge e : graph.adj(v)) {
            int w = e.to();
            if (distTo[w] < distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
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
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            stack.push(e);
        }
        return stack;
    }
}
