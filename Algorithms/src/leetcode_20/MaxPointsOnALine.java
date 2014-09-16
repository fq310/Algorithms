package leetcode_20;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
    	int maxPoints = 0;
    	for (int i = 0; i < points.length; ++i) {
    		int verticalPoints = 0, samePoints = 0;
    		Map<String, Integer> map = new HashMap<>();
    		for (int j = i + 1; j < points.length; ++j) {
    			if (points[i].x == points[j].x && points[i].y == points[j].y) {
    				++samePoints;
    				continue;
    			}
    			if (points[i].x == points[j].x) {
    				++verticalPoints;
    				continue;
    			}
    			int slopY = points[j].y - points[i].y;
				int slopX = points[j].x - points[i].x;
				int gcd = GCD(slopY, slopX);
    			String slop = slopY / gcd + "" + slopX / gcd;
    			Integer poinstIn1Line = map.get(slop);
				if (poinstIn1Line == null) {
					poinstIn1Line = 1;
				} else {
					++poinstIn1Line;
				}
				map.put(slop, poinstIn1Line);
    		}
    		maxPoints = Math.max(maxPoints, Math.max(verticalPoints + 1 + samePoints, getMaxCount(map) + 1 + samePoints));
    	}
        return maxPoints;
    }
    
    private int getMaxCount(Map<String, Integer> map) {
    	int max = 0;
    	for (Integer value : map.values()) {
    		if (value > max) max = value;
    	}
		return max;
	}

    private int GCD(int a, int b) {
	   if (b == 0) return a;
	   return GCD(b, a % b);
	}    	
}


