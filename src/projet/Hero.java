package projet;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JUGURTHA
 */
public class Hero extends Character implements Attackable, Talkable{
	
	Scanner action = new Scanner(System.in);
	Scanner choice = new Scanner(System.in);
	private boolean win = false;
	private boolean quit = false;
	private boolean cheat = false;

	public Hero(String name) {
		super(name);
	}
	
	public void play() {
		while (!win && !quit && this.isAlive()) {
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
				NuclearCentral.print("Where do want to go ?");
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
		case "drop":{
			try {
				this.drop(argv[1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("You can drop an Object in your inventory");
			}
			break;
		}
		case "quit": {
			this.quit();
			break;
		}
		case "use": {
			try {
				use(argv[1], argv[2]);
			} catch (IndexOutOfBoundsException e2) {
				try {
					this.use(argv[1]);
				} catch (ArrayIndexOutOfBoundsException e1) {
					NuclearCentral.print("Use what ?");
				}
			}
			break;
		}
		case "talk": {
			this.talk();
			break;
		}
		case "inventory": {
			this.showInventory();
			break;
		}
		case "attack": {
			// si il n'y a pas d'ennemie ou que l'ennemie est mort
			Enemy target = this.enemyInRoom();
			if(target != null && !(target.isAlive())) {
				NuclearCentral.print("No ennemy alive here ! you can go ");
				break;
			}
				
			// sinon, on l'attaque avec l'objet en argument
			try {
				Object obj= this.findObjectInventory(argv[1]);
			    this.attack((Attackable) target, obj);
			    
			} catch (ArrayIndexOutOfBoundsException e) {
				
				this.attack((Attackable) target);
			}
			break;
		}
		case "cheat": {
			this.switchCheat();
			break;
		}
		
		default:
			NuclearCentral.print("!!! Action incorrect !!!");
		}
	}
	
	public void go(String room) {
		// la liste des portes de la Room actuelle
		List<Door> ld = this.getCurrentRoom().getDoors();
		// on parcours les portes
		for(Door door : ld) {
			// pour chaque porte on recupere la Room d'a cote
			Room r = door.room[0] != this.getCurrentRoom() ? door.room[0] : door.room[1] ;
			// si c'est bien la Room qu'on veut
			if(r.getName().split(" ")[0].equalsIgnoreCase(room)) {
				// on verifie si il y a un ennemie
				if(door.guard != null && door.guard.isAlive()) {
					door.guard.attack((Attackable)this);
					return;
				}
				// on ouvre sa porte
				door.open();
				// on entre dans la Room si elle est ouverte
				if(door.isState()) {
					this.changeRoom(r);
					door.close();
				}
				// on regarde ou on a att�rit
				this.look();
				// c'est bon on sort de la methode
				return;		
			}
			
		}
		// ici on a donc pas trouv� la Room
		NuclearCentral.print("!!! Room not found !!!");
		
	}
	
	public void changeRoom(Room room) {
		this.getCurrentRoom().removeCharacter(this);
		this.setCurrentRoom(room);
		room.addCharacter(this);
		NuclearCentral.print("!!! Room changed !!!");
	}

	public void take(String object) {
		if(this.isCurrentLight()) {
			Object obj = findObject(object);
			if(obj != null) {
				this.inventory.add(obj);
				this.getCurrentRoom().getObjects().remove(obj);
				NuclearCentral.print(object.toString() + " taken");
			}
			if(obj instanceof Donuts) {
				this.win = true;
				this.win();
			}
		}
	}
	
	public void drop(String object) {
		Object obj = findObjectInventory(object);
		if(obj != null) {
			this.inventory.remove(obj);
			this.getCurrentRoom().addObject(obj);
		}
		
	}
	
	public void win(){
		NuclearCentral.print("YOUHOUUUUUUU! MY DONUTS \n\n\n\n");
		NuclearCentral.print("GAME FINISH; YOU WON!!");
	}
	
	public boolean isCurrentLight() {
		if(this.getCurrentRoom().isLigth) {
			return true;
		} else {
			NuclearCentral.print("Hmmmm !!! Can't see anything, this room is not enlightened");
			return false;
		}
	}
	
	public void look() {
		this.showHP();
		if(this.isCurrentLight())
			NuclearCentral.print(this.getCurrentRoom().descriptif());			
		
	}

	public void look(String object) {
		if(this.isCurrentLight()) {
			Object obj = findObject(object);
			if(obj != null) 
				NuclearCentral.print(obj.descriptif());
			else
				NuclearCentral.print("!!! There's no " + object + " here !!!");	
		}
	}
	
	public void use(String object) {
		Object obj = findObjectInventory(object);
		if(obj != null) {
			obj.use(this);
		}
	}
	
	public void use(String obj1, String obj2) {
		Object object1 = findObjectInventory(obj1);
		if(object1 == null) {
			System.err.println("You have no "+ object1 +" in your inventory");
			return;
		}
		
		Object object2 = findObjectInventory(obj2);
		if(object2 == null) {
			System.err.println("You have no "+ object2 +" in your inventory");
			return;
		}
		
		((Barrel) object1).use(this, object2);
		
	}
		
	public void quit() {
		NuclearCentral.print("Really ? I'm always hungry, you want to RAGE QUIT ? ( enter q to quit)");
		if(this.action.nextLine().equalsIgnoreCase("q")) {
			this.quit  = true;
			NuclearCentral.print("Okay! See you ");
			return;
		}
		NuclearCentral.print("Thank you ! We go back");
	}
	 	
	public Object findObject(String object) {
		// la liste d'objets de la Room actuelle
		List<Object> lo = this.getCurrentRoom().getObjects();
		for(Object obj : lo) {
			if(obj.toString().equalsIgnoreCase(object)) {
				return obj;
			}
		}
		NuclearCentral.print("!!! No " + object + " found here !!!");
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
		NuclearCentral.print("!!! No " + object + " in your inventory !!!");
		return null;
	}

	public void showInventory() {
		if(this.inventory.size() < 0) {
			NuclearCentral.print("!!! Inventory is empty !!!");
		} else {
			for(Object obj : this.inventory ) {
				NuclearCentral.print(obj.toString());
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
	
	public void help() {
		NuclearCentral.print("MENU \n"
				+"inventory: 	         Show the inventory\n"
				+"talk:                    Talk with other persons in the room(Not enemies)\n"
				+"use: 		         Use an object in your inventory (you'll choose which one)\n"
				+"use object:	         Use the object (if it contains in inventory)\n"
				+"use object1 object2:	 Use the object with the other one (ex. 'use barrel duff' to refill duff)\n"
				+"take object:   	         Take an object\n"
				+"drop object:   	         Drop an object from your inventory to the room\n"
				+"look:     	         See everything around you in the room\n"
				+"look object:  	         To know more about the object\n"
				+"attack:        	         Attack the enemy in the room (if you inventory is empty, you'll punch him)\n"
				+"attack object:        	 Attack the enemy in the room with the object (if you have not the object, you'll punch him)\n"
				+"go room:  	         Go in other room (if you can)\n"
				+"quit:    	         Exit the game\n");

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
			NuclearCentral.print("What do you want to use to attack");
			this.showInventory();
			
			String s = choice.next();
			Object obj = findObjectInventory(s);
			
			this.attack(target, obj);
		
		} else {
			
			this.attack(target, null);
		}
		
		// Cheat code
		if(!this.cheat) {
			target.attack(this);
		}
	}
	
	public void switchCheat() {
		if(!this.cheat) NuclearCentral.print("!!! NOW when you attack an enemy, he will not attack back !!!");
		else NuclearCentral.print("!!! NOW when you attack an enemy, he will attack back !!!");
		
		this.cheat = !this.cheat;
	}

	@Override
	public void attack(Attackable target, Object object) {
		if (object == null) {
			NuclearCentral.print("let's punch him");
			target.beAttacked(-1);
		} else {
			target.beAttacked(object.getHealthEffect());
			//this.drop(object);
		}
		
	}
	
	public void talk() {
		Character target = this.getCurrentRoom().getCharacters().get(0);
		if(target != null && target instanceof Other) {
			this.talkTo((Talkable)target);
		}
		else
			System.err.println("There's no one to talk with here");
	}

	@Override
	public void talkTo(Talkable t) {
		t.talkTo((Talkable)this);
		
	}

	
}
