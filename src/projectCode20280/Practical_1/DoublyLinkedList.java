package projectCode20280.Practical_1;
// Didn't realise there would be started code when I wrote mine so I've just commented it out and put in my own code
import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E>, List<E>{

    private static class Node<E> {

        // Each node holds an element and a reference to the previous and next node

        private E element; // reference to the element stored at this node
        private Node<E> previous;
        private Node<E> next;

        /* Constructor:
        Creates a node with a given element and next node.
         */
        public Node(E element, Node<E> previous, Node<E> next){
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        // Accessor methods

        // returns an object of type E - the data/ element
        public E getElement(){
            return this.element;
        }

        // returns an object of type Node - the next node
        public Node<E> getNext(){
            return this.next;
        }

        public Node<E> getPrevious(){
            return this.previous;
        }

        // modifier method
        // modifies the next node which the current node points to
        public void setNext(Node<E> next){
            this.next = next;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

    }

    // END OF NODE CLASS

    // DOUBLY LINKED LIST CLASS

    // header and trailer never have data (element = null), they are just null pointers
    // therefore, the first actual node in our list (ie with data not null) is the node after the header
    // the last node is the node before the  trailer

    private Node<E> header; // first node
    private Node<E> trailer; // last node
    private int size = 0; // header and trailer not included in size

    // Constructor
    public DoublyLinkedList(){
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return this.size;
    }


//    *****

    public void addBetween(E element, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        size++;
    }

    public E removeElement(Node<E> node){
        E temp = node.getElement();

        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        size--;
        return temp;
    }

//    *****



    // add to end of list just before trailer - ie between trailer.getPrevious() and trailer
    public void addLast(E element){
         addBetween(element, trailer.getPrevious(), trailer);
    }

    // add to front just after header - ie between header and header.getNext()
    public void addFirst(E element){
        addBetween(element, header, header.getNext());
    }

    // insert after a node with element/data = key
    public void insertAfter(E key, E element){
        Node current = header; // need to iterate through the list, so start at header

        // if list is empty
        if(isEmpty())
            throw new RuntimeException("Cannot insert. List is empty.");

            while(current != null ){     // while( current.getNext() != null) - will stop at node before trailer

            if(current.getElement().equals(key)){
                addBetween(element, current, current.getNext());
                return; }

            else
                current = current.getNext(); }

        throw new RuntimeException("Cannot inset node. No node with 'key' value exists.");
    }

    // add node at a given position
    public void add(int position, E element){

        if(position > size) {
            throw new RuntimeException("Cannot add node. Position out of bounds."); }

        if(position == size) {
            addLast(element); }

        else if(position == 0){
            addFirst(element); }

        else{
            Node current = header.next;

            for(int i=0; i<position; i++){
                current = current.next; }

            addBetween(element, current.getPrevious(), current);
        }
    }



//   remove the first node with element/ value equal to key
    public void removeKey(E key){

//        Node current = header; // need to iterate through the list, so start with a Node equal to head

        // if list is empty
        if(isEmpty())
            throw new RuntimeException("Cannot remove. List is empty.");
        Node current = header.getNext();

        while(current != null ){  // while( current.getNext() != null) - will stop at node before trailer

            if(current.getElement().equals(key)){
              removeElement(current);
              return; }

            else
                current = current.getNext(); }

        throw new RuntimeException("Cannot delete node. No node with 'key' value exists.");

    }

    // note
    // position 0 = the first element after header, ie header.getNext()
    public E remove(int position) {

        if(isEmpty())
            throw new RuntimeException("Cannot remove node. List is empty.");

        Node<E> current = header.getNext(); // position 0

        if (position > size-1) { // size - 1 as index starts at 0
            throw new RuntimeException("Cannot remove node. Position out of bounds."); }

        for (int i = 0; i < position; i++) { // iterate through until we get to position we are looking for
            current = current.next; }

        return removeElement(current);

    }


    public E removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("could not remove: list is empty");
        }
        return removeElement(header.getNext()); // remove the first element after the header

    }

    public E removeLast(){
        if(isEmpty()){
            throw new RuntimeException("could not remove: list is empty");
        }
        return removeElement(trailer.previous);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int position){
        if(position > size-1 || size < 1) {
            throw new RuntimeException("Cannot add node. Position out of bounds."); }

        Node<E> current = header.getNext();

        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.getElement();
    }



    public String toString(){
        String str = "";

        Iterator<E> it =  new ListIterator();
        it.next(); // get ride of first null

        for(int i=0; i<size; i++){
            E element = it.next();
            str += element + " ";
        }

        return str;
    }



    public Iterator<E> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node current;

        public ListIterator(){
            current = header;
        }


        public boolean hasNext(){
            return current != null;
        }

        @Override
        public E next(){
            E res = (E) current.getElement();
            current = current.getNext();
            return res;
        }
    }


}

/*
public class DoublyLinkedList<E> implements List<E> {

	private class Node<E> {
		
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// TODO
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll);
           
           ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
	}

	
}
*/
