package projectCode20280.Practical_3_Trees;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nPractical 3 - Trees\n");

        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

        int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        for(int i : arr) {
            bt.insert(i);
        }

        System.out.println("Binary Tree: " + bt + "\nsize: " + bt.size());

        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        Position<Integer> root = tree.addRoot(5);
        Position<Integer> leftChild1 = tree.addLeft(root,3);
        Position<Integer> rightChild1 = tree.addRight(root, 6);

        tree.addLeft(leftChild1, 2);
        tree.addRight(leftChild1, 4);

        System.out.println("\nBinary Tree: " + tree);
        System.out.println("\nPre Order: ");
        tree.preorder().forEach(node -> {
            System.out.println(node.getElement());
        });

        System.out.println("\nPost Order: ");
        tree.postorder().forEach(node -> {
            System.out.println(node.getElement());
        });



    }


}
