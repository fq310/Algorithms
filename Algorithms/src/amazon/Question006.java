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
	 * �����ĵ�����
	 * ����������飬���ó�����������һ��Ԫ�أ�ȥ���αȽ�Դ�����ÿһ��Ԫ�أ����Ԫ�ز��ȣ�����ջ�������ȣ�����ջ�ٳ�ջ
	 * ��Ҳ���������ֹ��жϵ��㷨��
	 * �Ѿ���ջ��Ԫ��Ҫ��Դ������ɾ����
	 * ���ԭ����û��Ԫ���ˣ�Ҫȥ����ջ��ĵ�һ��Ԫ���ǲ���Ŀ��Ԫ�أ�������ǣ����˳���ǲ��Եģ�����ǣ��ͳ�ջ��ִ��һ��pop����
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
