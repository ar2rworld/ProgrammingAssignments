package C3003distanceClass;

public class mathAPOr {

	public static void main(String[] args) {
		int c=0;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				for(int k=1; k<=10; k++) {
					if(k + j + i == 10) {
						c ++ ;
					}
				}
			}
		}
		System.out.println(c);
	}

}
