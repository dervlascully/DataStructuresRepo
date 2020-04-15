package projectCode20280.Practical_4_PriorityQueues;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class Test_PriorityQueues {

    HeapPriorityQueue<Integer, Integer> hpq = new HeapPriorityQueue<>();

    @Test
    public void insertTest(){
        hpq.insert(0, 1);
        Entry<Integer, Integer> e = hpq.insert(0, 1);
        assertTrue(e.getKey() == 0);
        assertTrue(e.getValue() == 1);
    }

    @Test
    public void removeMinTest(){
        int[] keys = {5, 7, 34, 98, 2, 1, 7};
        for(int i=0; i<keys.length; i++){
            hpq.insert(keys[i], keys[i]);
        }

        assertTrue(hpq.removeMin().getKey() == 1);

    }

    @Test
    public void sizeTest(){
        int[] keys = {5, 7, 34, 98, 2, 1, 7};
        for(int i=0; i<keys.length; i++){
            hpq.insert(keys[i], keys[i]);
        }
        assertEquals(7, hpq.size());
    }

    @Test
    public void isEmptyTest(){
        assertTrue(hpq.isEmpty());
        int[] keys = {5, 7, 34, 98, 2, 1, 7};
        for(int i=0; i<keys.length; i++){
            hpq.insert(keys[i], keys[i]);
        }
        assertFalse(hpq.isEmpty());
    }

    // Tests if the Heaped Priority Queue can be used to sort an array correctly
    @Test
    public void sortTest(){
        int[] keys = {5, 7, 34, 98, 2, 1, 7};
        for(int i=0; i<keys.length; i++){
            hpq.insert(keys[i], keys[i]);
        }

        ArrayList<Integer> array = new ArrayList<>();
        while (!hpq.isEmpty())
            array.add(hpq.removeMin().getValue());

        assertEquals("[1, 2, 5, 7, 7, 34, 98]", array.toString());
    }
}
