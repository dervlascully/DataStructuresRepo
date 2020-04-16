package projectCode20280.Practical_6_BinarySearchTrees;

import projectCode20280.Practical_4_PriorityQueues.Entry;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();


        Integer[] arr = new Integer[] {44, 17, 88, 8, 32, 65, 82, 97, 28, 54, 22, 93, 21, 29, 76, 80};
        for(Integer i: arr) treeMap.put(i, i);

        System.out.println(treeMap);
        /*
        Random rnd = new Random();
        int n = 16;
        java.util.List<Integer> rands = rnd.ints(1, 1000).limit(n).distinct().boxed().collect(Collectors.toList());

        for(Integer i : rands) {
            treeMap.put(i, i);
        }

        System.out.println("tree entries: " + treeMap.entrySet());

        treeMap.remove(rands.get(1));

        System.out.println("tree entries after removal: " + treeMap.entrySet());

         */

        BinaryTreePrinter<Entry<Integer, Integer>> btp = new BinaryTreePrinter<>(treeMap.tree);
        System.out.println(btp.print());
    }
}
