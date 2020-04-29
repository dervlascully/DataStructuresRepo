package projectCode20280.Practical_7_AVL_Splay;

import projectCode20280.Practical_3_Trees.LinkedBinaryTree;
import projectCode20280.Practical_3_Trees.Position;
import projectCode20280.Practical_4_PriorityQueues.Entry;
import projectCode20280.Practical_6_BinarySearchTrees.TreeMap;

import java.util.Comparator;

public class SplayTreeMap<K extends Comparable<K>,V extends Comparable<V>> extends TreeMap<K,V> {

//    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();




    /** Constructs an empty map using the natural ordering of keys. */
    public SplayTreeMap() { super(); }

    /**
     * Constructs an empty map using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the map
     */
    public SplayTreeMap(Comparator<K> comp) { super(comp); }

    /** Utility used to rebalance after a map operation. */
    private void splay(Position<Entry<K,V>> p) {
        while(!isRoot(p)){
            Position<Entry<K,V>> parent = parent(p);
            Position<Entry<K,V>> grand = parent(parent); // grandparent of p

            if(grand == null)
                tree.rotate(p); // zig

            // p is the left child of parent which is the left child of grandparent
            // or p is the right child of parent which is the right child of grandparent
            else if( (parent == left(grand)) == (p == left(parent))){ // zig-zig (left-left or right-right)
                tree.rotate(parent); // move parent upward
                tree.rotate(p); // move p upward
            }

            // grandparent not null
            // p is left child of parent which is right child of grandparent
            // or p is right child of parent which is left child of grandparent
            // double rotation of p
            else{
                tree.rotate(p); // move p upward
                tree.rotate(p); // move p upward again
            }
        }
    }

    /** Overrides the TreeMap rebalancing hook that is called after a node access. */
    @Override
    protected void rebalanceAccess(Position<Entry<K,V>> p) {
        if(isExternal(p)) // not found
            p = parent(p); // let p = the parent of the external node, ie last not before not found

        if( p != null)
            splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        if(!isRoot(p))
            splay(parent(p));
    }


}
