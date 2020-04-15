package projectCode20280.Practical_5_HashMaps;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class Test_HashMaps {

    ChainHashMap<Integer, Integer> map = new ChainHashMap<>();

    @Test
    public void putTest(){
        map.put(0, 0);
        assertEquals("[<0, 0>]", map.toString());
    }

    @Test
    public void getTest(){
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        assertTrue(map.get(1) == 1);
        assertTrue(map.get(3) == null);
    }

    @Test
    public void removeTest(){
        map.put(0, 0);
        map.put(1, 1);
        map.remove(0);
        assertEquals("[<1, 1>]", map.toString());
    }

    @Test
    public void sizeTest(){
        assertEquals(0, map.size());
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        assertEquals(3, map.size());
        map.remove(0);
        assertEquals(2, map.size());

    }

    @Test
    public void isEmptyTest(){
        assertTrue(map.isEmpty());
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        assertFalse(map.isEmpty());
    }

    @Test
    public void keySetTest(){
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);

        ArrayList<Integer> array = new ArrayList<>();
        for(int x : map.keySet() )
            array.add(x);

        assertTrue(array.contains(0) && array.contains(1) && array.contains(2) && array.size() == 3);
    }

    @Test
    public void valueSetTest(){
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);

        ArrayList<Integer> array = new ArrayList<>();
        for(int x : map.values() )
            array.add(x);

        assertTrue(array.contains(0) && array.contains(1) && array.contains(2) && array.size() == 3);
    }

}
