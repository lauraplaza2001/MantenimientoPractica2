import org.example.DequeNode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {
    private T item;
    private DequeNode<T> next;
    private DequeNode<T> previous;

    @BeforeEach
    public void setUp(){
        next = null;
        previous= null;
        item = null;
    }

    public void finish(){
        next = null;
        previous = null;
        item = null;
    }


    @Test
    public void testGetItemReturnItem(){
        assertEquals(item, );
    }











}