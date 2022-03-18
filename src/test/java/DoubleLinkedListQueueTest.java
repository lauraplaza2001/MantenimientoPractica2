import org.example.DequeNode;
import org.example.DoubleLinkedListQueue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
   DoubleLinkedListQueue queue ;

    @BeforeAll
    public void setUp(){
        queue = new DoubleLinkedListQueue<>();

    }
    public  void finish(){
        queue = null;
    }

    @Test
    public void testSizeReturnZeroIfEmptyQueue(){
        DoubleLinkedListQueue queue = new DoubleLinkedListQueue();
        int expected =0;
        int obtained = queue.size();
        assertEquals(expected,obtained);
    }

    @Test
    public void testSizeReturnTheSizeIfNotEmptyQueue(){
        DoubleLinkedListQueue queue = new DoubleLinkedListQueue();
        queue.append(new DequeNode(3,null,null));
        int expected = 1;
        int obtained= queue.size();
        assertEquals(obtained,expected);
    }


}