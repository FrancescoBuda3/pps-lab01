package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStackImpl stack;

    @BeforeEach
    void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void oneValueCanBePushed(){
        this.stack.push(5);
        assertEquals(5, stack.peak());
    }

}