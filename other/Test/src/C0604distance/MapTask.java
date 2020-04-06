package C0604distance;

import java.util.Map;
import java.util.TreeMap;

public class MapTask {
	public static void main(String[] args) {
	String s = "Good Morning! I love programming and I love COSC 121.";
	s = s.toLowerCase();
	String[] arS = s.split(" ");
	Map<String, Integer> hm = new TreeMap<String,Integer>();
	for(int i=0; i<arS.length; i++) {
		String tS = arS[i];
		if(hm.containsKey(tS)) {
			int value = hm.get(tS);
			hm.put(tS, value + 1);
		}else {
			hm.put(tS, 1);
		}
	}
	
	}
}
