package org.example;

import org.example.DoubleEndedQueue;

import java.util.ArrayList;
import java.util.Comparator;


public class DoubleLinkedListQueue <T> implements DoubleEndedQueue {


    private DequeNode firstNode;
    private DequeNode lastNode;
    private int size;



    public DoubleLinkedListQueue(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public void append(DequeNode node) {

        //Node item cant be null even if it has other nodes attached/linked to it.
        if (node.getItem() == null) throw new RuntimeException("node cant be null");

         if ( size == 0){
            firstNode = node;
            lastNode = node;

        }else{
            DequeNode oldLastNode = lastNode;

            oldLastNode.setNext(node);
            node.setPrevious(oldLastNode);
            lastNode = node;
        }
        size++;

    }

    @Override
    public void appendLeft(DequeNode node) {
        //Node item cant be null even if it has other nodes attached/linked to it.
        if (node.getItem() == null) throw new RuntimeException("node cant be null");

        if (size == 0){
            firstNode = node;
            lastNode = node;

        }else{
            DequeNode oldFirstNode = firstNode;

            oldFirstNode.setPrevious(node);
            node.setNext(oldFirstNode);
            firstNode = node;
        }
        size++;
    }



    @Override
    public void deleteFirst() {
        if (this.size() <=0) throw new RuntimeException("size is 0");
        if (this.size == 1){
            firstNode = null;
            lastNode = null;

        }else{
            DequeNode oldFirstNode = firstNode;
            DequeNode newFirstNode = firstNode.getNext();

            newFirstNode.setPrevious(null); //Now is first node
            this.firstNode = newFirstNode;
            deleteNode(oldFirstNode); //clean memory
        }
        size--;

    }




    @Override
    public void deleteLast() {
        if (this.size() <=0) throw new RuntimeException("size is 0");
        if (this.size == 1 ){
            firstNode = null;
            lastNode = null;
        }else{
            DequeNode  oldLastNode = lastNode;
            DequeNode  newLastNode = lastNode.getPrevious();

            newLastNode.setNext(null); //Now is last node
            this.lastNode = newLastNode;
            deleteNode(oldLastNode); //clean memory
        }
        size--;
    }

    @Override
    public DequeNode peekFirst() {

        return firstNode;
    }

    @Override
    public DequeNode peekLast() {
        return lastNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode getAt(int position) {
        return null;
    }

    @Override
    public DequeNode find(Object item) {
        return null;

    }

    @Override
    public void delete(DequeNode node) {

    }

    @Override
    public void sort(Comparator comparator) {

    }

    //PRIVATE METHODS

    private void deleteNode(DequeNode node){
        node.setNext(null);
        node.setPrevious(null);
        node.setItem(null);
    }

}

