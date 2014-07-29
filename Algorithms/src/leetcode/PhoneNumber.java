package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class PhoneNumber {
	private class Node {
		String currentString;
		public Node(String letter, Node parent) {
			if (parent == null)
				this.currentString = letter;
			else 
				this.currentString = parent.getCurrentString() + letter;
		}
		@Override
		public String toString() {
			return currentString;
		}
		public String getCurrentString() {
			return currentString;
		}
	}
	
	private Map<Character, List<String>> digit2letter = new HashMap<>();
	{
		digit2letter.put('2', getList(new String[]{"a", "b", "c"}));
		digit2letter.put('3', getList(new String[]{"d", "e", "f"}));
		digit2letter.put('4', getList(new String[]{"g", "h", "i"}));
		digit2letter.put('5', getList(new String[]{"j", "k", "l"}));
		digit2letter.put('6', getList(new String[]{"m", "n", "o"}));
		digit2letter.put('7', getList(new String[]{"p", "q", "r", "s"}));
		digit2letter.put('8', getList(new String[]{"t", "u", "v"}));
		digit2letter.put('9', getList(new String[]{"w", "x", "y", "z"}));
		digit2letter.put('0', getList(new String[]{" "}));
	}
	
    public List<String> letterCombinations(String digits) {
    	Node root = new Node("", null);
    	Queue<Node> leaves = new LinkedList<>();
    	leaves.add(root);
    	Queue<Node> newLeaves = new LinkedList<>();
    	for (int i = 0; i < digits.length(); ++i) {
    		char c = digits.charAt(i);
    		List<String> letters = digit2letter.get(c);
    		newLeaves.clear();
    		while (leaves.isEmpty() == false) {
    			Node node = leaves.poll();
    			for (String letter : letters) {
    				Node leave = new Node(letter, node);
    				newLeaves.add(leave);
    			}
    		}
    		leaves.addAll(newLeaves);
    	}
    	List<String> result = new ArrayList<>();
    	while (newLeaves.isEmpty() == false) {
    		result.add(newLeaves.poll().getCurrentString());
    	}
    	if (result.size() == 0) result.add("");
        return result;
    }
    
	private List<String> getList(String[] strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
