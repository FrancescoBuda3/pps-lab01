package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int TEST_VALUE = 5;
    private MinMaxStackImpl stack;

    @BeforeEach
    void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void oneValueCanBePushed(){
        this.stack.push(TEST_VALUE);
        assertEquals(TEST_VALUE, stack.peak());
    }

    @Test
    public void oneValueCanBePopped(){
        this.stack.push(TEST_VALUE);
        assertAll(
                () -> assertEquals(TEST_VALUE, stack.pop()),
                () -> assertTrue(this.stack.isEmpty())
        );
    }

}