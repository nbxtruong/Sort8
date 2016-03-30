package sort;

public interface ComparableData<T> extends IndexedData<T> {
    
    public int compare(int i, int j);
}