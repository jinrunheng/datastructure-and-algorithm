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

    /**
     * @param e 是否包含 e
     * @return 查找当前数组是否包含元素 e；如果包含元素 e 则返回 true，如果不包含元素 e 则返回 false
     */
    public boolean contains(int e) {
        return find(e) != -1;
    }

    /**
     * @param e 查找的元素 e
     * @return 查找数组当中元素 e 所在的<strong>最近索引</strong>，如果不存在元素 e，则返回 -1
     * <p>
     * ex:
     * data = [3,2,4,2,5]
     * find(2)
     * return : 1
     * find(6)
     * return : -1
     * </p>
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param e
     * @return 返回数组中元素 e 所有的索引位置,如果不存在，则返回空数组
     * <p>
     * ex:
     * data = [3,2,4,2,5]
     * findAll(2)
     * return : [1,3]
     * findAll(6)
     * return : []
     * </p>
     */
    public int[] findAll(int e) {
        int count = getElementCount(e);
        if (count == 0) {
            return new int[]{};
        }
        int[] ret = new int[count];
        int retIndex = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                ret[retIndex++] = i;
            }
        }
        return ret;
    }

    /**
     * @param index 删除 index 位置的元素
     * @return 返回删除的元素值
     */
    public int remove(int index) {
        if (size <= 0) {
            throw new IllegalArgumentException("Remove failed. Array is empty!");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed. Index is illegal!");
        }
        int ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }


    /**
     * @param e 如果数组中存在元素 e，则删除最近的元素 e.
     *          <p>
     *          ex:
     *          data = [3,2,4,2,5]
     *          removeElement(2)
     *          return: true
     *          data = [3,4,2,5]
     *          </>
     */
    public boolean removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * @param e
     * @return 如果数组中存在元素 e，则将数组中 所有值为 e 的元素删除
     *
     * <p>
     * ex:
     * data = [3,2,4,2,5]
     * removeAllElement(2)
     * return: true
     * data = [3,4,5]
     * </p>
     */
    public boolean removeAllElements(int e) {
        int count = getElementCount(e);
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                removeElement(e);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param e
     * @return 返回当前数组中，元素 e 的个数
     */
    public int getElementCount(int e) {
        int ret = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * @return 从数组中删除第一个元素，返回删除的元素
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * @return 从数组中删除最后一个元素，返回删除的元素
     */
    public int removeLast() {
        return remove(size - 1);
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
