import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Algorithm to find k shortest paths
 */
public class DijkstraKSP {
    private ArrayList<Path> paths;

    private MinPQ<Path> pq;

    public DijkstraKSP(EdgeWeightedDigraph graph, int source, int target, int kPaths) {
        pq = new MinPQ<>();
        paths = new ArrayList<>();
        pq.insert(new Path(source));
        while (!pq.isEmpty()) {
            var currentPath = pq.delMin();
            int lastVertex = currentPath.getLastVertex();
            if (lastVertex == target) {
                paths.add(currentPath);
            }
            if (paths.size() < kPaths) {
                for (var edge : graph.adj(lastVertex)) {
                    // Vertices already in path should be skipped
                    // we don't want to find walks but paths
                    if (!currentPath.containsVertex(edge.to())) {
                        var newPath = new Path(currentPath, edge);
                        pq.insert(newPath);
                    }
                }
            }
        }
    }


    public Iterable<DirectedEdge> getPath(int k) {
        if (k > paths.size()) {
            return null;
        }

        Path path = paths.get(k - 1);
        return path.edges;
    }

    public double getDistance(int k) {
        if (k > paths.size()) {
            return -1;
        }

        Path path = paths.get(k - 1);
        return path.weight;
    }

    public int count() {
        return paths.size();
    }

    private class Path implements Comparable<Path> {
        private LinkedList<DirectedEdge> edges = new LinkedList<>();
        private HashSet<Integer> vertices = new HashSet<>();
        private int lastVertex;
        private double weight = 0;

        public Path(int vertex) {
            lastVertex = vertex;
        }

        public Path(Path previousPath, DirectedEdge nextEdge) {
            edges.addAll(previousPath.edges);
            edges.add(nextEdge);
            vertices.addAll(previousPath.vertices);
            vertices.add(nextEdge.to());
            lastVertex = nextEdge.to();
            weight = previousPath.weight + nextEdge.weight();
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public boolean containsVertex(int vertex) {
            return vertices.contains(vertex);
        }

        @Override
        public int compareTo(Path o) {
            return Double.compare(this.weight, o.weight);
        }
    }
}
