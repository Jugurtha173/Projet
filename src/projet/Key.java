package projet;

public class Key extends Object {

	public Key() {
		super("Key");
	}
	
	@Override
	public String descriptif() {
		
		return this.toString();
	}

	@Override
	public void use(Character c) {
		System.out.println(this.descriptif());	
	}

}
