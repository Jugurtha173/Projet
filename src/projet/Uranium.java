package projet;

public class Uranium extends Object{
	public Uranium() {
		super("Uranium", -13);
		
	}
	
	@Override
	public String descriptif() {
		
		return this.toString();
	}

	@Override
	public void use(Character c) {
		((Hero)c).attack(((Hero)c).enemyInRoom());
	}
}
