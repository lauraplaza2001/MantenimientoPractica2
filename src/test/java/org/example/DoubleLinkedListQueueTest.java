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
        assertNull(queue.peekFirst());
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
        assertNull(queue.peekLast());
    }

    @Test
    public void testPeekLastReturnTheFirstElement(){
        DequeNode<Integer> newNode = new DequeNode(1,null,null);
        queue.append(newNode);
        DequeNode<Integer> obtained = queue.peekLast();
        assertEquals(newNode,obtained);
    }




    @Test
    public void testDeleteFirstDeleteElementCorrectly(){
        DequeNode<Integer> newNode = new DequeNode(1,null,null);
        DequeNode<Integer> node1 = new DequeNode(2,null,null);

        queue.append(newNode);
        queue.append(node1);
        queue.deleteFirst();

        int sizeExpected= 1;
        int sizeObtained = queue.size();
        assertEquals(sizeExpected,sizeObtained);
        assertEquals(queue.peekFirst().getItem(),node1.getItem());
    }

    @Test
    public void testDeleteFirstWhenThereIsOnlyOneElement(){
        DequeNode<Integer> newNode = new DequeNode(1,null,null);
        queue.append(newNode);
        queue.deleteFirst();

        int sizeExpected= 0;
        int sizeObtained = queue.size();

        assertEquals(sizeExpected,sizeObtained);
        assertNull(queue.peekFirst());
        assertNull(queue.peekLast());
    }

    @Test
    public void testDeleteLastWhenThereIsOnlyOneElement(){
        DequeNode<Integer> newNode = new DequeNode(1,null,null);
        queue.append(newNode);
        queue.deleteLast();

        int sizeExpected= 0;
        int sizeObtained = queue.size();

        assertEquals(sizeExpected,sizeObtained);
        assertNull(queue.peekFirst());
        assertNull(queue.peekLast());
    }




    @Test
    public void testDeleteLastThrowsExceptionIfSizeIsZero(){
        assertThrows(RuntimeException.class, ()->queue.deleteLast());
    }
    @Test
    public void testDeleteFirstThrowsExcepcionIfSizeIsZero(){
        assertThrows(RuntimeException.class, ()->queue.deleteFirst());
    }
    @Test
    public void testDeleteLastDeleteElementCorrectly(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);
        queue.deleteLast();


        int expectedSize = 1;
        int obtainedSize = queue.size();


        assertEquals(expectedSize,obtainedSize);
        assertEquals(queue.peekLast().getItem(),node1.getItem());

    }


    @Test
    public void testAppendInsertFirstNode(){
        DequeNode node1 = new DequeNode(3,null,null);
        queue.append(node1);
        int expected = 1;
        int obtained= queue.size();

        assertEquals(queue.peekLast(),node1);
        assertEquals(queue.peekFirst(),node1);
        assertEquals(expected,obtained);

    }

    @Test
    public void testAppendLeftInsertFirstNode(){
        DequeNode node1 = new DequeNode(3,null,null);
        queue.appendLeft(node1);
        int expected = 1;
        int obtained= queue.size();

        assertEquals(queue.peekLast(),node1);
        assertEquals(queue.peekFirst(),node1);
    }




    @Test
    public void testAppendInsertCorrectly(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.append(node1);
        queue.append(node2);

        int sizeExpected=2;
        int sizeObtained = queue.size();

        assertEquals(node1.getNext(),node2);
        assertEquals(node2.getPrevious(),node1);
        assertEquals(sizeExpected,sizeObtained);
    }


    @Test
    public void testAppendLeftInsertCorrectly(){
        DequeNode node1 = new DequeNode(3,null,null);
        DequeNode node2 = new DequeNode(5,null,null);

        queue.appendLeft(node1);
        queue.appendLeft(node2);

        int sizeExpected=2;
        int sizeObtained = queue.size();

        assertEquals(node2.getNext(),node1);
        assertEquals(node1.getPrevious(),node2);
        assertEquals(sizeExpected,sizeObtained);

    }


}