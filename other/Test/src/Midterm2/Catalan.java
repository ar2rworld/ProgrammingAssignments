package Midterm2;

public class Catalan {
	static int count = 0;
	static long[] memo;
	public static void main(String[] args) {
		int n=30;
		memo = new long[n+1];
		long start = System.currentTimeMillis();
		System.out.println(cat(n));
		long finish = System.currentTimeMillis();
		System.out.println("Time : " + (finish - start)+ "milliseconds" + "\ncount : " + count);
		
	}
	public static long cat(int n) {
		count ++;
		if(n <=1)
			return 1;
		if(memo[n] > 0)
			return memo[n];
		int res = 0;
		for (int i=0;i<n; i++) {
			res+= cat(i) * cat(n-i-1);
		}
		memo[n] = res;
		return res;
		
	}
}
