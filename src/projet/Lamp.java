package projet;

public class Lamp extends Object {
	
	public Lamp() {
		super("Lamp");
	}

	@Override
	public String descriptif() {
		
		return "Lamp, you can light up rooms with it";
	}

	@Override
	public void use(Character c) {
		c.getCurrentRoom().lightUp();
		
	}

}
