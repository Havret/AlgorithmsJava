import java.util.*;

/**
 * Regular expression pattern matching (grep)
 */
public class NFA {
    private char[] re;  // match transitions
    private Digraph G;  // epsilon transitions
    private int M;      // number of states

    public NFA(String regexp) {
        // create the NFA for the given regular expression
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = regexp.length();
        G = new Digraph(M + 1);

        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }

            if (i < M - 1 && re[i + 1] == '*') { // lookahead
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
                G.addEdge(i, i + 1);
            }
        }
    }

    public boolean recognizes(String text) {
        var pc = new LinkedList<Integer>();
        var dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                pc.add(v);
            }
        }

        for (int i = 0; i < text.length(); i++) {
            var match = new LinkedList<Integer>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == text.charAt(i) || re[v] == '.') {
                        match.add(v + 1);
                    }
                }
            }
            pc = new LinkedList<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
        }

        for (int v : pc) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }
}
