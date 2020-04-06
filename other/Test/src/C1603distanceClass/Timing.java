package C1603distanceClass;

public class Timing {
	public static void main(String[] args){
		
		test1(1000); //thousand
		test1(1000000); //million
		test1(1000000000); //billion
		test2(1000); //thousand
		test2(10000); //10 thousand
		test2(200000); //200 thousand
	}
	
	public static void test1(int n){
		long start = System.currentTimeMillis();
		long k = 0;
		for(int i = 0; i < n; i++){
			k += i % 2;
		}
		long end = System.currentTimeMillis();
		System.out.print("Test 1 - Execution time with n = " + n);
		System.out.println(" is " + (end - start) + " milliseconds");
		
	}
	
	public static void test2(long n){
		long start = System.currentTimeMillis();
		long k = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				k += i % 2 + j;
				
			}
		}
		
		for(int i = 0; i < n; i++){
			k++;
		}
		long end = System.currentTimeMillis();
		System.out.print("Test 2 - Execution time with n = " + n);
		System.out.println(" is " + (end - start) + " milliseconds");
		
	}
}
