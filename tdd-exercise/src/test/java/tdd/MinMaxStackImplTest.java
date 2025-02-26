package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int TEST_VALUE = 5;
    public static final List<Integer> TEST_VALUES = List.of(2, 3, 6, 12, 1, 7, 4, 22, 5);
    private static final int MIN_TEST_VALUE = 1;

    private MinMaxStackImpl stack;

    @BeforeEach
    void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void oneValueCanBePushed(){
        this.stack.push(TEST_VALUE);
        assertEquals(TEST_VALUE, stack.peek());
    }

    @Test
    public void oneValueCanBePopped(){
        this.stack.push(TEST_VALUE);
        assertAll(
                () -> assertEquals(TEST_VALUE, stack.pop()),
                () -> assertTrue(this.stack.isEmpty())
        );
    }
    
    @Test
    public void canGetTheMinimumValue(){
        for (Integer testValue : TEST_VALUES) {
            this.stack.push(testValue);
        }
        assertEquals(MIN_TEST_VALUE, this.stack.getMin());
    }

}