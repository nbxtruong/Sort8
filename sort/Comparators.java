package sort;

import java.util.Comparator;

public class Comparators {
	public static <T> Comparator<T> lexicographic(final Comparator<T> comp1,
			final Comparator<T> comp2) {
		return new Comparator<T>() {
			public int compare(T t1, T t2) {
				int resultComp1 = comp1.compare(t1, t2);
				return resultComp1 == 0 ? comp2.compare(t1, t2) : resultComp1;
			}

		};
	}

	public static <T> Comparator<T> reverse(final Comparator<T> comp) {
		return new Comparator<T>() {
			public final int compare(T t1, T t2) {
				return -comp.compare(t1, t2);
			}
		};
	}

	public static <T extends Comparable<? super T>> Comparator<T> trivialComparator() {
		return new Comparator<T>() {
			public final int compare(T t1, T t2) {
				return t1.compareTo(t2);
			}
		};
	}
}
