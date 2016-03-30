package sort;

import java.util.Comparator;

public class SortableDataWithComparator<T> extends ComparableSwapableData<T>  {

	private Comparator<? super T> comparator;

	public SortableDataWithComparator(SwapableData<T> data, Comparator<? super T> comparator) {
		super(data);
		this.comparator = comparator;
	}
		
	public final int compare(int i, int j) {
		return comparator.compare(get(i), get(j));
	}
}
