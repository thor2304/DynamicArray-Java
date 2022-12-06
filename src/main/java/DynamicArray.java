import java.util.Arrays;

public class DynamicArray implements HomeMadeList {
    /**
     * This variable is used when the list is created to give it a starting size,
     * since arrays must have a length when initialized.
     */
    static final int INITIAL_SIZE = 6;

    /**
     * Defines how the array should expand.
     * The previous ArrayLength will be multiplied by this factor to generate the new length.
     */
    static final int EXPANSION_FACTOR = 2;

    /**
     * This variable keeps count of the fill amount of the underlying Array. <br>
     * This is tied to the highest addressable index, through the following observations:
     * <ul>
     *     <li>[savedElements -1] is the index where the element saved with the highest index is located</li>
     *     <li>[savedElements] is the index of the next element to be inserted  </li>
     * </ul>
     */
    private int savedElements;

    /**
     * This variable is the underlying array that allows us to store elements. <br>
     * This array will have to be replaced when elements are added or removed.
     */
    private int[] underLyingArray;

    /**
     * Initializes an underlying array using {@link #INITIAL_SIZE}
     */
    public DynamicArray() {
        this.underLyingArray = new int[INITIAL_SIZE];
        savedElements = 0;
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int size() {
        return savedElements;
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int getUnderlyingSize() {
        return underLyingArray.length;
    }


    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int getFill() {
        return getUnderlyingSize();
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int indexOf(int toFind) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == toFind){
                return i;
            }
        }
        return -1;
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public void add(int a) {
        add(savedElements, a);
//        if (savedElements == underLyingArray.length) {
//            //Create the new larger array
//            int[] temporaryArray = new int[underLyingArray.length * EXPANSION_FACTOR];
//            // Copy elements from old array
//            for (int i =0; i< underLyingArray.length; i++) {
//                temporaryArray[i] = underLyingArray[i];
//            }
//            // Change the underlying array to point at the new array
//            underLyingArray = temporaryArray;
//        }
//        this.underLyingArray[savedElements] = a;
//        savedElements++;
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public void add(int index, int a) {
        if (index > savedElements || index < 0) { //change to underlyingArray.length, if this behaviour is not desired
            throw new ArrayIndexOutOfBoundsException("index " + index +
                    " is out of bounds for the number of saved elements: " + savedElements +
                    ", The highest allowed index is " + savedElements);
        }

        if (savedElements == underLyingArray.length && index == savedElements) {
            //Create the new larger array
            int[] temporaryArray = new int[underLyingArray.length * EXPANSION_FACTOR];
            // Copy elements from old array
            for (int i = 0; i < underLyingArray.length; i++) {
                temporaryArray[i] = underLyingArray[i];
            }
            // Change the underlying array to point at the new array
            underLyingArray = temporaryArray;
        }
        this.underLyingArray[index] = a;
        savedElements++;
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int get(int index) {
        if (index >= savedElements || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index " + index + " is out of bounds for the number of saved elements: " + savedElements);
        }
        return underLyingArray[index];
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int remove(int index) {
        if (index >= savedElements || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index " + index + " is out of bounds for the number of saved elements: " + savedElements);
        }

        int out = underLyingArray[index];

        int tempLength = this.underLyingArray.length;

        // Check whether we should shrink
        if ((savedElements - 1) * 2 == this.underLyingArray.length) {
            tempLength = savedElements - 1;
//            tempLength = this.underLyingArray // 2; // Should be equivalent to above
        }

        int[] temporaryArray = new int[tempLength];


        // Add all elements up till the one we want to remove
        for (int i = 0; i < index; i++) {
            temporaryArray[i] = underLyingArray[i];
        }

        // Add all elements after the element we want to remove
        for (int i = index + 1; i < savedElements; i++) {
            temporaryArray[i - 1] = underLyingArray[i];
        }
/* Alternative best practice using System.arraycopy
//        // Add all elements up till (and excluding) the one we want to remove
//        System.arraycopy(this.underLyingArray, 0, temporaryArray, 0, index);
//
//        // Add all elements after the element we want to remove
        System.arraycopy(this.underLyingArray, index + 1, temporaryArray, index, savedElements - index);
*/

        underLyingArray = temporaryArray;
        savedElements--;

        return out;
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public int[] toArray() {
        int length = this.getUnderlyingSize();
        int[] out = new int[length];
        System.arraycopy(this.underLyingArray, 0, out, 0, length);
        return out;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "savedElements=" + savedElements +
                ", underLyingArray=" + Arrays.toString(underLyingArray) +
                '}';
    }
}
