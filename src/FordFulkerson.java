/**
 * Ford-Fulkerson shortest-augmenting path maxflow algorithm
 */
public class FordFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;

    public FordFulkerson(FlowNetwork graph, int s, int t) {
        while (hasAugmentingPath(graph, s, t)) {
            // compute bottleneck capacity
            double bottleneckCapacity = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottleneckCapacity = Math.min(bottleneckCapacity, edgeTo[v].residualCapacityTo(v));
            }

            // augment flow
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottleneckCapacity);
            }

            value += bottleneckCapacity;
        }
    }

    private boolean hasAugmentingPath(FlowNetwork graph, int s, int t) {
        marked = new boolean[graph.V()];
        edgeTo = new FlowEdge[graph.V()];
        var queue = new Queue<Integer>();

        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (var edge : graph.adj(v)) {
                int w = edge.other(v);
                if (edge.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = edge;
                    marked[w] = true;
                    queue.enqueue(w);
                }

            }
        }
        return marked[t];
    }

    public double value() {
        return this.value;
    }

    public boolean inCut(int v) {
        return marked[v];
    }
}
