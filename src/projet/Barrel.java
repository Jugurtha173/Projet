package projet;

public class Barrel extends Object {
		
	private int level = 5;

	public Barrel() {
		super("Barrel");
	}
	
	@Override
	public String descriptif() {	
		return this.toString() + "[level "+ this.level +"]";
	}

	@Override
	public void use(Character c) {
		System.out.println("You can fill "+ this.level +" duff bottles with this barrel (USE Duff Barrel)");
	}
	
	public void use(Character c, Object duff) {
		if(this.level <= 0) {
			System.out.println("Barrel is empty, can't fill");
			return;
		}
		
		if(!(duff instanceof Duff)) {
			System.out.println("Barrel can fill only empty duff bottles");
			return;
		}		
		// Remplire la premiere bouteillr de duff vide dand l'inventaire
		Duff nextEmptyDuff = ((Duff) duff).getNextEmptyDuff(c);
		if(nextEmptyDuff != null) {
			nextEmptyDuff.fill();
			this.level--;			
		}

	}

}
