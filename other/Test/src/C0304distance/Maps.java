package C0304distance;

import java.util.*;

import C3101.Student;
public class Maps
{
    public static void main(String[] args){
       Map<String, Integer> hashmap = new TreeMap<String,Integer>();
       hashmap.put("ZAdam", 135);
       hashmap.put("Dave",90);
       hashmap.put("Jackson", 110);
       hashmap.put("Nelson", 134);
       hashmap.put("Nelson", 111);
       System.out.println(hashmap);
       System.out.println("Nelson's IQ is " + hashmap.get("Nelson"));
       
       for(String key: hashmap.keySet()){
    	   System.out.println(key + " -> " + hashmap.get(key));
       }
       System.out.println(hashmap.containsValue(90));
       
       //Iterator<String> iterator = hashmap.iterator();
       Map<A,Integer> hm = new TreeMap<A, Integer>();
       hm.put(new A(1), 1);
       hm.put(new A(2), 2);
       hm.put(new A(3), 3);
       System.out.println("\n"+ hm);
       System.out.println(hm.containsKey(new A(1)));
       
   }
}
class A implements Comparable<A>{
	public int a;
	public A(int a) {
		this.a = a;
	}
	public String toString() { return String.valueOf(a);}
	public int compareTo(A o) {
		if(a > o.a) {
			return 1;
		}else if(a< o.a) {
			return -1;
		}else {
			return 0;
		}		
}
	}