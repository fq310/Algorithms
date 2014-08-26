package leetcode_20;

public class JumpGame {
    public boolean canJump(int[] A) {
    	if (A == null || A.length < 2) return true;
    	int canReach = 0;
    	for (int i = 0; i <= canReach; ++i) {
    		if (A[i] + i > canReach) canReach = A[i] + i;
    		if (canReach >= A.length - 1) return true;
    	}
        return false;
    }
}
