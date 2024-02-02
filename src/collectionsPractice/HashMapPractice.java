package collectionsPractice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashMapPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMapPractice.updateValue();
		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		map.put("Jhon", 01);
//		map.put("Adam", 02);
//		map.put("Lisa", 03);
//		map.put("Tony", 04);
//		map.put("Kim", 05);
//		
//		for(Map.Entry<String, Integer> m:map.entrySet())
//		{
//			System.out.println("HashMap:  " +m.getKey() +" : " +m.getValue());
//		}
//		
//		Map<String, Integer> linkmap = new LinkedHashMap<String, Integer>();
//		
//		linkmap.put("Jhon", 01);
//		linkmap.put("Adam", 02);
//		linkmap.put("Lisa", 03);
//		linkmap.put("Tony", 04);
//		linkmap.put("Kim", 05);
//		
//		for(Map.Entry<String, Integer> m1:linkmap.entrySet())
//		{
//			System.out.println("LinkedHashMap:  " +m1.getKey() +" : " +m1.getValue());
//		}

	}
	
	public static void updateValue() {
		
Map<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "A");
		hm.put(2, "B");
		hm.put(3, "C");
		hm.put(4, "D");
		hm.put(5, "E");
		
		
		
		for(Map.Entry<Integer, String> map:hm.entrySet())
		{
			System.out.println(map.getKey() +" : " +map.getValue());
		}
	}

}
