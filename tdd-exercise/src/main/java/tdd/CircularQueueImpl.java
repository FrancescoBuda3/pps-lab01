package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final List<Integer> queue;
    private final int maxSize;

    public CircularQueueImpl(int size) {
        this.queue = new ArrayList<>(size);
        this.maxSize = size;
    }

    @Override
    public void enqueue(int value) {
        this.queue.add(value);
        if (this.queue.size() > maxSize) {
            this.queue.removeFirst();
        }
    }

    @Override
    public int peek() {
        return this.queue.getFirst();
    }

    @Override
    public int dequeue() {
        return this.queue.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.maxSize;
    }
}
