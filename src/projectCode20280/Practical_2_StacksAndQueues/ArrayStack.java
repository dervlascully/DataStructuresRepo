package projectCode20280.Practical_2_StacksAndQueues;

public class ArrayStack<E> implements Stack<E>{

    public static final int CAPACITY = 1000; // default array capacity

    private E[] data; // generic array used for storage
    private int t = -1; // index of top element in stack
    private int cap;

    public ArrayStack() {
        this(CAPACITY); // Constructs stack with default capacity
    }

    @SuppressWarnings({"unchecked"})
    public ArrayStack(int capacity) { // constructs stack with a given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
        this.cap = capacity;
    }


    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public int size() {
        return (t + 1);
    }

    public void push(E element) {
//        if (size() == CAPACITY)
//            return StackFullError;
//            return;

//        else {
            t++;
            data[t] = element;
//        }
    }

    public E pop() {
        if (isEmpty())
            return null;

        else {
            E temp = data[t];
            data[t] = null; // not sure if i need to do this
            t--;
            return temp;
        }
    }

    public String toString(){
        String str = "top -> ";
        for(int i=t; i>=0; i--)
            str += (data[i] + " ");
        return str;
    }

    public int getCapacity(){
        return this.cap;
    }

}
