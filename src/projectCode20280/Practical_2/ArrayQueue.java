package projectCode20280.Practical_2;

public class ArrayQueue<E> implements Queue<E> {


    public static final int CAPACITY = 1000;
    int front = -1;
    int rear = -1;
    E arrayQueue[];

    public ArrayQueue() {
        this(CAPACITY); // Constructs stack with default capacity
    }

    @SuppressWarnings({"unchecked"})
    public ArrayQueue(int capacity) { // constructs stack with a given capacity
        arrayQueue = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }



    @Override
    public int size() {
        if(isEmpty())
            return 0;

        return this.rear - this.front + 1;
    }

    @Override
    public boolean isEmpty() {
        return (this.front == -1 && this.rear == -1);
    }

    @Override
    public void enqueue(E e) {
        if(isFull())
            throw new RuntimeException("Cannot add to queue: queue is full");

        if(isEmpty())
            front = 0; // rear will be zero too as we are incrementing below

        arrayQueue[rear + 1] = e;
        rear++;

    }

    @Override
    public E first() {
        return arrayQueue[front];
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new RuntimeException("Cannot remove from queue: queue is empty");

        if(front == rear){ // one element
            E temp = arrayQueue[front];
            front = -1;
            rear = -1;
            return temp;
        }
        front++;
        return arrayQueue[front - 1];
    }

    public boolean isFull(){
        return this.size() >= CAPACITY;
    }

    public String toString(){
        String str = "front -> ";
        for(int i = front; i<= rear; i++){
            str += arrayQueue[i] + " ";
        }

        return str + " <- rear";
    }
}
