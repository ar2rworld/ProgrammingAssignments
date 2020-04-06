package a;

public class Domestic extends Commercial {
	private double airportFee;
	
	public Domestic(String dl, String dest, Time dt, Time dur, double sF, double aF) {
		super(dl, dest, dt, dur,sF);
		airportFee = aF;
	}
	
	public double getAirportFee() {
		return airportFee;
	}
	public String toString() {
		return "Flight " + flightNumber + "-D departs " + departLocation + " for " + destination + " at " + departTime + "\nStatus: " + getStatus() + "\n\n";
	}
}
