package C1701;

import java.util.ArrayList;

public class Beatles {
	public static void main(String[] args) {
	ArrayList<String> band = new ArrayList<String>();
	band.add("John");
	band.add("Pete");
	band.add("Paul");
	band.add("George");
	System.out.println(band);
	int index = band.indexOf("Pete");
	band.remove(index);
	System.out.println(band);
	if(!band.contains("Ringo")){
		System.out.println("Ringo is missing");
		band.add("Ringo");
	}
	System.out.println("size of the band: " + band.size());
	for (int i = 0 ; i < band.size(); i++) {
		System.out.println(i + ": " + band.get(i));
	}
}
}
