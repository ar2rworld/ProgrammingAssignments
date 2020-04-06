package a;

public class Commercial extends Flight {
	private String status;
	private double securityFee;
	
	public Commercial(String dl, String dest, Time dt, Time dur, double sF) {
		super(dl, dest, dt, dur);
		securityFee = sF;
		status = "On Time";
	}
	
	public String getStatus() {
		return status;
	}
	public double getSecurityFee() {
		return securityFee;
	}
	public void setStatus(String a) {
		status = a;
	}
	
}
