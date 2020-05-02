package projectCode20280.Practical_6_BinarySearchTrees;

import projectCode20280.Practical_4_PriorityQueues.Entry;

import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        Random rnd = new Random();
        int n = 16;
        java.util.List<Integer> rands = rnd.ints(1, 1000).limit(n).distinct().boxed().collect(Collectors.toList());

        for(Integer i : rands) {
            treeMap.put(i, i);
        }

        System.out.println("\n\nTree entries:\n" + treeMap.entrySet() + "\n");
        BinaryTreePrinter<Entry<Integer, Integer>> btp = new BinaryTreePrinter<>(treeMap.tree);
        System.out.println(btp.print());



        System.out.println("\n\nRemove: " + treeMap.remove(rands.get(1)) + "\n");
        System.out.println("Tree entries after removal:\n" + treeMap.entrySet() + "\n");
        System.out.println(btp.print());
    }
}
