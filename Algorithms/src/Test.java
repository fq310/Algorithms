
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data b[] = {new Data(28), new Data(59), new Data(74), new Data(91), new Data(45), new Data(40), new Data(90), new Data(10), new Data(19), new Data(27)};
		Selection.sort(b);
		Data a[] = {new Data(54), new Data(97), new Data(91), new Data(18), new Data(48), new Data(20), new Data(71), new Data(55), new Data(37), new Data(43)};
		Shell.sort(a);
//		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
//		q.enqueue(1);
//		q.enqueue(2);
//		q.enqueue(3);
//		q.enqueue(4);
//		Iterator<Integer> i1 = q.iterator();
//		while (i1 != null && i1.hasNext()) {
//			StdOut.print(i1.next() + " ");
//		}
//		StdOut.println();
//		Iterator<Integer> i2 = q.iterator();
//		while (i2 != null && i2.hasNext()) {
//			StdOut.print(i2.next() + " ");
//		}
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