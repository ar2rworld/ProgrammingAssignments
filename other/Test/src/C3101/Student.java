package C3101;

import java.util.*;

public class Student implements Comparable<Student>{
	
	private double GPA;
	private String name;
	
	public Student(String n , double gpa) {
		name = n;
		GPA = gpa;
	}
	
	@Override
	//check on similari methods with signature
	public int compareTo(Student o) {
		if(GPA > o.GPA) {
			return 1;
		}else if(GPA < o.GPA) {
			return -1;
		}else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nGPA: " + GPA;
	}
	
	public static void main(String[] args) {
		Student[] kensMinions = {new Student("Jake" , 0), new Student("Andre", 100), new Student("Justin" , 99)};
		Arrays.sort(kensMinions);
		for(int i =0; i< kensMinions.length; i++) {
			//System.out.println(kensMinions[i]);
		}
	ArrayList<Student> superNerd = new ArrayList<Student>();
	superNerd.add(new Student("Joey" , 73));
	superNerd.add(new Student("Natasha" , 97));
	superNerd.add(new Student("Matt" , 93));
	superNerd.add(new Student("Sophie" , 99));
	superNerd.add(new Student("Mitch" , 95));
	superNerd.add(new Student("Daniel" , 94));
	
	Collections.sort(superNerd);
	for(Student s: superNerd) {
		System.out.println(s);
	}
	}
}
