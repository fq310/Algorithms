package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
    	if (words.length == 0) return new ArrayList<>();
    	List<String> result = new ArrayList<>();
    	List<String> buffer = new ArrayList<>();
    	int bufferLength = 0;
    	for (int i = 0; i < words.length;) {
    		buffer.add(words[i]);
    		bufferLength += words[i].length();
    		if (buffer.size() - 1 + bufferLength > L) {
    			buffer.remove(buffer.size() - 1);
    			addToResult(buffer, bufferLength - words[i].length(), result, L);
    			buffer.clear(); bufferLength = 0;
    		} else if (buffer.size() - 1 + bufferLength == L) {
    			addToResult(buffer, bufferLength, result, L);
    			buffer.clear(); bufferLength = 0;
    			++i;
    		} else {
    			++i;
    		}
    	}
    	if (buffer.size() > 0) {
    		addToResult(buffer, bufferLength, result, L);
    	}
    	treatLastRow(L, result);
    	return result;
        
    }

	private void treatLastRow(int L, List<String> result) {
		String lastRow = result.get(result.size() - 1);
    	String[] data = lastRow.split(" ");
    	StringBuilder s = new StringBuilder();
    	for (String str : data) {
    		if (str.length() == 0) continue;
    		s.append(str).append(' ');
    	}
    	if (s.length() > 0 && s.charAt(s.length() - 1) == ' ') s.deleteCharAt(s.length() - 1);
    	while (s.length() < L) {
    		s.append(' ');
    	}
    	result.set(result.size() - 1, s.toString());
	}

	private void addToResult(List<String> buffer, int length, List<String> result, int maxLength) {
		int i = 0;
		while (length < maxLength) {
			buffer.set(i, buffer.get(i) + ' ');
			++length;
			++i;
			if (i >= buffer.size() - 1) i = 0;
		}
		StringBuilder s = new StringBuilder();
		for (String str : buffer) {
			s.append(str);
		}
		result.add(s.toString());
	}
}
