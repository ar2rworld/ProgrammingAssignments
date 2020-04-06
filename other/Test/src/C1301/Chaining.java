package C1301;

public class Chaining {
	public static void main(String[] args) {
		Cook mitchell = new Cook();
		System.out.println(mitchell);
		System.out.println(mitchell.getId());

	}
}
//not public - u are not allowed
class Person{
	private int id = 0;
	public Person() {
		System.out.println("Person Constructor");		
	}
	
	public String toString() {
		return "This is a person";
	}
	public int getId() {
		return id;
	}
}
class Staff extends Person{
	public Staff() {
		System.out.println("Staff Constructor");
	}
	
	public String toString() {
		return "This is a staff";
	}
	
}
class Cook extends Staff{
	public Cook() {
		System.out.println("Cook constructor");
	}
	@Override
	// to check out: Are u overriding the method or not
	public String toString() {
		return "This is a Cook";
	}
}
