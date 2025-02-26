package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int TEST_VALUE = 5;
    public static final List<Integer> TEST_VALUES = List.of(2, 3, 6, 12, 1, 7, 4, 22, 5);
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 22;

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

    private void fillWithTestValues() {
        for (Integer testValue : TEST_VALUES) {
            this.stack.push(testValue);
        }
    }
    
    @Test
    public void canGetTheMinimumValue(){
        fillWithTestValues();
        assertEquals(MIN_TEST_VALUE, this.stack.getMin());
    }

    @Test
    public void canGetTheMaximumValue(){
        fillWithTestValues();
        assertEquals(MAX_TEST_VALUE, this.stack.getMax());
    }

    @Test
    public void valuesArePoppedInTheCorrectOrder(){
        fillWithTestValues();
        List<Integer> poppedValues = new ArrayList<> ();
        for (int i = 0; i < TEST_VALUES.size(); i++) {
            poppedValues.add(stack.pop());
        }
        assertEquals(TEST_VALUES, poppedValues.reversed());
    }

    @Test
    public void returnsTheCorrectSize(){
        fillWithTestValues();
        assertEquals(TEST_VALUES.size(), this.stack.size());
    }

    @Test
    public void cannotPopIfEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void cannotPeekIfEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void cannotGetTheMinimumValueIfEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.getMin());
    }

}