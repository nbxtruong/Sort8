package sort;

public class SortableDataWithStatistics<T> extends SortableDataDelegation<T>
		implements SortableData<T> {

	int nswap;

	int ncompare;

	public SortableDataWithStatistics(SortableData<? extends T> data) {
		super(data);
		nswap = ncompare = 0;
	}

	public void swap(int i, int j) {
		nswap++;
		super.swap(i, j);
	}

	public int compare(int i, int j) {
		ncompare++;
		return super.compare(i, j);
	}

	public int getSwapStat() {
		return nswap;
	}

	public int getCompareStat() {
		return ncompare;
	}
}