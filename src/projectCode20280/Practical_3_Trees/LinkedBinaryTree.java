 package projectCode20280.Practical_3_Trees;

 import projectCode20280.Practical_4_PriorityQueues.DefaultComparator;

 public class LinkedBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {
    //  extends Comparable<E>


    /** Nested static class for a binary tree node. */
    protected static class Node<E> implements Position<E> {
        // element, parent node, left child node
        public E element;
        public Node<E> parent;
        public Node<E> left;
        public Node<E> right;

        public String toString(){
            if(element == null)
                return "\u29B0";

            return getElement().toString();
        }


        public Node(E element, Node<E> parent, Node<E> left, Node<E> right){
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement(){
            return this.element;
        }

        public Node<E> getParent(){
            return this.parent;
        }

        public Node<E> getLeft(){
            return this.left;
        }

        public Node<E> getRight(){
            return this.right;
        }

        public void setElement(E element){
            this.element = element;
        }

        public void setParent(Node<E> parent){
            this.parent = parent;
        }

        public void setLeft(Node<E> left){
            this.left = left;
        }

        public void setRight(Node<E> right){
            this.right = right;
        }

    }

    /** Factory function to create a new node storing element e. */
    protected Node<E> createNode(E e, Node<E> parent,
                                 Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // LinkedBinaryTree instance variables

    protected Node<E> root = null;     // root of the tree

    private int size = 0;              // number of nodes in the tree

    public LinkedBinaryTree() {

    }      // empty constructor - constructs an empty binary tree

    // nonpublic utility
    /**
     * Verifies that a Position belongs to the appropriate class, and is
     * not one that has been previously removed. Note that our current
     * implementation does not actually verify that the position belongs
     * to this particular list instance.
     *
     * @param p   a Position (that should belong to this tree)
     * @return    the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");

        // If p is an instance of a Node<E> type cast it to Node<E>
        Node<E> node = (Node<E>) p;       // safe cast
        if (node.getParent() == node)     // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // accessor methods (not already implemented in AbstractBinaryTree)
    /**
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p    A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return ((Node<E>)p).getParent();

    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return ((Node<E>)p).getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return ((Node<E>)p).getRight();
    }

    // update methods supported by this class
    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e   the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");

        root = createNode(e, null, null, null);
        size++;
        return root;
    }

    public void insert(E e){

            //recursively add from root
            root = addRecursive(root, e);
            ++size;

    }

    //recursively add Nodes to binary tree in proper position
    // takes in a node and an element
    private Node<E> addRecursive(Node<E> p, E e){

         // think tis is wrong - see next base case
        // base case - when the current node is null, we've reached a leaf node, and we can insert the new node in that position
//        if(p == null){
//            return createNode(e, null, null, null);
//        }

        // base case
        if(isEmpty()){
            root = createNode(e, null, null, null);
            return root;
        }

       if(e.compareTo(p.getElement()) == -1) { // if the new node's value is lower than the current node's, we go to the left child
//            p.setLeft(addRecursive(p.getLeft(), e));

           if(p.left != null)
               addRecursive(p.left, e);

           else
               p.left = createNode(e, p, null, null);
       }


        else if(e.compareTo(p.getElement()) == 1) { // if the new node's value is greater than the current node's, we go to the right child
//           p.setRight(addRecursive(p.getRight(), e));
           if(p.right != null){
               addRecursive(p.right, e);
           }

           else{
               p.right = createNode(e, p, null, null);
           }
       }

//        else {
//            // value already exists
//            return p;
//        }

        return p;

    }




    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");

        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;

    }

    public Position<E> addRight(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");

        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced element.
     *
     * @param p   the relevant Position
     * @param e   the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;


//        Node<E> parent = node.getParent();
//
//        if(node != root && parent.getLeft() == node)
//            parent.setLeft(node);
//
//        else if(node != root && parent.getRight() == node)
//            parent.setRight(node);
//        node.setElement(e);
//        return temp;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p   a leaf of the tree
     * @param t1  an independent tree whose structure becomes the left child of p
     * @param t2  an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                       LinkedBinaryTree<E> t2) throws IllegalArgumentException {

        Node<E> n = validate(p);

        if(isInternal(p)) throw new IllegalArgumentException("p must be a leaf");

        size += t1.size() + t2.size();

        if(!t1.isEmpty()){
            t1.root.setParent(n);
            n.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if(!t2.isEmpty()){
            t2.root.setParent(n);
            n.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }

    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p   the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {

        Node<E> n = (Node<E>)p;

        if(numChildren(n) == 2) // if the node has two children - error
            throw new IllegalArgumentException("Cannot remove node with two children");


        // if left is not null, child is left child of n, else child is right child of n
        Node<E> child = n.getLeft() != null ? n.getLeft() : n.getRight();

        if(child != null){ // parent of the child is now the parent of the node removed
            child.setParent(n.getParent());
        }

        if(n == root){ // if node being removed is the root, set the root to be the child
            root = child;
        }

        else{
            Node<E>  parent = n.getParent();
            if(n == parent.getLeft()) // child of parent of node being removed is now child of node being removed
                parent.setLeft(child);

            else
                parent.setRight(child);
        }

        --size; // decrement size as a node has been removed
        E old = n.getElement();
        return old; // return the element og the node being removed

        /*
        Node<E> temp = validate(p);
        // validate will throw exception if not valid position

        E returnValue = temp.getElement();
        Node<E> P = temp.getParent(); // parent


        if(temp.right == null){

            // node has no children
            if(temp.left == null) {

                // if the node is the right child of its parent
                if(P.getRight() == temp){
                    P.setRight(null); // set right child of parent to null
                }

                // if the node is the left child of its parent
                else if(P.getLeft() == temp){
                    P.setLeft(P.getRight()); // set left child of parent to its current right child
                }

            }

            // node has one child - left child
            else{
                // if the node is the right child of its parent
                if(P.getRight() == temp){
                    P.setRight(temp.getLeft()); // set right child of parent to null
                }

                // if the node is the left child of its parent
                else if(P.getLeft() == temp){
                    P.setLeft(temp.getLeft()); // set left child of parent to its current right child
                }

            }
        }

        else{
            throw new IllegalArgumentException();
        }

        return returnValue;


         */

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 1;

        for(Position<E> p : positions()) {
            sb.append(p.getElement());

            if(i < this.size) {
                sb.append(", ");
            }
            i++;

        }
        sb.append("]");
        return sb.toString();
    }

    private final DefaultComparator<E> comparator  = new DefaultComparator<>();

    public int compare(E first, E second){
        return comparator.compare(first, second);
    }


}

