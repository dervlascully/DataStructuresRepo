//package projectCode20280.Practical_1_LinkedLists;
//import org.junit.Test;
//
//
//import static org.junit.Assert.*;
//
//public class Test_LinkedList {
//
//    SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
//
//    @Test
//    public void addFirstSLL(){
//        sll.addFirst(1);
//        assertEquals("1 ", sll.toString());
//    }
//
//    @Test
//    public void addLastSLL(){
//        sll.addFirst(1);
//        sll.addLast(3);
//        assertEquals("1 3 ", sll.toString());
//    }
//
//    @Test
//    public void addSLL(){
//        sll.addFirst(1);
//        sll.addLast(3);
//        sll.add(1, 6);
//        assertEquals("1 6 3 ", sll.toString());
//    }
//
//    @Test
//    public void sizeSLL(){
//        sll.addFirst(1);
//        sll.addLast(3);
//        sll.add(1, 6);
//        sll.remove(0);
//        assertEquals(2, sll.size());
//    }
//
//    @Test
//    public void removeSLL(){
//        sll.addFirst(1);
//        sll.addLast(3);
//        sll.add(1, 6);
//        sll.add(3, 7);
//        assertTrue(sll.remove(1) == 6);
//        assertEquals("1 3 7 ", sll.toString());
//    }
//
//    @Test
//    public void removeFirstSLL(){
//        sll.addFirst(1);
//        sll.addLast(3);
//        sll.add(1, 6);
//        assertTrue(sll.removeFirst() == 1);
//        assertEquals("6 3 ", sll.toString());
//    }
//
//    @Test
//    public void removeLastSLL(){
//        sll.addFirst(1);
//        sll.addLast(3);
//        sll.add(1, 6);
//        sll.add(3, 7);
//        assertTrue(sll.removeLast() == 7);
//        assertEquals("1 6 3 ", sll.toString());
//    }
//
//    @Test
//    public void firstSLL(){
//        sll.addFirst(3);
//        sll.addFirst(2);
//        sll.addFirst(1);
//        assertTrue(sll.first() == 1);
//    }
//
//    @Test
//    public void getSLL(){
//        sll.addFirst(3);
//        sll.addFirst(2);
//        sll.addFirst(1);
//        assertTrue(sll.get(1) == 2);
//    }
//    @Test
//    public void isEmptySLL(){
//        assertTrue(sll.isEmpty());
//        sll.addFirst(3);
//        sll.addFirst(2);
//        sll.addFirst(1);
//        assertFalse(sll.isEmpty());
//    }
//
//    @Test
//    public void removeKeySLL(){
//        sll.addFirst(3);
//        sll.addFirst(2);
//        sll.addFirst(1);
//        sll.addFirst(0);
//        sll.removeKey(2);
//        assertEquals("0 1 3 ", sll.toString());
//    }
//
//    @Test
//    public void insertAfterSLL(){
//        sll.addFirst(3);
//        sll.addFirst(2);
//        sll.addFirst(1);
//        sll.addFirst(0);
//        sll.insertAfter(2, 9);
//        assertEquals("0 1 2 9 3 ", sll.toString());
//    }
//
//    /* ******************************************************************************** */
//
//    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
//
//    @Test
//    public void addFirstDLL(){
//        dll.addFirst(1);
//        assertEquals("1 ", dll.toString());
//    }
//
//    @Test
//    public void addLastDLL(){
//        dll.addFirst(1);
//        dll.addLast(3);
//        assertEquals("1 3 ", dll.toString());
//    }
//
//    @Test
//    public void addDLL(){
//        dll.addFirst(1);
//        dll.addLast(3);
//        dll.add(1, 6);
//        assertEquals("1 6 3 ", dll.toString());
//    }
//
//    @Test
//    public void sizeDLL(){
//        dll.addFirst(1);
//        dll.addLast(3);
//        dll.add(1, 6);
//        dll.remove(0);
//        assertEquals(2, dll.size());
//    }
//
//    @Test
//    public void removeDLL(){
//        dll.addFirst(1);
//        dll.addLast(3);
//        dll.add(1, 6);
//        dll.add(3, 7);
//        assertTrue(dll.remove(1) == 6);
//        assertEquals("1 3 7 ", dll.toString());
//    }
//
//    @Test
//    public void removeFirstDLL(){
//        dll.addFirst(1);
//        dll.addLast(3);
//        dll.add(1, 6);
//        assertTrue(dll.removeFirst() == 1);
//        assertEquals("6 3 ", dll.toString());
//    }
//
//    @Test
//    public void removeLastDLL(){
//        dll.addFirst(1);
//        dll.addLast(3);
//        dll.add(1, 6);
//        dll.add(3, 7);
//        assertTrue(dll.removeLast() == 7);
//        assertEquals("1 6 3 ", dll.toString());
//    }
//
//
//    @Test
//    public void getDLL(){
//        dll.addFirst(3);
//        dll.addFirst(2);
//        dll.addFirst(1);
//        assertTrue(dll.get(1) == 2);
//    }
//
//    @Test
//    public void isEmptyDLL(){
//        assertTrue(dll.isEmpty());
//        dll.addFirst(3);
//        dll.addFirst(2);
//        dll.addFirst(1);
//        assertFalse(dll.isEmpty());
//    }
//
//    @Test
//    public void removeKeyDLL(){
//        dll.addFirst(3);
//        dll.addFirst(2);
//        dll.addFirst(1);
//        dll.addFirst(0);
//        dll.removeKey(2);
//        assertEquals("0 1 3 ", dll.toString());
//    }
//
//    @Test
//    public void insertAfterDLL(){
//        dll.addFirst(3);
//        dll.addFirst(2);
//        dll.addFirst(1);
//        dll.addFirst(0);
//        dll.insertAfter(2, 9);
//        assertEquals("0 1 2 9 3 ", dll.toString());
//    }
//
//    /* ******************************************************************************** */
//
//    CircularlyLinkedList<Integer> cll = new CircularlyLinkedList<>();
//
//    @Test
//    public void addFirstCLL(){
//        cll.addFirst(1);
//        assertEquals("1 ", cll.toString());
//    }
//
//    @Test
//    public void addLastCLL(){
//        cll.addFirst(1);
//        cll.addLast(3);
//        assertEquals("1 3 ", cll.toString());
//    }
//
//    @Test
//    public void addCLL(){
//        cll.addFirst(1);
//        cll.addLast(3);
//        cll.add(1, 6);
//        assertEquals("1 6 3 ", cll.toString());
//    }
//
//    @Test
//    public void sizeCLL(){
//        cll.addFirst(1);
//        cll.addLast(3);
//        cll.add(1, 6);
//        cll.remove(0);
//        assertEquals(2, cll.size());
//    }
//
//    @Test
//    public void removeCLL(){
//        cll.addFirst(1);
//        cll.addLast(3);
//        cll.add(1, 6);
//        cll.add(3, 7);
//        assertTrue(cll.remove(1) == 6);
//        assertEquals("1 3 7 ", cll.toString());
//    }
//
//    @Test
//    public void removeFirstCLL(){
//        cll.addFirst(1);
//        cll.addLast(3);
//        cll.add(1, 6);
//        assertTrue(cll.removeFirst() == 1);
//        assertEquals("6 3 ", cll.toString());
//    }
//
//    @Test
//    public void removeLastCLL(){
//        cll.addFirst(1);
//        cll.addLast(3);
//        cll.add(1, 6);
//        cll.add(3, 7);
//        assertTrue(cll.removeLast() == 7);
//        assertEquals("1 6 3 ", cll.toString());
//    }
//
//
//    @Test
//    public void getCLL(){
//        cll.addFirst(3);
//        cll.addFirst(2);
//        cll.addFirst(1);
//        assertTrue(cll.get(1) == 2);
//    }
//
//    @Test
//    public void isEmptyCLL(){
//        assertTrue(cll.isEmpty());
//        cll.addFirst(3);
//        cll.addFirst(2);
//        cll.addFirst(1);
//        assertFalse(cll.isEmpty());
//    }
//
//
//}
