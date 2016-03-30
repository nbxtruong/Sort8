package sort;

abstract class ComparableSwapableData<T> implements SortableData<T> {

	private SwapableData<? extends T> data;
	
	public ComparableSwapableData(SwapableData<? extends T> data) {
		this.data = data;
	}
	
	public int size() {
		return data.size();
	}
	
	public T get(int i) {
		return data.get(i);
	}
	
	public void swap(int i, int j) {
		data.swap(i, j);
	}
	
	public abstract int compare(int i, int j);
}
