import java.util.HashSet;

public class MSTHelper {
    public static boolean isInMST(EdgeWeightedGraph graph, Edge edge) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        int start = edge.either(), end = edge.other(start);
        double weight = edge.weight();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            Integer v = stack.pop();
            for (Edge e : graph.adj(v)) {
                if (e.weight() < weight) {
                    if (e.other(v) == end) {
                        return false;
                    }
                    if (!visited.contains(e.other(v))) {
                        visited.add(e.other(v));
                        stack.push(e.other(v));
                    }
                }
            }
        }

        return true;
    }
}
