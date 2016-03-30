package sort;

public class QuickSort implements Sort {
	
	private SortableData<?> data;

	public QuickSort() {
	}
	
	private void quickSort(int left, int right) {
		if (left < right) {
			int i = left;
			int j = right + 1;
			while (i < j) {
				while (data.compare(++i, left) < 0 && i < right)
					;
				while (data.compare(--j,left) > 0)
					;
				if (i < j) {
					data.swap(i, j);
				}
			}
			data.swap(left, j);
			quickSort(left, j - 1);
			quickSort(j + 1, right);
		}
	}

	public void doSort(SortableData<?> data) {
		this.data = data;
		quickSort(0, data.size() - 1);
	}
}