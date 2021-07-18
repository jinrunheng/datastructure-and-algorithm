package com.github.datastructureandalgorithm.datastructure.Set;

import com.github.datastructureandalgorithm.datastructure.LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    /**
     * @param e 向集合中添加一个元素
     */
    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    /**
     * @param e 向集合中删除元素 e
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * @param e 元素 e
     * @return 返回集合中是否包含元素 e
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * @return 返回集合中的元素个数
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * @return 返回集合是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
