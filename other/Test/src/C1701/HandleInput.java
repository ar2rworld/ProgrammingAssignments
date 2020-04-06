package C1701;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleInput {
	public static void main(String[] agrs) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		boolean badInput = true;
		do {
			try {
				System.out.println("Enter a number");
				n = input.nextInt();
				
			}
			catch(InputMismatchException ex) {
				System.out.println(ex);
				input.nextLine();
			}
		}while(badInput);
	}
}
