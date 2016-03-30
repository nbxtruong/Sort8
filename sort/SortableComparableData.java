package sort;

public class SortableComparableData<T extends Comparable<? super T>> extends ComparableSwapableData<T> {
	
	public SortableComparableData(SwapableData<? extends T> data) {
		super(data);
	}

	public final int compare(int i, int j) {
		return get(i).compareTo(get(j));
	}
}
