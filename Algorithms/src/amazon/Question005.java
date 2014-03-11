package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Question005 {
	public static void main(String args[]) {
		String itemX = "item1";
		String records = "custA item1 custB item1 custA item2 custB item3 custC item1 custC item3 custD item2";
		System.out.println(findBuyMost(itemX, records));
		itemX = "item2";
		records = "custA item1 custB item1 custC item1 custA item2 custB item3 custA item3";
		System.out.println(findBuyMost(itemX, records));
		
		itemX = "item2";
		records = "custA item1 custB item1 custC item1";
		System.out.println(findBuyMost(itemX, records));
		
		itemX = "item1";
		records = "custA item1 custB item1 custC item1 custD item2 custE item2";
		System.out.println(findBuyMost(itemX, records));
		
		itemX = "item1";
		records = "custA item1 custB item1 custC item1 custA item6 custB item3 custC item4";
		System.out.println(findBuyMost(itemX, records));
	}

	private static String findBuyMost(String itemX, String records) {
		String[] values = records.split(" ");
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < values.length; ++i) {
			String user = values[i];
			String item = values[++i];
			List<String> userList = map.get(item);
			if (userList == null) {
				userList = new ArrayList<String>();
				map.put(item, userList);
			}
			userList.add(user);
		}
		List<String> xUsers = map.get(itemX);
		if (xUsers == null) return "None";
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (Entry<String, List<String>> entry : map.entrySet()) {
			String item = entry.getKey();
			if (item.equals(itemX)) continue;
			List<String> users = entry.getValue();
			int count = 0;
			for (String user : users) {
				if (xUsers.contains(user)) {
					++count;
				}
			}
			if (count > 0) {
				countMap.put(item, count);
			}
		}
		if (countMap.size() == 0) return "None";
		String maxItem = null;
		int maxItemCount = 0;
		for (Entry<String, Integer> entry : countMap.entrySet()) {
			String item = entry.getKey();
			int count = entry.getValue();
			if (count > maxItemCount) {
				maxItemCount = count;
				maxItem = item;
			}
		}
		if (maxItemCount == 0) return "None";
		return maxItem;
	}
	
	
}
