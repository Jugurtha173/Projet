package projet;

/**
 *
 * @author JUGURTHA
 */
public class Skate extends Object{
    public Skate() {
    	super("Skate", -3);
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
