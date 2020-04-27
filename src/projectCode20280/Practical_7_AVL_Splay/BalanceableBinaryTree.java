package projectCode20280.Practical_7_AVL_Splay;


import projectCode20280.Practical_3_Trees.LinkedBinaryTree;
import projectCode20280.Practical_3_Trees.Position;
import projectCode20280.Practical_4_PriorityQueues.Entry;

public class BalanceableBinaryTree<K extends Comparable<K>, V extends Comparable<V>> extends LinkedBinaryTree<Entry<K, V>> {
    // -------------- nested BSTNode class --------------
    // this extends the inherited LinkedBinaryTree.Node class.
    protected static class BSTNode<E> extends LinkedBinaryTree.Node<E> {
        int aux = 0;

        BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            super(e, parent, leftChild, rightChild);
        }

        public int getAux() {
            return aux;
        }

        public void setAux(int value) {
            aux = value;
        }
    } // --------- end of nested BSTNode class ---------

    // positional-based methods related to aux field
    public int getAux(Position<Entry<K, V>> p) {
        return ((BSTNode<Entry<K, V>>) p).getAux();
    }

    public void setAux(Position<Entry<K, V>> p, int value) {
        ((BSTNode<Entry<K, V>>) p).setAux(value);
    }

    // Override node factory function to produce a BSTNode (rather than a Node)
    @Override
    protected Node<Entry<K, V>> createNode(Entry<K, V> e, Node<Entry<K, V>> parent, Node<Entry<K, V>> left,
                                           Node<Entry<K, V>> right) {
        return new BSTNode<>(e, parent, left, right);
    }

    /** Re-links a parent node with its oriented child node. */
    private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeftChild) {
        child.setParent(parent);
        if(makeLeftChild)
            parent.setLeft(child);

        else
            parent.setRight(child);
    }

    /**
     * Rotates Position p above its parent. Switches between these configurations,
     * depending on whether p is a or p is b.
     *
     * <pre>
     *          b                  a
     *         / \                / \
     *        a  t2             t0   b
     *       / \                    / \
     *      t0  t1                 t1  t2
     * </pre>
     *
     * Caller should ensure that p is not the root.
     */
    public void rotate(Position<Entry<K, V>> p) {
        Node<Entry<K, V>> x = validate(p);
        Node<Entry<K, V>> y = x.getParent(); // we assume this exists
        Node<Entry<K, V>> z = y.getParent(); // grandparent (possibly null)

        if(z == null){
            root = x; // x becomes the root of the tree
            x.setParent(null);
        }

        else{
            relink(z, x, y == z.getLeft()); // x becomes direct child of z
        }
        // now rotate x and y, including transfer of middle subtree
        if(x == y.getLeft()){ // if x is left child
            relink(y, x.getRight(), true); // x's right child becomes y's left
            relink(x, y, false); // y becomes x's right child
        }else{
            relink(y, x.getLeft(), false); // x's left child becomes y's right
            relink(x, y, true); // y becomes left child of x
        }
    }

    /**
     *
     * Returns the Position that becomes the root of the restructured subtree.
     *
     * Assumes the nodes are in one of the following configurations:
     *
     * <pre>
     *     z=a                 z=c           z=a               z=c
     *    /  \                /  \          /  \              /  \
     *   t0  y=b             y=b  t3       t0   y=c          y=a  t3
     *      /  \            /  \               /  \         /  \
     *     t1  x=c         x=a  t2            x=b  t3      t0   x=b
     *        /  \        /  \               /  \              /  \
     *       t2  t3      t0  t1             t1  t2            t1  t2
     * </pre>
     *
     * The subtree will be restructured so that the node with key b becomes its
     * root.
     *
     * <pre>
     *           b
     *         /   \
     *       a       c
     *      / \     / \
     *     t0  t1  t2  t3
     * </pre>
     *
     * Caller should ensure that x has a grandparent.
     */
    public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
        Position<Entry<K, V>> y = parent(x);
        Position<Entry<K, V>> z = parent(y);
        if( (x == right(y)) == (y == right(z)) ){ // matching alignments
            rotate(y); // single rotation of y
            return y;
        }
        else{ // opposite alignments
            rotate(x); // double rotation of x
            rotate(x);
            return x;
        }
    }
}
