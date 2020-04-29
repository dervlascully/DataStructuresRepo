package projectCode20280.Practical_6_BinarySearchTrees;

import projectCode20280.Practical_3_Trees.BinaryTree;
import projectCode20280.Practical_3_Trees.LinkedBinaryTree;
import projectCode20280.Practical_3_Trees.Position;
import projectCode20280.Practical_3_Trees.Tree;
import projectCode20280.Practical_4_PriorityQueues.DefaultComparator;
import projectCode20280.Practical_4_PriorityQueues.Entry;
import projectCode20280.Practical_7_AVL_Splay.BalanceableBinaryTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of a sorted map using a binary search tree.
 */

public class TreeMap<K extends Comparable<K>, V extends Comparable <V>> extends AbstractSortedMap<K, V> {
    // extends Comparable<K>

    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree();
//    protected LinkedBinaryTree<Entry<K,V>> tree = new LinkedBinaryTree<>();

    /** Constructs an empty map using the natural ordering of keys. */
    public TreeMap() {
        super(); // the AbstractSortedMap constructor
        tree.addRoot(null); // create a sentinel leaf as root
    }

    /**
     * Returns the number of entries in the map.
     *
     * @return number of entries in the map
     */
    @Override
    public int size() {
        return (tree.size() - 1) / 2; // only internal nodes have entries
    }

