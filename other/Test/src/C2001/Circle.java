package C2001;

public class Circle {

	//public static void main(String[] args) {
		private double radius;
		public Circle() {
			radius = 0;
		}
		public void setRadius(double r) throws InvalidRadiusException{
			if(r >=0) {
				radius = 0;
			}else {
				throw new InvalidRadiusException(r);
			}
		}
	//}

}
