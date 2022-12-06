// Author: Thor Malmby Jørgin tjoer21@student.sdu.dk

public interface HomeMadeList {
    /**
     * Searches the list and finds the index of the element toFind
     * @param toFind The element to find
     * @return The index of toFind in the list <br> -1 if not present
     */
    int indexOf(int toFind);


    /**
     * Does the same as {@link java.util.ArrayList#size()}
     * @return Returns the amount of elements filled into the array.
     */
    int size();

    /**
     * This method has no counterpart in {@link java.util.ArrayList} <br>
     * It returns the size of the underlying array. This is useful for demonstration purposes. <br>
     * In ArrayList this is abstracted away, since you as a developer should not be using this information.
     * @return The size of the underlying array
     */
    int getUnderlyingSize();

    /**
     * Inserts the value at the end of the array.
     * The first empty spot is considered the end of the array.
     * equivalent:
     * {@link #set(int, int)} with insert(this.getSize(), int a)
     */
    void add(int a);

    /**
     * Inserts the value at the specified index.<br>
     * set can only be used to change the value of an index, that has already been added.
     * @param index The index to write the value to
     * @param a The value to save
     */
    void set(int index, int a);

    /**
     * Returns the value stored at the index
     * @return The value saved at the index
     * @param index The index to retrieve the value from
     */
    int get(int index);

    /**Removes the element that is saved at the specified index.
     * The value that was saved at the index is returned
     *
     * @param index The index of the underlying array to remove
     * @return The element that was removed from the array
     */
    int remove(int index);

    /**
     * This method is used to convert this {@link HomeMadeList} to a regular array. <br><br>
     * It copies the contents of the list into a new array,
     * such that changes in one of these does not affect the other.
     *
     * @return an array that contains the same elements as this list
     */
    int[] toArray();
}
