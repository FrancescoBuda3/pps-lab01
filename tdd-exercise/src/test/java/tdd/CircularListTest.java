package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final int SIZE = 10;
    public static final int TEST_VALUE = 3;
    public static final List<Integer> TEST_VALUES = List.of(2, 3, 6, 12, 1, 7, 4, 22, 5, 7);


    private CircularQueue queue;

    @BeforeEach
    void beforeEach(){
        this.queue = new CircularQueueImpl(SIZE);
    }

    @Test
    public void oneValueCanBeEnqueued(){
        this.queue.enqueue(TEST_VALUE);
        assertEquals(TEST_VALUE, this.queue.peek());
    }

    @Test
    public void oneValueCanBeDequeued(){
        this.queue.enqueue(TEST_VALUE);
        assertEquals(TEST_VALUE, this.queue.dequeue());
    }

    private void fillWithTestValue() {
        for (Integer testValue : TEST_VALUES) {
            this.queue.enqueue(testValue);
        }
    }

    @Test
    public void multipleValuesCanBeEnqueued(){
        List<Integer> dequeuedValues = new ArrayList<>();
        fillWithTestValue();
        while (!this.queue.isEmpty()) {
            dequeuedValues.add(this.queue.dequeue());
        }
        assertEquals(TEST_VALUES, dequeuedValues);
    }

    @Test
    public void updateTheOldestValueIfFull(){
        fillWithTestValue();
        this.queue.enqueue(TEST_VALUE);
        assertEquals(TEST_VALUES.get(1), this.queue.dequeue());
    }

    @Test
    public void cannotDequeueIfEmpty(){
        assertThrows(IllegalStateException.class, () -> this.queue.dequeue());
    }
}
