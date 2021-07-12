package com.github.datastructureandalgorithm.datastructure.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListStackTest {

    @Test
    void push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        Assertions.assertEquals(stack.getSize(), 1);
    }

    @Test
    void pop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        Assertions.assertEquals(stack.peek(), 2);
        Assertions.assertEquals(stack.getSize(), 2);
    }

    @Test
    void peek() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        Assertions.assertEquals(stack.peek(), 1);
    }

    @Test
    void getSize() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        Assertions.assertEquals(stack.getSize(), 0);
        stack.push(1);
        Assertions.assertEquals(stack.getSize(), 1);
    }

    @Test
    void isEmpty() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testToString() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
//        Stack:
//        [9]
//        [8]
//        [7]
//        [6]
//        [5]
//        [4]
//        [3]
//        [2]
//        [1]
//        [0]
        System.out.println(stack.toString());
    }
}