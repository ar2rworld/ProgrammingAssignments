package test;
public class Test {
		private int a;
		private int b;
	public Test(int a, int b){
		this.a = a;
		this.b = b;
	}
	public static void main(String[] args) {
		print("123");
		print(1234);
		int a = 10;

		print(123+a);
		print(str(123));
		print("A" + 123);
	}
	public static void print(String a) {
		System.out.println(a);
	}
	public static void print(int a) {
		System.out.println(a);
	}
	public static String str(int a) {
		return Integer.toString(a);
	}
}
