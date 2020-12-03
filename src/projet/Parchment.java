package projet;

public class Parchment extends Object {
	private boolean crypt = true;
	
	public Parchment() {
		super("Parchment");
	}
	
	public void decrypt() {
		this.crypt = false;
	}

	@Override
	public String descriptif() {
		if(this.crypt) {
			return "crypt";
		} else {
			return "decrypted";
		}
	}

	@Override
	public void use(Character c) {
		System.out.println(this.descriptif());
	}
	
	
	
		
}
