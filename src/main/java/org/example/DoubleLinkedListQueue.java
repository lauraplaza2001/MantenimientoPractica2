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
     //   if ((node.getItem() instanceof T)= false ) throw

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
        DequeNode node = this.firstNode;
        if (this.size == 1){
            firstNode = null;
            lastNode = null;
        }else {
            firstNode = firstNode.getNext();
            firstNode.setPrevious(null);
        }

        size--;

        //Desconectado de la lista
        node.setNext(null);
        node.setPrevious(null);

    }


    @Override
    public void deleteLast() {
        if (this.size() <=0) throw new RuntimeException("size is 0");
        DequeNode node = lastNode;
        if (this.size == 1){
            firstNode= null;
            lastNode  = null;


        }else {
            lastNode = lastNode.getPrevious();
            lastNode.setNext(null);
        }
        size--;

        //Desconectado de la lista
        node.setNext(null);
        node.setPrevious(null);

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


        //Lo desconectado de la lista

        node.setPrevious(null);
        node.setNext(null);



    }

    @Override
    public void sort(Comparator comparator) {
        try {
            DoubleLinkedListQueue sortedList = new DoubleLinkedListQueue();
            int initialSize = this.size;
            for (int i =0; i < initialSize; i++){ //  Por cada elemento de la nueva lista, vamos a ir insertando los mas peque??os
                DequeNode menor = this.firstNode;
                int j = 0;

                while (j < this.size()){ //Se podr??a sacar fuera por simplicidad
                    DequeNode newNode = this.getAt(j);
                    if (comparator.compare(menor.getItem(),newNode.getItem()) > 0){ // entiendo que da > 0 si el primer elemento es mayor que el segundo
                        menor = newNode;
                    }
                    j++;
                } //Obtengo el nodo menor

                this.delete(menor); //borro el nodo menor de la lista, la funci??n de borrado se encarga de quitar los enlaces del nodo
                sortedList.append(menor);// inserto el nodo menor en la lista ordenada

            }

            //Tendr?? al final la lista vac??a y la lista sortedList llena con los elementos pero de menor a mayor, los inserto de nuevo en la lista

            for (int i = 0; i < sortedList.size(); i++) {//Se podr??a sacar fuera por simplicidad
                DequeNode node = sortedList.getAt(i);
                sortedList.delete(node); //Se borra de sortedList lo que libera sus enlaces
                this.append(node); //Lo inserto correctamente donde corresponde
            }



        } catch (ClassCastException e) {
            throw new RuntimeException("ERROR, wrong comparator");
        }


    }
}

