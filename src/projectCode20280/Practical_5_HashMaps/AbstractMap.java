package projectCode20280.Practical_5_HashMaps;

import projectCode20280.Practical_4_PriorityQueues.DefaultComparator;
import projectCode20280.Practical_4_PriorityQueues.Entry;

import java.util.Iterator;

/**
 * An abstract base class to ease the implementation of the Map interface.
 *
 * The base class provides three means of support: 1) It provides an isEmpty
 * implementation based upon the abstract size() method. 2) It defines a
 * protected MapEntry class as a concrete implementation of the entry interface
 * 3) It provides implemenations of the keySet and values methods, based upon
 * use of a presumed implementation of the entrySet method.
 *
 */
public abstract class AbstractMap<K extends Comparable<K>, V extends Comparable<V>> implements Map<K, V> {

    /**
     * Tests whether the map is empty.
     *
     * @return true if the map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // ---------------- nested MapEntry class ----------------
    /**
     * A concrete implementation of the Entry interface to be used within a Map
     * implementation.
     */
    protected static class MapEntry<K extends Comparable<K>, V extends Comparable<V>> implements Entry<K, V> {
        private K k; // key
        private V v; // value

        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        // public methods of the Entry interface
        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }

        /** Returns string representation (for debugging only) */
        public String toString() {
            return "<" + k + ", " + v + ">";
        }

        private final DefaultComparator<K> comparator  = new DefaultComparator<>();
        @Override
        public int compareTo(Entry<K, V> o) {
            return comparator.compare(this.getKey(), o.getKey());
        }

    } // ----------- end of nested MapEntry class -----------

    // Provides support for keySet() and values() methods, based upon
    // the entrySet() method that must be provided by subclasses

    // ---------------- nested KeyIterator class ----------------
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public K next() {
            return entries.next().getKey();
        } // return key!

        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }

    }
    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override
        public String toString(){
            String s = "[";
            for(Iterator<K> it = new KeyIterator(); it.hasNext();){
                s += it.next() + ", ";
            }
            s = s.substring(0, s.length()-2); // get rid of last comma and space
            return s + "]";
        }
    }

    /**
     * Returns an iterable collection of the keys contained in the map.
     *
     * @return iterable collection of the map's keys
     */
    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }


    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public V next() {
            return entries.next().getValue();
        } // return value!

        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    }

    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    /**
     * Returns an iterable collection of the values contained in the map. Note that
     * the same value will be given multiple times in the result if it is associated
     * with multiple keys.
     *
     * @return iterable collection of the map's values
     */
    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }
}
