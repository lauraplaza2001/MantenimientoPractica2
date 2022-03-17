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
        DequeNode<Integer> nodo = new DequeNode<>(1,null,null);
    }

    public void finish(){
       item = null;
       next = null;
       previous= null;
    }


    @Test
    public void testSetNextReturnSetOK(){
        DequeNode<Integer> node = new DequeNode<Integer>(item,next,previous);
        DequeNode<Integer> newNode = new DequeNode<Integer>(2,null,null);
        node.setNext(newNode);
        assertEquals(next,newNode);
    }

    @Test
    public void testSetPreviousReturnSetOK(){
        DequeNode<Integer> node = new DequeNode<Integer>(item,next,previous);
        DequeNode<Integer> newNode = new DequeNode<Integer>(2,null,null);
        node.setPrevious(newNode);
        assertEquals(previous,newNode);
    }

    @Test
    public void testSetItemReturnSetOK(){
        DequeNode<Integer> node = new DequeNode<>(item,next,previous);
        Integer i = 4;
        node.setItem(i);
        assertEquals(i,item);
    }

    @Test
    public void testIsFirstNodeReturnTrue(){
        DequeNode<Integer> node = new DequeNode<>(item,next,null);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void testIsFirstNodeReturnFalse(){

        DequeNode<Integer> node = new DequeNode<>(item,next,previous);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void testIsLastNodeReturnTrue(){
        DequeNode<Integer>
        DequeNode<Integer> node = new DequeNode<>(item,null,previous);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void testIsLastNodeReturnFalse(){
        DequeNode<Integer> node = new DequeNode<>(item,null,previous);
        assertTrue(node.isFirstNode());
    }










}