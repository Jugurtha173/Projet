package projet;


public class Knife extends Object{

	public Knife() {
		super("Knife", -5);
		
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
