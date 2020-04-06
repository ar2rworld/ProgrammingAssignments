package test;

public class Circle extends Shape {
	private double radius;
	public void setRadius(double a) {
		radius = a;
		setArea(Math.PI * a * a);
	}
	public double getRadius() {
		return radius;
	}
}
