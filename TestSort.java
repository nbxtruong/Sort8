import sort.AsciiTracer;
import sort.ObservableSortableData;
import sort.Sort;
import sort.SortableComparableData;
import sort.SortableData;
import sort.SwapableArray;
import sort.WinTracer;

/**
 * @author baudon
 * 
 */

public class TestSort {

	private static Sort getSort(String name) throws Exception {
		return (Sort) Class.forName(name).newInstance();
	}

	public static void sortAndPrint(SortableData<?> sd, Sort sort) {
		sort.doSort(sd);
		for (int i = 0; i < sd.size(); ++i) {
			System.out.print(sd.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sort sort = null;
		try {
			sort = getSort(args[0]);
		} catch (Exception e) {
			throw new Error("Sort " + args[0] + " impossible to find.");
		}
		String[] args2 = new String[args.length - 1];
		System.arraycopy(args, 1, args2, 0, args.length - 1);
		ObservableSortableData<String> osd = new ObservableSortableData<String>(
				new SortableComparableData<String>(new SwapableArray<String>(
						args2)));
		osd.addObserver(new AsciiTracer());
		osd.addObserver(new WinTracer(osd));
		sortAndPrint(osd, sort);
	}
}
