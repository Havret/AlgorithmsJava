import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPQTest {
    @Test
    void should_process_elements_in_descending_order() {
        var maxPQ = new MaxPQ<Integer>(10);
        maxPQ.insert(1);
        maxPQ.insert(9);
        maxPQ.insert(2);
        maxPQ.insert(8);
        maxPQ.insert(3);
        maxPQ.insert(7);
        maxPQ.insert(4);
        maxPQ.insert(6);
        maxPQ.insert(5);
        maxPQ.insert(10);

        for (int i = 10; i > 0; i--) {
            assertEquals(i, maxPQ.delMax());
        }
    }

    @Test
    void should_process_elements_in_descending_order_when_pq_initialized_without_given_capacity() {
        var maxPQ = new MaxPQ<Integer>();
        maxPQ.insert(1);
        maxPQ.insert(9);
        maxPQ.insert(2);
        maxPQ.insert(8);
        maxPQ.insert(3);
        maxPQ.insert(7);
        maxPQ.insert(4);
        maxPQ.insert(6);
        maxPQ.insert(5);
        maxPQ.insert(10);

        for (int i = 10; i > 0; i--) {
            assertEquals(i, maxPQ.delMax());
        }
    }
}