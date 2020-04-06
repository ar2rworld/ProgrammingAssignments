package C1701;

import java.util.Scanner;
public class Divide {
	public static void main(String[] agrs) {
		Scanner in = new Scanner(System.in);
		System.out.println("Plz enter a number");
		int number = in.nextInt();
		int number2 = in.nextInt();
		try {
			int ratio = divide(number , number2);
			System.out.println(ratio);
		}
		catch(ArithmeticException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Continue as normal");
		
	}
	public static int divide(int n1, int n2) throws ArithmeticException{
		if (n2 == 0) throw new ArithmeticException("Divisor can't be zero"); //
		return n1/n2;
	}
}
