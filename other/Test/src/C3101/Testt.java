package C3101;

public class Testt {
	public static void main(String[] agrs) {
		System.out.println(test());
	}
	public static String test() {
		try {
			System.out.println("A");
			int i = 0;
			i = i/0;
			System.out.println("2");
			return "hah";
		}
		catch(Exception e) {
			System.out.println("3");
		}
		finally {
			System.out.println("1");
		}
		System.out.println("lel");
		return "e";
	}
}
