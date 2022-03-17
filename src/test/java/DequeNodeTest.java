import org.example.DequeNode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {


    private Integer item;
    private DequeNode<Integer> next;
    private DequeNode<Integer> previous;



    @BeforeEach
    public void setUp(){
        item = 3;
        next = null;
        previous=null;
    }

    public void finish(){
       item = null;
       next = null;
       previous= null;
    }


    @Test
    public void testSetNextReturnSetOK(){
        DequeNode<Integer> node = new DequeNode<Integer>(item,next,previous);
        DequeNode<Integer> expected = new DequeNode<Integer>(2,null,null);
        node.setNext(expected);
        assertEquals(node.getNext(),expected);
    }

    @Test
    public void testSetPreviousReturnSetOK(){
        DequeNode<Integer> node = new DequeNode<Integer>(item,next,previous);
        DequeNode<Integer> expected = new DequeNode<Integer>(2,null,null);
        node.setPrevious(expected);
        assertEquals(node.getPrevious(),expected);
    }

    @Test
    public void testSetItemReturnSetOK(){
        DequeNode<Integer> node = new DequeNode<>(item,next,previous);
        Integer expected = 4;
        node.setItem(expected);
        assertEquals(expected,node.getItem());

    }

    @Test
    public void testIsFirstNodeReturnTrue(){
        DequeNode<Integer> node = new DequeNode<>(item,next,null);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void testIsFirstNodeReturnFalse(){
        DequeNode<Integer> newNode = new DequeNode<>(item,next,previous);
        DequeNode<Integer> node = new DequeNode<>(2,next,newNode);
        assertFalse(node.isFirstNode());

    }

    @Test
    public void testIsLastNodeReturnTrue(){
        DequeNode<Integer> node = new DequeNode<>(item,null,previous);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void testIsLastNodeReturnFalse(){
        DequeNode<Integer> newNode = new DequeNode<>(item,next,previous);
        DequeNode<Integer> node = new DequeNode<>(2,newNode,previous);
        assertFalse(node.isLastNode());
    }

    @Test
    public void testIsNotATerminalNodeReturnTrue(){
        DequeNode<Integer> node = new DequeNode<>(item,next,previous);
        DequeNode<Integer> firstNode = new DequeNode<>(2,node,null);
        DequeNode<Integer> lastNode = new DequeNode<>(10,null,node);
        node.setPrevious(firstNode);
        node.setNext(lastNode);
        assertTrue(node.isNotATerminalNode());
    }

    @Test
    public void testIsNotATerminalNodeReturnFalseIfNoPreviousElement(){
        DequeNode<Integer> node = new DequeNode<>(item,null,null);
        DequeNode<Integer> lastNode = new DequeNode<>(10,null,node);
        node.setNext(lastNode);
        assertFalse(node.isNotATerminalNode());
    }

    @Test
    public void testIsNotATerminalNodeReturnFalseIfNoNextElement(){
        DequeNode<Integer> node = new DequeNode<>(item,null,null);
        DequeNode<Integer> lastNode = new DequeNode<>(10,null,node);
        node.setNext(lastNode);
        assertFalse(node.isNotATerminalNode());
    }

    @Test
    public void testConstructorIsOk(){
        DequeNode<Integer> node = new DequeNode<>(item,next,previous);
        assertEquals(node.getItem(),item);
        assertEquals(node.getPrevious(),previous);
        assertEquals(node.getNext(),next);
    }






}