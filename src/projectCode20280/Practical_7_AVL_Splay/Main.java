package projectCode20280.Practical_7_AVL_Splay;

public class Main {
    public static void main(String[] args) {
        SplayTreeMap<Integer, Integer> STM = new SplayTreeMap<>();
        Integer[] arr = new Integer[] {44, 17, 88, 8, 32, 65, 82, 97, 28, 54, 22, 93, 21, 29, 76, 80};
        for(Integer i: arr) STM.put(i, i);
        System.out.println(STM);
    }
}
