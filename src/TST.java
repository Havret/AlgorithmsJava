import java.util.*;

/**
 * Ternary search trie symbol table
 */
public class TST<Value> {
    private Node root;

    private class Node {
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) {
            return null;
        } else {
            return node.val;
        }
    }

    private Node get(Node x, String key, int d) {
        char c = key.charAt(d);

        if (x == null) {
            return null;
        }

        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }

        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            x.val = val;
        }

        return x;
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }

        var keys = new LinkedList<String>();
        var node = get(root, prefix, 0);
        if (node == null) {
            return keys;
        }
        if (node.val != null) {
            keys.add(prefix);
        }
        collect(node.mid, new StringBuilder(prefix), keys);
        return keys;
    }

    private void collect(Node x, StringBuilder prefix, LinkedList<String> keys) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            keys.add(prefix.toString() + x.c);
        }

        collect(x.left, prefix, keys);

        collect(x.mid, prefix.append(x.c), keys);
        prefix.deleteCharAt(prefix.length() - 1);

        collect(x.right, prefix, keys);
    }
}
