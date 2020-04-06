package C0604distance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteratorr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		/*for( Integer i : ints) {
			ints.remove(1);
		}*/
		Iterator<Integer> iter = ints.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			if(i == 2) {
				iter.remove();
				//ints.remove(2-1);
			}
			System.out.println(i);
		}

	}

}
