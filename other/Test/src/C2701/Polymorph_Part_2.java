package C2701;
/*
import C1301.Animal;
import C1301.Cat;
import C1301.Dog;
*/
public class Polymorph_Part_2 {
	public static void main(String[] args) {
		Cat pet = new Cat("Snowball ||");
		Dog pet2 = new Dog("Santa's little helper");
		feed(pet);
		feed(pet2);
		
		Cat felix = new Cat("Santa's little helper");
		System.out.println(pet2.equals(felix));
		Animal animal = new Dog("Animal plays drums");
		System.out.println(animal instanceof Cat);
	}
	public static void feed(Animal a) {
		System.out.println("It's time to feed " + a.getName());
		
		if( a instanceof Cat) {
			System.out.println(", the cat who eats " + a.eats());
		}
		if(a instanceof Dog) {
			System.out.println(", the dog who eats " + a.eats());
		}
	}
	
}
abstract class Animal{
	protected String name;
	public Animal(String name) {
		System.out.println("Animal constructor");
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Animal) {
			Animal a = (Animal ) o;
			return name.equals(a.getName());
		}else {
			return false;
		}
		}
	public abstract String eats();
	}

class Cat extends Animal{
	public Cat (String name) {
		super(name);
		System.out.println("Cat Constructor");
	}
	public String eats() {
		return "mice";
	}
}
class Dog extends Animal{
	public Dog(String name) {
		super(name);
		System.out.println("Dog Constructor");
	}
	public String eats() {
		return "Homework";
	}
}
