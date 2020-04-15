package projectCode20280.Practical_3_Trees;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_Trees {

    LinkedBinaryTree<Integer> lb = new LinkedBinaryTree<>();

    @Test
    public void insertTest(){
        int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        for(int i : arr) {
            lb.insert(i);
        }
        assertEquals("[12, 25, 31, 36, 42, 58, 62, 75, 90]", lb.toString());
    }

    @Test
    public void rootTest(){
        int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        for(int i : arr) {
            lb.insert(i);
        }
        assertTrue(lb.root.getElement() == 12);
    }

    @Test
    public void sizeTest(){
        int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        for(int i : arr) {
            lb.insert(i);
        }
        assertEquals(9, lb.size());
    }

    @Test
    public void isEmptyTest(){
        assertTrue(lb.isEmpty());
        int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        for(int i : arr) {
            lb.insert(i);
        }
        assertFalse(lb.isEmpty());
    }

    @Test
    public void postOrderTest(){
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(5);
        Position<Integer> leftChild1 = tree.addLeft(root,3);
        Position<Integer> rightChild1 = tree.addRight(root, 6);
        tree.addLeft(leftChild1, 2);
        tree.addRight(leftChild1, 4);
        String s = "";
        for(Position<Integer> p : tree.postorder()){
            s += p.getElement() + "\n";
        }

        assertEquals("2\n" + "4\n" + "3\n" + "6\n" + "5\n", s);
    }

    @Test
    public void preOrderTest(){
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(5);
        Position<Integer> leftChild1 = tree.addLeft(root,3);
        Position<Integer> rightChild1 = tree.addRight(root, 6);
        tree.addLeft(leftChild1, 2);
        tree.addRight(leftChild1, 4);
        String s = "";
        for(Position<Integer> p : tree.preorder()){
            s += p.getElement() + "\n";
        }
        assertEquals("5\n" + "3\n" + "2\n" + "4\n" + "6\n", s);
    }
}
