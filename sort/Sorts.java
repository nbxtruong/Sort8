package sort;


import java.util.Comparator;
import java.util.List;

/*
 * Created on 27 oct. 2004
 *
 */

/**
 * @author baudon
 *  
 */
public class Sorts {

    private static QuickSort qs = new QuickSort();

    private static InsertionSort is = new InsertionSort();

    private static void sort(Sort s, SortableData<?> data) {
        s.doSort(data);
    }

    public static <T extends Comparable<? super T>> void quickSort(T [] array) {
        sort(qs, new SortableComparableData<T>(new SwapableArray<T>(array)));
    }

    public static <T> void quickSort(T [] array, Comparator<? super T> comparator) {
        sort(qs, new SortableDataWithComparator<T>(new SwapableArray<T>(array), comparator));
    }

    public static <T extends Comparable<? super T>> void quickSort(List<T> l) {
        sort(qs, new SortableComparableData<T>(new SwapableList<T>(l)));
    }

    public static <T> void quickSort(List<T> l, Comparator<? super T> comparator) {
        sort(qs, new SortableDataWithComparator<T>(new SwapableList<T>(l), comparator));
    }

    public static <T extends Comparable<? super T>> void insertionSort(T [] array) {
        sort(is, new SortableComparableData<T>(new SwapableArray<T>(array)));
    }

    public static <T> void insertionSort(T [] array, Comparator<? super T> comparator) {
        sort(is, new SortableDataWithComparator<T>(new SwapableArray<T>(array), comparator));
    }

    public static <T extends Comparable<? super T>> void insertionSort(List<T> l) {
        sort(is, new SortableComparableData<T>(new SwapableList<T>(l)));
    }

    public static <T> void insertionSort(List<T> l, Comparator<? super T> comparator) {
        sort(is, new SortableDataWithComparator<T>(new SwapableList<T>(l), comparator));
    }

}