package C0903;

public class Class0903 {
	int t = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//r(5);
		//System.out.println(m(5));
		System.out.println(sum(5));
		System.out.println(sum1(5));
	}
	public static int sum(int n) {
		if(n>0)
			return n+(sum(n-1));
		return n;
	}
	public static int sum1(int n) {
		if(n< 2)return 1;
		else return n + sum(n-1);
	}
	public static void r(int n) {
		int q = n;
		if(n == 0) {
			System.out.println("\n*");
			//r();
		}else {
			System.out.print("*");
			r(n-1);
		}
		
	}
	public static int m(int v) {
		if(v >=0) {
			return 5 * m(v-2);
		}else
			return 1;
	}

}
//class a 