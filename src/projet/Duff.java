package projet;

/**
 *
 * @author JUGURTHA
 */
public class Duff extends Object{
	
	private boolean full = true;
	
	public Duff() {
		super("Duff", 2);
	}
	
	public boolean isEmpty() {
		return !(this.full);
	}

	public void fill() {
		this.full = true;
		System.out.println("Duff filled");
	}
	
	@Override
	public String descriptif() {
		
		return "Duff" + (this.full ? " [Full]" : " [Empty]") ;
	}

	
	public Duff getNextFullDuff(Character c) {
		for(Object obj : c.inventory)
			if(obj instanceof Duff && !((Duff) obj).isEmpty())
				return (Duff)obj;
			
		System.out.println("You have no full duff in your inventory");
		return null;
		
	}
	
	public Duff getNextEmptyDuff(Character c) {
		for(Object obj : c.inventory)
			if(obj instanceof Duff && ((Duff) obj).isEmpty())
				return (Duff)obj;
			
		System.out.println("You have no Empty duff in your inventory");
		return null;
		
	}
	
	@Override
	public void use(Character c) {
		Duff duff;
		if(this.full) 
			duff = this;
		else 
			duff = getNextFullDuff(c);

		if(duff == null) {	
			return;
		} else {
			System.out.println("Drinkink duff ... YES !");
			c.editHP(duff.getHealthEffect());
			duff.full = false;
		}
		
		
	}
}
