package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NuclearCentral {
	
	private List<Room> Rooms = new ArrayList<>();
	
    public static void main(String[] args) {
    	
    	NuclearCentral nc = new NuclearCentral();
    	nc.start();
        
    }

	
	public void start() {
		
		this.init();
				
		// Commencement		
		
		Scanner input = new Scanner(System.in);
		
		NuclearCentral.print(""
				+ "Welcome to Homer's Adventure\n"
				+ "A game created by:\n"
				+ "Hylia BOUDAHBA\n"
				+ "Ramus ASSOGBA\n"
				+ "Jugurtha ASMA\n"
				+ "November 2020 version\n\n\n"
				+ "Enter any key to continue");
		
		input.next();
		
		NuclearCentral.print(""
				+ "Homer is in his office ... 'Working' \n"
				+ "Suddenly ... he's hungry!\n"
				+ "But Mr Burns confiscated his DONUT\n"
				+ "DOH !!!\n"
				+ "Homer is really hungry he will have to collect his donut in the boss's office\n"
				+ "LET'S GO\n\n\n"
				+ "Enter any key to continue");
		
		input.next();
		
		System.out.println("\n\n===================================================================================================\n\n");
		System.out.println("Enter HELP to know the different commands");
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
		Room safety = new Room("Safety deposit box");	
		
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
		this.Rooms.add(safety);

		// creation des portes
		Door hd_h = new Door(homerDesk, hall);
		Door h_r = new Door(hall, rest);
		Door h_b = new Door(hall, b24);
		Door h_c = new Door(hall, control);
		Door r_k = new Door(rest, kitchen);
		Door b_c = new Door(b24, control);
		Door b_k = new Door(b24, kitchen);
		ClosedDoor b_s = new ClosedDoor(b24, storage);
		Door c_m = new Door(control, moes);
		Door k_e = new Door(kitchen, engine);
		AutoLockDoor k_a = new AutoLockDoor(kitchen, auditorium);
		Door k_s = new Door(kitchen, storage);
		Door s_m = new Door(storage, moes);
		Door m_o = new Door(moes, operations);
		Door e_a = new Door(engine, auditorium);
		SecretCodeDoor a_p = new SecretCodeDoor(auditorium, production, 2210);
		Door a_e = new Door(auditorium, employee);
		Door e_o = new Door(employee, operations);
		Door p_b = new Door(production, burnsDesk);
		SecretCodeDoor b_safety = new SecretCodeDoor(burnsDesk, safety);
		
		// creation des objets
		Object skate = new Skate();
		Object hamburger = new Burger();
		Object key = new Key();
		Object duff1 = new Duff();
		Object duff2 = new Duff();
		Object duff3 = new Duff();
		Object barrel= new Barrel();
		Object lamp = new Lamp();
		Object parchment = new Parchment();
		Object donuts = new Donuts();
			
		
		// creation des personnages
		Other moe = new Other("Moe");
		moe.addSpeechs(Talkable.speechOfMoe1, Talkable.speechOfMoe2, Talkable.speechOfMoe3);
		moe.inventory.add(barrel);
		
		Other marge = new Other("Marge", "kiss");
		marge.addSpeechs(Talkable.speechOfMarge1, Talkable.speechOfMarge2, Talkable.speechOfMarge3);
		marge.inventory.add(new  Duff());
		
		Other wiggum = new Other("Wiggum");
		wiggum.addSpeechs(Talkable.speechOfWiggum1, Talkable.speechOfWiggum2, Talkable.speechOfWiggum3);
		wiggum.inventory.add(new  Gun());
		wiggum.inventory.add(key);
		
		Other krusty = new Other("Krusty");
		krusty.addSpeechs(Talkable.speechOfKrusty1, Talkable.speechOfKrusty2, Talkable.speechOfKrusty3);
		krusty.inventory.add(hamburger);
		
		Other bart = new Other("Bart");
		bart.addSpeechs(Talkable.speechOfBart1, Talkable.speechOfBart2, Talkable.speechOfBart3);
		bart.inventory.add(skate);
		
		Other lisa = new Other("Lisa");
		lisa.addSpeechs(Talkable.speechOfLisa1, Talkable.speechOfLisa2, Talkable.speechOfLisa3);
		
		Other burns= new Other("Mr Burns");
		burns.addSpeechs(Talkable.speechOfBurns1, Talkable.speechOfBurns2, Talkable.speechOfBurns3);
		
		// creation des ennemies
		Enemy tahiti_Bob = new Enemy("Tahiti Bob");
		tahiti_Bob.inventory.add(new Knife());
		tahiti_Bob.inventory.add(new Knife());
		tahiti_Bob.inventory.add(new Knife());

		Enemy kang_kodos = new Enemy("Kang & Kodos");
		kang_kodos.inventory.add(new Uranium());
		
		Enemy nelson = new Enemy("Nelson");
		
		Enemy smithers= new Enemy("Smithers");
		smithers.inventory.add(new Gun());
		
		
		// MAJ des Rooms
		homerDesk.addObject(new Duff());
		
		hall.addCharacter(bart);
		hall.addObject(duff1);
		
		control.addCharacter(wiggum);
		control.addObject(lamp);
		
		b24.addEnemy(tahiti_Bob, b_k);
		
		rest.addCharacter(marge);
		
		moes.addCharacter(moe);
		
		storage.addObject(parchment);
		
		kitchen.addCharacter(krusty);
		
		operations.addEnemy(kang_kodos, m_o);
		
		employee.addEnemy(nelson, e_o);
		
		auditorium.addCharacter(lisa);
		
		engine.addObject(duff2);
		
		production.addEnemy(smithers, p_b);
		production.addObject(duff3);
		
		burnsDesk.addCharacter(burns);
		
		safety.addObject(donuts);
		
	}

	public static void print(String s) {
    	for(int i = 0; i < s.length(); i++) {
    		System.out.print(s.charAt(i));
    		try { Thread.sleep(5);}
    		catch (InterruptedException e) {}
    	}
    	System.out.println();
    }
}
