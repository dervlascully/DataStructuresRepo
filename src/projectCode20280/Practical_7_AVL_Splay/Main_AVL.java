package projectCode20280.Practical_7_AVL_Splay;

import projectCode20280.Practical_4_PriorityQueues.Entry;
import projectCode20280.Practical_6_BinarySearchTrees.BinaryTreePrinter;

import java.util.Random;
import java.util.stream.Collectors;

public class Main_AVL {
    public static void main(String[] args) {
        AVLTreeMap<Integer, Integer> avl = new AVLTreeMap<>();

        Random rnd = new Random();
        int n = 16;
        java.util.List<Integer> rands = rnd.ints(1, 1000).limit(n).distinct().boxed().collect(Collectors.toList());

        for(Integer i : rands) {
            avl.put(i, i);
        }
        System.out.println("\n\nTree entries:\n" + avl.entrySet() + "\n");
        System.out.println(avl.toBinaryTreeString());

        int [] array = {1, 10, 4, 16, 2};
        for(int i=0; i<array.length; i++) {

            if(i%2 == 0) {
                System.out.println("\n\nRemove: " + avl.remove(rands.get(i)) + "\n");
            }
            else{
                avl.put(rands.get(i)*3, rands.get(i*3));
                System.out.println("\n\nInsert: " + rands.get(i*3) + "\n");
            }
            System.out.println("\n\nTree entries:\n" + avl.entrySet() + "\n");
            System.out.println(avl.toBinaryTreeString());
        }


    }
}
