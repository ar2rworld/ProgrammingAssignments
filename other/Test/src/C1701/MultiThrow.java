package C1701;

public class MultiThrow {
	public static void myCrazyMethod() throws NumberFormatException, ArithmeticException {
		String s = "5";
		Integer.parseInt(s);
		int i = 0;
		int y = 2 ;
		int a = 214999999 * 1000;
		a *= 1000;
	}
	public static void main(String[] agrs) {
		try {
			myCrazyMethod();
		}
		catch(NumberFormatException ex) {
			System.out.println("Number format exception");
		}
		catch(ArithmeticException ex) {
			System.out.println("Arithmetic exception");
		}
		catch(Exception ex) {
			System.out.println("Error");
		}
		finally {
			System.out.println("FINAL!!!");
		}
	}
}
