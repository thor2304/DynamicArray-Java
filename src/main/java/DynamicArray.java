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
        if (savedElements == underLyingArray.length) {
            //Create the new larger array
            int[] temporaryArray = new int[underLyingArray.length * EXPANSION_FACTOR];
            // Copy elements from old array
            // Should use arrayCopy
            for (int i =0; i< underLyingArray.length; i++) {
                temporaryArray[i] = underLyingArray[i];
            }
            // Change the reference of the underlying array to point at the new array
            underLyingArray = temporaryArray;
        }

        // Add the new element
        this.underLyingArray[savedElements] = a;
        savedElements++;
        // the above lines could be merged to:
//        this.underLyingArray[savedElements++] = a;
        // But this requires more explanation to ensure that the students understand that:
        // savedElements is read first, given as the index, and then incremented
    }

    // For javadoc see HomeMadeList or ctrl + q on the method name
    public void set(int index, int a) {
        if (index >= savedElements || index < 0) { //change to underlyingArray.length, if this behaviour is not desired
            throw new ArrayIndexOutOfBoundsException("index " + index +
                    " is out of bounds for the number of saved elements: " + savedElements +
                    ", The highest allowed index is " + (savedElements-1));
        }

        // set the element
        this.underLyingArray[index] = a;
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

        // Save the value that we remove, so it can be returned
        int out = underLyingArray[index];

        // Move all elements after the element we want to remove
        // This effectively removes/deletes the element at [index]
        for (int i = index + 1; i < savedElements; i++) {
            // Should be replaced with System.arrayCopy (Perhaps in a step focused on improvement?)
            underLyingArray[i - 1] = underLyingArray[i];
        }

        //Since the element have been deleted, decrement savedElements
        savedElements--;

        //Set the last element and set to 0 to avoid duplicating when the elements are moved left
        this.underLyingArray[savedElements] = 0;
        // Try without this to see the effect

        // Check whether we should shrink
        if (savedElements * 2 <= this.underLyingArray.length) {
            //Shrink Array

            int[] shrunkArray = new int[this.savedElements];

            // Copy elements from underlying to the shrunk array
            // We have already moved all the elements and deleted, so we should simply copy them over.
            for (int i = 0; i < this.savedElements; i++) {
                // Should be replaced with System.arrayCopy (Perhaps in a step focused on improvement?)
                shrunkArray[i] = this.underLyingArray[i];
            }

            this.underLyingArray = shrunkArray;
        }

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
