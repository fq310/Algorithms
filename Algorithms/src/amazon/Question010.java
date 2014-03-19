package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question010 {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
    			new int[]{20, 18, 7, 19, 10},
    			new int[]{24, 4, 15, 11, 9},
    			new int[]{13, 0, 22, 12, 14},
    			new int[]{23, 16, 1, 2, 5},
    			new int[]{21, 17, 8, 3, 6}};
		int[][] target1 = new int[][]{
    			new int[]{20, 18, 7, 19, 10},
    			new int[]{24, 4, 0, 11, 9},
    			new int[]{13, 22, 15, 12, 14},
    			new int[]{23, 16, 1, 2, 5},
    			new int[]{21, 17, 8, 3, 6}};
		int[][] target2 = new int[][]{
    			new int[]{20, 18, 7, 19, 10},
    			new int[]{24, 15, 11, 12, 9},
    			new int[]{13, 4, 22, 2, 14},
    			new int[]{23, 16, 0, 1, 5},
    			new int[]{21, 17, 8, 3, 6}};
		List<String> operations1 = new ArrayList<String>();
		operations1.add("U");
		operations1.add("R");
		List<String> operations2 = new ArrayList<String>();
		operations2.add("R");
		operations2.add("R");
		operations2.add("L");
		operations2.add("U");
		operations2.add("D");
		operations2.add("D");
		System.out.println(getPath(matrix, target1, operations1));
		System.out.println(getPath(matrix, target2, operations2));
	}
	
	private static String getPath(int[][] original, int[][] target, List<String> operations) {
		Set<List<String>> allOperations = new HashSet<List<String>>(); 
		getCombination(operations, new ArrayList<String>(), operations.size(), allOperations);
		int[][] sourceMatrix = createSourceMatrix();
		for (List<String> opeartion : allOperations) {
			copyMatrix(sourceMatrix, original);
			boolean successful = moveMatrix(sourceMatrix, opeartion);
			if (successful == false) continue;
			boolean isEqual = comapreMatrix(sourceMatrix, target);
			if (isEqual) return getString(opeartion);
		}
		return "None";
	}
	
	
    private static String getString(List<String> opeartions) {
    	StringBuilder result = new StringBuilder();
    	for (String opeartion : opeartions) {
    		result.append(opeartion);
    	}
		return result.toString();
	}

	private static boolean comapreMatrix(int[][] sourceMatrix, int[][] target) {
		for (int i = 0; i < sourceMatrix.length; ++i) {
			for (int j = 0; j < sourceMatrix[i].length; ++j) {
				if (target[i][j] != sourceMatrix[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean moveMatrix(int[][] sourceMatrix,
			List<String> opeartions) {
		int x = 0, y = 0;
		for (int i = 0; i < sourceMatrix.length; ++i) {
			boolean found = false;
			for (int j = 0; j < sourceMatrix[i].length; ++j) {
				if (sourceMatrix[i][j] == 0) {
					x = i;
					y = j;
					found = true;
					break;
				}
			}
			if (found) break;
		}
		for (String operation : opeartions) {
			if (operation.equals("U")) {
				--x;
				if (x < 0) return false;
				swap(x, y, x + 1, y, sourceMatrix);
			}
			if (operation.equals("D")) {
				++x;
				if (x < 0) return false;
				swap(x, y, x - 1, y, sourceMatrix);
			}
			if (operation.equals("L")) {
				--y;
				if (y < 0) return false;
				swap(x, y, x, y + 1, sourceMatrix);
			}
			if (operation.equals("R")) {
				++y;
				if (y < 0) return false;
				swap(x, y, x, y - 1, sourceMatrix);
			}
		}
		return true;
	}

	private static void swap(int i, int j, int i2, int j2, int[][] sourceMatrix) {
		int temp = sourceMatrix[i][j];
		sourceMatrix[i][j] = sourceMatrix[i2][j2];
		sourceMatrix[i2][j2] = temp;
	}

	private static void copyMatrix(int[][] sourceMatrix, int[][] original) {
		for (int i = 0; i < original.length; ++i) {
			for (int j = 0; j < original[i].length; ++j) {
				sourceMatrix[i][j] = original[i][j];
			}
		}
	}

	private static int[][] createSourceMatrix() {
    	int[][] matrix = new int[][]{
    			new int[]{0, 0, 0, 0, 0},
    			new int[]{0, 0, 0, 0, 0},
    			new int[]{0, 0, 0, 0, 0},
    			new int[]{0, 0, 0, 0, 0},
    			new int[]{0, 0, 0, 0, 0}};
		return matrix;
	}

	private static void getCombination(List<String> datas, List<String> bufferList, int num, Set<List<String>> result) {   
        if (bufferList.size() == num) {   
        	result.add(bufferList);
            return;   
        }   
        for (int i = 0; i < datas.size(); i++) {   
            List<String> newDatas = new ArrayList<String>(datas);   
            List<String> newTarget = new ArrayList<String>(bufferList);   
            newTarget.add(newDatas.get(i));   
            newDatas.remove(i);   
            getCombination(newDatas, newTarget, num, result);   
        }   
    }

}
