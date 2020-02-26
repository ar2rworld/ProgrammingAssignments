package Lab3;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Assignment3{
	/*
	 Artur Linnik 300305901
	 1.02.2020
	 Assignment3
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Student> a = new ArrayList<Student>();
		String inOpt = "";
		int tGrade = 0;
		int index=0;
		while(true) {			
			System.out.println(" Select one of the following options\r\n" + 
						"1. Add a Student\r\n" + 
						"2. Edit student grades\r\n" + 
						"3. Exit");
			inOpt = in.next();
			if(inOpt.equals("1")){
				System.out.println("Please enter the students name: ");
				inOpt = in.next();
				System.out.println("Please enter a grade for " + inOpt + ": ");
				tGrade = getNumVal();
				a.add(new Student(inOpt, tGrade));
			}
			if(inOpt.equals("2")) {
				if(a.size() == 0) {
					System.out.println("No student added");
				}else {
					System.out.println("What student would you like to enter a grade for?");
					for(int i=0; i<a.size(); i++) {
						int m = i+1;
						System.out.println(" " + m + ") " + a.get(i).toString());
					}
					index = getValidIndex(a);
					System.out.println("Please enter a grade for " + a.get(index).getName());
					int v = getNumVal();
					a.get(index).setGrade(v);
				}
			}
			if(inOpt.equals("3")) {
				System.out.println("Thank you, Goodbye!");
				break;
			}
			System.out.println("Main menu\n");
					
		}
	}
	public static int getValidIndex(ArrayList<Student> ar) {
		Scanner in = new Scanner(System.in);
		int max = ar.size() ;
		int n = 0;
		boolean t = false;
		try {
			while(in.hasNextInt()) {
				n = in.nextInt();
				if(n > 0 && n <=max) {
					return n-1;
				}else {
					System.out.println("No such index. Enter again.");
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Wrong input. Enter again.");
		}
		return n;
	}
	public static int getNumVal() {
		Scanner in = new Scanner(System.in);
		int n = 0;
		boolean t = false;
		while(true) {
			try {
					if(t) {
						in.next();
					}
					n = in.nextInt();
					return n;
			}
			//change type of exception
			catch(InputMismatchException e) {
				System.out.println("Wrong input. Enter again.");
				t = true;
			}
		}
	}
}
class Student{
	private String name;
	private int grade;
	public Student(String n, int g) {
		name = n;
		grade = g;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int g) {
		grade = g;
	}
	public String toString() {
		return getName() + " - " + getGrade();
	}
}