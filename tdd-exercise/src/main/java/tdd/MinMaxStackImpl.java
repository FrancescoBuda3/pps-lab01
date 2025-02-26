package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl  implements MinMaxStack {
    private final List<Integer> stack = new ArrayList<>();
    private int min = Integer.MAX_VALUE;

    public void push(int value) {
        stack.add(value);
        if (value < min) {
            min = value;
        }
    }

    public int pop() {
        return stack.removeFirst();
    }

    @Override
    public int peek() {
        return stack.getFirst();
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return 0;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }
}
