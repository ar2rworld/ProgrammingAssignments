package test;

public class Mother extends Woman {
	private int numKids;
	public Mother(int kids, String name) {
		super(name);
		numKids = kids;
		System.out.println("M Constuctor");
	}
	public void lieDetector() {
		System.out.println("Mom always kniw when you are lying");
	}
}
