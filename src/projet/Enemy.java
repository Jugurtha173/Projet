package projet;

public class Enemy extends Character implements Attackable{

	public Enemy(String name) {
		super(name);
	}


	@Override
	public void beAttacked(int damage) {
		if (damage > 0 ) {
			damage = -damage;			
		}
		this.editHP(damage);
		this.showHP();
		// on verifie le hero est toujours vivant
		this.die();
	}
	
	@Override
	public void attack(Attackable target) {
		String detail = "DOH ! you've been attacked by "+ this.getName()+ ", with a ";
		// l'ennemie attack la cible avec le premier objet de son invetaire si ce dernier n'est pas vide
		if(this.inventory.size() != 0) {
			detail += inventory.get(0).toString() + ", " + this.inventory.get(0).getHealthEffect() ;
			target.beAttacked(this.inventory.get(0).getHealthEffect());		
			// on perds le premier objet de l'inventaire
			this.getCurrentRoom().addObject(this.inventory.get(0));
			this.inventory.remove(0);
		} else {
			// sinon on frappe la cible avec un coup-de-poing ( un coup-de-poing implique -1 point de vie)
			detail += " punch -1";
			target.beAttacked(-1);
		}
		
		
		detail += " HP, you must kill him before !";
		System.out.println(detail);
	}

	@Override
	public void attack(Attackable target, Object object) {
		target.beAttacked(object.getHealthEffect());	
		
	}

	
    
}
