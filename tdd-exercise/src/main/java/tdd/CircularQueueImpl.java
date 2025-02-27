package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final List<Integer> queue;

    public CircularQueueImpl(int size) {
        this.queue = new ArrayList<>(size);
    }

    @Override
    public void enqueue(int value) {
        this.queue.add(value);
    }

    @Override
    public int peek() {
        return this.queue.getLast();
    }

    @Override
    public int dequeue() {
        return this.queue.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
