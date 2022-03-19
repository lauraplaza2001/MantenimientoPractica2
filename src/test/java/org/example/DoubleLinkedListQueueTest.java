package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    private DoubleLinkedListQueue queue ;

    @BeforeEach
    public void setUp(){
        queue = new DoubleLinkedListQueue<>();

    }
    public  void finish(){
        queue = null;
    }

    @Test
    public void testSizeReturnZeroIfEmptyQueue(){

        int expected =0;
        int obtained = queue.size();
        assertEquals(expected,obtained);
    }

    @Test
    public void testSizeReturnTheSizeIfNotEmptyQueue(){

        queue.append(new DequeNode(3,null,null));
        int expected = 1;
        int obtained= queue.size();
        assertEquals(obtained,expected);
    }
    @Test
    public void testPeekFirstReturnNullIfEmptyQueue(){
        assertEquals(null,queue.peekFirst());
    }

    @Test
    public void testPeekFirstReturnTheFirstElement(){
        DequeNode<Integer> newNode = new DequeNode(1,null,null);
        queue.append(newNode);
        DequeNode<Integer> obtained = queue.peekFirst();
        assertEquals(newNode,obtained);
    }

    @Test
    public void testPeekLastReturnNullIfEmptyQueue(){
        assertEquals(null,queue.peekLast());
    }

    @Test
    public void testPeekLastReturnTheFirstElement(){
        DequeNode<Integer> newNode = new DequeNode(1,null,null);
        queue.append(newNode);
        DequeNode<Integer> obtained = queue.peekLast();
        assertEquals(newNode,obtained);
    }

















    @Test
    public void testDeleteLastThrowsExcepcionIfSizeIsZero(){
        assertThrows(RuntimeException.class, ()->queue.deleteLast());
    }
    @Test
    public void testDeleteFirstThrowsExcepcionIfSizeIsZero(){
        assertThrows(RuntimeException.class, ()->queue.deleteFirst());
    }
    @Test
    public void testDeleteLastWorksCorrectly(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);
        assertEquals(queue.peekFirst(),node1);

    }
    @Test
    public void testDeleteLastDecreasesSize(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);

        int expectedSize = 1;
        queue.deleteLast();
        assertEquals(expectedSize,queue.size());
    }
    @Test
    public void testDeleteFirstDecreasesSize(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);

        int expectedSize = 1;
        queue.deleteFirst();
        assertEquals(expectedSize,queue.size());
    }
    public void testAppendNodeAlreadyLinked(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        //Linked nodes
        node1.setItem(node2);
        node2.setPrevious(node1);

        assertThrows(RuntimeException.class, ()->queue.append(node1));

    }

    // --append
    @Test
    public void testAppendInsertFirstNode(){
        DequeNode node1 = new DequeNode(3,null,null);
        queue.append(node1);

        assertEquals(queue.peekLast(),node1);
        assertEquals(queue.peekFirst(),node1);

    }
    @Test
    public void testAppendInsertsNodeAtTheEnd(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);

        assertEquals(queue.peekLast(),node2);
    }
    @Test
    public void testAppendSizeIncrementsCorrectly(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);
        int expectedValue = 1;

        queue.append(node1);
        assertEquals(expectedValue,queue.size());

        queue.append(node2);
        expectedValue = 2;
        assertEquals(expectedValue,queue.size());
    }

    @Test
    public void testAppendNodeConections(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);

        assertEquals(node1.getNext(),node2);
        assertEquals(node2.getPrevious(),node1);

    }
    //--appendLeft
    @Test
    public void testAppendLeftInsertFirstNode(){
        DequeNode node1 = new DequeNode(3,null,null);
        queue.appendLeft(node1);

        assertEquals(queue.peekLast(),node1);
        assertEquals(queue.peekFirst(),node1);

    }
    @Test
    public void testAppendLeftInsertsNodeAtTheBeginning(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.appendLeft(node1);
        queue.appendLeft(node2);

        assertEquals(queue.peekFirst(),node2);
    }
    @Test
    public void testAppendLeftSizeIncrementsCorrectly(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);
        int expectedValue = 1;

        queue.appendLeft(node1);
        assertEquals(expectedValue,queue.size());

        queue.appendLeft(node2);
        expectedValue = 2;
        assertEquals(expectedValue,queue.size());
    }

    @Test
    public void testAppendLeftNodeConections(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.appendLeft(node1);
        queue.appendLeft(node2);

        assertEquals(node2.getNext(),node1);
        assertEquals(node1.getPrevious(),node2);

    }

    @Test
    public void testAppendLeftNodeAlreadyLinked(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        //Linked nodes
        node1.setItem(node2);
        node2.setPrevious(node1);

        assertThrows(RuntimeException.class, ()->queue.appendLeft(node1));

    }

}