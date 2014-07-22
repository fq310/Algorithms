package leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if (sum(gas) < sum(cost)) return -1;
    	for (int i = 0; i < gas.length; ++i) {
    		int currentStation = i;
    		int tank = 0;
    		int n = 0;
    		while (n < gas.length && tank >= 0) {
    			int realIndex = currentStation % gas.length;
    			tank += gas[realIndex];
    			tank -= cost[realIndex];
    			++currentStation;
    			++n;
    		}
    		if (tank >= 0) { 
    			return i;
    		} else {
    			i = (currentStation - 1) % gas.length;
    		}
    	}
        return -1;
    }

	private int sum(int[] data) {
		int sum = 0;
		for (int i : data) {
			sum += i;
		}
		return sum;
	}
}
