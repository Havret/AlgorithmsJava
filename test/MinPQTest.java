import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinPQTest {
    @Test
    void should_process_elements_in_ascending_order() {
        var minPQ = new MinPQ<Integer>(10);
        minPQ.insert(1);
        minPQ.insert(9);
        minPQ.insert(2);
        minPQ.insert(8);
        minPQ.insert(3);
        minPQ.insert(7);
        minPQ.insert(4);
        minPQ.insert(6);
        minPQ.insert(5);
        minPQ.insert(10);

        for (int i = 1; i < 11; i++) {
            assertEquals(i, minPQ.delMin());
        }
    }

    @Test
    void should_process_elements_in_ascending_order_when_pq_initialized_without_given_capacity() {
        var minPQ = new MinPQ<Integer>();
        minPQ.insert(1);
        minPQ.insert(9);
        minPQ.insert(2);
        minPQ.insert(8);
        minPQ.insert(3);
        minPQ.insert(7);
        minPQ.insert(4);
        minPQ.insert(6);
        minPQ.insert(5);
        minPQ.insert(10);

        for (int i = 1; i < 11; i++) {
            assertEquals(i, minPQ.delMin());
        }
    }
}