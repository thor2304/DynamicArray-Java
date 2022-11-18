public class DynamicArray implements HomeMadeList {
    static final int INITIAL_SIZE = 6;
    /**
     * Defines how the array should expand.
     * The previous ArrayLength will be multiplied by this factor to generate the new length.
     */
    static final int EXPANSION_FACTOR = 2;

    private int savedElements;
    private int[] underLyingArray;

    public DynamicArray() {
        this.underLyingArray = new int[INITIAL_SIZE];
        savedElements = 0;
    }

    public int getFill() {
        return -1;
    }

    public int getSize() {
        return savedElements;
    }

    public int getArraySize() {
        return underLyingArray.length;
    }

    public int index() {
        return -1;
    }

    public void insert(int a) {
        insert(savedElements, a);
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

    public void insert(int index, int a) {
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

    public int getIndex(int index) {
        if (index >= savedElements || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index " + index + " is out of bounds for the number of saved elements: " + savedElements);
        }
        return underLyingArray[index];
    }

    public int remove(int index) {
        if (index >= savedElements || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index " + index + " is out of bounds for the number of saved elements: " + savedElements);
        }

        int out = underLyingArray[index];

        int tempLength = this.underLyingArray.length;

        if ((savedElements - 1) * 2 == this.underLyingArray.length) {
            tempLength = savedElements - 1;
//            tempLength = this.underLyingArray / 2; // Should be equivalent to above
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

        underLyingArray = temporaryArray;
        savedElements--;

        return out;
    }

    public int[] getArrayCopy() {
        int length = this.getArraySize();
        int[] out = new int[length];
        System.arraycopy(this.underLyingArray, length, out, 0, length);
        return out;
    }
}
