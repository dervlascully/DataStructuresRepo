package projectCode20280.Practical_2;

import jdk.swing.interop.SwingInterOpUtils;
import projectCode20280.Practical_1.SinglyLinkedList;

public class Test {
    public static void main(String[] args) {

        System.out.println("\nPractical 2 - Stacks & Queues");

        System.out.println("\nCHECK DELIMITERS");
        delimiterMatching d1 = new delimiterMatching("{ (a + (b * c) - myArray[3] * (7 - 6) )}");
        d1.checkDelimiter(); // correct

        delimiterMatching d2 = new delimiterMatching("(( [ { ){})");
        d2.checkDelimiter(); // not correct

        // Optional: Input from console:
        /*
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string.");
        s = sc.nextLine();
        delimiterMatching d = new delimiterMatching(s);
        d.checkDelimiter();
        */

        System.out.println("\nARRAY STACK");
        ArrayStack<Integer> s1 = new ArrayStack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        System.out.println(s1);
        System.out.println("size: " + s1.size());
        s1.pop();
        System.out.println(s1);
        s1.pop();
        System.out.println(s1);
        System.out.println("size: " + s1.size());
        System.out.println("Empty: " + s1.isEmpty());

        System.out.println("\nLINKED STACK");
        LinkedStack<Integer> s2 = new LinkedStack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);
        s2.push(5);
        System.out.println(s2);
        System.out.println("size: " + s2.size());
        s2.pop();
        System.out.println(s2);
        s2.pop();
        System.out.println(s2);
        System.out.println("size: " + s2.size());
        System.out.println("Empty: " + s2.isEmpty());

        System.out.println("\nARRAY QUEUE");
        ArrayQueue<Integer> q1 = new ArrayQueue<>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        System.out.println(q1);
        System.out.println("size: " + q1.size());
        q1.dequeue();
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
        System.out.println("size: " + q1.size());
        System.out.println("Empty: " + q1.isEmpty());

        System.out.println("\nLINKED QUEUE");
        ArrayQueue<Integer> q2 = new ArrayQueue<>();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        q2.enqueue(5);
        System.out.println(q2);
        System.out.println("size: " + q2.size());
        q2.dequeue();
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
        System.out.println("size: " + q2.size());
        System.out.println("Empty: " + q2.isEmpty());

        // See SinglyLinkedList class in practical 1 for reverse method.
        System.out.println("\nPRACTICAL 2 Q2. REVERSE");
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<>();
        l4.addFirst(1);
        l4.addFirst(2);
        l4.addFirst(3);
        l4.addFirst(4);
        l4.addFirst(5);
        System.out.println(l4);
        l4.reverse();
        System.out.println("Reverse: " + l4);

        System.out.println("\nBOUNDED STACK");
        BoundedStack<Integer> s3 = new BoundedStack<>(3);
        s3.push(1);
        s3.push(2);
        s3.push(3);
        System.out.println(s3);
        s3.pop();
        System.out.println(s3);
        s3.push(4);
        System.out.println(s3);
        try {
            s3.push(5);
        }
        catch(Exception e){
            System.out.println("Cannot add note, stack out of bounds");
        }


    }
}
