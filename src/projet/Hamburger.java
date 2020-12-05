package projet;

/**
 *
 * @author JUGURTHA
 */
public class Hamburger extends Object{

	public Hamburger() {
		super("Hamburger", +3);
	}
	
	@Override
	public String descriptif() {
		
		return this.toString()+" use to gain energy!";
	}

	@Override
	public void use(Character c) {
		c.editHP(this.getHealthEffect());
	}
    
}
