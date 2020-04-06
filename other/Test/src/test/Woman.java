package test;

public class Woman {
	private String name;
	public Woman() {
		System.out.println("Woman no args construtor");
	}
	public Woman(String name) {
		this.name = name;
		System.out.println("Woman with name constructor");
	}
}
