package projectCode20280.Practical_2;

public class Main {


    public static void main(String[] args) {
        delimiterMatching d = new delimiterMatching("import java.util.Iterator;\n" +
                "\n" +
                "public class SinglyLinkedList<E> implements Iterable<E>, LinkedList<E> {\n" +
                "    /*\n" +
                "    There is no need for Node to be a top-level class as it is only used by\n" +
                "    LinkedList. Since it does not need access to LinkedList's members, we usually declare\n" +
                "    it as static.\n" +
                "     */\n" +
                "    private static class Node<E> {\n" +
                "\n" +
                "        // Each node holds an element and a reference to the next node\n" +
                "        private E element; // reference to the element stored at this node\n" +
                "        private Node<E> next; // reference to the subsequent node in the list\n" +
                "\n" +
                "        /* Constructor:\n" +
                "        Creates a node with a given element and next node.\n" +
                "         */\n" +
                "        public Node(E element, Node<E> next){\n" +
                "            this.element = element;\n" +
                "            this.next = next;\n" +
                "        }\n" +
                "\n" +
                "        // Accessor methods\n" +
                "\n" +
                "        // returns an object of type E - the element / data\n" +
                "        public E getElement(){\n" +
                "            return this.element;\n" +
                "        }\n" +
                "\n" +
                "        // returns an object of type Node - the next node\n" +
                "        public Node<E> getNext(){\n" +
                "            return next;\n" +
                "        }\n" +
                "\n" +
                "        // modifier method\n" +
                "        // modifies the next node which the current node points to\n" +
                "        public void setNext(Node<E> next){\n" +
                "            this.next = next;\n" +
                "        }\n" +
                "    }\n" +
                "    // END OF NODE CLASS\n" +
                "\n" +
                "    // SINGLY LINKED LIST CLASS\n" +
                "\n" +
                "    public Node<E> head; // First node in list\n" +
                "    public int size = 0; // size of list / number of nodes\n" +
                "\n" +
                "    public int size(){\n" +
                "        return this.size;\n" +
                "    }\n" +
                "\n" +
                "    // Add an element to the front of the list\n" +
                "    public void addFirst(E element){\n" +
                "        head = new Node<E>(element, head);\n" +
                "        /* head is now equal to this new node, the element/ data part is passed in as parameter,\n" +
                "        this new node points to/ references the old head\n" +
                "         */\n" +
                "        size++; // increase size as we have added another node to the list\n" +
                "    }\n" +
                "\n" +
                "    // Add an element to the end of the list\n" +
                "    public void addLast(E element){\n" +
                "\n" +
                "        Node<E> newest = new Node<E>(element, null);\n" +
                "        // new node with the element we are passing in, which points to null as it will go at the end of the list\n" +
                "\n" +
                "        Node<E> last = head;\n" +
                "        /* new node which we will use to  go through the list to find the last node.\n" +
                "        for now this node is equal to head. It therefore points to / references either (1) the second node in the list (or points to null if there is only one node in the list),\n" +
                "        or (2), in the case that the list is empty, it is null (NB, doesn't point to null,\n" +
                "        it IS null\n" +
                "         */\n" +
                "\n" +
                "        /*\n" +
                "        last is initialised to head. If there are no elements in the list, head will be null.\n" +
                "        Therefore, last will be null.\n" +
                "        In this case, we will assign head the value of this new node, ie head = newest\n" +
                "         */\n" +
                "        if(last == null){\n" +
                "            head = newest;\n" +
                "        }\n" +
                "\n" +
                "        // else, if there is at least one node in the list\n" +
                "        else{\n" +
                "            while(last.getNext() != null){\n" +
                "                /*\n" +
                "                getNext() returns the address of the next node\n" +
                "                loop will end when we reach en node that points to null\n" +
                "                ie the last node\n" +
                "                Therefore, 'last' will be the last node in the list when the loop ends\n" +
                "                 */\n" +
                "\n" +
                "                last = last.getNext();\n" +
                "                // last = the previous last . getNext()\n" +
                "            }\n" +
                "            // at this point, last is the last node in the list, so last needs to point to the new node\n" +
                "            last.setNext(newest);\n" +
                "        }\n" +
                "\n" +
                "        // once the node is added we increase the size\n" +
                "        size++;\n" +
                "    }\n" +
                "\n" +
                "    /*\n" +
                "    Will insert a node with element passed in a second parameter after the first\n" +
                "    occurrence of a node with element equal to the first parameter passed in\n" +
                "     */\n" +
                "    public void insertAfter(E key, E element){\n" +
                "\n" +
                "        Node current = head; // need to iterate through the list, so start with a Node equal to head\n" +
                "\n" +
                "        // if list is empty\n" +
                "        if(current == null)\n" +
                "            throw new RuntimeException(\"Cannot insert. List is empty.\");\n" +
                "\n" +
                "        // list is not empty\n" +
                "        /* iterate through, loop will break when we reach the end of list if return statement within loop\n" +
                "        has not already been reached.\n" +
                "         */\n" +
                "        while(current != null) {\n" +
                "\n" +
                "            if (current.getElement().equals(key)) {\n" +
                "                Node newNode = new Node(element, current.next);\n" +
                "                current.next = newNode;\n" +
                "                size++;\n" +
                "                return;\n" +
                "\n" +
                "                /*\n" +
                "                If we find a node with element = key\n" +
                "                Insert new node after it\n" +
                "                Therefore, new node points to the node that this node (current) had previously pointed to\n" +
                "                current now points to the new node\n" +
                "                increase size\n" +
                "                 */\n" +
                "            }\n" +
                "\n" +
                "            else\n" +
                "                current = current.next; // iterate through list\n" +
                "        }\n" +
                "        // reached the end of list and have not found an element with key value\n" +
                "        throw new RuntimeException(\"Cannot insert. No node with key value\");\n" +
                "    }\n" +
                "\n" +
                "    /*\n" +
                "    Insert a node with value passed in as parameter at a certain position.\n" +
                "    eg add(\"hello\", 3)\n" +
                "    will insert node with element/ value \"hello\" as the fourth (0 1 2 3) node in the list\n" +
                "     */\n" +
                "    public void add(int position, E element){\n" +
                "        Node current = head;\n" +
                "\n" +
                "        if(position > size-1) {\n" +
                "            throw new RuntimeException(\"Cannot add node. Position out of bounds.\");\n" +
                "        }\n" +
                "\n" +
                "        if(position == 0)\n" +
                "            addFirst(element);\n" +
                "\n" +
                "        else{\n" +
                "            for(int i=1; i<position; i++){\n" +
                "                current = current.next;\n" +
                "            }\n" +
                "\n" +
                "            Node newNode = new Node(element, current.next);\n" +
                "            current.next = newNode;\n" +
                "            size++;\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    /*\n" +
                "    remove the first node with element/ value equal to key\n" +
                "     */\n" +
                "    public void removeKey(E key){\n" +
                "\n" +
                "        // if the linked list is empty\n" +
                "        if(head == null){\n" +
                "            throw new RuntimeException(\"cannot delete: list is empty\");\n" +
                "        }\n" +
                "\n" +
                "        // if the first node has the element we want to delete, delete first node\n" +
                "        if(head.getElement().equals(key)){\n" +
                "            head = head.next; // head is now the node which the previous head was pointing to\n" +
                "            size--; // decrease size\n" +
                "            return; // NB end here\n" +
                "        }\n" +
                "\n" +
                "        // if we reach this point, then the list is not empty and the head is not the element twe are looking to remove\n" +
                "\n" +
                "        // new variable current of type Node, which we assign the values of head to begin\n" +
                "        Node current = head;\n" +
                "\n" +
                "        // new variable previous of type Node, which is null for now as current is head, so there is no previous node to head\n" +
                "        Node previous = null;\n" +
                "\n" +
                "        /* since current first equals head, we know that we will enter the loop\n" +
                "        as we have established above that head is not null and its element is not the key.\n" +
                "        Therefore, loop will break when we reach the end or when we reach a node who's element is the key\n" +
                "         */\n" +
                "\n" +
                "        while(current != null && ! current.getElement().equals(key)){\n" +
                "            previous = current;\n" +
                "            current = current.next;  // iterate through list\n" +
                "        }\n" +
                "\n" +
                "        // when we reach here, current is either null or current has element equal to key (therefore remove it)\n" +
                "\n" +
                "        // if current is null - we have reached the end of list and have not found a node with element = key\n" +
                "        if(current == null){\n" +
                "            throw new RuntimeException(\"cannot delete: no element in list with key: \" + key);\n" +
                "        }\n" +
                "\n" +
                "        /*\n" +
                "        We have found a node with element = key\n" +
                "        delete node\n" +
                "        ie, the previous node needs to point to the node that the current node was pointing to\n" +
                "         */\n" +
                "        previous.next = current.next;\n" +
                "\n" +
                "        size --; // reduce size\n" +
                "    }\n" +
                "\n" +
                "    public E remove(int position) {\n" +
                "\n" +
                "        Node<E> current = head;\n" +
                "        Node<E> previous = null;\n" +
                "\n" +
                "        if (position > size-1) {\n" +
                "            throw new RuntimeException(\"Cannot remove node. Position out of bounds.\");\n" +
                "        } else {\n" +
                "            for (int i = 0; i < position; i++) {\n" +
                "                previous = current;\n" +
                "                current = current.next;\n" +
                "            }\n" +
                "\n" +
                "            E temp = current.getElement();\n" +
                "\n" +
                "            previous.setNext(current.getNext());\n" +
                "            // previous points to node that current was pointing to\n" +
                "\n" +
                "            // don't think i need this\n" +
                "            current.setNext(null);\n" +
                "            // current now points to null, and is not pointed to by any nodes\n" +
                "\n" +
                "            return temp;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public E removeFirst(){\n" +
                "\n" +
                "        if(head == null){\n" +
                "            throw new RuntimeException(\"could not remove: list is empty\");\n" +
                "        }\n" +
                "\n" +
                "        else{\n" +
                "            E temp = head.getElement();\n" +
                "            head = head.getNext();\n" +
                "            size--;\n" +
                "            return temp;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public E removeLast(){\n" +
                "        if(head == null){\n" +
                "            throw new RuntimeException(\"could not remove: list is empty\");\n" +
                "        }\n" +
                "\n" +
                "        Node<E> current = head;\n" +
                "        Node<E> previous = null;\n" +
                "        while(current.getNext() != null){\n" +
                "            previous = current;\n" +
                "            current = current.getNext();\n" +
                "        }\n" +
                "        E temp = current.getElement();\n" +
                "        // At this point, current points to null, therefore previous is the 2nd last element and current is the last\n" +
                "        previous.setNext(null);\n" +
                "        size--;\n" +
                "\n" +
                "        return temp;\n" +
                "    }\n" +
                "\n" +
                "    public String toString(){\n" +
                "        String str = \"\";\n" +
                "        for(Iterator<E> it =  new ListIterator(); it.hasNext();){\n" +
                "            E element = it.next();\n" +
                "            str += element + \" \";\n" +
                "\n" +
                "        }\n" +
                "        return str;\n" +
                "    }\n" +
                "\n" +
                "    public boolean isEmpty(){\n" +
                "        return size == 0;}\n" +
                "\n" +
                "\n" +
                "\n" +
                "    public E get(int position){\n" +
                "        if(position > size-1) {\n" +
                "            throw new RuntimeException(\"Error - index out of bounds.\"); }\n" +
                "\n" +
                "        Node<E> current = head;\n" +
                "\n" +
                "\n" +
                "        for (int i = 0; i < position; i++) {\n" +
                "            current = current.next;\n" +
                "        }\n" +
                "\n" +
                "        return current.getElement();\n" +
                "    }\n" +
                "\n" +
                "    // Cloning\n" +
                "\n" +
                "    public SinglyLinkedList<E> copy(){\n" +
                "        SinglyLinkedList<E> twin =new SinglyLinkedList<E>();\n" +
                "        Node<E> temp = head;\n" +
                "        while(temp != null){\n" +
                "            twin.addLast(temp.getElement());\n" +
                "            temp = temp.getNext();\n" +
                "        }\n" +
                "        return twin;\n" +
                "    }\n" +
                "\n" +
                "    public Iterator<E> iterator(){\n" +
                "        return new ListIterator();\n" +
                "    }\n" +
                "\n" +
                "    private class ListIterator implements Iterator<E>{\n" +
                "        Node current;\n" +
                "\n" +
                "        public ListIterator(){\n" +
                "            current = head;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        public boolean hasNext(){\n" +
                "            return current != null;\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public E next(){\n" +
                "            E res = (E) current.getElement();\n" +
                "            current = current.getNext();\n" +
                "            return res;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public E first(){\n" +
                "        if(isEmpty())\n" +
                "            return null;\n" +
                "\n" +
                "        return head.getElement();\n" +
                "    }\n" +
                "\n" +
                "}");
        d.checkDelimiter();
    }
}
