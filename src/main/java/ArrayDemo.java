import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        demoHomemade();
        System.out.println("\n");
        demoArrayList();
    }

    private static void demoHomemade(){
        System.out.println("Demoing Homemade List");
        System.out.println("-".repeat(100));

        System.out.println("Initializing the homemade List");
        HomeMadeList homeMadeList = new DynamicArray();

        System.out.println("Adding 1, 3, 5 to the homemade list:");
        homeMadeList.add(1);
        homeMadeList.add(3);
        homeMadeList.add(5);

        System.out.println("" + homeMadeList + "\n");

        System.out.println("removing 3 from the list (by removing from index 1)");
        homeMadeList.remove(1);

        System.out.println("" + homeMadeList + "\n");
    }

    private static void demoArrayList(){
        System.out.println("Demoing Javas ArrayList");
        System.out.println("-".repeat(100));

        System.out.println("Initializing the ArrayList");
        List<Integer> arrayList = new ArrayList<>();

        System.out.println("Adding 1, 3, 5 to the ArrayList:");
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);

        System.out.println("" + arrayList + "\n");

        System.out.println("removing 3 from the list (by removing from index 1)");
        arrayList.remove(1);

        System.out.println("" + arrayList + "\n");

    }
}
