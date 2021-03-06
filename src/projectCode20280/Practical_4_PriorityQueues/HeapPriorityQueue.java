package projectCode20280.Practical_4_PriorityQueues;

import java.util.ArrayList;

import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 */

public class HeapPriorityQueue<K extends Comparable<K>,V extends Comparable<V>> extends AbstractPriorityQueue<K,V> {

    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the priority queue
     */
    public HeapPriorityQueue(Comparator<K> comp) { super(comp); }

    /**
     * Creates a priority queue initialized with the respective
     * key-value pairs.  The two arrays given will be paired
     * element-by-element. They are presumed to have the same
     * length. (If not, entries will be created only up to the length of
     * the shorter of the arrays)
     * @param keys an array of the initial keys for the priority queue
     * @param values an array of the initial values for the priority queue
     */
    public HeapPriorityQueue(K[] keys, V[] values){
        super();
        for(int j=0; j < Math.min(keys.length, values.length); j++){
            heap.add(new PQEntry<>(keys[j], values[j]));
        }

        heapify();
    }

    // protected utilities
    protected int parent(int j){
        return (j - 1)/2;
    }
    protected int left(int j){
        return (2*j) + 1;
    }
    protected int right(int j){
        return (2*j) + 2;
    }
    protected boolean hasLeft(int j){
        return (2*j) + 1 <= size() - 1;
    }
    protected boolean hasRight(int j){
        return (2*j) + 2 <= size() - 1;
    }

    /** Exchanges the entries at indices i and j of the array list. */
    protected void swap(int i, int j){
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /** Moves the entry at index j higher, if necessary, to restore the heap property. */
    protected void upheap(int j){
        while(j > 0){ // continue until reaching root
            int p = parent(j);
            if(compare(heap.get(j),heap.get(p)) >= 0) break; // heap properly verified
            swap(j, p);
            j = p; // continue from parent's location

        }
    }

    /** Moves the entry at index j lower, if necessary, to restore the heap property. */
    protected void downheap(int j){
        while(hasLeft(j)){ // continue to bottom (or break statement)
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if(hasRight(j)){
                int rightIndex = right(j);
                if(compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex; // right child is smaller
            }

            if(compare(heap.get(smallChildIndex), heap.get(j)) >= 0) break; // heap properly restored

            swap(j, smallChildIndex); // continue at position of child
            j = smallChildIndex;
        }
    }

    /** Performs a bottom-up construction of the heap in linear time. */
    protected void heapify(){
        int startIndex = parent(size() - 1);
        for(int j=startIndex; j>= 0; j--){ // start at parent of last entry
            downheap(j); // loop until processing the root
        }
    }

    // public methods

    /**
     * Returns the number of items in the priority queue.
     * @return number of items
     */
    @Override
    public int size() { return heap.size(); }

    /**
     * Returns (but does not remove) an entry with minimal key.
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K,V> min(){
        if(isEmpty()) return null;
        return heap.get(0); // min is the first element in the array
    }

    /**
     * Inserts a key-value pair and return the entry created.
     * @param key     the key of the new entry
     * @param value   the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this queue
     */
    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);   // add to the end of the list
        upheap(heap.size() - 1);  // upheap newly added list
        return newest;
    }

    /**
     * Removes and returns an entry with minimal key.
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K,V> removeMin(){
        if(heap.isEmpty()) return null;
        System.out.println("min " + heap.get(0).getKey() +" " + heap.get(heap.size() - 1).getKey());
        Entry<K, V> entry = heap.get(0);
        swap(0, heap.size() - 1); // put minimum at the end
        heap.remove(heap.size() - 1); // remove it from the list
        downheap(0); // fix new root
        return entry;
    }

    /** Used for debugging purposes only */
    private void sanityCheck() {
        for (int j=0; j < heap.size(); j++) {
            int left = left(j);
            int right = right(j);
            if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0)
                System.out.println("Invalid left child relationship");
            if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0)
                System.out.println("Invalid right child relationship");
        }
    }

    public String toString(){
        String s = "[";
        for(int i=0; i<heap.size(); i++){
            s += heap.get(i).getValue() + ", ";
        }

        s = s.substring(0, s.length() - 2);
        return s + "]";
    }
}
