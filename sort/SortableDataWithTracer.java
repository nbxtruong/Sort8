package sort;

public class SortableDataWithTracer<T> extends SortableDataDelegation<T> implements SortableData<T> {

	public SortableDataWithTracer(SortableData<? extends T> data) {
		super(data);
	}

	public void swap(int i, int j) {
		System.out.println("Swapping " + i + " " + j);
		super.swap(i, j);
	}

	public int compare(int i, int j) {
		System.out.println("Comparing " + i + " " + j);
		return super.compare(i, j);
	}
}