package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl {
    private final List<Integer> stack = new ArrayList<>();

    public void push(int i) {
        stack.add(i);
    }

    public int peak() {
        return stack.getFirst();
    }
}
