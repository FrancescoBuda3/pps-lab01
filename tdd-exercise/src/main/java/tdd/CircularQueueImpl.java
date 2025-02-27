package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final List<Integer> queue = new ArrayList<>();

    @Override
    public void enqueue(int value) {
        this.queue.add(value);
    }

    @Override
    public int peek() {
        return queue.getLast();
    }
}
