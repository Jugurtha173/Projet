package projet;

/**
 *
 * @author JUGURTHA
 */
public class Burger extends Object{

	public Burger() {
		super("Burger", 3);
	}
	
	@Override
	public String descriptif() {
		
		return this.toString()+" use to gain energy!";
	}

	@Override
	public void use(Character c) {
		c.editHP(this.getHealthEffect());
		System.out.println("Eating burger ...");
		c.inventory.remove(this);
	}
    
}
