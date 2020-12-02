package projet;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JUGURTHA
 */
public class Hero extends Character implements Attackable{
	
	Scanner action = new Scanner(System.in);
	Scanner choice = new Scanner(System.in);
	private boolean win = false;
	private boolean quit = false;

	public Hero(String name) {
		super(name);
	}
	
	public void play() {
		while (!win && !quit && this.isAlive) {
			String line = action.nextLine();
			String[] argv = line.split(" ");
			this.evalAction(argv);			
		}	
	}

	public void evalAction(String[] argv) {
		switch (argv[0].toLowerCase()) {
		case "go": {
			try {		
				this.go(argv[1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Where do want to go ?");
			}
			break;
		}
		case "help": {
			this.help();
			break;
		}
		case "look": {
			try {		
				this.look(argv[1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				this.look();
			}
			
			break;		
		}
		case "take": {
			this.take(argv[1]);
			break;
		}
		case "quit": {
			this.quit();
			break;
		}
		case "use": {
			try {
				this.use(argv[1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Use what ?");
			}
			break;
		}
		case "inventory": {
			this.showInventory();
			break;
		}
		case "attack": {
			// si il n'y a pas d'ennemie ou que l'ennemie est mort
			Enemy target = this.enemyInRoom();
			if(target != null || !target.isAlive) {
				System.out.println("No ennemy alive here ! you can go ");
				break;
			}
				
			// sinon, on l'attaque avec l'objet en argument
			try {
				Object obj= this.findObjectInventory(argv[1]);
			    this.attack((Attackable) this.enemyInRoom(), obj);
			    
			} catch (ArrayIndexOutOfBoundsException e) {
				
				this.attack((Attackable) this.enemyInRoom());
			}
			break;
		}
		
		
		default:
			System.out.println("!!! Action incorrect !!!");
		}
	}

	@Override
	public void specialPower() {
		
	}
	
	public void go(String room) {
		// la liste des portes de la Room actuelle
		List<Door> ld = this.getCurrentRoom().getDoors();
		// on parcours les portes
		for(Door door : ld) {
			// pour chaque porte on recupere la Room d'a cote
			Room r = door.room[0] != this.getCurrentRoom() ? door.room[0] : door.room[1] ;
			// si c'est bien la Room qu'on veut
			if(r.getName().equalsIgnoreCase(room)) {
				// on verifie si il y a un ennemie
				if(door.guard != null && door.guard.isAlive) {
					door.guard.attack((Attackable)this);
					return;
				}
				// on ouvre sa porte
				door.open();
				// on entre dans la Room si elle est ouverte
				if(door.isState()) {
					this.changeRoom(r);					
				}
				// on regarde ou on a att�rit
				this.look();
				// c'est bon on sort de la methode
				return;		
			}
			
		}
		// ici on a donc pas trouv� la Room
		System.out.println("!!! Room not found !!!");
		
	}
	
	public void changeRoom(Room room) {
		this.getCurrentRoom().removeCharacter(this);
		this.setCurrentRoom(room);
		room.addCharacter(this);
		System.out.println("!!! Room changed !!!");
	}

	public void take(String object) {
		Object obj = findObject(object);
		if(obj != null) {
			this.inventory.add(obj);
			this.getCurrentRoom().getObjects().remove(obj);
			System.out.println(object.toString() + " takken");
		}
	}
		
	public void look() {
		this.showHP();
		System.out.println(this.getCurrentRoom().descriptif());
	}
	
	public void look(String object) {
		Object obj = findObject(object);
		if(obj != null) {
			System.out.println(obj.descriptif());
		} else {
			System.out.println("!!! There's no " + object + " here !!!");
		}
	}
	
	public void use(String object) {
		Object obj = findObjectInventory(object);
		if(obj != null) {
			obj.use(this);
		}
	}
	
	public void help() {
		System.out.println("on est dans help");
	}
	
	public void quit() {
		System.out.println("Really ? I'm always hungry, you want to RAGE QUIT ? ( enter q to quit)");
		if(this.action.nextLine().equalsIgnoreCase("q")) {
			this.quit  = true;
			System.out.println("Okay! See you ");
			return;
		}
		System.out.println("Thank you ! We go back");
	}
	 	
	public Object findObject(String object) {
		// la liste d'objets de la Room actuelle
		List<Object> lo = this.getCurrentRoom().getObjects();
		for(Object obj : lo) {
			if(obj.toString().equalsIgnoreCase(object)) {
				return obj;
			}
		}
		System.out.println("!!! No " + object + " found here !!!");
		return null;
	}
	
	public Object findObjectInventory(String object) {
		// la liste d'objets de la Room actuelle
		List<Object> lo = this.inventory;
		for(Object obj : lo) {
			if(obj.toString().equalsIgnoreCase(object)) {
				return obj;
			}
		}
		System.out.println("!!! No " + object + " in your inventory !!!");
		return null;
	}

	public void showInventory() {
		if(this.inventory.size() < 0) {
			System.out.println("!!! Inventory is empty !!!");
		} else {
			for(Object obj : this.inventory ) {
				System.out.println(obj.toString());
			}
		}
	}

	public Enemy enemyInRoom() {
		List<Character> chars = this.getCurrentRoom().getCharacters();
		for(Character c : chars) {
			if(c instanceof Enemy) {
				return (Enemy) c;
			}	
		}
		return null;
	}
	
	@Override
	public void beAttacked(int damage) {
		this.editHP(damage);	
		this.showHP();
		// on verifie le hero est toujours vivant
		this.die();
	}

	@Override
	public void attack(Attackable target) {
		// l'ennemie attack la cible avec son invetaire si ce dernier n'est pas vide
		if(this.inventory.size() != 0) {
			System.out.println("What do you want to use to attack");
			this.showInventory();
			
			String s = choice.next();
			Object obj = findObjectInventory(s);
			
			this.attack(target, obj);
		
		}
	}

	@Override
	public void attack(Attackable target, Object object) {
		if (object == null) {
			System.out.println("let's punch him");
			target.beAttacked(-1);
		} else {
			target.beAttacked(object.getHealthEffect());
			//this.inventory.remove(object);
		}
		
	}

	
	
}
