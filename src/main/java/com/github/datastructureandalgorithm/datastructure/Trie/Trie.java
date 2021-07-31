package com.github.datastructureandalgorithm.datastructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {
        public int path;
        public int end;
        public Map<Character, TrieNode> next;

        public TrieNode() {
            this.end = 0;
            this.path = 0;
            next = new HashMap<>();
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
        if (word == null) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
            cur.path++;
        }
        cur.end++;
        size++;
    }

    /**
     * 查询单词 word 是否在 Trie 中
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        if (word == null) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null || cur.next.get(c).path == 0) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.end > 0;
    }

    /**
     * 从 Trie 中 删除 word
     *
     * @param word
     */
    public void remove(String word) {
        if (contains(word)) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur = cur.next.get(c);
                cur.path--;
            }
            cur.end--;
            size--;
        }
    }

    /**
     * 返回在 Trie 中有多少个以 prefix 为前缀的字符串
     *
     * @param prefix
     * @return
     */
    public int prefix(String prefix) {
        if (prefix == null) {
            return 0;
        }
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null || cur.next.get(c).path == 0) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return cur.path;
    }

    /**
     * 查询在 Trie 中是否有以 prefix 为前缀的单词
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        return prefix(prefix) > 0;
    }

    /**
     * 匹配查询：
     * <p>
     * 符号 "." 可以匹配任何字符
     * 例如输入 word = d..r
     * <p>
     * 如果 Trie 中包含字符串 deer，那么 d..r 就可以匹配到 deer，结果就会返回 true
     *
     * @param word
     * @return
     */
    public boolean match(String word) {
        return match(root, word, 0);
    }

    private boolean match(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.end > 0;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null || node.next.get(c).path == 0) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
