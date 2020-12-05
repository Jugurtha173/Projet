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
				Projet.print("Where do want to go ?");
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
			this.drop(argv[1]);
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
					Projet.print("Use what ?");
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
				Projet.print("No ennemy alive here ! you can go ");
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
			Projet.print("!!! Action incorrect !!!");
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
				// on regarde ou on a attérit
				this.look();
				// c'est bon on sort de la methode
				return;		
			}
			
		}
		// ici on a donc pas trouvé la Room
		Projet.print("!!! Room not found !!!");
		
	}
	
	public void changeRoom(Room room) {
		this.getCurrentRoom().removeCharacter(this);
		this.setCurrentRoom(room);
		room.addCharacter(this);
		Projet.print("!!! Room changed !!!");
	}

	public void take(String object) {
		if(this.isCurrentLight()) {
			Object obj = findObject(object);
			if(obj != null) {
				this.inventory.add(obj);
				this.getCurrentRoom().getObjects().remove(obj);
				Projet.print(object.toString() + " takken");
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
		Projet.print("YOUHOUUUUUUU! MY DONUTS \n\n\n\n");
		Projet.print("GAME FINISH; YOU WON!!");
	}
	
	private boolean isCurrentLight() {
		if(this.getCurrentRoom().isLigth) {
			return true;
		} else {
			Projet.print("Hmmmm !!! Can't see anything, this room is not enlightened");
			return false;
		}
	}
	
	public void look() {
		this.showHP();
		if(this.isCurrentLight())
			Projet.print(this.getCurrentRoom().descriptif());			
		
	}

	public void look(String object) {
		if(this.isCurrentLight()) {
			Object obj = findObject(object);
			if(obj != null) 
				Projet.print(obj.descriptif());
			else
				Projet.print("!!! There's no " + object + " here !!!");	
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
		Projet.print("Really ? I'm always hungry, you want to RAGE QUIT ? ( enter q to quit)");
		if(this.action.nextLine().equalsIgnoreCase("q")) {
			this.quit  = true;
			Projet.print("Okay! See you ");
			return;
		}
		Projet.print("Thank you ! We go back");
	}
	 	
	public Object findObject(String object) {
		// la liste d'objets de la Room actuelle
		List<Object> lo = this.getCurrentRoom().getObjects();
		for(Object obj : lo) {
			if(obj.toString().equalsIgnoreCase(object)) {
				return obj;
			}
		}
		Projet.print("!!! No " + object + " found here !!!");
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
		Projet.print("!!! No " + object + " in your inventory !!!");
		return null;
	}

	public void showInventory() {
		if(this.inventory.size() < 0) {
			Projet.print("!!! Inventory is empty !!!");
		} else {
			for(Object obj : this.inventory ) {
				Projet.print(obj.toString());
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
		Projet.print("MENU \n"
				+"inventory: 	         Show the inventory\n"
				+"use: 		         Use an object in your inventory (you'll choose which one)\n"
				+"use object:	         Use the object (if it contains in inventory)\n"
				+"use object1 object2:	 Use the object with the other one (ex. 'use barrel duff' to refill duff)\n"
				+"take object:   	         Take an object\n"
				+"drop object:   	         Drop an object from your inventory to the room\n"
				+"look:     	         See everything arround you in the room\n"
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
			Projet.print("What do you want to use to attack");
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
		if(!this.cheat) Projet.print("!!! NOW when you attack an enemy, he will not attack back !!!");
		else Projet.print("!!! NOW when you attack an enemy, he will attack back !!!");
		
		this.cheat = !this.cheat;
	}

	@Override
	public void attack(Attackable target, Object object) {
		if (object == null) {
			Projet.print("let's punch him");
			target.beAttacked(-1);
		} else {
			target.beAttacked(object.getHealthEffect());
			//this.drop(object);
		}
		
	}
	
	public void talk() {
		Talkable target = (Talkable)this.getCurrentRoom().getCharacters().get(0);
		if(target != null && target instanceof Other) {
			this.talkTo(target);
		}
		else
			System.err.println("There's no one to talk with here");
	}

	@Override
	public void talkTo(Talkable t) {
		t.talkTo((Talkable)this);
		
	}

	
}
