import java.util.Scanner;
public class A{
    
public static int day = 0;
public static int dayel = 0;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//sunday = 0
		System.out.println("Enter today's day:");
		int day = in.nextInt();
		System.out.println("Enter the number of days elapsed since today:");
		int el = in.nextInt();
		//String _day = ""; 
		int dayel = el%7; 
			
		
		System.out.println("Today is " +new  A().Day(day) + " and the future day us " + new A().Day(dayel));
	}
	
	public String Day(int day){
		//int day = 0;
		String _day = "";
		switch(day){
				case 0:
					_day = "Sunday";
				break;
				case 1:
					_day = "Monday";
				break;
				case 2:
					_day = "Tuesday";
				break;
				case 3:
					_day = "Wednesday";
				break;
				case 4:
					_day = "Thursday";
				break;
				case 5:
					_day = "Friday";
				break;
				case 6:
					_day = "Saturday";
				break;
			}
			return _day;
	}
	
	/*public void m(String[] args){
	    System.out.println("Today is " + Day(day) + " and the future day us " + Day(dayel));
	}*/
	
}