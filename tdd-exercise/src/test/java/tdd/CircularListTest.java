package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final int TEST_VALUE = 3;

    private CircularQueue queue;

    @BeforeEach
    void beforeEach(){
        this.queue = new CircularQueueImpl();
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
}
