package cs240.hw3;

public class SingleLinkedList<T> implements ListInterface<T> {
	private Node firstNode;
	private int numberOfEntries;
	@Override
	public void addItem(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty()){
			firstNode = newNode;
		}
		else {
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.next = newNode;
		}
		numberOfEntries++;
	}

	@Override
	public void addItem(T newEntry, int index) {
		Node newNode = new Node(newEntry);
		if(index ==1){
			newNode.next = firstNode;
			firstNode = newNode;
		}
		else{
			Node nodeBefore = getNodeAt(index - 1);
			Node nodeAfter = nodeBefore.next;
			newNode.next = nodeAfter;
			nodeBefore.next = newNode;
		}
	}

	@Override
	public T removeItem(int index) {
		T result = null; 
		if ((index >= 1) && (index <= numberOfEntries)){
			assert !isEmpty();
		if (index == 1) 
			result = firstNode.data; 
			firstNode = firstNode.next;
		}
		else{
			Node nodeBefore = getNodeAt(index - 1);
			Node nodeToRemove = nodeBefore.next;
			Node nodeAfter = nodeToRemove.next;
			nodeBefore.next =nodeAfter;
			result = nodeToRemove.data; 
		} 
		numberOfEntries--;
		
		return result;
	}

	@Override
	public void removeAll() {
		firstNode = null;
		numberOfEntries =0;
	}

	@Override
	public T replaceItem(T newEntry, int index) {
		if ((index >= 1) && (index <= numberOfEntries))
		{
			assert !isEmpty();
			Node desiredNode = getNodeAt(index);
			desiredNode.data=newEntry;
			return newEntry;
		}
		else{
			System.out.println("nothing was replaced");
			return null;
		}
	}

	@Override
	public T peekItem(int index) {
		T temp = null;
		if ((index >= 1) && (index <= numberOfEntries))
		{
			assert !isEmpty();
			temp = getNodeAt(index).data;
		} 
		return temp;
	}

	@Override
	public Object peekAll() {
		return firstNode.data;
	}

	@Override
	public boolean checkItem(T newEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)){
			if (newEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		return found;
	}

	@Override
	public int checkCount() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if (numberOfEntries == 0){
			assert firstNode == null;
			result = true;
		}
		else{
			assert firstNode != null;
			result = false;
		} 
		return result;
	}
	private class Node{
		private T data; 
		private Node next; 
		private Node(T dataPortion){
			this(dataPortion, null);
		}
		private Node(T dataPortion, Node nextNode){
		data = dataPortion;
		next = nextNode;
		} 
	}
	private Node getNodeAt(int givenPosition)
	{
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		for (int counter = 1; counter < givenPosition; counter++){
			currentNode = currentNode.next;
		}
		assert currentNode != null;
		return currentNode;
	} 

}
