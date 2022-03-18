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

        if (node.getItem() != null){

            if ( size == 0){
                setFirstNode(node);
                setLastNode(node);

            }else{
                DequeNode oldLastNode = lastNode;

                oldLastNode.setNext(node);
                node.setPrevious(oldLastNode);
                setLastNode(node);
            }
        }

    }
    private void  setLastNode(DequeNode node){
        size++;
        if (node.getNext() != null){
            this.lastNode = node;
        } else{
            setLastNode(node.getNext());
        }
    }


    @Override
    public void appendLeft(DequeNode node) {
        if (node.getItem() != null){
            if (size == 0){
                setFirstNode(node);
                setLastNode(node);

            }else{
                DequeNode oldFirstNode = firstNode;

                oldFirstNode.setPrevious(node);
                node.setNext(oldFirstNode);
                setFirstNode(node);
            }


        }
    }
    private void  setFirstNode(DequeNode node){
        size++;
        if (node.getPrevious() != null){
            this.lastNode = node;
        } else{
            setLastNode(node.getPrevious());
        }
    }
    @Override
    public void deleteFirst() {
        if (this.size() >0){
            DequeNode oldFirstNode = firstNode;
            DequeNode newFirstNode = firstNode.getNext();

            newFirstNode.setPrevious(null); //Now is first node
            deleteNode(oldFirstNode); //clean memory
        }
        size--;

    }
    private void deleteNode(DequeNode node){
        node.setNext(null);
        node.setPrevious(null);
        node.setItem(null);
    }

    @Override
    public void deleteLast() {
        if (this.size() >0){
           DequeNode  oldLastNode = lastNode;
           DequeNode  newLastNode = lastNode.getPrevious();

            newLastNode.setNext(null); //Now is last node
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
}
