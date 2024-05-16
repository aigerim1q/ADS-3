import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Test MyHashTable
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
            MyHashTable.HashNode<MyTestingClass, String> current = ((MyHashTable<MyTestingClass, String>) table).chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
