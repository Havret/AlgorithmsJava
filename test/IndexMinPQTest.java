import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IndexMinPQTest {
    @Test
    void should_process_elements_in_ascending_order_with_regard_to_indexes() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(10);
        minPQ.insert(10, 1);
        minPQ.insert(9, 9);
        minPQ.insert(8, 2);
        minPQ.insert(7, 8);
        minPQ.insert(6, 3);
        minPQ.insert(5, 7);
        minPQ.insert(4, 4);
        minPQ.insert(3, 6);
        minPQ.insert(2, 5);
        minPQ.insert(1, 10);

        var expected = Arrays.asList(
                new IndexedMinPQTestItem(10, 1),
                new IndexedMinPQTestItem(8, 2),
                new IndexedMinPQTestItem(6, 3),
                new IndexedMinPQTestItem(4, 4),
                new IndexedMinPQTestItem(2, 5),
                new IndexedMinPQTestItem(3, 6),
                new IndexedMinPQTestItem(5, 7),
                new IndexedMinPQTestItem(7, 8),
                new IndexedMinPQTestItem(9, 9),
                new IndexedMinPQTestItem(1, 10)
        );

        assertEquals(10, minPQ.size());
        assertFalse(minPQ.isEmpty());
        for (var testItem : expected) {
            assertTrue(minPQ.contains(testItem.index));
            assertEquals(testItem.value, minPQ.min());
            assertEquals(testItem.index, minPQ.minIndex());
            assertEquals(testItem.index, minPQ.delMin());
            assertFalse(minPQ.contains(testItem.index));
        }
        assertEquals(0, minPQ.size());
        assertTrue(minPQ.isEmpty());
    }

    @Test
    void should_be_able_to_change_key_on_specific_index() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(10);
        minPQ.insert(10, 1);
        minPQ.insert(9, 9);
        minPQ.insert(8, 2);
        minPQ.insert(7, 8);
        minPQ.insert(6, 3);
        minPQ.insert(5, 7);
        minPQ.insert(4, 4);
        minPQ.insert(3, 6);
        minPQ.insert(2, 5);
        minPQ.insert(1, 10);

        minPQ.change(6, 100);

        var expected = Arrays.asList(
                new IndexedMinPQTestItem(10, 1),
                new IndexedMinPQTestItem(8, 2),
                new IndexedMinPQTestItem(4, 4),
                new IndexedMinPQTestItem(2, 5),
                new IndexedMinPQTestItem(3, 6),
                new IndexedMinPQTestItem(5, 7),
                new IndexedMinPQTestItem(7, 8),
                new IndexedMinPQTestItem(9, 9),
                new IndexedMinPQTestItem(1, 10),
                new IndexedMinPQTestItem(6, 100)
        );

        assertEquals(10, minPQ.size());
        assertFalse(minPQ.isEmpty());
        for (var testItem : expected) {
            assertTrue(minPQ.contains(testItem.index));
            assertEquals(testItem.value, minPQ.min());
            assertEquals(testItem.index, minPQ.minIndex());
            assertEquals(testItem.index, minPQ.delMin());
            assertFalse(minPQ.contains(testItem.index));
        }
        assertEquals(0, minPQ.size());
        assertTrue(minPQ.isEmpty());
    }

    private class IndexedMinPQTestItem {
        public IndexedMinPQTestItem(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int index;
        public int value;
    }
}