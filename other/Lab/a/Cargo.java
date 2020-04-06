package a;

public class Cargo extends Flight{
	private String freightDescription;
	
	public Cargo(String dl, String dest, Time dt, Time dur, String fD) {
		super(dl, dest, dt, dur);
		freightDescription = fD;
	}
	
	public String getFreightDescription() {
		return freightDescription;
	}
	public String toString() {
		return "Flight " + flightNumber +"-C departs " + departLocation + " for " + destination + " at " + departTime + "\nFreight: " + freightDescription + "\n\n";
	}
	
}
