package projectCode20280.Practical_4;


import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class PQSort {

    public static void main(String[] args) {
        main2(args);
    }

    public static void main1(String[] args) {


        int n = 100;
        while(n < 100000) {

            LinkedList<Integer> arr = new Random().ints(0, 1000).distinct().limit(n).boxed().collect(Collectors.toCollection(LinkedList::new));

            final long startTime = System.nanoTime();

            // Phase 1 - move elements from arr -> PQ
            LinkedList<Integer> PQ = new LinkedList<>();
            while (!arr.isEmpty())
                PQ.addLast(arr.removeFirst());

            // Phase 2 - move elements PQ -> arr
            while (!PQ.isEmpty())
                arr.addLast(removeMin(PQ));

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;


            boolean isSorted = isSorted(arr.toArray(new Integer[arr.size()]), arr.size());
            System.out.println(n + ", " + elapsedTime);

            n *= 1.1;
        }

    }

    public static void main2(String[] args) {

        int n = 50;
        while(n <= 110) {

            LinkedList<Integer> arr = new Random().ints(0, 1000).distinct().limit(n).boxed().collect(Collectors.toCollection(LinkedList::new));
            final long startTime = System.nanoTime();
            System.out.println("\n\n" + arr + "\n");

            // Phase 1 - move elements from arr -> PQ
            HeapPriorityQueue<Integer, Integer> PQ = new HeapPriorityQueue<>();
            while (!arr.isEmpty()) {
                Integer val = arr.removeFirst();
                PQ.insert(val, val);
            }


            // Phase 2 - move elements PQ -> arr
            while (!PQ.isEmpty())
                arr.addLast(PQ.removeMin().getValue());

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;


            boolean isSorted = isSorted(arr.toArray(new Integer[arr.size()]), arr.size());
            System.out.println(n + " " + elapsedTime);

            System.out.println("\n" + arr);

            n += 10;
        }

//        while(n < 100000) {
//
//            LinkedList<Integer> arr = new Random().ints(0, 1000).distinct().limit(n).boxed().collect(Collectors.toCollection(LinkedList::new));
//
//            final long startTime = System.nanoTime();
//
//            // Phase 1 - move elements from arr -> PQ
//            HeapPriorityQueue<Integer, Integer> PQ = new HeapPriorityQueue<>();
//            while (!arr.isEmpty()){
//                Integer val = arr.removeFirst();
//                PQ.insert(val, val);
//            }
//
//
//            // Phase 2 - move elements PQ -> arr
//            while (!PQ.isEmpty())
//                arr.addLast(PQ.removeMin().getValue());
//
//            long endTime = System.nanoTime();
//            long elapsedTime = endTime - startTime;
//
//
//            boolean isSorted = isSorted(arr.toArray(new Integer[arr.size()]), arr.size());
//            System.out.println(n + " " + elapsedTime);
//
//            n *= 1.1;
//        }


    }

    public static Integer removeMin(LinkedList<Integer> ll){
        int min_index = 0;
        Integer min_val = ll.get(min_index);

        for(int i=1; i<ll.size(); i++){
            Integer curr = ll.get(i);
            if(curr < min_val){
                min_val = curr;
                min_index = i;
            }
        }
        ll.remove(min_index);
        return min_val;
    }

    public static boolean isSorted(Comparable[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }
}
