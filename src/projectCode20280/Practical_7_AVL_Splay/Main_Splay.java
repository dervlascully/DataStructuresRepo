package projectCode20280.Practical_7_AVL_Splay;

import java.util.Random;
import java.util.stream.Collectors;

public class Main_Splay {

    public static void main(String[] args) {

        SplayTreeMap<Integer, Integer> splay = new SplayTreeMap<>();

        Random rnd = new Random();
        int n = 16;
        java.util.List<Integer> rands = rnd.ints(1, 1000).limit(n).distinct().boxed().collect(Collectors.toList());

        for(Integer i : rands) {
            splay.put(i, i);
        }
        System.out.println("\n\nTree entries:\n" + splay.entrySet() + "\n");
        System.out.println(splay.toBinaryTreeString());

        int [] array = {1, 10, 4, 16, 2};
        for(int i=0; i<array.length; i++) {

            if(i%2 == 0) {
                System.out.println("\n\nRemove: " + splay.remove(rands.get(i)) + "\n");
            }
            else{
                splay.put(rands.get(i)*3, rands.get(i*3));
                System.out.println("\n\nInsert: " + rands.get(i*3) + "\n");
            }
            System.out.println("\n\nTree entries:\n" + splay.entrySet() + "\n");
            System.out.println(splay.toBinaryTreeString());
        }

    }
}
