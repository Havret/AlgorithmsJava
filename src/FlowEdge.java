public class FlowEdge {
    private final int v, w;
    private final double capacity;
    private double flow;

    public FlowEdge(int v, int w, double cap) {
        this.v = v;
        this.w = w;
        this.capacity = cap;
        this.flow = 0.0;
    }

    /**
     * @return vertex this edge points from
     */
    public int from() {
        return v;
    }


    /**
     * @return vertex this edge points to
     */
    public int to() {
        return w;
    }

    /**
     * @return other endpoint
     */
    public int other(int vertex) {
        if (vertex == v)
            return w;
        else if (vertex == w)
            return v;
        else
            throw new RuntimeException("Illegal endpoint");
    }

    /**
     * @return capacity of this edge
     */
    public double capacity() {
        return capacity;
    }

    /**
     * @return flow of this edge
     */
    public double flow() {
        return flow;
    }

    /**
     * @return residual capacity toward v
     */
    public double residualCapacityTo(int vertex) {
        if (vertex == v)
            return flow;
        else if (vertex == w)
            return capacity - flow;
        else
            throw new IllegalArgumentException();
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == v) {
            flow -= delta;
        } else if (vertex == w) {
            flow += delta;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }


    @Override
    public String toString() {
        return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
    }
}
