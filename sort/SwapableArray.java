package sort;

public class SwapableArray<T> implements SwapableData<T> {
	private T[] array;

	public SwapableArray(T[] a) {
		this.array = a;
	}

	public int size() {
		return array.length;
	}

	public void swap(int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public T get(int i) {
		return array[i];
	}
}