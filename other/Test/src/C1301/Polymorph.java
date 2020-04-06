package C1301;

public class Polymorph {
	public static void main(String[] args) {
		Cat pet = new Cat("Snowball ||");
		Dog pet2 = new Dog("Santa's little helper");
		feed(pet);
		feed(pet2);
		
		Cat felix = new Cat("Santa's little helper");
		System.out.println(pet2.equals(felix));
	}
	public static void feed(Animal a) {
		System.out.println("It's time to feed " + a.getName());
		
		if( a instanceof Cat) {
			System.out.println(", the cat");
		}
		if(a instanceof Dog) {
			System.out.println(", the dog");
		}
	}
	
}
class Animal{
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
	}

class Cat extends Animal{
	public Cat (String name) {
		super(name);
		System.out.println("Cat Constructor");
	}
}
class Dog extends Animal{
	public Dog(String name) {
		super(name);
		System.out.println("Dog Constructor");
	}
}