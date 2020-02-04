package projectCode20280;

import java.util.Iterator;
// Didn't realise there would be started code when I wrote mine so I've just commented it out and put in my own code

public class SinglyLinkedList<E> implements Iterable<E>, LinkedList<E> {

    /*
    There is no need for Node to be a top-level class as it is only used by
    LinkedList. Since it does not need access to LinkedList's members, we usually declare
    it as static.
     */
    private static class Node<E> {

        // Each node holds an element and a reference to the next node

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        /* Constructor:
        Creates a node with a given element and next node.
         */
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        // Accessor methods

        // returns an object of type E - the element / data
        public E getElement(){
            return this.element;
        }

        // returns an object of type Node - the next node
        public Node<E> getNext(){
            return next;
        }

        // modifier method
        // modifies the next node which the current node points to
        public void setNext(Node<E> next){
            this.next = next;
        }
    }
    // END OF NODE CLASS

    // SINGLY LINKED LIST CLASS

    public Node head; // First node in list
    public int size = 0; // size of list / number of nodes

    public int getSize(){
        return this.size;
    }

    // Add an element to the front of the list
    public void addFirst(E element){
        head = new Node<E>(element, head);
        /* head is now equal to this new node, the element/ data part is passed in as parameter,
        this new node points to/ references the old head
         */
        size++; // increase size as we have added another node to the list
    }

    // Add an element to the end of the list
    public void addLast(E element){

        Node<E> newest = new Node<E>(element, null);
        // new node with the element we are passing in, which points to null as it will go at the end of the list

        Node<E> last = head;
        /* new node which we will use to  go through the list to find the last node.
        for now this node is equal to head. It therefore points to / references either (1) the second node in the list (or points to null if there is only one node in the list),
        or (2), in the case that the list is empty, it is null (NB, doesn't point to null,
        it IS null
         */

        /*
        last is initialised to head. If there are no elements in the list, head will be null.
        Therefore, last will be null.
        In this case, we will assign head the value of this new node, ie head = newest
         */
        if(last == null){
            head = newest;
        }

        // else, if there is at least one node in the list
        else{
            while(last.getNext() != null){
                /*
                getNext() returns the address of the next node
                loop will end when we reach en node that points to null
                ie the last node
                Therefore, 'last' will be the last node in the list when the loop ends
                 */

                last = last.getNext();
                // last = the previous last . getNext()
            }
            // at this point, last is the last node in the list, so last needs to point to the new node
            last.setNext(newest);
        }

        // once the node is added we increase the size
        size++;
    }

    /*
    Will insert a node with element passed in a second parameter after the first
    occurrence of a node with element equal to the first parameter passed in
     */
    public void insertAfter(E key, E element){

        Node current = head; // need to iterate through the list, so start with a Node equal to head

        // if list is empty
        if(current == null)
            throw new RuntimeException("Cannot insert. List is empty.");

        // list is not empty
        /* iterate through, loop will break when we reach the end of list if return statement within loop
        has not already been reached.
         */
        while(current != null) {

            if (current.getElement().equals(key)) {
                Node newNode = new Node(element, current.next);
                current.next = newNode;
                size++;
                return;

                /*
                If we find a node with element = key
                Insert new node after it
                Therefore, new node points to the node that this node (current) had previously pointed to
                current now points to the new node
                increase size
                 */
            }

            else
                current = current.next; // iterate through list
        }
        // reached the end of list and have not found an element with key value
        throw new RuntimeException("Cannot insert. No node with key value");
    }

    /*
    Insert a node with value passed in as parameter at a certain position.
    eg add("hello", 3)
    will insert node with element/ value "hello" as the fourth (0 1 2 3) node in the list
     */
    public void add(E element, int position){
        Node current = head;

        if(position > size-1) {
            throw new RuntimeException("Cannot add node. Position out of bounds.");
        }

        if(position == 0)
            addFirst(element);

        else{
            for(int i=1; i<position; i++){
                current = current.next;
            }

            Node newNode = new Node(element, current.next);
            current.next = newNode;
            size++;

        }

    }



