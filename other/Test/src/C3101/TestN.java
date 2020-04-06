package C3101;

public class TestN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//student s
		// 
		B a = new B();
		a.act();
		actAPar(a);
	}
	public static void actAPar(B a) {
		System.out.println("actAPar");
	}

}
class A{
	public A() {
		System.out.println("A");
	}
	public void act() {
		System.out.println("act no par A class");
	}
	public void act(A a) {
		System.out.println("act B a");
	}
}
class B extends A{
	public B() {
		System.out.println("B");
	}
	public void act() {
		System.out.println("act no par B class");
	}
	public void act(A a) {
		System.out.println("act B a");
	}
}
