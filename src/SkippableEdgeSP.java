public class SkippableEdgeSP {
    private Iterable<DirectedEdge> shortestSkippablePath = null;

    public SkippableEdgeSP(EdgeWeightedDigraph graph, int source, int target) {
        DijkstraKSP KShortestPaths = new DijkstraKSP(graph, source, target, Integer.MAX_VALUE);
        double minReducedDistance = Double.MAX_VALUE;
        for (int i = 1; i <= KShortestPaths.count(); i++) {
            var currentPath = KShortestPaths.getPath(i);
            var currentDistance = KShortestPaths.getDistance(i);
            var maxEdge = findMaxEdge(currentPath);
            var reducedDistance = currentDistance - maxEdge.weight();
            if (minReducedDistance > reducedDistance) {
                shortestSkippablePath = currentPath;
                minReducedDistance = reducedDistance;
            }
        }
    }

    public Iterable<DirectedEdge> getShortestSkippablePath() {
        return shortestSkippablePath;
    }

    private static DirectedEdge findMaxEdge(Iterable<DirectedEdge> edges) {
        DirectedEdge max = null;
        for (DirectedEdge edge : edges) {
            if (max == null || max.weight() < edge.weight()) {
                max = edge;
            }
        }
        return max;
    }
}
