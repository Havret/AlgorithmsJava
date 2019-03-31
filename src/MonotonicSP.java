import java.util.ArrayList;
import java.util.Comparator;

public class MonotonicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    private Comparator<DirectedEdge> comparator;

    public MonotonicSP(EdgeWeightedDigraph graph, int s, Comparator<DirectedEdge> comparator) {
        this.comparator = comparator;
        edgeTo = new DirectedEdge[graph.V()];
        distTo = new double[graph.V()];
        pq = new IndexMinPQ<>(graph.V());

        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(graph, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph graph, int v) {
        for (DirectedEdge edge : sortEdges(graph.adj(v))) {
            int w = edge.to();
            DirectedEdge previousEdge = edgeTo[v];
            if (distTo[w] > distTo[v] + edge.weight() && isMonotonic(previousEdge, edge)) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    private Iterable<DirectedEdge> sortEdges(Iterable<DirectedEdge> edges) {
        var sorted = new ArrayList<DirectedEdge>();
        for (var edge : edges) {
            sorted.add(edge);
        }
        sorted.sort(comparator);
        return sorted;
    }

    private boolean isMonotonic(DirectedEdge previous, DirectedEdge next) {
        return previous == null || comparator.compare(next, previous) > 0;
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

        Stack<DirectedEdge> stack = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            stack.push(e);
        }
        return stack;
    }
}
