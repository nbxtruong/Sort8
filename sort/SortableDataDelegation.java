package sort;

abstract class SortableDataDelegation<T> implements SortableData<T> {

	private SortableData<? extends T> data;

	public SortableDataDelegation(SortableData<? extends T> data) {
		this.data = data; 
	}

	public int size() {
		return data.size();
	}

	public void swap(int i, int j) {
		data.swap(i, j);
	}

	public T get(int i) {
		return data.get(i);
	}

	public int compare(int i, int j) {
		return data.compare(i, j);
	}

}