package sort;

public class InsertionSort implements Sort  {

	private SortableData<?> data;

	public InsertionSort() {
	}

	private void insert(int i) {
		if (i < data.size() - 1) {
			if (data.compare(i, i + 1) > 0) {
				data.swap(i, i+1);
				insert(i + 1);
			}
		}
	}

	public void doSort(SortableData<?> data) {
		this.data = data;
		for (int i = data.size() - 2; i >= 0; --i) {
			insert(i);
		}
	}
}
