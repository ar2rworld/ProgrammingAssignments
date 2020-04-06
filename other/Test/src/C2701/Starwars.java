package C2701;

public class Starwars {
	public static void main(String[] agrs) {
		Jedi luke = new Jedi();
		Sith darthVader = new Sith();
		
		darthVader.attack();
		luke.attack();
		darthVader.heal();
		luke.heal();
		Character spy = summonCharacter();
		spy.attack();
		System.out.println(spy.i);	
	}
	public static Character summonCharacter() {
		int n = (int) (Math.random() * 1000);
		if(n % 2 == 0) {
			return new Jedi();
		}else {
			return new Sith();
		}
	}
}
