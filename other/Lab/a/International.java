package a;

public class International extends Commercial {
	private String country;
	
	public International(String dl, String dest, Time dt, Time dur, double sF, String c) {
		super(dl, dest, dt, dur, sF);
		country = c;
	}
	
	public String getCountry() {
		return country;
	}
	public String toString() {
		return "Flight " + flightNumber + "-I departs " + departLocation + " for " + destination + " at " + departTime + "\nStatus: " + getStatus()+ "\nCountry: " + getCountry() + "\n\n";
	}
}
