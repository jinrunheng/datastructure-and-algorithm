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
    public void addFirst(int e){
        add(e,0);
    }

    /**
     * 在第 index 位置插入一个新的元素 e
     *
     * @param e 添加的元素
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

}