    /*
    remove the first node with element/ value equal to key
     */
    public void removeKey(E key){

        // if the linked list is empty
        if(head == null){
            throw new RuntimeException("cannot delete: list is empty");
        }

        // if the first node has the element we want to delete, delete first node
        if(head.getElement().equals(key)){
            head = head.next; // head is now the node which the previous head was pointing to
            size--; // decrease size
            return; // NB end here
        }

        // if we reach this point, then the list is not empty and the head is not the element twe are looking to remove

        // new variable current of type Node, which we assign the values of head to begin
        Node current = head;

        // new variable previous of type Node, which is null for now as current is head, so there is no previous node to head
        Node previous = null;

        /* since current first equals head, we know that we will enter the loop
        as we have established above that head is not null and its element is not the key.
        Therefore, loop will break when we reach the end or when we reach a node who's element is the key
         */

        while(current != null && ! current.getElement().equals(key)){
            previous = current;
            current = current.next;  // iterate through list
        }

        // when we reach here, current is either null or current has element equal to key (therefore remove it)

        // if current is null - we have reached the end of list and have not found a node with element = key
        if(current == null){
            throw new RuntimeException("cannot delete: no element in list with key: " + key);
        }

        /*
        We have found a node with element = key
        delete node
        ie, the previous node needs to point to the node that the current node was pointing to
         */
        previous.next = current.next;

        size --; // reduce size
    }

    public void remove(int position) {

        Node current = head;
        Node previous = null;

        if (position > size-1) {
            throw new RuntimeException("Cannot remove node. Position out of bounds.");
        } else {
            for (int i = 0; i < position; i++) {
                previous = current;
                current = current.next;
            }

            previous.setNext(current.getNext());
            // previous points to node that current was pointing to

            // don't think i need this
            current.setNext(null);
            // current now points to null, and is not pointed to by any nodes
        }
    }

    public void removeFirst(){

        if(head == null){
            throw new RuntimeException("could not remove: list is empty");
        }

        else{
            head = head.getNext();
            size--;
        }
    }

    public void removeLast(){
        if(head == null){
            throw new RuntimeException("could not remove: list is empty");
        }

        Node current = head;
        Node previous = null;
        while(current.getNext() != null){
            previous = current;
            current = current.getNext();
        }
        // At this point, current points to null, therefore previous is the 2nd last element and current is the last
        previous.setNext(null);
        size--;
    }

    public String toString(){
        String str = "";
        for(Iterator<E> it =  new ListIterator(); it.hasNext();){
            E element = it.next();
            str += element + " ";

        }
        return str;
    }

    public boolean isEmpty(){
        return size == 0;}



    public E get(int position){
        if(position > size-1) {
            throw new RuntimeException("Error - index out of bounds."); }

        Node<E> current = head;


        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.getElement();
    }

    // Cloning

    public SinglyLinkedList<E> copy(){
        SinglyLinkedList<E> twin =new SinglyLinkedList<E>();
        Node<E> temp = head;
        while(temp != null){
            twin.addLast(temp.getElement());
            temp = temp.getNext();
        }
        return twin;
    }

    public Iterator<E> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
        Node current;

        public ListIterator(){
            current = head;
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

// public class SinglyLinkedList<E> implements List<E> {

// 	private class Node<E> {
// 		/// TODO
// 	}
	
// 	@Override
// 	public boolean isEmpty() {
// 		// TODO Auto-generated method stub
// 		return false;
// 	}

// 	@Override
// 	public E get(int i) {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public void add(int i, E e) {
// 		// TODO Auto-generated method stub

// 	}

// 	@Override
// 	public E remove(int i) {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public Iterator<E> iterator() {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public int size() {
// 		// TODO Auto-generated method stub
// 		return 0;
// 	}	
	

// 	@Override
// 	public E removeFirst() {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public E removeLast() {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public void addFirst(E e) {
// 		// TODO Auto-generated method stub
		
// 	}

// 	@Override
// 	public void addLast(E e) {
// 		// TODO Auto-generated method stub
		
// 	}
	
// 	public static void main(String[] args) {
// 		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

// 		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
// 		for (String s : alphabet) {
// 			sll.addFirst(s);
// 			sll.addLast(s);
// 		}
// 		System.out.println(sll.toString());

// 		sll.removeFirst();
// 		System.out.println(sll.toString());
		
// 		sll.removeLast();
// 		System.out.println(sll.toString());

// 		sll.remove(2);
// 		System.out.println(sll.toString());
		
// 		for (String s : sll) {
// 			System.out.print(s + ", ");
// 		}
// 	}


}
