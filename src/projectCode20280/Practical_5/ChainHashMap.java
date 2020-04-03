package projectCode20280.Practical_5;



import projectCode20280.Practical_4.Entry;

import java.util.ArrayList;

/*
 * Map implementation using hash table with separate chaining.
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    // a fixed capacity array of UnsortedTableMap that serve as buckets
    private UnsortedTableMap<K, V>[] table; // initialized within createTable


    /* Constructors: */

    /** Creates a hash table with capacity 11 and prime factor 109345121. */
    public ChainHashMap() {
        super();
    }

    /** Creates a hash table with given capacity and prime factor 109345121. */
    public ChainHashMap(int cap) {
        super(cap);
    }

    /** Creates a hash table with the given capacity and prime factor. */
    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    /** Creates an empty table having length equal to current capacity. */
    @Override
    @SuppressWarnings({ "unchecked" })
    protected void createTable() {

        /* bucket array - an array of unsorted table maps
        Java doesn't allow you to create the array with generic arguments,
        so create non generic unsorted table map and cast to the right type */

        table = (UnsortedTableMap<K, V>[])  new UnsortedTableMap[capacity];
    }

    /**
     * Returns value associated with key k in bucket with hash value h. If no such
     * entry exists, returns null.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return associate value (or null, if no such entry)
     */
    @Override
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        return bucket == null ? null : bucket.get(k);

        /*
        table is an array of Unsorted Table Maps
        h is a hash value
        table[h] returns the Unsorted Table Map at position h. We call this bucket
        return the value with key k in this bucket.
        if bucket is null return null.
         */
    }

    /**
     * Associates key k with value v in bucket with hash value h, returning the
     * previously associated value, if any.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @param v the value to be associated
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K, V> bucket = table[h];

        // no bucket at that position
        if(bucket == null){
            bucket = new UnsortedTableMap<K, V>(); // create a new bucket
            table[h] = bucket; // add the bucket to the table at position h
        }
        int prev_size = bucket.size();

        V old = bucket.put(k, v);

        n += (bucket.size() - prev_size); // n == size of hash table

        return old;
    }

    /**
     * Removes entry having key k from bucket with hash value h, returning the
     * previously associated value, if found.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];

        if(bucket == null) // no bucket at position h
            return null;

        int prev_size = bucket.size();
        V old = bucket.remove(k);

        n -= (prev_size - bucket.size());
        return old;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        /*
        for each element in unsorted table map
            for each element in bucket
                print element
         */

        ArrayList<Entry<K, V>> res = new ArrayList<Entry<K, V>>();
        for(int i=0; i<capacity; i++){
            UnsortedTableMap<K, V> bucket = table[i];
            if(bucket != null){
                for(Entry<K, V> entry : bucket.entrySet()) { // this calls entry set from the UTM class
                    res.add(entry);
                }
            }
        }

        return res; // returns the iterable ArrayList
    }

    public String toString(){
        return entrySet().toString(); // entrySet returns an ArrayList
    }

    public static void main(String[] args) {


        ChainHashMap<Integer, String> m = new ChainHashMap<Integer, String>();
        System.out.println("\nSize: " + m.size());
        System.out.println(m);
        m.put(1, "One");
        m.put(2, "Two");
        m.put(3, "Three");
        System.out.println("Size: " + m.size());
        System.out.println(m);
        m.remove(3);
        System.out.println("Size: " + m.size());
        System.out.println(m);




    }
}
