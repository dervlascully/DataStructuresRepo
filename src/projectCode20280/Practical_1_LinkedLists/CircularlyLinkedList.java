package projectCode20280.Practical_1_LinkedLists;

import java.util.Iterator;

public class CircularlyLinkedList<E>  implements Iterable<E>, List<E>{

    private static class Node<E> {

        // Each node holds an element and a reference to the next node

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        /* Constructor:
        Creates a node with a given element and next node.
         */
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        // Accessor methods

        // returns an object of type E - the element / data
        public E getElement(){
            return this.element;
        }

        // returns an object of type Node - the next node
        public Node<E> getNext(){
            return next;
        }

        // modifier method
        // modifies the next node which the current node points to
        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    Node<E> tail = null;
    int size = 0;

    public CircularlyLinkedList (){

    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public E first(){
        if(isEmpty()) return null;

        return tail.getNext().getElement();
    }

    public E last(){
        if(isEmpty()) return null;

        return tail.getElement();
    }

    public void rotate(){
        if(tail!= null)
            tail = tail.getNext();
    }

    public void addFirst(E element){
        if(isEmpty()){
            tail = new Node<E>(element, null);
            tail.setNext(tail);
        }

        else{
            Node<E> newest = new Node<E>(element, tail.getNext());
            tail.setNext(newest);
        }

        size++;
    }

    public void addLast(E element){
        addFirst(element);
        tail = tail.getNext();
    }

    public E removeFirst(){
        if(isEmpty()) throw new RuntimeException("Cannot remove node: list is empty.");

        Node<E> head = tail.getNext();
        E temp = head.getElement();

        if(head == tail)
            tail = null;

        else{
            tail.setNext(head.getNext());
        }

        size--;
        return temp;
    }

    public E removeLast(){
        if(isEmpty()) throw new RuntimeException("Cannot remove node: list is empty.");

//        Node<E> current = tail.getNext();
////        E temp = current.getElement();
////        while(current.getNext() != tail)
////            current = current.getNext();
////
////        current.setNext(tail.getNext());
////        tail = current;
////        size--;
////        return temp;

        Node<E> current = tail.getNext();
        E temp = tail.getElement();
        while(current.getNext() != tail) // we want current to get to the node before the last node
            current = current.getNext();

        current.setNext(tail.getNext());
        tail = current;
        size --;
        return temp;
    }

    public String toString(){
        String str = "[";

        Iterator<E> it =  new ListIterator();

        for(int i=0; i<size; i++){
            E element = it.next();
            str += element + ", ";
        }
        str = str.substring(0, str.length()-2);

        return str + "]";
    }

    public void add(int position, E element){
        Node current = tail.getNext();

        if(position > size) {
            throw new RuntimeException("Cannot add node. Position out of bounds.");
        }

        if(position == 0)
            addFirst(element);

        if(position == size){
            addLast(element);
        }

        else{
            for(int i=1; i<position; i++){
                current = current.next;
            }

            Node newNode = new Node(element, current.next);
            current.next = newNode;
            size++;

        }

    }

    public E remove(int position){

        if (position > size-1) {
            throw new RuntimeException("Cannot remove node. Position out of bounds.");
        }

        if(position == 0){
            return removeFirst();
        }

        if(position == size - 1){
            return removeLast();
        }

        Node<E> current = tail.getNext();
        Node<E> previous = null;

        for(int i=0; i<position; i++){
                previous = current;
                current = current.getNext(); }

        E temp = current.getElement();
        previous.setNext(current.getNext());
        size --;
        return temp;
    }

    public E get(int position){
        if(position > size-1) {
            throw new RuntimeException("Error - index out of bounds."); }

        Node<E> current = tail.getNext();


        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.getElement();
    }








    public Iterator<E> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
        Node current;

        public ListIterator(){
            current = tail.getNext();
        }


        public boolean hasNext(){
            return current != null;
        }

        @Override
        public E next(){
            E res = (E) current.getElement();
            current = current.getNext();
            return res;
        }
    }

}

