package com.github.datastructureandalgorithm.datastructure.dynamic_array;

public class Array {

    private int[] data;
    private int size;

    /**
     * @param capacity 用户传入 capacity 指定数组的容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * @return 数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向尾部添加元素
     *
     * @param e 添加的元素
     */
    public void addLast(int e) {
        add(e, size);
    }

    /**
     * 在首部添加一个元素
     *
     * @param e 添加的元素
     */
    public void addFirst(int e) {
        add(e, 0);
    }

    /**
     * 在第 index 位置插入一个新的元素 e
     *
     * @param e     添加的元素
     * @param index 添加元素的索引
     */
    public void add(int e, int index) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed. Array is full");
        }
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index out of bounds");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * @param index 索引
     * @return 获取 index 处的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    /**
     * @param e     更新后的元素
     * @param index 将索引为 index 位置的元素 更新为 e
     */
    public void set(int e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
