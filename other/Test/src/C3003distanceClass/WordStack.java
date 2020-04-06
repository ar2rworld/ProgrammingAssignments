package C3003distanceClass;

import java.util.ArrayList;
public class WordStack {

	private ArrayList<String> list = new ArrayList<String>();
	
	public int getSize(){
		return list.size();
	}

	public String peek(){
		return list.get(getSize() -1);
	}
	
	public void push(String s){
		list.add(s);
	}
	
	public String pop(){
		String temp = peek();
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
