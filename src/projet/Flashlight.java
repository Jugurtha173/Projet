package projet;

public class Flashlight extends Object {
	
	public Flashlight() {
		super("Flashlight");
	}

	@Override
	public String descriptif() {
		
		return "Flashlight, you can light up rooms with it";
	}

	@Override
	public void use(Character c) {
		c.getCurrentRoom().lightUp();
		
	}

}
