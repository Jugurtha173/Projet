package projet;

/**
 *
 * @author JUGURTHA
 */
public class Duff extends Object{
	
	public Duff() {
		super("Duff");
	}
	
	@Override
	public String descriptif() {
		
		return this.toString();
	}

	@Override
	public void use(Character c) {
		System.out.println("using duff");
		
	}
}
