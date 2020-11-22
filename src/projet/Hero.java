package projet;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JUGURTHA
 */
public class Hero extends Character{
	
	Scanner action = new Scanner(System.in);
	private boolean win = false;
	private boolean quit = false;

	public Hero(String name) {
		super(name);	
	}
	
	public void play() {
		while (!this.win && !this.quit) {
			String line = action.nextLine();
			String[] argv = line.split(" ");
			this.evalAction(argv);			
		}	
	}

	public void evalAction(String[] argv) {
		switch (argv[0].toLowerCase()) {
		case "go": {
			this.go(argv[1]);
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
			this.use();
			break;
		}
		case "inventory": {
			this.showInventory();
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
			// pour chaque porte on recupére la Room d'à côté
			Room r = door.room1 != this.getCurrentRoom() ? door.room1 : door.room2 ;
			// si c'est bien la Room qu'on veut
			if(r.getName().equalsIgnoreCase(room)) {
				// on ouvre sa porte
				door.open();
				// on entre dans la Room
				this.changeRoom(r);
				// c'est bon on sort de la methode
				return;		
			}
			
		}
		// ici on a donc pas trouvé la Room
		System.out.println("!!! Room not found !!!");

	}
	
	public void changeRoom(Room room) {
		this.setCurrentRoom(room);
		System.out.println("!!! Room changed !!!");
	}

	public void take(String object) {
		Object obj = findObject(object);
		if(obj != null) {
			this.inventory.add(obj);
			System.out.println(object.toString() + " takken");
		}
	}
		
	public void look() {
		
		System.out.println(this.getCurrentRoom().descriptif());
	}
	
	public void look(String object) {
		Object obj = findObject(object);
		if(obj != null) {
			System.out.println(obj.descriptif());
		}
	}
	
	public void use() {
		System.out.println("on est dans use");
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
		System.out.println("!!! Object " + object + " not found !!!");
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
	
}
