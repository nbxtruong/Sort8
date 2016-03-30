package sort;

import java.util.Observable;

public class ObservableSortableData<T> extends Observable implements
		SortableData<T> {

	public static final String SWAP_NAME = "Swap";

	public static final String COMPARE_NAME = "Compare";

	public static final String GET_NAME = "Get";

	public class Operation {
		private String name;

		private int[] indices;

		private Operation(String name, int[] indices) {
			this.name = name;
			this.indices = indices;
		}

		public String name() {
			return name;
		}

		public int[] indices() {
			return indices;
		}
	}

	private SortableData<? extends T> data;

	public ObservableSortableData(SortableData<? extends T> data) {
		this.data = data;
	}

	public int size() {
		return data.size();
	}

	private void notify(String operationName, int... indices) {
		setChanged();
		notifyObservers(new Operation(operationName, indices));
	}

	public void swap(int i, int j) {
		data.swap(i, j);
		notify(SWAP_NAME, i, j);
	}

	public T get(int i) {
		notify(GET_NAME, i);
		return data.get(i);
	}

	public int compare(int i, int j) {
		notify(COMPARE_NAME, i, j);
		return data.compare(i, j);
	}
}