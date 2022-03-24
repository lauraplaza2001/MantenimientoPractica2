package org.example;

import org.example.DequeNode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {


    private DequeNode<Integer> dequeNode;



    @BeforeEach
    public void setUp(){
        dequeNode  = new DequeNode<>(1,null,null);
    }

    public void finish(){
        dequeNode = null;
    }


    @Test
    public void testSetNextReturnSetOK(){
        DequeNode<Integer> expected = new DequeNode<Integer>(2,null,null);
        dequeNode.setNext(expected);

        assertEquals(dequeNode.getNext(),expected);
    }

    @Test
    public void testSetPreviousReturnSetOK(){
        DequeNode<Integer> expected = new DequeNode<Integer>(2,null,null);
        dequeNode.setPrevious(expected);
        assertEquals(dequeNode.getPrevious(),expected);
    }

    @Test
    public void testSetItemReturnSetOK(){
        Integer expected = 4;
        dequeNode.setItem(expected);
        assertEquals(expected,dequeNode.getItem());

    }

    @Test
    public void testIsFirstNodeReturnTrue(){
        assertTrue(dequeNode.isFirstNode());
    }

    @Test
    public void testIsFirstNodeReturnFalse(){

        DequeNode<Integer> node = new DequeNode<>(2,null,dequeNode);
        dequeNode.setNext(node);
        assertFalse(node.isFirstNode());

    }

    @Test
    public void testIsLastNodeReturnTrue(){
        assertTrue(dequeNode.isLastNode());
    }

    @Test
    public void testIsLastNodeReturnFalse(){
        DequeNode<Integer> newNode = new DequeNode<>(2,null,null);
        dequeNode.setNext(newNode);
        assertFalse(dequeNode.isLastNode());
    }

    @Test
    public void testIsNotATerminalNodeReturnTrue(){

        DequeNode<Integer> firstNode = new DequeNode<>(2,dequeNode,null);
        DequeNode<Integer> lastNode = new DequeNode<>(10,null,dequeNode);
        dequeNode.setNext(lastNode);
        dequeNode.setPrevious(firstNode);
        assertTrue(dequeNode.isNotATerminalNode());
    }

    @Test
    public void testIsNotATerminalNodeReturnFalseIfNoPreviousElement(){
        assertFalse(dequeNode.isNotATerminalNode());
    }








}