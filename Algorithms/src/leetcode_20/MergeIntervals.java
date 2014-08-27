package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new ArrayList<>();
    	result.addAll(intervals);
    	Collections.sort(result, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if (a.start == b.start) return 0;
				return a.start < b.start ? -1 : 1;
			}
    	});
    	int i = 0;
    	while (i < result.size() - 1) {
    		Interval pre = result.get(i);
    		Interval after = result.get(i + 1);
    		if ((pre.start <= after.start && pre.end >= after.start) ||
    				(pre.start >= after.start && after.end >= pre.start)) {
    			Interval in = new Interval();
    			if (pre.start <= after.start)
    				in.start = pre.start;
    			else
    				in.start = after.start;
    			if (pre.end >= after.end) {
    				in.end = pre.end;
    			} else {
    				in.end = after.end;
    			}
    			result.remove(i);
				result.remove(i);
				result.add(i, in);
    		} else {
    			++i;
    		}
    	}
    	return result;
    }
}
