package C2001a;
public class MultiThrow {
	public static void main(String[] args){
		System.out.println(myOtherCrazySide());
	}

	public static String myOtherCrazySide() {
		try{
			myCrazyMethod();			
		}
		catch(NumberFormatException e){
			System.out.println("Number Format Exception");
			return "Number Format";
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception");
		}
		catch(Exception e){
			System.out.println("Exception");
		}
		finally{
			System.out.println("this always gets called");
			return "From finally";
		}
	//	System.out.println("Try-catch is done");
	//	return "From after the try-catch";
	}

	public static void myCrazyMethod() throws NumberFormatException, ArithmeticException{
		String s = "5.6";
		Integer.parseInt(s);
		int y = 2 / 0;
	}

}