package com.github.datastructureandalgorithm.datastructure.Set;

import com.github.datastructureandalgorithm.datastructure.BST.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    /**
     * @param e 向集合中添加元素 e
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * @param e 删除元素 e
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * @param e 元素 e
     * @return 集合中是否包含元素 e
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    /**
     * @return 集合中元素的个数
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * @return 集合是否为空
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
