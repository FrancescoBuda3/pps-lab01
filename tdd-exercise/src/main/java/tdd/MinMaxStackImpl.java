package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl {
    private final List<Integer> stack = new ArrayList<>();

    public void push(int value) {
        stack.add(value);
    }

    public int peak() {
        return stack.getFirst();
    }
}
