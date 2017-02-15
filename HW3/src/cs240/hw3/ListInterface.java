package cs240.hw3;

public interface ListInterface<T> {
	/*Add a new entry to the end of the dequeue
	 @param a new entry to be added*/

	public void addItem(T newEntry);
	
	/*Add item to a specific location in the dequeue
	 @param a new entry to be added and index for location*/
	
	public void addItem(T newEntry, int index);
	
	/*Remove item at the index
	 * @param int for location to remove item
	 * @return item that was removed from the list
	*/
	public T removeItem(int index);
	
	/*Remove all items. Clear the list*/
	public void removeAll();
	
	/*Replace item in the queue with another item
	 * @param a new Entry to replace with and index for location
	 * @return item that was replaced
	 */
	public T replaceItem(T newEntry, int index);
	
	/*Look at the item at a specific index
	 * @param index for location of item
	 * @return the item at the index
	 */
	public T peekItem(int index);
	
	/*Print out all the data of the items in the list
	 */
	public void peekAll();
	
	/*Check to see if item exists
	 * @param an item entry to check for
	 * @return boolean, true if item is in and false if not
	 */
	public boolean checkItem(T newEntry);
	
	/*Check to see the number of entries in the list
	 * @return int number of entries*/
	public int checkCount();
	
	/*Check to see if list is empty
	 * @return true if it is empty false if not
	 */
	public boolean isEmpty();
	
	
}
