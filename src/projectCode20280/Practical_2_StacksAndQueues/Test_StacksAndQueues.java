package projectCode20280.Practical_2_StacksAndQueues;
import org.junit.Test;

import static org.junit.Assert.*;


public class Test_StacksAndQueues {

    ArrayQueue<Integer> aq = new ArrayQueue<>();

    @Test
    public void enqueueAQ(){
        aq.enqueue(1);
        aq.enqueue(2);
        assertEquals("front -> 1 2  <- rear", aq.toString());
    }

    @Test
    public void dequeueAQ(){
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        assertTrue(aq.dequeue() == 1);
        assertEquals("front -> 2 3  <- rear", aq.toString());
    }

    @Test
    public void isEmptyAQ(){
        assertTrue(aq.isEmpty());
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        assertFalse(aq.isEmpty());
    }

    @Test
    public void sizeAQ(){
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        assertTrue(aq.size() == 3);
        aq.dequeue();
        assertTrue(aq.size() == 2);
    }

    @Test
    public void firstAQ(){
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        assertTrue(aq.first() == 1);
    }

    /* ******************************************************************************** */

    ArrayStack<Integer> as = new ArrayStack<>();

    @Test
    public void pushAS(){
        as.push(0);
        as.push(1);
        as.push(2);
        assertEquals("top -> 2 1 0 ", as.toString());
    }

    @Test
    public void popAS(){
        as.push(0);
        as.push(1);
        as.push(2);
        as.pop();
        assertEquals("top -> 1 0 ", as.toString());
    }

    @Test
    public void isEmptyAS(){
        assertTrue(as.isEmpty());
        as.push(0);
        as.push(1);
        as.push(2);
        assertFalse(as.isEmpty());
    }

    @Test
    public void sizeAS(){
        as.push(0);
        as.push(1);
        as.push(2);
        assertEquals(3, as.size());
        as.pop();
        assertEquals(2, as.size());
    }

    @Test
    public void topAS(){
        as.push(0);
        as.push(1);
        as.push(2);
        assertTrue( as.top() == 2);
    }

    /* ******************************************************************************** */

    LinkedQueue<Integer> lq = new LinkedQueue<>();

    @Test
    public void enqueueLQ(){
        lq.enqueue(1);
        lq.enqueue(2);
        assertEquals("[1, 2]", lq.toString());
    }

    @Test
    public void dequeueLQ(){
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        assertTrue(lq.dequeue() == 1);
        assertEquals("[2, 3]", lq.toString());
    }

    @Test
    public void isEmptyLQ(){
        assertTrue(lq.isEmpty());
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        assertFalse(lq.isEmpty());
    }

    @Test
    public void sizeLQ(){
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        assertTrue(lq.size() == 3);
        lq.dequeue();
        assertTrue(lq.size() == 2);
    }

    @Test
    public void firstLQ(){
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        assertTrue(lq.first() == 1);
    }

    /* ******************************************************************************** */

    LinkedStack<Integer> ls = new LinkedStack<>();

    @Test
    public void pushLS(){
        ls.push(0);
        ls.push(1);
        ls.push(2);
        assertEquals("[2, 1, 0]", ls.toString());
    }

    @Test
    public void popLS(){
        ls.push(0);
        ls.push(1);
        ls.push(2);
        ls.pop();
        assertEquals("[1, 0]", ls.toString());
    }

    @Test
    public void isEmptyLS(){
        assertTrue(ls.isEmpty());
        ls.push(0);
        ls.push(1);
        ls.push(2);
        assertFalse(ls.isEmpty());
    }

    @Test
    public void sizeLS(){
        ls.push(0);
        ls.push(1);
        ls.push(2);
        assertEquals(3, ls.size());
        ls.pop();
        assertEquals(2, ls.size());
    }

    @Test
    public void topLS(){
        ls.push(0);
        ls.push(1);
        ls.push(2);
        assertTrue( ls.top() == 2);
    }
}
