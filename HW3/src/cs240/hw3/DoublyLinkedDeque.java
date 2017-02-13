package cs240.hw3;

public class DoublyLinkedDeque<T> implements DequeInterface<T> {
	private DoubleNode firstNode;
	private DoubleNode lastNode;
	
	public DoublyLinkedDeque(){
		firstNode = null;
		lastNode = null;
	}
	
	@Override
	public void addToFront(T newEntry) {
		DoubleNode newNode = new DoubleNode(null, newEntry, firstNode);
		if(isEmpty()){
			lastNode = newNode;
		}
		else{
			firstNode.previous = newNode;
		}
		firstNode = newNode;		
	}

	@Override
	public void addToBack(T newEntry) {
		DoubleNode newNode = new DoubleNode(lastNode, newEntry, null);
		if(isEmpty()){
			firstNode = newNode;
		}
		else{
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}
	
	@Override
	public T removeFront() {
		T front = null;
		if(!isEmpty()){
			front = firstNode.data;
			firstNode = firstNode.next;
			if(firstNode == null){
				lastNode = null;
			}
			else{
				firstNode.previous = null;
			}
		}
		return front;
	}

	@Override
	public T removeBack() {
		T back = null;
		if (!isEmpty())
		{
		back = lastNode.data;
		lastNode = lastNode.previous;
		if (lastNode == null)
		firstNode = null;
		else
		lastNode.next = null;
		} // end if
		return back;
	}

	@Override
	public T getFront() {
		return firstNode.data;
	}

	@Override
	public T getBack() {
		return lastNode.data;
	}

	@Override
	public boolean isEmpty() {
		return(firstNode == null && lastNode == null);
	}

	@Override
	public void clear() {
		if(!isEmpty()){
			removeFront();
		}
	}
	
	private class DoubleNode{
		private T data;
		private DoubleNode next;
		private DoubleNode previous;
		
		public DoubleNode(DoubleNode lastNode, T newEntry, DoubleNode firstNode){
			this.data = newEntry;
			this.next = lastNode;
			this.previous = firstNode;
		}
	}
	

}
