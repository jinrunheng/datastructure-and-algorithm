package com.github.datastructureandalgorithm.datastructure.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void push() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(stack.peek(), 1);
    }

    @Test
    void pop() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int i = 3; i >= 1; i--) {
            Assertions.assertEquals(i, stack.pop());
        }
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void peek() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        Assertions.assertEquals(1, stack.peek());
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void getSize() {
        Stack<Integer> stack = new ArrayStack<>();
        Assertions.assertEquals(0, stack.getSize());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        Assertions.assertEquals(10, stack.getSize());
    }

    @Test
    void isEmpty() {
        Stack<Integer> stack = new ArrayStack<>();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testToString() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        Stack：
//        [3]
//        [2]
//        [1]
        System.out.println(stack);
    }
}