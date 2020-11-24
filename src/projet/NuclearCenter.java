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
		this.Rooms.get(0).addCharacter(homer);
		((Hero) homer).play();
		

	}
	

	public void init() {
		// initialisation

		// creation des lieux
		Room homerDesk = new Room("Homer_Desk");
		Room hall1 = new Room("Hall_1");
		Room hall2 = new Room("Hall_2");
		Room hall3 = new Room("Hall_3");
		Room hall4 = new Room("Hall_4");
		Room hall5 = new Room("Hall_5");
		Room controlRoom = new Room("Control_Room");
		Room automatedControlRoom = new Room("Automated_Control_Room");
		Room engineRoom = new Room("Engine_Room");
		Room cafeteria = new Room("Cafeteria");
		Room productionRoom = new Room("Production_Room");
		Room BurnsDesk = new Room("Burns_Desk");
		
		// ajout des lieux à la NuclearCenter
		this.Rooms.add(homerDesk);
		this.Rooms.add(hall1);
		this.Rooms.add(hall2);
		this.Rooms.add(hall3);
		this.Rooms.add(hall4);
		this.Rooms.add(hall5);
		this.Rooms.add(controlRoom);
		this.Rooms.add(automatedControlRoom);
		this.Rooms.add(engineRoom);
		this.Rooms.add(cafeteria);
		this.Rooms.add(productionRoom);
		this.Rooms.add(BurnsDesk);

		
		// creation des portes
		Door hd_h1 = new Door(homerDesk, hall1);
		Door h1_h2 = new Door(hall1, hall2);
		Door h2_cr = new Door(hall2, controlRoom);
		Door cr_h3 = new Door(controlRoom, hall3);
		Door h3_acr = new Door(hall3, automatedControlRoom);
		Door acr_h4 = new Door(automatedControlRoom, hall4);
		Door h4_er = new Door(hall4, engineRoom);
		Door c_h5 = new Door(cafeteria, hall5);
		Door er_c = new Door(engineRoom, cafeteria);
		Door h5_pr = new Door(hall5, productionRoom);
		Door pr_bd = new Door(productionRoom, BurnsDesk);		
		
		// creation des personnages
		Character tahiti_Bob = new Enemy("Tahiti Bob");
		Character kang_kodos = new Enemy("Kang & Kodos");
		Character nelson = new Enemy("Nelson");
		Character smithers= new Enemy("Smithers");
		Character burns= new Enemy("Mr Burns");
		Character marge = new Other("Marge");
		Character moe = new Other("Moe");
		
		// creation des objets
		Object skate = new Skate();
		Object knife = new Knife();
		Object tablet = new Tablet();
		Object hamburger = new Hamburger();
		Object donut = new Donut();
		Object key = new Key();
		Object duff1 = new Duff();
		Object duff2 = new Duff();
		Object duff3 = new Duff();
		Object barrel= new Barrel();
		
		// MAJ des Rooms
		homerDesk.addObject(new Duff());
		hall1.addObject(skate);
		hall2.addObject(duff1);
		controlRoom.addCharacter(tahiti_Bob);
		hall3.addObject(duff2);
		hall3.addObject(key);
		automatedControlRoom.addCharacter(marge);
		hall4.addObject(barrel);
		engineRoom.addCharacter(kang_kodos);
		cafeteria.addCharacter(moe);
		hall5.addCharacter(nelson);
		productionRoom.addObject(duff3);
		productionRoom.addCharacter(smithers);
		BurnsDesk.addCharacter(burns);
		BurnsDesk.addObject(donut);;
	}
}
