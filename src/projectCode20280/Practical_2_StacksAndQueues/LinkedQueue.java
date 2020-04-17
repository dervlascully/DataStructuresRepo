package projectCode20280.Practical_2_StacksAndQueues;


import projectCode20280.Practical_1_LinkedLists.CircularlyLinkedList;

public class LinkedQueue<E> implements Queue<E> {


    CircularlyLinkedList<E> queue = new CircularlyLinkedList<>();

    public LinkedQueue(){
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E first() {
        return queue.first();
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new RuntimeException("Cannot deque: list is empty.");
        return queue.removeFirst();
    }

    public String toString(){
        return queue.toString();
    }

}
