package test;

public class ShapeTest {
public static void main(String[] args) {
	Shape s = new Shape();
	Circle c = new Circle();
	c.setRadius(10);
	print(c.getArea());
}

public static void print(double a) {
	System.out.println(a);
}
public static void print(String a) {
	System.out.println(a);
}
}
