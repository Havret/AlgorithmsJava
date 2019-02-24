public class Diameter {
    public Diameter(Graph graph) {


    }

    private int findFurthestNode(Graph graph, int source) {
        var firstDepthFirstPaths = new DepthFirstPaths(graph, source);

        var furthestPoint = 0;
        var furthestDistance = 0;

        for (int i = 0; i < graph.V(); i++) {
            if (firstDepthFirstPaths.hasPathTo(i)) {
                Iterable<Integer> path = firstDepthFirstPaths.pathTo(i);
                var distance = count(path);
                if (distance > furthestDistance) {
                    furthestPoint = i;
                    furthestDistance = distance;
                }
            }
        }

        return furthestPoint;
    }

    private int count(Iterable<Integer> path) {
        int length = 0;
        for (var i : path) {
            length++;
        }

        return length;
    }
}
