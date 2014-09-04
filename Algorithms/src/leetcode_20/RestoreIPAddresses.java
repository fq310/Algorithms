package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
    	List<String> result = new ArrayList<>();
    	restore(s, new ArrayList<String>(), result);
        return result;
    }
    
    private void restore(String data, List<String> ips, List<String> result) {
    	if (invalidDataLength(data, ips)) return;
    	if (ips.size() == 4) {
    		if (data.length() == 0) {
    			addToResult(ips, result);
    		}
    		return;
    	}
    	for (int i = 1; i <= 3 && i <= data.length(); ++i) {
    		String numberStr = data.substring(0, i);
    		if (startFrom0(numberStr)) continue;
			int number = Integer.parseInt(numberStr);
    		if (isValid(number)) {
    			List<String> newIps = new ArrayList<>();
    			newIps.addAll(ips);
    			newIps.add(numberStr);
    			restore(data.substring(i), newIps, result);
    		}
    	}
    }

	private boolean startFrom0(String numberStr) {
		if (numberStr.length() > 1 && numberStr.startsWith("0")) return true;
		return false;
	}

	private boolean invalidDataLength(String data, List<String> ips) {
		int maxLength = (4 - ips.size()) * 3;
		if (data.length() > maxLength) return true;
		return false;
	}

	private boolean isValid(int number) {
		return 0 <= number && number <= 255;
	}

	private void addToResult(List<String> ips, List<String> result) {
		StringBuilder ip = new StringBuilder();
		for (int i = 0; i < ips.size(); ++i) {
			ip.append(ips.get(i));
			if (i < ips.size() - 1)
				ip.append('.');
		}
		result.add(ip.toString());
	}
}
