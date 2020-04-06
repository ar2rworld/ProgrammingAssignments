package C2701;

public class Sith implements Character{
	public String weapon = "Red lightsaber";
	
	@Override 
	public void attack() {
		System.out.println("The sith attacks their enemy");
	}
	@Override
	public void heal() {
		System.out.println("The sith heals themselves");
	}
	
	@Override
	public String getWeapon() {
		return weapon;
	}
	
}

