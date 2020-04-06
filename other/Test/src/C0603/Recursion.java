package C0603;

import java.sql.Time;
import java.util.ArrayList;

import jdk.nashorn.internal.objects.Global;

public class Recursion {
	static long a=0;
	public static void main(String[] args) {
		/*long x = 100;
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		System.out.println(fact(x));
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(" a= " + a);
		long tt1 = System.currentTimeMillis();
		System.out.println(factorial(x));
		long tt2 = System.nanoTime();
		System.out.println(tt2-tt1);*/
		//System.out.println("123".substring(0,0).length());
		System.out.println(fibM(100));
	}
	public static int countX(String str) {
		  if(str.length()>0)
			  if(str.charAt(0)=='x')
		  return 1+countX(str.substring(1,str.length()-1));
		  else if(str.length()>1)
		  return countX(str.substring(1,str.length()-1));
		  return 0;
		}

	public static long factorial(long x) {
		long out=1;
		for(long i=1; i<=x;i++) {
			out *= i;
		}
		return out;
	}
	public static long fact(long x) {
		a+=1;
		String s="";
		s.equals("");
		if(x == 0) 
			return 1;
		return x * fact(x-1);
	}
	static ArrayList<Integer> ar;
	public static int fibM(int n) {
		if(n==0)
			return 0;
		if(n==1)
				return 1;
		if(n==2)
			return 1;
		else
		{
		ar.add(fibM(n-1));
		ar.add(fibM(n-2));
		return ar.get(ar.size()-1) + ar.get(ar.size()-2);
		}
	}

}
