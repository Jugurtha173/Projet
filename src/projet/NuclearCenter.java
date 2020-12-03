package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NuclearCenter {
	
	private List<Room> Rooms = new ArrayList<>();

	
	public void start() {
		
		this.init();
				
		// Commencement		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(""
				+ "Welcome to Homer's Adventure\n"
				+ "A game created by:\n"
				+ "Hylia BOUDAHBA\n"
				+ "Ramus ASSOGBA\n"
				+ "Jugurtha ASMA\n"
				+ "November 2020 version\n\n\n"
				+ "Enter any key to continue");
		
		input.next();
		
		System.out.println(""
				+ "Homer is in his office entrin to ... 'Work' \n"
				+ "Suddenly ... he's hungry!\n"
				+ "But Mr Burns confiscated his DONUT\n"
				+ "DOH !!!\n"
				+ "Homer is really hungry he will have to collect his donut in the boss's office\n"
				+ "LET'S GO\n\n\n"
				+ "Enter any key to continue");
		
		input.next();
		
		System.out.println("\n\n===================================================================================================\n\n");
		
		Hero homer = new Hero("Homer");
		// Homer a faim donc il est pas en pleinne forme
		homer.beAttacked(-3);
		// Homer est dans la premiere salle (son bureau)
		this.Rooms.get(0).addCharacter(homer);
		// LET'S GO
		homer.play();
		
		input.close();

	}
	

	public void init() {
		// initialisation

		// creation des lieux
		Room homerDesk = new Room("My Desk");
		Room hall = new Room("Hall");
		Room rest = new Room("Rest Room");
		Room b24 = new Room("B24");
		Room control = new Room("Control Room");
		Room kitchen = new Room("Kitchen");
		Room storage = new Room("Storage Room", false);
		Room moes = new Room("MOE'S Bar");
		Room engine = new Room("Engine Room");
		Room auditorium = new Room("Auditorium");
		Room employee = new Room("Employee Break Room");
		Room operations = new Room("Operations Center");
		Room production = new Room("Production Room");
		Room burnsDesk = new Room("Burns Office");		
		
		// ajout des lieux a la NuclearCenter
		this.Rooms.add(homerDesk);
		this.Rooms.add(hall);
		this.Rooms.add(rest);
		this.Rooms.add(b24);
		this.Rooms.add(control);
		this.Rooms.add(kitchen);
		this.Rooms.add(storage);
		this.Rooms.add(moes);
		this.Rooms.add(engine);
		this.Rooms.add(auditorium);
		this.Rooms.add(employee);
		this.Rooms.add(operations);
		this.Rooms.add(production);
		this.Rooms.add(burnsDesk);

		// creation des portes
		Door hd_h = new Door(homerDesk, hall);
		Door h_r = new Door(hall, rest);
		Door h_b = new Door(hall, b24);
		Door h_c = new Door(hall, control);
		Door r_k = new Door(rest, kitchen);
		Door b_c = new Door(b24, control);
		Door b_k = new Door(b24, kitchen);
		Door b_s = new Door(b24, storage);
		Door c_m = new Door(control, moes);
		Door k_e = new Door(kitchen, engine);
		Door k_i = new Door(kitchen, auditorium);
		Door k_s = new Door(kitchen, storage);
		Door s_m = new Door(storage, moes);
		Door m_o = new Door(moes, operations);
		Door e_a = new Door(engine, auditorium);
		Door a_p = new Door(auditorium, production);
		Door a_e = new Door(auditorium, employee);
		Door e_o = new Door(employee, operations);
		Door p_b = new Door(production, burnsDesk);
			
		
		// creation des personnages
		Character moe = new Other("Moe");
		Character marge = new Other("Marge");
		Character wiggum = new Other("Wiggum");
		Character krusty = new Other("Krusty");
		Character lisa = new Other("Lisa");
		
		// creation des ennemies
		Enemy tahiti_Bob = new Enemy("Tahiti Bob");
		tahiti_Bob.inventory.add(new Knife());
		tahiti_Bob.inventory.add(new Knife());
		tahiti_Bob.inventory.add(new Knife());

		Enemy kang_kodos = new Enemy("Kang & Kodos");
		Enemy nelson = new Enemy("Nelson");
		Enemy smithers= new Enemy("Smithers");
		Enemy burns= new Enemy("Mr Burns");
		
		// creation des objets
		Object skate = new Skate();
		Object knife = new Knife();
		Object tablet = new Tablet();
		Object hamburger = new Hamburger();
		Object key = new Key();
		Object duff1 = new Duff();
		Object duff2 = new Duff();
		Object duff3 = new Duff();
		Object barrel= new Barrel();
		Object flashlight = new Flashlight();
		Object parchment = new Parchment();
		Object treasure = new Treasure();
		
		// MAJ des Rooms
		homerDesk.addObject(new Duff());
		hall.addObject(skate);
		hall.addObject(duff1);
		control.addObject(key);
		control.addObject(flashlight);
		control.addCharacter(wiggum);
		b24.addEnemy(tahiti_Bob, b_k);
		rest.addCharacter(marge);
		moes.addCharacter(moe);
		moes.addObject(barrel);
		storage.addObject(parchment);
		kitchen.addCharacter(krusty);
		operations.addEnemy(kang_kodos, m_o);
		employee.addEnemy(nelson, e_o);
		auditorium.addCharacter(lisa);
		engine.addObject(duff2);
		production.addEnemy(smithers, p_b);
		production.addObject(duff3);
		burnsDesk.addCharacter(burns);
		burnsDesk.addObject(treasure);

	}
}
