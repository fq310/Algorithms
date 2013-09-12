import java.util.Iterator;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Data b[] = {new Data(17), new Data(47), new Data(80), new Data(11), new Data(46), new Data(14), new Data(42), new Data(49), new Data(44), new Data(53)};
//		Selection.sort(b);
//		Data a[] = {new Data(64), new Data(14), new Data(88), new Data(79), new Data(60), new Data(98), new Data(91), new Data(42), new Data(30), new Data(72)};
//		Shell.sort(a);
		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		Iterator<Integer> i1 = q.iterator();
		while (i1 != null && i1.hasNext()) {
			StdOut.print(i1.next() + " ");
		}
		StdOut.println();
		Iterator<Integer> i2 = q.iterator();
		while (i2 != null && i2.hasNext()) {
			StdOut.print(i2.next() + " ");
		}
	}

}

class Data implements Comparable<Data> {
	@Override
	public String toString() {
		return String.valueOf(a);
	}
	public Data(int a) {
		this.a = a;
	}
	int a;
	public int compareTo(Data data) {
		if (a > data.a) return 1;
		if (a < data.a) return -1;
		return 0;
	}
	
}