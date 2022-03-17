import org.example.DoubleEndedQueue;

import java.util.ArrayList;


public class DoubleLinkedListQueue <T> implements DoubleEndedQueue {

    private ArrayList <DequeNode<T>> nodes;

    public DoubleLinkedListQueue(){
      nodes = new ArrayList();
    }

    @Override
    public void append(DequeNode node) {
        if (node.getItem() != null )nodes.add(node);
    }



    @Override
    public void appendLeft(DequeNode node) {
        if (node.getItem() != null){
            DequeNode oldFirstNode = nodes.get(0);
             node.setNext(oldFirstNode);
             oldFirstNode.setPrevious(node);

        }
    }

    @Override
    public void deleteFirst() {
        if (this.size() >0){
            DequeNode oldFirstNode = nodes.get(0);
            DequeNode newFirstNode = nodes.get(1);

            newFirstNode.setPrevious(null); //Now is first node
            nodes.remove(0); //the array starts in the new first node
            deleteNode(oldFirstNode); //clean memory
        }

    }
    private void deleteNode(DequeNode node){
        node.setNext(null);
        node.setPrevious(null);
        node.setItem(null);
    }

    @Override
    public void deleteLast() {
        if (this.size() >0){
           DequeNode  oldLastNode = nodes.get(nodes.size());
           DequeNode  newLastNode = nodes.get(nodes.size()-1);

            newLastNode.setNext(null); //Now is last node
            nodes.remove(nodes.size()); //the array finish in the new last node
            deleteNode(oldLastNode); //clean memory
        }
    }

    @Override
    public DequeNode peekFirst() {
        DequeNode sol = new DequeNode(null,null,null);
        if (this.size()>0) {
             sol = nodes.get(0);
        }

        return sol;
    }

    @Override
    public DequeNode peekLast() {
        DequeNode sol = new DequeNode(null,null,null);
        if (this.size()>0) {
            sol = nodes.get(this.size());
        }

        return sol;
    }

    @Override
    public int size() {
        return nodes.size();
    }
}
