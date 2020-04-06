package C2701;

public class Jedi implements Character{
	public String weapon = "Blue lightsaber";
	
	@Override 
	public void attack() {
		System.out.println("The jedi attacks their enemy");
	}
	@Override
	public void heal() {
		System.out.println("The jedi heals themselves");
	}
	
	@Override
	public String getWeapon() {
		return weapon;
	}
	
}
