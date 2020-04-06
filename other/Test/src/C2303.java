import java.util.ArrayList;

public class C2303 {
	public static void main(String[] args) {
		ArrayList<Double> arlt= new ArrayList<Double>();
		for(int i=0;i<2000000; i++) {
			arlt.add(Math.random());
		}
		long s = System.currentTimeMillis();
		arlt.sort(null);
		long f = System.currentTimeMillis();
		System.out.println("Time of sorting: " + (f-s));
		
	}
}
