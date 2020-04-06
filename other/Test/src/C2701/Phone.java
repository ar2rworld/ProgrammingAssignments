package C2701;

abstract public class Phone {
	private String phoneNumber;
	public Phone(String s) {
		phoneNumber = s;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String toString() {
		return "#(" + phoneNumber + ")";
	}
	//abstract public boolean createConnection(Network n);
	abstract public void closeConnection();
}
