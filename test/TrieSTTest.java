import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TrieSTTest {
    @Test
    void should_be_possible_to_put_and_retrieve_elements_from_trie() {
        var trie = new TrieST<Integer>();

        trie.put("by", 4);
        trie.put("sea", 6);
        trie.put("sells", 1);
        trie.put("she", 0);
        trie.put("shells", 3);
        trie.put("shore", 7);
        trie.put("the", 5);

        assertEquals(4, trie.get("by"));
        assertEquals(6, trie.get("sea"));
        assertEquals(1, trie.get("sells"));
        assertEquals(0, trie.get("she"));
        assertEquals(3, trie.get("shells"));
        assertEquals(7, trie.get("shore"));
        assertEquals(5, trie.get("the"));
    }

    @Test
    void should_be_possible_to_remove_elements_from_trie() {
        var trie = new TrieST<Integer>();

        trie.put("by", 4);
        trie.put("sea", 6);
        trie.put("sells", 1);
        trie.put("she", 0);
        trie.put("shells", 3);
        trie.put("shore", 7);
        trie.put("the", 5);

        trie.delete("sea");
        trie.delete("sells");
        trie.delete("by");
        trie.delete("she");
        trie.delete("shells");
        trie.delete("shore");
        trie.delete("the");

        assertNull(trie.get("sea"));
        assertNull(trie.get("sells"));
        assertNull(trie.get("by"));
        assertNull(trie.get("she"));
        assertNull(trie.get("shells"));
        assertNull(trie.get("shore"));
        assertNull(trie.get("the"));
    }
}