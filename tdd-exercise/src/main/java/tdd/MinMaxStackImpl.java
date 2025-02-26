package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl  implements MinMaxStack {
    private final List<Integer> stack = new ArrayList<>();
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public void push(int value) {
        this.stack.addFirst(value);
        if (value < min) {
            min = value;
        }
        if (value > max) {
            max = value;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException();
        } else {
            return this.stack.removeFirst();
        }
    }

    @Override
    public int peek() {
        return this.stack.getFirst();
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
