import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NthOrderStatisticTest {
    @Test
    void should_find_median() {
        List<Integer> input = Arrays.asList(700, 600, 500, 400, 300, 200, 100);
        assertEquals(400, NthOrderStatistic.find(input, (input.size() - 1) / 2));
    }
}