    /** Utility used when inserting a new entry at a leaf of the tree */
    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry); // store new entry at p
        tree.addLeft(p, null); // add new sentinel leaves as children
        tree.addRight(p, null);
    }

    // Some notational shorthands for brevity (yet not efficiency)
    protected Position<Entry<K, V>> root() {
        return tree.root();
    }

    protected Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
        return tree.parent(p);
    }

    protected Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
        return tree.left(p);
    }

    protected Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
        return tree.right(p);
    }

    protected Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
        return tree.sibling(p);
    }

    protected boolean isRoot(Position<Entry<K, V>> p) {
        return tree.isRoot(p);
    }

    protected boolean isExternal(Position<Entry<K, V>> p) {
        return tree.isExternal(p);
    }

    protected boolean isInternal(Position<Entry<K, V>> p) {
        return tree.isInternal(p);
    }

    protected void set(Position<Entry<K, V>> p, Entry<K, V> e) {
        tree.set(p, e);
    }

    protected Entry<K, V> remove(Position<Entry<K, V>> p) {
        return tree.remove(p);
    }

    /**
     * Returns the position in p's subtree having the given key (or else the
     * terminal leaf).
     *
     * @param key a target key
     * @param p   a position of the tree serving as root of a subtree
     * @return Position holding key, or last node reached during search
     */
    private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        if(isExternal(p))
            return p; // key not found, return the final leaf

        int c = compare(key, p.getElement());

            // key we are looking for == key at position
            // key found, return its position
        if(c == 0)
            return p;

            // key we are looking for < key at position - search left subtree
        else if(c < 0)
            return treeSearch(left(p), key);

            // key we are looking for > key at position - search right subtree
        else
            return treeSearch(right(p), key);

    }

    /**
     * Returns position with the minimal key in the subtree rooted at Position p.
     *
     * @param p a Position of the tree serving as root of a subtree
     * @return Position with minimal key in subtree
     */
    protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> curr = p; // pointer at current position

        // walk down tree to the left continuously until we reach an external node
        while(isInternal(curr))
            curr = left(curr);

        // return the parent of the external node - leftmost node, therefore the minimum
        return parent(curr);

    }

    /**
     * Returns the position with the maximum key in the subtree rooted at p.
     *
     * @param p a Position of the tree serving as root of a subtree
     * @return Position with maximum key in subtree
     */
    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> curr = p; // pointer at current position

        // walk down tree to the left continuously until we reach an external node
        while(isInternal(curr))
            curr = right(curr);

        // return the parent of the external node - leftmost node, therefore the minimum
        return parent(curr);
    }

    /**
     * Returns the value associated with the specified key, or null if no such entry
     * exists.
     *
     * @param key the key whose associated value is to be returned
     * @return the associated value, or null if no such entry exists
     */
    @Override
    public V get(K key) throws IllegalArgumentException {

        System.out.println("\n");
        for(Position<Entry<K, V>> p : tree.inorder()){

            if(isInternal(p)){
                // debugging
                System.out.println("key: " + p.getElement().getKey());
                System.out.println("value: " + p.getElement().getValue());
                if(p.getElement().getKey() == key) {
                    rebalanceAccess(p);  // hook for balanced tree
                    return p.getElement().getValue();
                }
            }
        }
        return null;
    }

    /**
     * Associates the given value with the given key. If an entry with the key was
     * already in the map, this replaced the previous value with the new one and
     * returns the old value. Otherwise, a new entry is added and null is returned.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the key (or null, if no such
     *         entry)
     */
    @Override
    public V put(K key, V value) throws IllegalArgumentException {

        Entry<K,V> entry = new MapEntry<>(key, value);
        Position<Entry<K, V>> p = treeSearch(root(), key); // find entry with key 'key' in the tree. Start search at the root


        if(isExternal(p)){
            expandExternal(p, entry); // add new node
            rebalanceInsert(p);  // hook for balanced tree
            return null;
        }

        // internal - update the existing entry
        else{
            V old = p.getElement().getValue();
            set(p, entry);
            rebalanceAccess(p);  // hook for balanced tree

            return old;
        }
    }

    /**
     * Removes the entry with the specified key, if present, and returns its
     * associated value. Otherwise does nothing and returns null.
     *
     * @param key the key whose entry is to be removed from the map
     * @return the previous value associated with the removed key, or null if no
     *         such entry exists
     */
    @Override
    public V remove(K key) throws IllegalArgumentException {
        Position<Entry<K, V>> p = treeSearch(root(), key);

        if(isExternal(p)){ // key not found
            rebalanceAccess(p);  // hook for balanced tree
            return null;
        }

        else{
            V old = p.getElement().getValue();
            if(isInternal(left(p)) && isInternal(right(p))){ // both internal
                    Position<Entry<K, V>> replacement = treeMax(left(p));
                    set(p, replacement.getElement());
                    p = replacement;
            }
            Position<Entry<K, V>> leaf = isExternal(left(p)) ? left(p) : right(p);
            Position<Entry<K, V>> sib = sibling(leaf); // either the left or right sibling
            remove(leaf);
            remove(p); // sib is promoted in p's place
            rebalanceDelete(sib); // hook for balanced tree
            return old;
        }

    }

    // additional behaviors of the SortedMap interface
    /**
     * Returns the entry having the least key (or null if map is empty).
     *
     * @return entry with least key (or null if map is empty)
     */
    @Override
    public Entry<K, V> firstEntry() {
        if (isEmpty())
            return null;
        return treeMin(root()).getElement();
    }

    /**
     * Returns the entry having the greatest key (or null if map is empty).
     *
     * @return entry with greatest key (or null if map is empty)
     */
    @Override
    public Entry<K, V> lastEntry() {
        if (isEmpty())
            return null;
        return treeMax(root()).getElement();
    }

    /**
     * Returns the entry with least key greater than or equal to given key (or null
     * if no such key exists).
     *
     * @return entry with least key greater than or equal to given (or null if no
     *         such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        if(key.compareTo(lastEntry().getKey()) == 1)
            return null;

        if(key.compareTo(firstEntry().getKey()) == -1)
            return firstEntry();

        for(Position<Entry<K, V>> p : tree.inorder()){
            if(isInternal(p)){
                if(key.compareTo(p.getElement().getKey()) == -1 || key.compareTo(p.getElement().getKey()) == 0){
                    return p.getElement();
                }
            }
        }
        return null;
    }

    /**
     * Returns the entry with greatest key less than or equal to given key (or null
     * if no such key exists).
     *
     * @return entry with greatest key less than or equal to given (or null if no
     *         such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        if(key.compareTo(lastEntry().getKey()) == 1){
            return lastEntry();
        }

        Position<Entry<K, V>> previous = null;
        for(Position<Entry<K, V>> p : tree.inorder()){
            if(isInternal(p)){

                if(key.compareTo(p.getElement().getKey()) == -1){ // if key is less than the current key - return previous
                    if(previous == null)return null;
                    return previous.getElement();
                }

                previous = p; } }

        return null;
    }

    /**
     * Returns the entry with greatest key strictly less than given key (or null if
     * no such key exists).
     *
     * @return entry with greatest key strictly less than given (or null if no such
     *         entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
        if(key.compareTo(lastEntry().getKey()) == 1){
            return lastEntry();
        }

        Position<Entry<K, V>> previous = null;
        for(Position<Entry<K, V>> p : tree.inorder()){
            if(isInternal(p)){

                if(p.getElement().getKey() == key){ // if key is equal to the current key, return previous
                    if(previous == null)return null;
                    return previous.getElement();
                }

                if(key.compareTo(p.getElement().getKey()) == -1){ // if key is less than the current key - return previous
                    if(previous == null)return null;
                    return previous.getElement();
                }

                previous = p; } }

        return null;
    }

    /**
     * Returns the entry with least key strictly greater than given key (or null if
     * no such key exists).
     *
     * @return entry with least key strictly greater than given (or null if no such
     *         entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {

        if(key.compareTo(lastEntry().getKey()) == 1)
            return null;

        if(key.compareTo(firstEntry().getKey()) == -1)
            return firstEntry();

        for(Position<Entry<K, V>> p : tree.inorder()){
            if(isInternal(p)){
                if(key.compareTo(p.getElement().getKey()) == -1){
                    return p.getElement();
                }
            }
        }
        return null;
    }

    // Support for iteration
    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        for(Position<Entry<K, V>> p : tree.inorder()){ // inorder traversal of the tree
            if(isInternal(p)) // filter out 'null's
                buffer.add(p.getElement());
        }
        return buffer;
    }

    /**
     * Returns an iterable containing all entries with keys in the range from
     * <code>fromKey</code> inclusive to <code>toKey</code> exclusive.
     *
     * @return iterable with keys in desired range
     * @throws IllegalArgumentException if <code>fromKey</code> or
     *                                  <code>toKey</code> is not compatible with
     *                                  the map
     */
    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        if(compare(fromKey, toKey) < 0){ // ensure that fromKey < toKey
            subMapRecurse(fromKey, toKey, root(),buffer);
        }
        return buffer;
    }


    public void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p, ArrayList<Entry<K,V>> buffer){
        if(isInternal(p)){
            if(compare(p.getElement(), fromKey) < 0){
                // p's key is less than fromKey, so any relevant entries are to the right
                subMapRecurse(fromKey, toKey, right(p), buffer);
            }
            else{
                subMapRecurse(fromKey, toKey, left(p), buffer); // first consider left subtree
                if(compare(p.getElement(), toKey) < 0){ // p is within range
                    buffer.add(p.getElement()); // add to buffer
                    subMapRecurse(fromKey, toKey, right(p), buffer); // consider right subtree
                }
            }
        }
    }

    // remainder of class is for debug purposes only
    /** Prints textual representation of tree structure (for debug purpose only). */
    protected void dump() {
        dumpRecurse(root(), 0);
    }

    /** This exists for debugging only */
    private void dumpRecurse(Position<Entry<K, V>> p, int depth) {
        String indent = (depth == 0 ? "" : String.format("%" + (2 * depth) + "s", ""));
        if (isExternal(p))
            System.out.println(indent + "leaf");
        else {
            System.out.println(indent + p.getElement());
            dumpRecurse(left(p), depth + 1);
            dumpRecurse(right(p), depth + 1);
        }
    }

    private final DefaultComparator<K> comparator  = new DefaultComparator<>();
    public int compare(Entry<K, V> a, Entry<K, V> b){
        return comparator.compare(a.getKey(), b.getKey());
    }

    public String toString(){
        return tree.toString();
    }

    /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    protected void rebalanceDelete(Position<Entry<K, V>> p) { }

    /** Overrides the TreeMap rebalancing hook that is called after a node access. */
    protected void rebalanceAccess(Position<Entry<K, V>> p) { }

//    protected void rotate(Position<Entry<K, V>> p) { }

    public TreeMap(Comparator<K> comp) {
        super(comp);              // the AbstractSortedMap constructor
        tree.addRoot(null);       // create a sentinel leaf as root
    }

//    @Override
//    public Iterable<K> keySet() {
//        ArrayList<K> buffer = new ArrayList<>(size());
//        for(Position<Entry<K, V>> p : tree.inorder()){ // inorder traversal of the tree
//            if(isInternal(p)) // filter out 'null's
//                buffer.add(p.getElement().getKey());
//        }
//        return buffer;
//    }
}
