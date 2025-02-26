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

    private void replacePoppedMaximum() {
        this.stack
                .stream()
                .max(Integer::compareTo)
                .ifPresent(value -> this.max = value);
    }

    private void replacePoppedMinimum() {
        this.stack
                .stream()
                .min(Integer::compareTo)
                .ifPresent(value -> this.min = value);
    }

    public int pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        } else {
            int returnValue = this.stack.removeFirst();
            if (returnValue == this.min){
                replacePoppedMinimum();
            } else if (returnValue == this.max){
                replacePoppedMaximum();
            }
            return returnValue;
        }
    }



    @Override
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        } else {
            return this.stack.getFirst();
        }
    }

    @Override
    public int getMin() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        } else {
            return this.min;
        }
    }

    @Override
    public int getMax() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        } else {
            return this.max;
        }
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
