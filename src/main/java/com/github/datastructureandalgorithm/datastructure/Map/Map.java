package com.github.datastructureandalgorithm.datastructure.Map;

public interface Map<K, V> {

    void add(K k, V v);

    V remove(K k);

    boolean contains(K k);

    V get(K k);

    void set(K k, V v);

    int getSize();

    boolean isEmpty();
}
