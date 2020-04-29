
Repo for COMP20280 - Data Structures
Dervla Scully 18329511

This repository contains the code from the practical sessions for COMP20280.
It is divided up into a package/folder for each practical session / topic. Each contains a main and a Test class, containing JUnit tests (all contain tests provided by lecturer, and some contain additional tests that I wrote myself throughout the year when implementing the various datastructures).

1. Practical 1 - Linked Lists
This folder contains the List interface, the Singly, Doubly and Circularly Linked List classes, and a main.
A SinglyLinkedList is a data structure which provides an alternative to an array-based structure. A linked list, in its simplest form, is a collection of nodes that collectively form a linear sequence. In a singly linked list, each node stores a reference to an object that is an element of the sequence, as well as a reference to the next node of the list. A Circularly Linked List is essentially a singularly linked list in which the next reference of the tail node (the last node) is set to refer back to the head of the list (rather than null). A Doubly Linked List is a linked list in which each node keeps an explicit reference to the node before it and a reference to the node after it.

2. Practical 2 - Stacks and Queues
This folder contains the Stack and Queue interfaces, the ArrayQueue, ArrayStack, LinkedQueue and LinkedStack classes, and a main. It also contains classes delimiterMatching and BoundedStack which are relating to questions from the practical session. 
A stack is a collection of objects that are inserted and removed according to the last-in, first-out (LIFO) principle. ArrayStack implements a stack using an array, wherease LinkedStack implementd a stack using a Linked List. A queue is a collection of objects that are inserted and removed according to the first-in, first-out (FIFO) principle. Again, ArrayQueue implememts a queue using an array, whereas LinkedQueue implements a queue using an array.

3. Practical 3 - Trees
This folder contains the Tree, BinaryTree and Position interfaces, The AbstractTree and AbstractBinaryTree abstract classes and the LinkedBinaryTree class.
A tree is an abstract data type that stores elements hierarchically. With the excep- tion of the top element, each element in a tree has a parent element and zero or more children elements. A binary tree is an ordered tree with the following properties:Every node has at most two children, each child node is labeled as being either a left child or a right child, a left child precedes a right child in the order of children of a node. LinkedBinaryTree implements a BinaryTree using a LinkedList.

4. Practical 4 - Priority Queues
This folder contains the Entry and PriorityQueue interfaces, the AbstractPriorityQueue abstract class, and the DefaultComparator and HeapedPriorityQueue classes. It also contains a PQSort class, which relates to Assignment 1.
A queue is a collection of objects that are added and removed according to the first-in, first-out (FIFO) principle. A Priority Queue is a collection of prioritized elements that allows arbitrary element insertion, and allows the removal of the element that has first priority.

5. Practical 5 - Hash Maps
This folder contains the Map interface, the AbstractMap and AbstractHashMap abstract classes and the UnsortedTableMap and ChainHashMap classes. It also contains a WordCounter class and a sample_text file which relate to the practical questions.
A map is an abstract data type designed to efficiently store and retrieve values based upon a uniquely identifying search key for each. Specifically, a map stores key- value pairs (k, v), which we call entries, where k is the key and v is its corresponding value. ChainHashMap provides implementation of the Map interface. ChainHashMap uses a technique called hashing.  Hashing is a technique of converting a large String to small String that represents the same String. A shorter value helps in indexing and faster searches.

6. Practical 6 - Binary Search Trees
This folder contains the SortedMap interface, the AbstractSortedMap abstract class, and the BinaryTreePrinter and TreeMap classes. 
We define a Binary Search Tree as a proper binary tree, such that each internal position p stores a key-value pair (k,v) such that: keys stored in the left subtree of p are less than k, keys stored in the right subtree of p are greater than k.

7. AVl and Splay Tree
This folder contains classes AVLTreeMap, SplayTreeMap and BalanceableBinaryTree.
An AVLTreeMap is a Binary search tree in which the following Height Balance Property is maintained: For every internal position p of T , the heights of the children of p differ by at most 1. Due to the height balance property, the height of an AVL tree storing n entries is O(logn). The insertion and deletion operations for AVL trees begin similarly to the corre- sponding operations for (standard) binary search trees, but with post-processing for each operation to restore the balance of any portions of the tree that are adversely affected by the change. A Splay Tree is another balanced binary tree, but which does not strictly enforce a logarithmic upper bound on the height of the tree. In a Splay Tree, a move-to-root operation, called splaying, is performed at the bottommost position p reached during every insertion, deletion, or search. The splay operation causes more frequently accessed elements to remain nearer to the root, thereby reducing the typical search times. Splaying allows us to guarantee a logarithmic amortized running time, for insertions, deletions, and searches.




