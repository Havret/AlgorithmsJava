public class TrieST<Value> {
    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;

        private Node[] next = new Node[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        // Change value associated with key if in subtrie rooted at x.
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;
            return x;
        }

        // Use dth key char to identify subtrie.
        var c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public Value get(String key) {
        return get(root, key, 0);
    }

    private Value get(Node x, String key, int d) {
        // Return value associated with key in the subtrie rooted at x.

        if (x == null) {
            return null;
        }

        if (d == key.length()) {
            return (Value) x.val;
        }

        // Use dth key char to identify subtrie.
        var c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }

        if (d == key.length()) {
            x.val = null;
        } else {
            var c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val != null) {
            return x;
        }

        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }

        return null;
    }
}
