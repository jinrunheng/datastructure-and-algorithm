package com.github.datastructureandalgorithm.datastructure.Trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrieTest {

    @Test
    void getSize() {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("ab");
        trie.add("book");
        trie.add("abc");
        trie.add("car");
        Assertions.assertEquals(trie.getSize(), 5);
        trie.delete("abc");
        Assertions.assertEquals(trie.getSize(), 4);
    }

    @Test
    void add() {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("ab");
        trie.add("book");
        trie.add("abc");
        trie.add("car");
        Assertions.assertTrue(trie.contains("abc"));
        trie.delete("abc");
        Assertions.assertTrue(trie.contains("abc"));
        trie.delete("abc");
        trie.contains("abc");
        // Assertions.assertTrue();
        //boolean result = trie.contains("abc");
        //Assertions.assertFalse(result);
    }

    @Test
    void contains() {

    }

    @Test
    void delete() {
    }

    @Test
    void prefix() {
    }

    @Test
    void isPrefix() {
    }

    @Test
    void match() {
    }
}