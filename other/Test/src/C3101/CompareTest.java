package C3101;

import java.util.Arrays;

public class CompareTest {
	public static void main(String[] args) {
		System.out.println("fox".compareTo("elephant"));
		System.out.println("dog".compareTo("elephant"));
		
		String[] animals = {"dog", "fox", "rabbit", "elephant"};
		Arrays.sort(animals);
		for(int i=0; i< animals.length; i++) {
			System.out.println(animals[i]);
		}
	}
}
