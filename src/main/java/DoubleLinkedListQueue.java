import org.example.DoubleEndedQueue;


public class DoubleLinkedListQueue <T> implements DoubleEndedQueue {

    private DequeNode [] Nodes;

    public DoubleLinkedListQueue(T item){
        if (item == null) throw new RuntimeException("Not null item");
        DequeNode node = new DequeNode(item,null,null); //first Node in the list
        this.append(node);

    }

    @Override
    public void append(DequeNode node) {

    }

    @Override
    public void appendLeft(DequeNode node) {

    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public DequeNode peekFirst() {
        return null;
    }

    @Override
    public DequeNode peekLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
