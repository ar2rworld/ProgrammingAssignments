package C0304distance;

import java.util.*;

public class ArrayVsLinked {
	static final int N = 200000;
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		System.out.println("Add Test:");
		System.out.println("ArrayList add test time: " + getAddTime(list1));
		System.out.println("LinkedList add test time: " + getAddTime(list2));

	}

	public static long getAddTime(ArrayList<Integer> a){
		long start = System.currentTimeMillis();

		for(int i = 0; i < N; i++){
			//a.add(index, element);
			a.add(0,(int)(Math.random() * 2 * N));
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static long getAddTime(LinkedList<Integer> a){
		long start = System.currentTimeMillis();

		for(int i = 0; i < N; i++){
			//a.add(index, element);
			a.add(0,(int)(Math.random() * 2 * N));
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
