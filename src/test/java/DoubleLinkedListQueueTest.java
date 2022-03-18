import org.example.DequeNode;
import org.example.DoubleLinkedListQueue;
import org.junit.jupiter.api.BeforeAll;
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


}