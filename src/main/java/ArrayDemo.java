import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        Demo.reset(ConsoleColor.BLUE); // Simply here to centralize the colors
        demoHomemade();
        Demo.reset(ConsoleColor.GREEN);
        demoArrayList();
        Demo.reset(ConsoleColor.PURPLE);
        demoExpansion();
    }

    private static void demoExpansion() {
        Demo.header("Demoing the expansion of our homemade List");

        Demo.next("Initializing the homemade List");
        HomeMadeList homeMadeList = new DynamicArray();

        Demo.next("Adding 1, 2, 3, 4, 5, 6 to the homemade list:");
        homeMadeList.add(1);
        homeMadeList.add(2);
        homeMadeList.add(3);
        homeMadeList.add(4);
        homeMadeList.add(5);
        homeMadeList.add(6);

        System.out.println("" + homeMadeList + "\n");

        System.out.printf("The underlying array currently has the size: %d%s", homeMadeList.getUnderlyingSize(), "\n");

        Demo.next("Add another element to the array causes growth");
        homeMadeList.add(7);
        System.out.println(homeMadeList);
        System.out.printf("The underlying array now has the size: %d%s", homeMadeList.getUnderlyingSize(), "\n");

        Demo.next("Removing the element causes the array to shrink");
        System.out.printf("The underlying array currently has the size: %d%s", homeMadeList.getUnderlyingSize(), "\n");
        System.out.printf("Removing %d from index %d%s", homeMadeList.remove(2), 2, "\n");
        System.out.printf("The underlying array now has the size: %d%s", homeMadeList.getUnderlyingSize(), "\n");

        System.out.println("" + homeMadeList + "\n");


    }

    private static void demoHomemade() {
        Demo.header("Demoing Homemade List");

        Demo.next("Initializing the homemade List");
        HomeMadeList homeMadeList = new DynamicArray();

        Demo.next("Adding 1, 3, 5 to the homemade list:");
        homeMadeList.add(1);
        homeMadeList.add(3);
        homeMadeList.add(5);

        System.out.println("" + homeMadeList + "\n");

        Demo.next("Removing 3 from the list (by removing from index 1)");
        int removed = homeMadeList.remove(1);
        System.out.printf("The value removed was %d%s", removed, "\n");

        System.out.println("" + homeMadeList + "\n");

        Demo.next("Get from the list");
        int theIndex = 1;
        int myValue = homeMadeList.get(theIndex);
        System.out.printf("Getting the element at index %d, it is %d%s", theIndex, myValue, "\n\n");

        Demo.next("Trying to get from an index that is too high throws an exception");
        try {
            homeMadeList.get(2);
            // Since an exception causes us to leave this scope immediately,
            // the below statement is only executed if the exception is not thrown
            System.out.println("Exception is not thrown as expected");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown as expected:\n\t" + e.getMessage() + "\n");
        }

        Demo.next("Trying to remove from an index that is too high throws an exception");
        try {
            homeMadeList.remove(2);
            System.out.println("Exception is not thrown as expected");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown as expected:\n\t" + e.getMessage());
        }

        Demo.next("Using set on an index, that is outside the current length throws an exception");
        try {
            homeMadeList.set(2, 2);
            System.out.println("Exception is not thrown as expected");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown as expected:\n\t" + e.getMessage());
        }

        System.out.println("" + homeMadeList + "\n");

        Demo.next("Using set on an index, that is within the allowed does not throw an exception and changes the value");
        homeMadeList.set(0, 200);

        System.out.println("" + homeMadeList + "\n");


    }

    private static void demoArrayList() {
        Demo.header("Demoing Javas ArrayList");

        Demo.next("Initializing the ArrayList");
        List<Integer> arrayList = new ArrayList<>();

        Demo.next("Adding 1, 3, 5 to the ArrayList:");
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);

        System.out.println("" + arrayList + "\n");

        Demo.next("removing 3 from the list (by removing from index 1)");
        int removed = arrayList.remove(1);
        System.out.printf("The value removed was %d%s", removed, "\n");

        System.out.println("" + arrayList + "\n");

        Demo.next("Get from the list");
        int theIndex = 1;
        int myValue = arrayList.get(theIndex);
        System.out.printf("Getting the element at index %d, it is %d%s", theIndex, myValue, "\n");

        Demo.next("Trying to get from an index that is too high throws an exception");
        try {
            int result = arrayList.get(2);
            // Since an exception causes us to leave this scope immediately,
            // the below statement is only executed if the exception is not thrown
            System.out.println("Exception is not thrown as expected");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown as expected:\n\t" + e.getMessage() + "\n");
        }

        Demo.next("Trying to remove from an index that is too high throws an exception");
        try {
            arrayList.remove(2);
            System.out.println("Exception is not thrown as expected");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown as expected:\n\t" + e.getMessage());
        }

        Demo.next("Using set on an index, that is outside the current length throws an exception");
        try {
            arrayList.set(2, 2);
            System.out.println("Exception is not thrown as expected");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown as expected:\n\t" + e.getMessage());
        }
    }

    private static class Demo {
        private static int count = 0;
        private static String currentColor = ConsoleColor.BLUE;

        /**
         * Prints a formatted divider and the next number in the list.
         *
         * @param text The text that should be written on the header line after the number
         */
        public static void next(String text) {
            System.out.println("\n" + currentColor + count + ". " + text + "\n" + "-".repeat(40) + ConsoleColor.RESET);
            count++;
        }

        /**
         * Resets the count for the divider list
         */
        public static void reset(String newColor) {
            System.out.println("\n");
            count = 0;
            currentColor = newColor;
        }

        /**
         * Prints a header that separates different demos, without a number
         *
         * @param headerText The text that is displayed above the dividing line
         */
        public static void header(String headerText) {
            System.out.println(currentColor + headerText + "\n" + "#".repeat(120) + ConsoleColor.RESET);
        }
    }
}
