package leetcode_20;

public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != this.getClass()) return false;
		Interval that = (Interval) obj;
		if (that.start != this.start) return false;
		if (that.end != this.end) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31*hash + start;
		hash = 31*hash + end;
		return hash;
	}
	@Override
	public String toString() {
		return "[" + String.valueOf(start) + " : " +  String.valueOf(end) + "]";
	}
}
