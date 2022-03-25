package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    private DoubleLinkedListQueue<Integer> queue ;


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
        assertEquals(queue.peekFirst(),node1);
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
        assertEquals(queue.peekLast(),node1);

    }


    @Test
    public void testAppendANodeWithOtherNodesLinkedRaiseExcepcion(){
        DequeNode<Integer> node1 = new DequeNode<>(1,new DequeNode<>(3,null,null),null);
        assertThrows(RuntimeException.class, () -> queue.append(node1));
    }

    @Test
    public void testAppendLeftANodeWithOtherNodesLinkedRaiseExcepcion(){
        DequeNode<Integer> node1 = new DequeNode<>(1,new DequeNode<>(3,null,null),null);
        assertThrows(RuntimeException.class, () -> queue.appendLeft(node1));
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

    @Test
    public void testGetAtPositionSmallerThan0RaiseAnException(){
        assertThrows(RuntimeException.class, () -> queue.getAt(-2));
    }

    @Test
    public void testGetAtPositionGreaterThanSizeRaiseAnException(){
        queue.append(new DequeNode<>(1,null,null));
        assertThrows(RuntimeException.class, () -> queue.getAt(5));
    }

    @Test
    public void testGetAtPositionReturnCorrectly(){ // index start in 0
        DequeNode<Integer> expected = new DequeNode<>(1,null,null);
        queue.append(expected);
        assertEquals(queue.getAt(0),expected);
    }

    @Test
    public void testFindItemNotFoundReturnNull(){
        DequeNode<Integer> newNode = new DequeNode<>(1,null,null);
        assertNull(queue.find(newNode));
    }

    @Test
    public void testFindItemReturnTheItem(){
        DequeNode<Integer> newNode = new DequeNode<>(1,null,null);
        queue.append(newNode);
        assertEquals(newNode,queue.find(newNode.getItem()));
    }

    @Test
    public void testDeleteANodeNotFoundRaiseAnException(){
        DequeNode<Integer> newNode = new DequeNode<>(1,null,null);
        assertThrows(RuntimeException.class,()-> queue.delete(newNode));
    }

    @Test
    public void testDeleteANodeWhichIsTheFirstDoItCorrectly(){
        DequeNode<Integer> newNode = new DequeNode<>(1,null,null);
        DequeNode<Integer> newNode2 = new DequeNode<>(2,null,null);

        queue.append(newNode);
        queue.append(newNode2);

        queue.delete(newNode);

        assertEquals(queue.peekFirst(),newNode2);


    }

    @Test
    public void testDeleteANodeWhichIsTheLastDoItCorrectly(){
        DequeNode<Integer> newNode = new DequeNode<>(1,null,null);
        DequeNode<Integer> newNode2 = new DequeNode<>(2,null,null);

        queue.append(newNode);
        queue.append(newNode2);

        queue.delete(newNode2);

        assertEquals(queue.peekFirst(),newNode);
    }


    @Test
    public void testDeleteANodeNotFirstNotLastDoItCorrectly(){
        DequeNode<Integer> newNode = new DequeNode<>(1,null,null);
        DequeNode<Integer> newNode2 = new DequeNode<>(2,null,null);
        DequeNode<Integer> newNode3 = new DequeNode<>(3,null,null);

        queue.append(newNode);
        queue.append(newNode2);
        queue.append(newNode3);

        queue.delete(newNode2);

        assertEquals(newNode.getNext(),newNode3);
        assertEquals(newNode3.getPrevious(),newNode);
    }

    @Test
    public void testSort() {
        DequeNode<Integer> newNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> newNode2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> newNode3 = new DequeNode<>(3, null, null);

        queue.append(newNode3);
        queue.append(newNode);
        queue.append(newNode2);

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n = 0;
                if (o1 > o2) n = 1;
                else if (o1 < o2) n = -1;

                return n;
            }
        };

        queue.sort(c);

        // mientras haya elementos, comparamos
        for (int i = 0; i < queue.size() - 1; i++) {
            int expected = 1;

            assertTrue(c.compare((Integer) queue.getAt(i + 1).getItem(), (Integer) queue.getAt(i).getItem()) >= 0);
        }
    }


    //Se supone que no debe pasarse nunca un comparador que no sea capaz de comparar los elemntos de la lista
    //Por si acaso
    @Test
    public void testSortWithWrongComparator() {
        DequeNode<Integer> newNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> newNode2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> newNode3 = new DequeNode<>(3, null, null);

        queue.append(newNode3);
        queue.append(newNode);
        queue.append(newNode2);


        Comparator<String> c = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                int res = 0;
                if (o1.compareTo(o2) > 0) res = 1;
                else if (o1.compareTo(o2) < 0) res =-1;

                return res;
            }
        };

        assertThrows(RuntimeException.class, () -> queue.sort(c));
    }
}
