package leetcode_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	List<List<Integer>> result = new ArrayList<>();
    	Subsets s = new Subsets();
    	List<List<Integer>> subSets = s.subsets(num);
    	Set<List<Integer>> set = new HashSet<>();
    	set.addAll(subSets);
    	result.clear();
    	result.addAll(set);
    	return result;
    }
}
