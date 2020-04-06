package C3003distanceClass;

import java.util.ArrayList;
public class MyStack<E>{

	private ArrayList<E> list = new ArrayList<E>();
	
	public int getSize(){
		return list.size();
	}

	public E peek(){
		return list.get(getSize() -1);
	}
	
	public void push(E s){
		list.add(s);
	}
	
	public E pop(){
		E temp = peek();
		list.remove(getSize() -1);
		return temp;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public String toString(){
		return list.toString();
	}
}
