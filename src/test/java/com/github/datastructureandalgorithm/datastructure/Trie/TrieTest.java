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
        trie.remove("abc");
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
        trie.remove("abc");
        Assertions.assertTrue(trie.contains("abc"));
        trie.remove("abc");
        Assertions.assertFalse(trie.contains("abc"));
        Assertions.assertTrue(trie.contains("ab"));
    }

    @Test
    void contains() {

    }

    @Test
    void remove() {
    }

    @Test
    void prefix() {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("ab");
        trie.add("book");
        trie.add("abc");
        trie.add("car");
        Assertions.assertEquals(trie.prefix("ab"), 3);
        trie.remove("abc");
        Assertions.assertEquals(trie.prefix("ab"), 2);
        Assertions.assertEquals(trie.prefix("bo"),1);
    }

    @Test
    void isPrefix() {
    }

    @Test
    void match() {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("ab");
        trie.add("book");
        trie.add("abc");
        trie.add("car");
        trie.add("adc");
        Assertions.assertTrue(trie.match("a.."));
        trie.remove("abc");
        Assertions.assertTrue(trie.match("a.."));
        trie.remove("abc");
        Assertions.assertTrue(trie.match("a.."));
        trie.remove("adc");
        Assertions.assertFalse(trie.match("a.."));

    }
}