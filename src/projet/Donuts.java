package projet;

public class Donuts extends Object{

	
	public Donuts() {
		super("Donuts",0);
	}
	
	@Override
	public String descriptif() {
		return this.toString();
	}

	@Override
	public void use(Character c) {
		System.out.println();
		
	}

	
	
}
