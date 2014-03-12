package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question006 {

	public static void main(String[] args) {
		test(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
		test(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
		test(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
	}

	private static void test(int[] a1, int[] a2) {
		List<Integer> array1 = getList(a1);
		List<Integer> array2 = getList(a2);
		System.out.println(getOperations(array1, array2));
	}

	private static List<Integer> getList(int[] array) {
		List<Integer> list = new ArrayList<>();
		for (int value : array) {
			list.add(value);
		}
		return list;
	}
	
	/*
	 * 这道题的点在于
	 * 遍历结果数组，先拿出结果数组的死一个元素，去依次比较源数组的每一个元素，如果元素不等，就入栈，如果相等，就入栈再出栈
	 * 这也是正常的手工判断的算法。
	 * 已经入栈的元素要从源数组中删除，
	 * 如果原数组没有元素了，要去看看栈里的第一个元素是不是目标元素，如果不是，这个顺序是不对的，如果是，就出栈，执行一次pop操作
	 */
	private static String getOperations(List<Integer> arraySource, List<Integer> arrayResult) {
		List<String> operations = new ArrayList<String>();
		Stack<Integer> stack = new Stack<Integer>();
		String push = "push";
		String pop = "pop";
		boolean failed = false;
		for (Integer result : arrayResult) {
			List<Integer> removed = new ArrayList<Integer>();
			for (Integer source : arraySource) {
				if (source.equals(result)) {
					stack.push(source);
					operations.add(push + source);
					operations.add("|");
					stack.pop();
					operations.add(pop + source);
					operations.add("|");
					removed.add(source);
					break;
				} else {
					stack.push(source);
					operations.add(push + source);
					operations.add("|");
				}
				removed.add(source);
			}
			if (arraySource.isEmpty()) {
				Integer topElement = stack.peek();
				if (topElement.equals(result)) {
					stack.pop();
					operations.add(pop + result);
					operations.add("|");
				} else {
					failed = true;
				}
				continue;
			}
			arraySource.removeAll(removed);
		}
		if (failed == true) return "None";
		int lastElementIndex = operations.size() - 1;
		if (operations.get(lastElementIndex).equals("|")) {
			operations.remove(lastElementIndex);
		}
		StringBuilder operationString = new StringBuilder();
		for (String operation : operations) {
			operationString.append(operation);
		}
		return operationString.toString();
	}
}
