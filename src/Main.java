import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Test BST
        BST<Integer, String> binaryTree = new BST<>();
        binaryTree.put(5, "Five");
        binaryTree.put(3, "Three");
        binaryTree.put(4, "Four");
        binaryTree.put(2, "Two");
        binaryTree.put(6, "Six");
        binaryTree.put(7, "Seven");

        binaryTree.inOrder();
        System.out.println();
        System.out.println("Root data before remove: " + binaryTree.getRootValue());
        binaryTree.delete(5);
        System.out.println();
        binaryTree.inOrder();
        System.out.println();
        System.out.println("Root data after remove: " + binaryTree.getRootValue());

        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            String name = "Name" + id;
            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, "Student" + i);
        }

        for (int i = 0; i < table.chainArray.length; i++) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, String> current = table.chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}