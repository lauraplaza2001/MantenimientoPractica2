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
        if (node.getPrevious()!= null || node.getNext() != null) throw new RuntimeException("node must not be linked");

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
        if (node.getPrevious()!= null || node.getNext() != null) throw new RuntimeException("node must not be linked");

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
        }else {
           firstNode.setItem(firstNode.getNext().getItem());
           firstNode.setPrevious(null);
           firstNode.setNext(firstNode.getNext());
        }
        size--;

    }


    @Override
    public void deleteLast() {
        if (this.size() <=0) throw new RuntimeException("size is 0");

        if (this.size == 1){
            firstNode= null;
            lastNode  = null;


        }else {
            lastNode.setItem(lastNode.getPrevious().getItem());
            lastNode.setNext(null);
            lastNode.setPrevious(lastNode.getPrevious().getPrevious());
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
        if (position < 0 || position > this.size) throw new RuntimeException("Index out of bounds");
        DequeNode sol = firstNode;

        int i = 0;
        while (i< position) { // si position es 0, no entra en el while
               sol = sol.getNext();
               i++;
        }

        return sol;
    }

    @Override
    public DequeNode find(Object item) {

        int i = 0;
        DequeNode node = firstNode;

        while (i< this.size && !item.equals(node.getItem())){ // si position es 0, no entra en el while
            node = node.getNext();
            i++;
        }


        if (i >= this.size){
            node = null;
        }

        return node;

    }

    @Override
    public void delete(DequeNode node) {


        if (find(node.getItem()) == null) throw new RuntimeException("node not in list");
        if (node.getNext() == null) this.deleteLast();
        else if (node.getPrevious() == null) this.deleteFirst();
        else{
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            this.size--;
        }





        //Limpiar nodo
        /*
        nodeToDelete.setPrevious(null);
        nodeToDelete.setNext(null);
        node.setItem(null);
        */


    }

    @Override
    public void sort(Comparator comparator) {


    }


}

