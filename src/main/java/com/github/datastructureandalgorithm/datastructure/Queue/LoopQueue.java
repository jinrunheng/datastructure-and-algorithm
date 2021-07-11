package com.github.datastructureandalgorithm.datastructure.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(front + 1) % data.length];
        }
        data = newData;
        front = 0;
        tail = getSize() - 1;
    }

    @Override
    public void enqueue(E e) {
        if (getSize() < data.length - 1) {
            data[(tail + 1) % data.length] = e;
            tail = (tail + 1) % data.length;
        } else {
            resize(data.length * 2);
            data[getSize()] = e;
            tail++;
        }
    }

    @Override
    public E dequeue() {
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (getSize() == 0) {
            throw new RuntimeException("LoopQueue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        if (tail == front) {
            return 0;
        } else if (tail < front) {
            return tail + data.length - front + 1;
        } else {
            return tail - front + 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue size:%d,capacity:%d\n", getSize(), getCapacity());
        sb.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
}
