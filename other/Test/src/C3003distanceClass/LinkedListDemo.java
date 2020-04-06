package C3003distanceClass;

import java.util.*;
public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("F");
		ll.add("F");
		ll.add("B");
		ll.add("C");
		ll.add("E");
		ll.add("D");
		ll.addLast("Z");
		ll.addFirst("A");
		ll.add(1, "A2");
		System.out.println("Original contents of LL: " + ll);
		
		ll.remove("F");
		ll.remove(4);
		System.out.println("Contents of LL after remove: " + ll);
		
		ll.removeFirst();
		ll.removeLast();
		System.out.println("Contents of LL after remove ends: " + ll);
		
		String val = ll.get(2);
		ll.set(2, val + "*" );
		System.out.println("Contents of LL after change: " + ll);
		
	}

}
