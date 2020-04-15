package projectCode20280.Practical_1_LinkedLists;

import static org.junit.Assert.assertTrue;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nPractical 1 - Linked Lists\n");

        System.out.println("\nSINGLY LINKED LIST");
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        System.out.println(l1);
        l1.addLast(4);
        System.out.println(l1);
        l1.add(2, 5);
        System.out.println(l1);
        l1.removeFirst();
        System.out.println(l1);
        l1.removeLast();
        System.out.println(l1);
        l1.remove(2);
        System.out.println(l1);


        System.out.println("\nDOUBLY LINKED LIST");
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.addFirst(1);
        l2.addFirst(2);
        l2.addFirst(3);
        System.out.println(l2);
        l2.addLast(4);
        System.out.println(l2);
        l2.add(2, 5);
        System.out.println(l2);
        l2.removeFirst();
        System.out.println(l2);
        l2.removeLast();
        System.out.println(l2);
        l2.remove(2);
        System.out.println(l2);

        System.out.println("\nCIRCULARLY LINKED LIST");
        CircularlyLinkedList<Integer> l3 = new CircularlyLinkedList<>();
        l3.addFirst(1);
        l3.addFirst(2);
        l3.addFirst(3);
        System.out.println(l3);
        l3.addLast(4);
        System.out.println(l3);
        l3.add(2, 5);
        System.out.println(l3);
        l3.removeFirst();
        System.out.println(l3);
        l3.removeLast();
        System.out.println(l3);
        l3.remove(2);
        System.out.println(l3);

        System.out.println("\nPRACTICAL 2 Q2. REVERSE");
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<>();
        l4.addFirst(1);
        l4.addFirst(2);
        l4.addFirst(3);
        l4.addFirst(4);
        l4.addFirst(5);
        System.out.println(l4);
        l4.reverse();
        System.out.println(l4);


        System.out.println("\nDOUBLY LINKED LIST");
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        System.out.println(l);
        l.addLast(4);
        System.out.println(l);
        l.add(2, 5);
        System.out.println(l);

    }
}




























