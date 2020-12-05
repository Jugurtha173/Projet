package projet;

public class Gun extends Object{
	public Gun() {
		super("Gun", -10);
		
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
