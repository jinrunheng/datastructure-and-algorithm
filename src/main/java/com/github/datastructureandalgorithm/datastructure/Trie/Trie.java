package com.github.datastructureandalgorithm.datastructure.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现的 Trie 默认不会添加重复的单词
 */
public class Trie {

    private class TrieNode {
        public int path;
        public boolean isWord;
        public Map<Character, TrieNode> next;

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
            this.path = 0;
            next = new HashMap<>();
        }

        public TrieNode() {
            this(false);
        }
    }

    private TrieNode root;
    private int size;

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    /**
     * 获得 Trie 中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向 Trie 中添加一个单词
     *
     * @param word
     */
    public void add(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
            cur.path++;
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词 word 是否在 Trie 中
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
