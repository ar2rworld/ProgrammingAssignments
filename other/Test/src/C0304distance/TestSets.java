package C0304distance;

import java.util.*;
public class TestSets
{
   public static void main(String[] args){
       Set<String> programmers = new HashSet<String>();
       String s = "aaa";
       String s1 = "zzz";
       System.out.println(s + " " + count(s));
       System.out.println(s1 + " " + count(s1));
       programmers.add(s);
       programmers.add(s1);
       programmers.add("Taylor");
       programmers.add("Christian");
       programmers.add("Grayson");
       programmers.add("Tobias");
       programmers.add("Shane");
       programmers.add("Angie");
       programmers.add("Steven");
       programmers.add("Jesse John");
       programmers.add("Taylor");
       
       System.out.println(programmers);
       //Iterator<E> it = new Ite
       //System.out.println(programmers);
       
   }
 public static int count(String s) {
	 int out = 0;
	 for(int i=0;i<s.length(); i++) {
		 out += (int) s.charAt(i);
	 }
	 return out;
 }
}