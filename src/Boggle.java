import java.util.*;

/**
 * Boggle is a word game played on an 4-by-4 grid of tiles,
 * where each tile contains one letter in the alphabet.
 * The goal is to find all words in the dictionary that can
 * be made by following a path of adjacent tiles (with no tile repeated),
 * where two tiles are adjacent if they are horizontal, vertical,
 * or diagonal neighbors.
 */
public class Boggle {
    private HashSet<String> words = new HashSet<>();
    private TST<Boolean> tst = new TST<>();
    private char[] tiles;

    public Boggle(String[] dictionary, char[] tiles) {
        if (tiles.length != 16) {
            throw new IllegalArgumentException("You should provide exactly 16 tiles");
        }
        if (dictionary.length == 0) {
            throw new IllegalArgumentException("Dictionary shouldn't be empty");
        }

        this.tiles = tiles;

        for (String word : dictionary) {
            tst.put(word, true);
        }

        var graph = buildGraph();

        for (int i = 0; i < graph.V(); i++) {
            var prefix = new StringBuilder();
            var marked = new boolean[graph.V()];
            prefix.append(tiles[i]);
            dfs(graph, marked, i, prefix);

            if (words.size() == dictionary.length) {
                // we have found all the words from dictionary
                // no need to look further
                return;
            }
        }
    }

    private void dfs(Graph graph, boolean[] marked, int v, StringBuilder prefix) {
        marked[v] = true;

        var word = prefix.toString();
        if (tst.get(word) != null) {
            words.add(word);
        }

        for (int w : graph.adj(v)) {
            if (marked[w]) {
                continue;
            }

            prefix.append(tiles[w]);
            // If there are some keys matching current prefix
            // we may be on a right path to find a word from dictionary
            if (anyPrefixes(tst.keysWithPrefix(prefix.toString()))) {
                dfs(graph, marked, w, prefix);
            }
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private boolean anyPrefixes(Iterable<String> prefixes) {
        return prefixes.iterator().hasNext();
    }

    private Graph buildGraph() {
        Graph graph = new Graph(16);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int v = i * 4 + j;
                if (j < 3) {
                    int w = v + 1;
                    graph.addEdge(v, w);
                }
                if (i < 3) {
                    int w = v + 4;
                    graph.addEdge(v, w);
                }
                if (j < 3 && i < 3) {
                    int w = v + 5;
                    graph.addEdge(v, w);
                }
                if (j > 0 && i < 3) {
                    int w = v + 3;
                    graph.addEdge(v, w);
                }
            }
        }

        return graph;
    }

    public Iterable<String> getWords() {
        return words;
    }
}
