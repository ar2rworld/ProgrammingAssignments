package C2001;

public class TestCircle {

	public static void main(String[] agrs) {
		try {
			Circle c = new Circle();
					c.setRadius(-5);
					
					System.out.println("we are happy!");
					
				}
		catch(InvalidRadiusException e) {
			System.out.println("invalid radius ( from catch ) : " + e.getRadius());
			System.out.println(e.getMessage());
			}
		}
}
