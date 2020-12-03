package projet;

public class Flashlight extends Object {
	
	public Flashlight() {
		super("Flashlight");
	}

	@Override
	public String descriptif() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void use(Character c) {
		c.getCurrentRoom().lightUp();
		
	}

}
