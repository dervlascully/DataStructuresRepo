package projectCode20280.Practical_2_StacksAndQueues;

import projectCode20280.Practical_1_LinkedLists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedStack(){ // new stack relies on initially empty list
    }

    public int size(){
        return list.size();
    }

    public E top(){
        return list.first();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop(){
        return list.removeFirst();
    }

    public String toString(){
        return "top -> " + list.toString();
    }
}
