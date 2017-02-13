package cs240.hw3;

import java.util.Vector;

public class VectorList<T> implements ListInterface<T> {
	private Vector<T> list;
	
	public VectorList(){
		list = new Vector<T>();
	}
	@Override
	public void addItem(T newEntry) {
		list.addElement(newEntry);
	}

	@Override
	public void addItem(T newEntry, int index) {
		list.add(index, newEntry);
	}

	@Override
	public T removeItem(int index) {
		return list.remove(index);
	}

	@Override
	public void removeAll() {
		list.clear();
	}

	@Override
	public T replaceItem(T newEntry, int index) {
		return list.set(index, newEntry);
	}

	@Override
	public T peekItem(int index) {
		return list.get(index);
	}

	@Override
	public Vector<T> peekAll() {
		return list;
	}

	@Override
	public boolean checkItem(T newEntry) {
		return list.contains(newEntry);
	}

	@Override
	public int checkCount() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
