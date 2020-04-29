package projectCode20280.Practical_7_AVL_Splay;

public class Main {
    public static void main(String[] args) {
        AVLTreeMap<Integer, Integer> avl = new AVLTreeMap<>();

//        avl.put(2, 2);
//        avl.put(3, 3);
//        avl.put(3, 9);
//        System.out.println("result: " + avl.get(2));
//        System.out.println("result: " + avl.get(3));

//        avl.put(2, 2);
//        avl.put(3, 3);
//        avl.put(4, 4);
//        System.out.println("result: " + avl.get(2));
//        System.out.println("result: " + avl.get(3));
//        System.out.println("result: " + avl.get(4));


        Integer[] arr = new Integer[] { 44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21, 29, 76, 80 };
        for (Integer i : arr) {
            avl.put(i, i);
        }
        System.out.println("avl: " + avl);
        avl.remove(arr[0]);
        System.out.println("avl: " + avl);
        System.out.println(avl.get(17));
//        AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
//        Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

//        for(Integer i : arr) {
//            map.put(i, Integer.toString(i));
//        }
//        map.put(35, "35");
//        map.put(26, "26");
//        map.put(15, "15");
//        map.put(24, "24");
//        map.put(33, "33");
//        map.put(4, "4");
//        map.put(12, "12");
//        map.put(1, "1");
//        map.put(23, "23");
//        System.out.println(map.get(35));
//        System.out.println(map);
//        map.remove(35);
//        System.out.println(map);
////        map.get(26);

    }
}
