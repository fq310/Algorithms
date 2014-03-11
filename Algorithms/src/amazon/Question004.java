package amazon;

import java.util.HashMap;
import java.util.Map;

public class Question004 {

	public static void main(String[] args) {
		String[] confs = new String[]{"A={A=1;B=2;C=3;E={A=100;};};", "A+={C=4;E={B=10;C=D;};};"};
		String[] exs = new String[]{"A.E.B", "B.D.E"};
		calculateAndPrint(confs, exs);
	}
	
	private static void calculateAndPrint(String[] confs, String [] exs) {
		Map<String, Object> confMap = new HashMap<String, Object>();
		for (String conf : confs) {
			parseConf(conf, confMap);
		}
		for (String ex : exs) {
			String[] paths = ex.split("\\.");
			String value = findValue(0, paths, confMap);
			if (value == null) 
				System.out.println(ex + "=N/A");
			else 
				System.out.println(ex + "=" + value);
		}
	}

	@SuppressWarnings("unchecked")
	private static String findValue(int i, String[] paths, Map<String, Object> confMap) {
		if (i > paths.length - 1) return null;
		Object value = confMap.get(paths[i]);
		if (value == null) return null;
		if (value instanceof Map) {
			if (i + 1 > paths.length - 1) return (String) value;
			else return findValue(i + 1, paths, (Map<String, Object>) value);
		}
		if (value instanceof String) return (String) value;
		return null;
	}

	@SuppressWarnings("unchecked")
	private static void parseConf(String conf, Map<String, Object> confMap) {
		for (int i = 0; i < conf.length();) {
			char ch = conf.charAt(i);
			int j = i;
			if (ch == '=') {
				String name = findName(conf, i);
				if (conf.charAt(i + 1) == '{') {
					Object map = generateMap(confMap, name);
					j = findRightBracketIndex(conf, i + 2);
					parseConf(conf.substring(i + 2, j), (Map<String, Object>) map);
				} else {
					j = findTheFirstSemicolinIndex(conf, i);
					confMap.put(name, conf.substring(i + 1, j));
				}
				i = j;
			} else {
				++i;
			}
			
		}
	}

	private static int findTheFirstSemicolinIndex(String conf, int i) {
		int j;
		j = i + 1;
		for (; j < conf.length(); ++j) {
			if (conf.charAt(j) == ';') break;
			
		}
		return j;
	}

	private static Object generateMap(Map<String, Object> confMap, String name) {
		Object map;
		if (confMap.get(name) == null) {
			map = new HashMap<String, Object>();
			confMap.put(name, map);
		} else { 
			map = confMap.get(name);
		}
		return map;
	}

	private static int findRightBracketIndex(String conf, int startIndex) {
		int k = 0;
		for (;startIndex < conf.length(); ++startIndex) {
			if (conf.charAt(startIndex) =='{')
				++k;
			if (conf.charAt(startIndex) == '}') {
				if (k > 0)
					--k;
				else 
					break;
			}
		}
		return startIndex;
	}

	private static String findName(String conf, int i) {
		String name;
		if (conf.charAt(i-1) == '+') {
			name = String.valueOf(conf.charAt(i-2));
		} else {
			name = String.valueOf(conf.charAt(i-1));
		}
		return name;
	}

}
