public interface HomeMadeList {
    /**Purpose unknown
     *
     * @return
     */
    int getFill();

    /**
     * Purpose unknown
     *
     * @return
     */
    int index();

    /**
     * Returns the amount of elements filled into the array
     * @return An integer that represents the number of elements that have been saved into the array.
     */
    int getSize();

    /**
     * Returns the size of underlying array, this includes the empty fields
     * @return An integer that is equivalent to this.underLyingArray.length
     */
    int getArraySize();

    /**
     * Inserts the value at the end of the array.
     * The first empty spot is considered the end of the array.
     * equivalent:
     * {@link #insert(int, int)} with insert(this.getSize(), int a)
     */
    void insert(int a);

    /**
     * Inserts the value at the specified index
     * @param index The index to write the value to
     * @param a The value to save
     */
    void insert(int index, int a);

    /**
     * Returns the value stored at the index
     * @return The value saved at the index
     * @param index The index to retrieve the value from
     */
    int getIndex(int index);

    /**Removes the element that is saved at the specified index.
     * The value that was saved at the index is returned
     *
     * @param index The index of the underlying array to remove
     * @return The element that was removed from the array
     */
    int remove(int index);

    /**Returns a copy of the underlying Array.
     * Changes to this array will not affect the underlying array of this List
     *
     * @return a copy of the underlying Array
     */
    int[] getArrayCopy();
}
