public class GraphProperties {
    private int[] eccentricities;

    public GraphProperties(Graph graph) {
        this.eccentricities = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            int eccentricity = 0;
            var paths = new BreadthFirstPaths(graph, v);
            for (int w = 0; w < graph.V(); w++) {
                if (paths.hasPathTo(w)) {
                    var distance = paths.distanceTo(w);
                    if (distance > eccentricity) {
                        eccentricity = distance;
                    }
                }
            }
            this.eccentricities[v] = eccentricity;
        }
    }

    // length of the shortest path from
    // v to the furthest vertex from v
    public int eccentricity(int v) {
        return eccentricities[v];
    }

    // maximum eccentricity of any vertex
    public int diameter() {
        int diameter = 0;
        for (int eccentricity : eccentricities) {
            if (eccentricity > diameter) {
                diameter = eccentricity;
            }
        }
        return diameter;
    }

    // smallest eccentricity of any vertex
    public int radius() {
        int radius = Integer.MAX_VALUE;
        for (int eccentricity : eccentricities) {
            if (eccentricity < radius) {
                radius = eccentricity;
            }
        }
        return radius;
    }

    public int center() {
        int radius = radius();
        for (int i = 0; i < eccentricities.length; i++) {
            if (eccentricity(i) == radius)
                return i;
        }

        throw new IllegalArgumentException();
    }
}
